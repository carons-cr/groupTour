package dao.impl;

import dao.ITravelNoteDAO;
import model.TravelNote;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TravelNoteDAOImpl implements ITravelNoteDAO {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    public TravelNoteDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean doCreate(TravelNote travelNote) throws Exception {
        boolean isCreate = false;
        String sql = "INSERT INTO travel_note (user_id, title, cover_img_url, article, time)" +
                " VALUES (?, ?, ?, ?, ?)";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, travelNote.getUserId());
        this.preparedStatement.setString(2, travelNote.getTitle());
        this.preparedStatement.setString(3, travelNote.getCoverImgUrl());
        this.preparedStatement.setString(4, travelNote.getArticle());
        this.preparedStatement.setDate(5, new java.sql.Date(travelNote.getTime().getTime()));
        isCreate = (this.preparedStatement.executeUpdate() > 0);
        this.preparedStatement.close();
        return isCreate;
    }

    @Override
    public List<TravelNote> findAll() throws Exception {
        List<TravelNote> travelNoteList = null;
        String sql = "SELECT * FROM travel_note ORDER BY id DESC";
        ResultSet resultSet = null;
        this.preparedStatement = this.connection.prepareStatement(sql);
        resultSet = this.preparedStatement.executeQuery();
        travelNoteList = getTravelNoteListFromResultSet(resultSet);
        this.preparedStatement.close();
        return travelNoteList;
    }

    @Override
    public TravelNote findById(int id) throws Exception {
        TravelNote travelNote = null;
        String sql = "SELECT * FROM travel_note WHERE id = ?";
        ResultSet resultSet = null;
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, id);
        resultSet = this.preparedStatement.executeQuery();
        if (resultSet.next())
            travelNote = getTravelNoteFromResultSet(resultSet);
        this.preparedStatement.close();
        return travelNote;
    }

    @Override
    public int GetLastestId() throws Exception {
        int id = 0;
        String sql = "SELECT max(id) FROM travel_note";
        ResultSet resultSet = null;
        this.preparedStatement = this.connection.prepareStatement(sql);
        resultSet = this.preparedStatement.executeQuery();
        if (resultSet.next())
            id = resultSet.getInt(1);
        this.preparedStatement.close();
        return id;
    }

    @Override
    public List<TravelNote> findByUserId(int userId) throws Exception {
        List<TravelNote> travelNoteList = null;
        String sql = "SELECT * FROM travel_note WHERE user_id = ?";
        ResultSet resultSet = null;
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, userId);
        resultSet = this.preparedStatement.executeQuery();
        travelNoteList = getTravelNoteListFromResultSet(resultSet);
        this.preparedStatement.close();
        return travelNoteList;
    }

    private TravelNote getTravelNoteFromResultSet(ResultSet resultSet) throws Exception {
        TravelNote travelNote = new TravelNote();
        travelNote.setId(resultSet.getInt(1));
        travelNote.setUserId(resultSet.getInt(2));
        travelNote.setTitle(resultSet.getString(3));
        travelNote.setCoverImgUrl(resultSet.getString(4));
        travelNote.setArticle(resultSet.getString(5));
        travelNote.setTime(resultSet.getDate(6));
        return travelNote;
    }

    private List<TravelNote> getTravelNoteListFromResultSet(ResultSet resultSet) throws Exception {
        List<TravelNote> travelNoteList = null;
        TravelNote travelNote = null;
        if (resultSet.next()) {
            travelNoteList = new ArrayList<TravelNote>();
            travelNote = getTravelNoteFromResultSet(resultSet);
            travelNoteList.add(travelNote);
            while (resultSet.next()) {
                travelNote = getTravelNoteFromResultSet(resultSet);
                travelNoteList.add(travelNote);
            }
        }
        return travelNoteList;
    }
}
