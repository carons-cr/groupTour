package dao.impl;

import dao.IUserDAO;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements IUserDAO{
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public boolean doCreate(User user) throws Exception {
        boolean isCreate = false;
        String sql = "insert into user (user_name, password) values (?, ?)";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, user.getUserName());
        this.preparedStatement.setString(2, user.getPassword());
        isCreate = (this.preparedStatement.executeUpdate() > 0);
        this.preparedStatement.close();
        return isCreate;
    }

    @Override
    public boolean doUpdate(User user) throws Exception {
        boolean isUpdate = false;
        String sql = "update user set user_name = ?, password = ?, identification_number = ?, real_name = ?, "
                + "mobile_number = ?, age = ?, sex = ?, address = ? where id = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, user.getUserName());
        this.preparedStatement.setString(2, user.getPassword());
        this.preparedStatement.setString(3, user.getIdentificationNumber());
        this.preparedStatement.setString(4, user.getRealName());
        this.preparedStatement.setString(5, user.getMobileNumber());
        this.preparedStatement.setInt(6, user.getAge());
        this.preparedStatement.setString(7, user.getSex());
        this.preparedStatement.setString(8, user.getAddress());
        this.preparedStatement.setInt(9, user.getId());
        isUpdate = (this.preparedStatement.executeUpdate() > 0);
        this.preparedStatement.close();
        return isUpdate;
    }

    @Override
    public User findById(int id) throws Exception {
        User user = null;
        String sql = "select * from user where id = ?";
        ResultSet resultSet = null;
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, id);
        resultSet = this.preparedStatement.executeQuery();
        if (resultSet.next())
            user = getUserFromResultSet(resultSet);
        this.preparedStatement.close();
        return user;
    }

    @Override
    public User findByUserName(String userName) throws Exception {
        User user = null;
        String sql = "select * from user where user_name = ?";
        ResultSet resultSet = null;
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, userName);
        resultSet = this.preparedStatement.executeQuery();
        if (resultSet.next())
            user = getUserFromResultSet(resultSet);
        this.preparedStatement.close();
        return user;
    }

    @Override
    public User findByMobileNumber(String mobileNumber) throws Exception {
        User user = null;
        String sql = "select * from user where mobile_number = ?";
        ResultSet resultSet = null;
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, mobileNumber);
        resultSet = this.preparedStatement.executeQuery();
        if (resultSet.next())
            user = getUserFromResultSet(resultSet);
        this.preparedStatement.close();
        return user;
    }

    private User getUserFromResultSet(ResultSet resultSet) throws Exception{
        User user = new User();
        user.setId(resultSet.getInt(1));
        user.setUserName(resultSet.getString(2));
        user.setPassword(resultSet.getString(3));
        user.setIdentificationNumber(resultSet.getString(4));
        user.setRealName(resultSet.getString(5));
        user.setMobileNumber(resultSet.getString(6));
        user.setAge(resultSet.getInt(7));
        user.setSex(resultSet.getString(8));
        user.setAddress(resultSet.getString(9));
        return user;
    }

    @Override
    public List<User> findAll() throws Exception {
        List<User> userList = null;
        String sql = "select * from user";
        ResultSet resultSet = null;
        User user = null;
        this.preparedStatement = connection.prepareStatement(sql);
        resultSet = this.preparedStatement.executeQuery();
        if (resultSet.next()) {
            userList = new ArrayList<User>();
            user = getUserFromResultSet(resultSet);
            userList.add(user);
            while (resultSet.next()) {
                user = getUserFromResultSet(resultSet);
                userList.add(user);
            }
        }
        this.preparedStatement.close();
        return userList;
    }
}
