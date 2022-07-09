package jm.task.core.jdbc.util;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static Util util;
    private static Connection connection;
    public static Connection getSQLConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String userName = "djurayevumid";
            String password = "James4root!!";
            String connectionUrl = "jdbc:mysql://localhost:3306/smth";
            connection = DriverManager.getConnection(connectionUrl, userName, password);

        }catch (ClassNotFoundException e) {
            System.out.println("ConnectionERROR: " + e.getMessage());
        }
        return connection;
    }
    public static Util getInstance() throws SQLException {
        if (util == null) {
            util = new Util();
        } else if (util.getSQLConnection().isClosed()) {
            util = new Util();
        }
        return util;
    }


}
