package dao.proxy;

import dao.ITravelNoteDAO;
import dao.impl.TravelNoteDAOImpl;
import model.TravelNote;
import util.DBUtil;

import java.util.List;

public class TravelNoteDAOProxy implements ITravelNoteDAO {
    private DBUtil dbUtil = null;
    private ITravelNoteDAO travelNoteDAO = null;

    public TravelNoteDAOProxy() throws Exception {
        this.dbUtil = new DBUtil();
        this.travelNoteDAO = new TravelNoteDAOImpl(this.dbUtil.getConnection());
    }

    @Override
    public boolean doCreate(TravelNote travelNote) throws Exception {
        boolean isCreate = false;
        try {
            isCreate = this.travelNoteDAO.doCreate(travelNote);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return isCreate;
    }

    @Override
    public List<TravelNote> findAll() throws Exception {
        List<TravelNote> travelNoteList = null;
        try {
            travelNoteList = this.travelNoteDAO.findAll();
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return travelNoteList;
    }

    @Override
    public TravelNote findById(int id) throws Exception {
        TravelNote travelNote = null;
        try {
            travelNote = this.travelNoteDAO.findById(id);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return travelNote;
    }

    @Override
    public int GetLastestId() throws Exception {
        int id = 0;
        try {
            id = this.travelNoteDAO.GetLastestId();
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return id;
    }
}
