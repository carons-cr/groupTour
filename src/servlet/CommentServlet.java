package servlet;

import dao.factory.DAOFactory;
import model.GroupComment;
import model.SystemGroup;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "CommentServlet", urlPatterns = "/comment")
public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String systemGroupIdStr = request.getParameter("id");
        int systemGroupId = Integer.parseInt(systemGroupIdStr);
        String userName = request.getParameter("author");
        String content = request.getParameter("comment");
        User user = null;
        SystemGroup systemGroup = null;
        GroupComment groupComment = null;
        try {
            user = DAOFactory.getIUserDAOInstance().findByUserName(userName);
            systemGroup = DAOFactory.getISystemGroupDAOInstance().findById(systemGroupId);
            if (user != null && systemGroup != null) {
                groupComment = new GroupComment();
                groupComment.setSystemGroupId(systemGroupId);
                groupComment.setUserId(user.getId());
                Date date = new Date();
                groupComment.setTime(date);
                groupComment.setContent(content);
                DAOFactory.getIGroupCommentDAOInstance().doCreate(groupComment);
            }
            response.sendRedirect("systemGroup");
        }catch (Exception e) {
            response.sendRedirect("/html/error.html");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
