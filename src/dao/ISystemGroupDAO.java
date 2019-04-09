package dao;

import model.SystemGroup;

import java.util.List;

public interface ISystemGroupDAO {
    public List<SystemGroup> findAll() throws Exception;
    public SystemGroup findById(int id) throws Exception;
}
