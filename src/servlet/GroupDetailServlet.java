package servlet;

import dao.factory.DAOFactory;
import model.SystemGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "GroupDetailServlet", urlPatterns = "/groupDetail")
public class GroupDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String systemGroupIdStr = request.getParameter("id");
        int systemGroupId = Integer.parseInt(systemGroupIdStr);
        SystemGroup systemGroup = null;
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
                    path += "?end=true";
                }
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
