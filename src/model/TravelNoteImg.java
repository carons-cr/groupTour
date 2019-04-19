package model;

public class TravelNoteImg {
    private int id;
    private int travelNoteId;
    private String imgUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTravelNoteId() {
        return travelNoteId;
    }

    public void setTravelNoteId(int travelNoteId) {
        this.travelNoteId = travelNoteId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
