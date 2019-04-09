package dao.factory;

import dao.ISystemGroupDAO;
import dao.IUserDAO;
import dao.proxy.SystemGroupDAOProxy;
import dao.proxy.UserDAOProxy;

public class DAOFactory {
    public static IUserDAO getIUserDAOInstance() throws Exception {
        return new UserDAOProxy();
    }
    public static ISystemGroupDAO getISystemGroupDAOInstance() throws Exception {
        return new SystemGroupDAOProxy();
    }
}
