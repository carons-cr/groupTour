package dao;

import model.GroupComment;

import java.util.List;

public interface IGroupCommentDAO {
    public boolean doCreate(GroupComment groupComment) throws Exception;
    public List<GroupComment> findBySystemGroupId(int systemGroupId) throws Exception;
    public GroupComment findByUserId(int userId) throws Exception;
}
