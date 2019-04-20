package servlet;

import dao.factory.DAOFactory;
import model.TravelNote;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TravelNoteServlet", urlPatterns = "/travelNote")
public class TravelNoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        try {
            List<TravelNote> travelNoteList = null;
            travelNoteList = DAOFactory.getITravelNoteDAOInstance().findAll();
            if (travelNoteList != null) {
                session.setAttribute("travelNoteList", travelNoteList);
            }
            response.sendRedirect("/travelNote.jsp");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
