package dao.proxy;

import dao.ITravelNoteViewDAO;
import dao.impl.TravelNoteViewDAOImpl;
import model.TravelNoteView;
import util.DBUtil;

import java.util.List;

public class TravelNoteViewDAOProxy implements ITravelNoteViewDAO {
    private DBUtil dbUtil = null;
    private ITravelNoteViewDAO travelNoteViewDAO = null;

    public TravelNoteViewDAOProxy() throws Exception {
        this.dbUtil = new DBUtil();
        this.travelNoteViewDAO = new TravelNoteViewDAOImpl(this.dbUtil.getConnection());
    }

    @Override
    public boolean doCreate(TravelNoteView travelNoteView) throws Exception {
        boolean isCreate = false;
        try {
            isCreate = this.travelNoteViewDAO.doCreate(travelNoteView);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return isCreate;
    }

    @Override
    public int getViewNum(int travelNoteId) throws Exception {
        int id = 0;
        try {
            id = this.travelNoteViewDAO.getViewNum(travelNoteId);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return id;
    }

    @Override
    public List<TravelNoteView> findByUserId(int userId) throws Exception {
        List<TravelNoteView> travelNoteViewList = null;
        try {
            travelNoteViewList = this.travelNoteViewDAO.findByUserId(userId);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return travelNoteViewList;
    }
}
