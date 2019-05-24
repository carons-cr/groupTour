package servlet;

import dao.factory.DAOFactory;
import model.GroupOrder;
import model.SystemGroup;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "SignUpServlet", urlPatterns = "/signUp")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String systemGroupIdStr = request.getParameter("id");
        int systemGroupId = Integer.parseInt(systemGroupIdStr);
        String userName = request.getParameter("userName");
        String realName = request.getParameter("realName");
        String sex = request.getParameter("sex");
        String ageStr = request.getParameter("age");
        int age = Integer.parseInt(ageStr);
        String address = request.getParameter("address");
        String mobileNumber = request.getParameter("mobileNumber");
        String identificationNumber = request.getParameter("identificationNumber");
        User user = null;
        SystemGroup systemGroup = null;
        GroupOrder groupOrder = null;
        try {
            user = DAOFactory.getIUserDAOInstance().findByUserName(userName);
            if (user != null) {
                user.setRealName(realName);
                user.setSex(sex);
                user.setAge(age);
                user.setAddress(address);
                user.setMobileNumber(mobileNumber);
                user.setIdentificationNumber(identificationNumber);
                DAOFactory.getIUserDAOInstance().doUpdate(user);
            }
            systemGroup = DAOFactory.getISystemGroupDAOInstance().findById(systemGroupId);
            if (systemGroup != null && user != null) {
                groupOrder = new GroupOrder();
                groupOrder.setSystemGroupId(systemGroupId);
                groupOrder.setUserId(user.getId());
                groupOrder.setPrice(systemGroup.getPrice());
                Date date = new Date();
                groupOrder.setTime(date);
                DAOFactory.getIGroupOrderDAOInstance().doCreate(groupOrder);
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
