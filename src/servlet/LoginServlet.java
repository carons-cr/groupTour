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

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        try {
            if (DAOFactory.getIUserDAOInstance().findByUserName(userName) == null) {
                session.setAttribute("loginFailUserName", userName);
                response.sendRedirect("/registerALogin.jsp?name=login");
            }else {
                User user = DAOFactory.getIUserDAOInstance().findByUserName(userName);
                if (!password.equals(user.getPassword())) {
                    session.setAttribute("loginFailUserName", userName);
                    response.sendRedirect("/registerALogin.jsp?name=login");
                }else {
                    session.setAttribute("userName", userName);
                    response.sendRedirect("/index.jsp");
                }
            }
        }catch (Exception e) {
            response.sendRedirect("/html/error.html");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
