package dao.impl;

import dao.IGroupCommentDAO;
import model.GroupComment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GroupCommentDAOImpl implements IGroupCommentDAO {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    public GroupCommentDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean doCreate(GroupComment groupComment) throws Exception {
        boolean isCreate = false;
        String sql = "insert into group_comment (id, system_group_id, user_id, time, content) " +
                "values (?, ?, ?, ?, ?)";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, groupComment.getId());
        this.preparedStatement.setInt(2, groupComment.getSystemGroupId());
        this.preparedStatement.setInt(3, groupComment.getUserId());
        this.preparedStatement.setDate(4, new java.sql.Date(groupComment.getTime().getTime()));
        this.preparedStatement.setString(5, groupComment.getContent());
        isCreate = (this.preparedStatement.executeUpdate() > 0);
        this.preparedStatement.close();
        return isCreate;
    }

    @Override
    public List<GroupComment> findBySystemGroupId(int systemGroupId) throws Exception {
        List<GroupComment> groupCommentList = null;
        String sql = "select * from group_comment where system_group_id = ?";
        ResultSet resultSet = null;
        GroupComment groupComment = null;
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, systemGroupId);
        resultSet = this.preparedStatement.executeQuery();
        if (resultSet.next()) {
            groupCommentList = new ArrayList<GroupComment>();
            groupComment = getGroupCommentFromResultSet(resultSet);
            groupCommentList.add(groupComment);
            while (resultSet.next()) {
                groupComment = getGroupCommentFromResultSet(resultSet);
                groupCommentList.add(groupComment);
            }
        }
        this.preparedStatement.close();
        return groupCommentList;
    }

    @Override
    public GroupComment findByUserId(int userId) throws Exception {
        GroupComment groupComment = null;
        String sql = "select * from group_comment where user_id = ?";
        ResultSet resultSet = null;
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, userId);
        resultSet = this.preparedStatement.executeQuery();
        if (resultSet.next())
            groupComment = getGroupCommentFromResultSet(resultSet);
        this.preparedStatement.close();
        return groupComment;
    }

    private GroupComment getGroupCommentFromResultSet(ResultSet resultSet) throws Exception {
        GroupComment groupComment = new GroupComment();
        groupComment.setId(resultSet.getInt(1));
        groupComment.setSystemGroupId(resultSet.getInt(2));
        groupComment.setUserId(resultSet.getInt(3));
        groupComment.setTime(resultSet.getDate(4));
        groupComment.setContent(resultSet.getString(5));
        return groupComment;
    }
}
