package servlet;

import dao.factory.DAOFactory;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "registerServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User user = new User(userName, password);
        HttpSession session = request.getSession();
        try {
            if (DAOFactory.getIUserDAOInstance().findByUserName(userName) == null) {
                DAOFactory.getIUserDAOInstance().doCreate(user);
                session.setAttribute("userName", userName);
            }else {
                session.setAttribute("reRegisterUserName", userName);
            }
            response.sendRedirect("/index.jsp");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
