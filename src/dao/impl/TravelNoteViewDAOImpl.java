package dao.impl;

import dao.ITravelNoteViewDAO;
import model.TravelNoteView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TravelNoteViewDAOImpl implements ITravelNoteViewDAO {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    public TravelNoteViewDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean doCreate(TravelNoteView travelNoteView) throws Exception {
        boolean isCreate = false;
        String sql = "insert into travel_note_view (travel_note_id, user_id) values (?, ?)";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, travelNoteView.getTravelNoteId());
        this.preparedStatement.setInt(2, travelNoteView.getUserId());
        isCreate = (this.preparedStatement.executeUpdate() > 0);
        this.preparedStatement.close();
        return isCreate;
    }

    @Override
    public int getViewNum(int travelNoteId) throws Exception {
        int id = 0;
        String sql = "select count(*) from travel_note_view where travel_note_id = ?";
        ResultSet resultSet = null;
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, travelNoteId);
        resultSet = this.preparedStatement.executeQuery();
        if (resultSet.next())
            id = resultSet.getInt(1);
        this.preparedStatement.close();
        return id;
    }

    @Override
    public List<TravelNoteView> findByUserId(int userId) throws Exception {
        List<TravelNoteView> travelNoteViewList = null;
        String sql = "SELECT * FROM travel_note_view WHERE user_id = ?";
        ResultSet resultSet = null;
        TravelNoteView travelNoteView = null;
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, userId);
        resultSet = this.preparedStatement.executeQuery();
        if (resultSet.next()) {
            travelNoteViewList = new ArrayList<TravelNoteView>();
            travelNoteView = getTravelNoteViewFromResultSet(resultSet);
            travelNoteViewList.add(travelNoteView);
            while (resultSet.next()) {
                travelNoteView = getTravelNoteViewFromResultSet(resultSet);
                travelNoteViewList.add(travelNoteView);
            }
        }
        this.preparedStatement.close();
        return travelNoteViewList;
    }

    private TravelNoteView getTravelNoteViewFromResultSet(ResultSet resultSet) throws Exception {
        TravelNoteView travelNoteView = new TravelNoteView();
        travelNoteView.setId(resultSet.getInt(1));
        travelNoteView.setTravelNoteId(resultSet.getInt(2));
        travelNoteView.setUserId(resultSet.getInt(3));
        return travelNoteView;
    }
}
