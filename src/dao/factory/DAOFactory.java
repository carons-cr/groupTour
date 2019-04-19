package dao.factory;

import dao.ISystemGroupDAO;
import dao.ITravelNoteDAO;
import dao.ITravelNoteImgDAO;
import dao.IUserDAO;
import dao.proxy.SystemGroupDAOProxy;
import dao.proxy.TravelNoteDAOProxy;
import dao.proxy.TravelNoteImgDAOProxy;
import dao.proxy.UserDAOProxy;

public class DAOFactory {
    public static IUserDAO getIUserDAOInstance() throws Exception {
        return new UserDAOProxy();
    }

    public static ISystemGroupDAO getISystemGroupDAOInstance() throws Exception {
        return new SystemGroupDAOProxy();
    }

    public static ITravelNoteDAO getITravelNoteDAOInstance() throws Exception {
        return new TravelNoteDAOProxy();
    }

    public static ITravelNoteImgDAO getITravelNoteImgDAOInstance() throws Exception {
        return new TravelNoteImgDAOProxy();
    }
}
