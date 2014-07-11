package raka.teja.config;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author I Made Raka Teja
 */
public class Database {
    
    /*String namaClassDriver = "com.mysql.jdbc.Driver";
        String jdbcUrl = "jdbc:mysql://localhost/dbjavaweb";
        String username = "root";
        String password = "";

        Class.forName(namaClassDriver).newInstance();

        conn = DriverManager.getConnection(jdbcUrl, username, password);*/
        
    private final String USER               = "root";
    private final String PASSWORD           = "";
    private final String CLASS_DRIVER_NAME  = "com.mysql.jdbc.Driver";
    private final String URL                = "jdbc:mysql://localhost/dbjavaweb";
    
    private Connection conn;
    
    public Connection connect() throws InstantiationException, IllegalAccessException, SQLException
    {
        try {
            Class.forName(CLASS_DRIVER_NAME).newInstance();
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public void disconnect()
    {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConn()
    {
        return conn;
    }
}
