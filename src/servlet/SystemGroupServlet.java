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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SystemGroupServlet", urlPatterns = "/systemGroup")
public class SystemGroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        try {
            List<SystemGroup> systemGroupList = null;
            systemGroupList = DAOFactory.getISystemGroupDAOInstance().findAll();
            session.setAttribute("systemGroupList", systemGroupList);
            response.sendRedirect("/systemGroup.jsp");
        }catch (Exception e) {
            response.sendRedirect("/html/error.html");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
