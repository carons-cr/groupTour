package servlet;

import dao.factory.DAOFactory;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String userName = request.getParameter("name");
        User user = null;
        List<GroupOrder> groupOrderList = null;
        SystemGroup systemGroup = null;
        List<SystemGroup> systemGroupList = null;
        List<Integer> userIdList = null;
        List<User> groupMemberList = null;
        List<TravelNote> travelNoteList = null;
        List<TravelNoteView> travelNoteViewList = null;
        TravelNote viewNote = null;
        List<TravelNote> viewNoteList = null;
        try {
            user = DAOFactory.getIUserDAOInstance().findByUserName(userName);
            if (user != null) {
                int userId = user.getId();
                groupOrderList = DAOFactory.getIGroupOrderDAOInstance().findByUserId(userId);
                if (groupOrderList != null) {
                    systemGroupList =  new ArrayList<SystemGroup>();
                    for (GroupOrder groupOrder : groupOrderList) {
                        systemGroup = DAOFactory.getISystemGroupDAOInstance().findById(groupOrder.getSystemGroupId());
                        systemGroupList.add(systemGroup);
                        userIdList = DAOFactory.getIGroupOrderDAOInstance().findUserIdListByGroupId(groupOrder.getSystemGroupId());
                        if (userIdList != null) {
                            groupMemberList = new ArrayList<User>();
                            for (Integer id : userIdList) {
                                if (id == userId)
                                    continue;
                                User otherUser = DAOFactory.getIUserDAOInstance().findById(id);
                                groupMemberList.add(otherUser);
                            }
                        }
                    }
                }
                travelNoteList = DAOFactory.getITravelNoteDAOInstance().findByUserId(userId);
                travelNoteViewList = DAOFactory.getITravelNoteViewDAOInstance().findByUserId(userId);
                if (travelNoteViewList != null) {
                    viewNoteList = new ArrayList<TravelNote>();
                    for (TravelNoteView travelNoteView : travelNoteViewList) {
                        viewNote = DAOFactory.getITravelNoteDAOInstance().findById(travelNoteView.getTravelNoteId());
                        viewNoteList.add(viewNote);
                    }
                }
            }
            session.setAttribute("systemGroupList", systemGroupList);
            session.setAttribute("travelNoteList", travelNoteList);
            session.setAttribute("viewNoteList", viewNoteList);
            session.setAttribute("groupMemberList", groupMemberList);
            response.sendRedirect("/user.jsp");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
