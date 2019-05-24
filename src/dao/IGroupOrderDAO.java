package dao;

import model.GroupOrder;
import model.User;

import java.util.List;

public interface IGroupOrderDAO {
    public boolean doCreate(GroupOrder groupOrder) throws Exception;
    public List<GroupOrder> findBySystemGroupId(int systemGroupId) throws Exception;
    public List<GroupOrder> findByUserId(int userId) throws Exception;
    public List<Integer> findUserIdListByGroupId(int groupId) throws Exception;
}
