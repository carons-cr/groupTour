package dao.impl;

import dao.ITravelNoteImgDAO;
import model.TravelNoteImg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TravelNoteImgDAOImpl implements ITravelNoteImgDAO {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    public TravelNoteImgDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean doCreate(TravelNoteImg travelNoteImg) throws Exception {
        boolean isCreate = false;
        String sql = "insert into travel_note_img (travel_note_id, img_url) values (?, ?)";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, travelNoteImg.getTravelNoteId());
        this.preparedStatement.setString(2, travelNoteImg.getImgUrl());
        isCreate = (this.preparedStatement.executeUpdate() > 0);
        this.preparedStatement.close();
        return isCreate;
    }

    @Override
    public List<TravelNoteImg> findAllByTravelNoteId(int travelNoteId) throws Exception {
        List<TravelNoteImg> travelNoteImgList = new ArrayList<TravelNoteImg>();
        String sql = "select * from travel_note_img where travel_note_id = ?";
        ResultSet resultSet = null;
        TravelNoteImg travelNoteImg = null;
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, travelNoteId);
        resultSet = this.preparedStatement.executeQuery();
        while (resultSet.next()) {
            travelNoteImg = getTravelNoteImgFromResultSet(resultSet);
            travelNoteImgList.add(travelNoteImg);
        }
        this.preparedStatement.close();
        return travelNoteImgList;
    }

    private TravelNoteImg getTravelNoteImgFromResultSet(ResultSet resultSet) throws Exception {
        TravelNoteImg travelNoteImg = new TravelNoteImg();
        travelNoteImg.setId(resultSet.getInt(1));
        travelNoteImg.setTravelNoteId(resultSet.getInt(2));
        travelNoteImg.setImgUrl(resultSet.getString(3));
        return travelNoteImg;
    }
}
