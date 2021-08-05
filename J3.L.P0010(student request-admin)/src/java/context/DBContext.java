package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBContext {

    public static final String HOSTNAME = "localhost";
    public static final String PORT = "1433";
    public static final String DBNAME = "Request";
    public static final String INTEGRATED_SECURITY = "false";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "1234";

    public Connection getConnection() {
        String connectionUrl = "jdbc:sqlserver://" + HOSTNAME
                + ":" + PORT + ";"
                + "databaseName=" + DBNAME + ";"
                + "integratedSecurity=" + INTEGRATED_SECURITY + ";";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Where is your JDBC Driver?");
            return null;
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connectionUrl, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Can't connect!");
            return conn;
        }
        return conn;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Close connection failed!");
            }
        }
    }

    public static void closePreparedStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println("Close PreparedStatement failed!");
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Close ResultSet failed!");
            }
        }
    }
}
