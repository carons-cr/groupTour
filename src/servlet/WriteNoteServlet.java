package servlet;

import dao.factory.DAOFactory;
import model.TravelNote;
import model.TravelNoteImg;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "WriteNoteServlet", urlPatterns = "/writeNote")
public class WriteNoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        TravelNote travelNote = new TravelNote();
        String title = request.getParameter("title");
        String article = request.getParameter("article");
        String userName = request.getParameter("author");
        String[] imgUrlArray = request.getParameterValues("img");
        Date date = new Date();
        travelNote.setTitle(title);
        travelNote.setArticle(article);
        travelNote.setTime(date);
        if (imgUrlArray != null)
            travelNote.setCoverImgUrl(imgUrlArray[0]);
        TravelNoteImg travelNoteImg = new TravelNoteImg();
        try {
            User user = DAOFactory.getIUserDAOInstance().findByUserName(userName);
            if (user != null) {
                travelNote.setUserId(user.getId());
            }
            DAOFactory.getITravelNoteDAOInstance().doCreate(travelNote);
            int travelNoteId = DAOFactory.getITravelNoteDAOInstance().GetLastestId();
            travelNoteImg.setTravelNoteId(travelNoteId);
            if (imgUrlArray != null) {
                for (String imgUrl : imgUrlArray) {
                    travelNoteImg.setImgUrl(imgUrl);
                    DAOFactory.getITravelNoteImgDAOInstance().doCreate(travelNoteImg);
                }
            }
            response.sendRedirect("travelNote");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
