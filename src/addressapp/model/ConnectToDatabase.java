/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressapp.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ana Pimenta
 */
public class ConnectToDatabase {

    public static Connection createConnection() {
        String dbUrl = "url aqui";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

}

