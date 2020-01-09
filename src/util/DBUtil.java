package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil{
    private Connection connection = null;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/grouptour?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mysql";

    public DBUtil() throws Exception{
        Class.forName(DRIVER);
        this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() throws Exception{
        if (this.connection != null)
            this.connection.close();
    }
}
