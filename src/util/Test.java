package util;

import dao.IUserDAO;
import dao.factory.DAOFactory;
import model.SystemGroup;
import model.User;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

public class Test {
    public static void main(String[] args) {
        /*测试for each语句遍历空集合
        List<String> strs = new ArrayList<String>();
        for (String str : strs) {
            System.out.println(str);
        }*/
        /*测试系统拼团数据库操作
        List<SystemGroup> systemGroupList = new ArrayList<SystemGroup>();
        SystemGroup systemGroup = null;
        try {
            systemGroupList = DAOFactory.getISystemGroupDAOInstance().findAll();
            for (int i = 0; i < systemGroupList.size(); i++) {
                systemGroup = systemGroupList.get(i);
                System.out.println(systemGroup.getId() + "\t" + systemGroup.getName());
            }
            int id = systemGroupList.get(5).getId();
            systemGroup = DAOFactory.getISystemGroupDAOInstance().findById(id);
            System.out.println(systemGroup.getId() + "\t" + systemGroup.getName());
        }catch (Exception e) {
            e.printStackTrace();
        }/*

        /*测试用户数据库操作
        User user = null;
        try {
            for (int i = 0; i < 3; i++) {
                user = new User();
                user.setUserName("user" + i);
                user.setPassword("password" + i);
                System.out.println(user);
                if (DAOFactory.getIUserDAOInstance().doCreate(user))
                    System.out.println("成功添加用户" + i);
                else
                    System.out.println("添加用户" + i + "失败");
            }
            user = DAOFactory.getIUserDAOInstance().findByUserName("user1");
            user.setMobileNumber("123");
            user.setPassword("rePassword");
            user.setSex("男");
            if (DAOFactory.getIUserDAOInstance().doUpdate(user))
                System.out.println("成功更新最后一位用户的密码为" + user.getPassword() + "性别为" + user.getSex());
            else
                System.out.println("更新最后一位用户的信息失败");
            int id = user.getId();
            System.out.println("找到用户名为user1的用户的id是：" + id);
            user = DAOFactory.getIUserDAOInstance().findById(id);
            String mobileNumber = user.getMobileNumber();
            System.out.println("找到用户id为" + id + "的用户的手机号是：" + mobileNumber);
            user = DAOFactory.getIUserDAOInstance().findByMobileNumber(mobileNumber);
            System.out.println("找到手机号为" + mobileNumber + "的用户名是：" + user.getUserName());
        }catch (Exception e) {
            e.printStackTrace();
        }*/

        /*测试数据库连接
        DBUtil dbUtil = null;
        Connection connection = null;
         try {
            dbUtil = new DBUtil();
            connection = dbUtil.getConnection();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
             if (connection != null) {
                 System.out.println("数据库连接成功!");
                 try {
                     dbUtil.closeConnection();
                 }catch (Exception e)
                 {
                     e.printStackTrace();
                 }
             }
        }*/
    }
}
