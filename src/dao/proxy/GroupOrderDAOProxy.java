package dao.proxy;

import dao.IGroupOrderDAO;
import dao.impl.GroupOrderDAOImpl;
import model.GroupOrder;
import util.DBUtil;

import java.util.List;

public class GroupOrderDAOProxy implements IGroupOrderDAO {
    private DBUtil dbUtil = null;
    private IGroupOrderDAO groupOrderDAO = null;

    public GroupOrderDAOProxy() throws Exception{
        this.dbUtil = new DBUtil();
        this.groupOrderDAO = new GroupOrderDAOImpl(this.dbUtil.getConnection());
    }

    @Override
    public boolean doCreate(GroupOrder groupOrder) throws Exception {
        boolean isCreate = false;
        try {
            isCreate = this.groupOrderDAO.doCreate(groupOrder);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return isCreate;
    }

    @Override
    public List<GroupOrder> findBySystemGroupId(int systemGroupId) throws Exception {
        List<GroupOrder> groupOrderList = null;
        try {
            groupOrderList = this.groupOrderDAO.findBySystemGroupId(systemGroupId);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return groupOrderList;
    }

    @Override
    public List<GroupOrder> findByUserId(int userId) throws Exception {
        List<GroupOrder> groupOrderList = null;
        try {
            groupOrderList = this.groupOrderDAO.findByUserId(userId);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return groupOrderList;
    }
}
