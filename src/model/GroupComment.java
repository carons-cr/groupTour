package model;

import java.util.Date;

public class GroupComment {
    private int id;
    private int systemGroupId;
    private int userId;
    private Date time;
    private String content;

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
