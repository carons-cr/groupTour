package dao.impl;

import dao.IGroupOrderDAO;
import model.GroupOrder;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GroupOrderDAOImpl implements IGroupOrderDAO {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    public GroupOrderDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean doCreate(GroupOrder groupOrder) throws Exception {
        boolean isCreate = false;
        String sql = "insert into group_order (id, system_group_id, user_id, price, time) " +
                "values (?, ?, ?, ?, ?)";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, groupOrder.getId());
        this.preparedStatement.setInt(2, groupOrder.getSystemGroupId());
        this.preparedStatement.setInt(3, groupOrder.getUserId());
        this.preparedStatement.setInt(4, groupOrder.getPrice());
        this.preparedStatement.setDate(5, new java.sql.Date(groupOrder.getTime().getTime()));
        isCreate = (this.preparedStatement.executeUpdate() > 0);
        this.preparedStatement.close();
        return isCreate;
    }

    @Override
    public List<GroupOrder> findBySystemGroupId(int systemGroupId) throws Exception {
        List<GroupOrder> groupOrderList = null;
        String sql = "select * from group_order where system_group_id = ?";
        ResultSet resultSet = null;
        GroupOrder groupOrder = null;
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, systemGroupId);
        resultSet = this.preparedStatement.executeQuery();
        groupOrderList = getGroupOrderListFromResultSet(resultSet);
        this.preparedStatement.close();
        return groupOrderList;
    }

    @Override
    public List<GroupOrder> findByUserId(int userId) throws Exception {
        List<GroupOrder> groupOrderList = null;
        String sql = "select * from group_order where user_id = ?";
        ResultSet resultSet = null;
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, userId);
        resultSet = this.preparedStatement.executeQuery();
        groupOrderList = getGroupOrderListFromResultSet(resultSet);
        this.preparedStatement.close();
        return groupOrderList;
    }

    @Override
    public List<Integer> findUserIdListByGroupId(int groupId) throws Exception {
        List<Integer> userIdList = null;
        String sql = "select user_id from group_order where system_group_id = ?";
        ResultSet resultSet = null;
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, groupId);
        resultSet = this.preparedStatement.executeQuery();
        if (resultSet.next()) {
            userIdList = new ArrayList<Integer>();
            userIdList.add(resultSet.getInt(1));
            while (resultSet.next()) {
                userIdList.add(resultSet.getInt(1));
            }
        }
        this.preparedStatement.close();
        return userIdList;
    }

    private GroupOrder getGroupOrderFromResultSet(ResultSet resultSet) throws Exception {
        GroupOrder groupOrder = new GroupOrder();
        groupOrder.setId(resultSet.getInt(1));
        groupOrder.setSystemGroupId(resultSet.getInt(2));
        groupOrder.setUserId(resultSet.getInt(3));
        groupOrder.setPrice(resultSet.getInt(4));
        groupOrder.setTime(resultSet.getDate(5));
        return groupOrder;
    }

    private List<GroupOrder> getGroupOrderListFromResultSet(ResultSet resultSet) throws Exception {
        List<GroupOrder> groupOrderList = null;
        GroupOrder groupOrder = null;
        if (resultSet.next()) {
            groupOrderList = new ArrayList<GroupOrder>();
            groupOrder = getGroupOrderFromResultSet(resultSet);
            groupOrderList.add(groupOrder);
            while (resultSet.next()) {
                groupOrder = getGroupOrderFromResultSet(resultSet);
                groupOrderList.add(groupOrder);
            }
        }
        return groupOrderList;
    }
}
