package connectivity;

import java.sql.*;


import static java.lang.Class.*;

public class ConnectionClass {
    Connection connection;

    public Connection getConnection() {

        String url = "jdbc:mysql://localhost:3307/occ_sa_db";
        String userName = "root";
        String password = "Nikhar1!";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("com.mysql.jdbc.Driver");
            //System.setProperty("jdbc.drivers","com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("coming from class file " + e);
        }

        return connection;
    }

}
