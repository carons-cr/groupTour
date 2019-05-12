package servlet;

import dao.factory.DAOFactory;
import model.TravelNote;
import model.TravelNoteImg;
import model.TravelNoteView;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NoteDetailServlet", urlPatterns = "/noteDetail")
public class NoteDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String travelNoteIdStr = request.getParameter("id");
        String userName = request.getParameter("name");
        int travelNoteId = Integer.parseInt(travelNoteIdStr);
        TravelNoteView travelNoteView = new TravelNoteView();
        TravelNote travelNote = null;
        List<TravelNoteImg> travelNoteImgList = null;
        HttpSession session = request.getSession();
        try {
            if (userName != null) {
                User user = DAOFactory.getIUserDAOInstance().findByUserName(userName);
                if (user != null) {
                    travelNoteView.setUserId(user.getId());
                }
            }
            travelNoteView.setTravelNoteId(travelNoteId);
            DAOFactory.getITravelNoteViewDAOInstance().doCreate(travelNoteView);
            int viewNum = DAOFactory.getITravelNoteViewDAOInstance().getViewNum(travelNoteId);
            if (viewNum != 0) {
                session.setAttribute("viewNum", viewNum);
            }
            travelNote = DAOFactory.getITravelNoteDAOInstance().findById(travelNoteId);
            if (travelNote != null) {
                session.setAttribute("travelNote", travelNote);
                User author = DAOFactory.getIUserDAOInstance().findById(travelNote.getUserId());
                if (author != null) {
                    session.setAttribute("authorName", author.getUserName());
                }
            }
            travelNoteImgList = DAOFactory.getITravelNoteImgDAOInstance().findAllByTravelNoteId(travelNoteId);
            if (travelNoteImgList != null) {
                session.setAttribute("travelNoteImgList", travelNoteImgList);
            }
            response.sendRedirect("/noteDetail.jsp");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
