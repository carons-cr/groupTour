package model;

import java.util.Date;

public class GroupOrder {
    private int id;
    private int systemGroupId;
    private int userId;
    private int price;
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSystemGroupId() {
        return systemGroupId;
    }

    public void setSystemGroupId(int systemGroupId) {
        this.systemGroupId = systemGroupId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
