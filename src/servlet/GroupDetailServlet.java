package servlet;

import dao.factory.DAOFactory;
import model.GroupComment;
import model.GroupOrder;
import model.SystemGroup;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "GroupDetailServlet", urlPatterns = "/groupDetail")
public class GroupDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String systemGroupIdStr = request.getParameter("id");
        int systemGroupId = Integer.parseInt(systemGroupIdStr);
        SystemGroup systemGroup = null;
        List<GroupComment> groupCommentList = null;
        List<User> userList = null;
        HttpSession session = request.getSession();
        String path = "/groupDetail.jsp";
        try{
            systemGroup = DAOFactory.getISystemGroupDAOInstance().findById(systemGroupId);
            if (systemGroup != null) {
                session.setAttribute("systemGroup", systemGroup);
                Date startTime = systemGroup.getStartTime();
                Date today = new Date();
                if (startTime.compareTo(today) > 0) {
                    path += "?end=false";
                }else {
                    groupCommentList = DAOFactory.getIGroupCommentDAOInstance().findBySystemGroupId(systemGroupId);
                    session.setAttribute("groupCommentList", groupCommentList);
                    path += "?end=true";
                }
                List<GroupOrder> groupOrderList = DAOFactory.getIGroupOrderDAOInstance().findBySystemGroupId(systemGroupId);
                if (groupOrderList != null) {
                    userList = new ArrayList<User>();
                    for (int i = 0; i < groupOrderList.size(); i++) {
                        GroupOrder groupOrder = groupOrderList.get(i);
                        int userId = groupOrder.getUserId();
                        User user = DAOFactory.getIUserDAOInstance().findById(userId);
                        if (user != null)
                            userList.add(user);
                    }
                }
                session.setAttribute("userList", userList);
            }
            response.sendRedirect(path);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
