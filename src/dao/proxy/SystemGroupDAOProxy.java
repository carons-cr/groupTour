package dao.proxy;

import dao.ISystemGroupDAO;
import dao.impl.SystemGroupDAOImpl;
import model.SystemGroup;
import util.DBUtil;

import java.util.List;

public class SystemGroupDAOProxy implements ISystemGroupDAO{
    private DBUtil dbUtil = null;
    private ISystemGroupDAO systemGroupDAO = null;

    public SystemGroupDAOProxy() throws Exception{
        this.dbUtil = new DBUtil();
        this.systemGroupDAO = new SystemGroupDAOImpl(this.dbUtil.getConnection());
    }

    @Override
    public List<SystemGroup> findAll() throws Exception {
        List<SystemGroup> systemGroupList = null;
        try {
            systemGroupList = this.systemGroupDAO.findAll();
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return systemGroupList;
    }

    @Override
    public SystemGroup findById(int id) throws Exception {
        SystemGroup systemGroup = null;
        try {
            systemGroup = this.systemGroupDAO.findById(id);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return systemGroup;
    }
}
