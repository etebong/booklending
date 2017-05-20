/*
 this establishes a onnection to the mysql database
 with root as the username
 and no password for the password

*/
package database;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
import java.sql.*;

public class ConnectDb {

    public static Connection connect() {
        Connection con = null;

        try {
            String url = "jdbc:mysql://localhost/booklending?useSSL=false";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(url, username, password);

            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

}
