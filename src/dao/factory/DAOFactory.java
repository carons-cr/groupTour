package dao.factory;

import dao.*;
import dao.proxy.*;

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

    public static ITravelNoteViewDAO getITravelNoteViewDAOInstance() throws Exception {
        return new TravelNoteViewDAOProxy();
    }

    public static IGroupOrderDAO getIGroupOrderDAOInstance() throws Exception {
        return new GroupOrderDAOProxy();
    }

    public static IGroupCommentDAO getIGroupCommentDAOInstance() throws Exception {
        return new GroupCommentDAOProxy();
    }
}
