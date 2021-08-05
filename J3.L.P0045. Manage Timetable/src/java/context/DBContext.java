package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
     public Connection getConnection()throws Exception {
        String url = "jdbc:sqlserver://"+serverName+":"+portNumber +";databaseName="+dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
    private final String serverName = "HUNG\\SQLEXPRESS";
    private final String dbName = "Timetable";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "1234";
}