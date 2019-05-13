package dao;

import model.TravelNote;

import java.util.List;

public interface ITravelNoteDAO {
    public boolean doCreate(TravelNote travelNote) throws Exception;
    public List<TravelNote> findAll() throws Exception;
    public TravelNote findById(int id) throws Exception;
    public int GetLastestId() throws Exception;
    public List<TravelNote> findByUserId(int userId) throws Exception;
}
