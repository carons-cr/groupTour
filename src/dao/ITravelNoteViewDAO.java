package dao;

import model.TravelNoteView;

public interface ITravelNoteViewDAO {
    public boolean doCreate(TravelNoteView travelNoteView) throws Exception;
    public int getViewNum(int travelNoteId) throws Exception;
}
