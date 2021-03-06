package dao;

import model.User;

import java.util.List;

public interface IUserDAO {
    public boolean doCreate(User user) throws Exception;
    public boolean doUpdate(User user) throws Exception;
    public User findById(int id) throws Exception;
    public User findByUserName(String userName) throws Exception;
    public User findByMobileNumber(String mobileNumber) throws Exception;
    public List<User> findAll() throws Exception;
}
