package dao;

import model.TravelNoteImg;

import java.util.List;

public interface ITravelNoteImgDAO {
    public boolean doCreate(TravelNoteImg travelNoteImg) throws Exception;
    public List<TravelNoteImg> findAllByTravelNoteId(int travelNoteId) throws Exception;
}
