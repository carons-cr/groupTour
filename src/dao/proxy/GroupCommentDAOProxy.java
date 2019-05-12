package dao.proxy;

import dao.IGroupCommentDAO;
import dao.impl.GroupCommentDAOImpl;
import model.GroupComment;
import util.DBUtil;

import java.util.List;

public class GroupCommentDAOProxy implements IGroupCommentDAO {
    private DBUtil dbUtil = null;
    private IGroupCommentDAO groupCommentDAO = null;

    public GroupCommentDAOProxy() throws Exception{
        this.dbUtil = new DBUtil();
        this.groupCommentDAO = new GroupCommentDAOImpl(this.dbUtil.getConnection());
    }

    @Override
    public boolean doCreate(GroupComment groupComment) throws Exception {
        boolean isCreate = false;
        try {
            isCreate = this.groupCommentDAO.doCreate(groupComment);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return isCreate;
    }

    @Override
    public List<GroupComment> findBySystemGroupId(int systemGroupId) throws Exception {
        List<GroupComment> groupCommentList = null;
        try {
            groupCommentList = this.groupCommentDAO.findBySystemGroupId(systemGroupId);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return groupCommentList;
    }

    @Override
    public GroupComment findByUserId(int userId) throws Exception {
        GroupComment groupComment = null;
        try {
            groupComment = this.groupCommentDAO.findByUserId(userId);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return groupComment;
    }
}
