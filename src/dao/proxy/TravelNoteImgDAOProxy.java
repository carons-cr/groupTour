package dao.proxy;

import dao.ITravelNoteImgDAO;
import dao.impl.TravelNoteImgDAOImpl;
import model.TravelNoteImg;
import util.DBUtil;

import java.util.List;

public class TravelNoteImgDAOProxy implements ITravelNoteImgDAO {
    private DBUtil dbUtil = null;
    private ITravelNoteImgDAO travelNoteImgDAO = null;

    public TravelNoteImgDAOProxy() throws Exception {
        this.dbUtil = new DBUtil();
        this.travelNoteImgDAO = new TravelNoteImgDAOImpl(this.dbUtil.getConnection());
    }

    @Override
    public boolean doCreate(TravelNoteImg travelNoteImg) throws Exception {
        boolean isCreate = false;
        try {
            isCreate = this.travelNoteImgDAO.doCreate(travelNoteImg);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return isCreate;
    }

    @Override
    public List<TravelNoteImg> findAllByTravelNoteId(int travelNoteId) throws Exception {
        List<TravelNoteImg> travelNoteImgList = null;
        try {
            travelNoteImgList = this.travelNoteImgDAO.findAllByTravelNoteId(travelNoteId);
        }catch (Exception e) {
            throw e;
        }finally {
            this.dbUtil.closeConnection();
        }
        return travelNoteImgList;
    }
}
