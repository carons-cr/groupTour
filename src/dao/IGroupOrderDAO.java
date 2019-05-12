package dao;

import model.GroupOrder;

import java.util.List;

public interface IGroupOrderDAO {
    public boolean doCreate(GroupOrder groupOrder) throws Exception;
    public List<GroupOrder> findBySystemGroupId(int systemGroupId) throws Exception;
    public GroupOrder findByUserId(int userId) throws Exception;
}
