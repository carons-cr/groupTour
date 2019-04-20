package dao.impl;

import dao.ISystemGroupDAO;
import model.SystemGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SystemGroupDAOImpl implements ISystemGroupDAO{
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    public SystemGroupDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<SystemGroup> findAll() throws Exception {
        List<SystemGroup> systemGroupList = new ArrayList<SystemGroup>();
        String sql = "select * from system_group order by id desc";
        ResultSet resultSet = null;
        SystemGroup systemGroup = null;
        this.preparedStatement = connection.prepareStatement(sql);
        resultSet = this.preparedStatement.executeQuery();
        while (resultSet.next()) {
            systemGroup = getSystemGroupFromResultSet(resultSet);
            systemGroupList.add(systemGroup);
        }
        this.preparedStatement.close();
        return systemGroupList;
    }

    @Override
    public SystemGroup findById(int id) throws Exception {
        SystemGroup systemGroup = new SystemGroup();
        String sql = "select * from system_group where id = ?";
        ResultSet resultSet = null;
        this.preparedStatement = connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, id);
        resultSet = this.preparedStatement.executeQuery();
        if (resultSet.next())
            systemGroup = getSystemGroupFromResultSet(resultSet);
        this.preparedStatement.close();
        return systemGroup;
    }

    private SystemGroup getSystemGroupFromResultSet(ResultSet resultSet) throws Exception{
        SystemGroup systemGroup = new SystemGroup();
        systemGroup.setId(resultSet.getInt(1));
        systemGroup.setName(resultSet.getString(2));
        systemGroup.setPrice(resultSet.getInt(3));
        systemGroup.setNumber(resultSet.getInt(4));
        systemGroup.setStartTime(resultSet.getDate(5));
        systemGroup.setEndTime(resultSet.getDate(6));
        systemGroup.setDescription(resultSet.getString(7));
        systemGroup.setImgUrl(resultSet.getString(8));
        return systemGroup;
    }
}
