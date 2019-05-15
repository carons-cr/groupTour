package dao.proxy;

import dao.IUserDAO;
import dao.impl.UserDAOImpl;
import model.User;
import util.DBUtil;

import java.util.List;

public class UserDAOProxy implements IUserDAO {
    private DBUtil dbUtil = null;
    private IUserDAO userDAO = null;

    public UserDAOProxy() throws Exception{
        this.dbUtil = new DBUtil();
        this.userDAO = new UserDAOImpl(this.dbUtil.getConnection());
    }

    @Override
    public boolean doCreate(User user) throws Exception {
        boolean isCreate = false;
        try {
            if (this.userDAO.findByUserName(user.getUserName()) == null)
                isCreate = this.userDAO.doCreate(user);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return isCreate;
    }

    @Override
    public boolean doUpdate(User user) throws Exception {
        boolean isUpdate = false;
        try {
            if (this.userDAO.findByUserName(user.getUserName()) != null)
                isUpdate = this.userDAO.doUpdate(user);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return isUpdate;
    }

    @Override
    public User findById(int id) throws Exception {
        User user = null;
        try {
            user = this.userDAO.findById(id);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return user;
    }

    @Override
    public User findByUserName(String userName) throws Exception {
        User user = null;
        try {
            user = this.userDAO.findByUserName(userName);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return user;
    }

    @Override
    public User findByMobileNumber(String mobileNumber) throws Exception {
        User user = null;
        try {
            user = this.userDAO.findByMobileNumber(mobileNumber);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return user;
    }

    @Override
    public List<User> findAll() throws Exception {
        List<User> userList = null;
        try {
            userList = this.userDAO.findAll();
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return userList;
    }
}
