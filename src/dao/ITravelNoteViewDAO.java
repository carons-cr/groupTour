package dao;

import model.TravelNoteView;

import java.util.List;

public interface ITravelNoteViewDAO {
    public boolean doCreate(TravelNoteView travelNoteView) throws Exception;
    public int getViewNum(int travelNoteId) throws Exception;
    public List<TravelNoteView> findByUserId(int userId) throws Exception;
}
