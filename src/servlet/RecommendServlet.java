package servlet;

import dao.factory.DAOFactory;
import model.*;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import util.KMeans;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "RecommendServlet", urlPatterns = "/recommend")
public class RecommendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("userName");
        HttpSession session = request.getSession();
        List<User> userList = null;
        User user = null;
        List<TravelNoteView> travelNoteViewList = null;
        int[] travelNotesId = new int[3];
        int[] membersIndex = null;
        List<SystemGroup> systemGroupList = null;
        SystemGroup systemGroup = null;
        List<GroupOrder> groupOrderList = null;
        try{
            userList = DAOFactory.getIUserDAOInstance().findAll();
            if (userList != null) {
                KMeans kMeans = new KMeans(4);
                kMeans.DATA = new double[userList.size()][5];
                for (int i = 0; i < userList.size(); i++) {
                    user = userList.get(i);
                    travelNoteViewList = DAOFactory.getITravelNoteViewDAOInstance().findByUserId(user.getId());
                    if (travelNoteViewList != null) {
                        for (int j = 0; j < 3; j++) {
                            if (travelNoteViewList.size() > j && travelNoteViewList.get(j) != null) {
                                travelNotesId[j] = travelNoteViewList.get(j).getTravelNoteId();
                            }else {
                                travelNotesId[j] = 0;
                            }
                        }
                    }
                    kMeans.DATA[i] = kMeans.getData(user.getAge(), user.getSex(), travelNotesId);
                }
                for (User user1 : userList) {
                   if (user1.getUserName().equals(userName)) {
                        membersIndex = kMeans.getMembersIndex(user1.getId() - 1);
                    }
                }
                if (membersIndex != null) {
                    systemGroupList = new ArrayList<SystemGroup>();
                    for (int k = 0; k < membersIndex.length; k++) {
                        groupOrderList = DAOFactory.getIGroupOrderDAOInstance().findByUserId(membersIndex[k] + 1);
                        if (groupOrderList != null) {
                            for (GroupOrder groupOrder : groupOrderList) {
                                systemGroup = DAOFactory.getISystemGroupDAOInstance().findById(groupOrder.getSystemGroupId());
                                if (systemGroup != null && !isDuplicates(systemGroupList, systemGroup)) {
                                    systemGroupList.add(systemGroup);
                                }
                            }
                        }
                    }
                }
            }
            session.setAttribute("recommendGroupList", systemGroupList);
            response.sendRedirect("/index.jsp");
        }catch (Exception e) {
            response.sendRedirect("/html/error.html");
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private boolean isDuplicates(List<SystemGroup> systemGroupList, SystemGroup systemGroup) {
        for (SystemGroup systemGroup1 : systemGroupList) {
            if (systemGroup1.getId() == systemGroup.getId())
                return true;
        }
        return false;
    }


}
