package net.ghostrealms.ticket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by River on 2/23/2015.
 * DataManager for the Ticket System * 
 */
public class DataManager {

    private Connection connection = null;
    private SupportTicket instance;
    
    public DataManager(DataManagerContext context, SupportTicket plugin) {
        instance = plugin;
        switch(context) {
            case MYSQL:
                connection = getSQLConnection();
                break;
            case H2:
                connection = geth2Connection();
                break;
            case SQLITE:
                connection = getSQLiteConnection();
                break;
            default:
                connection = null;
        }
    }



    public Connection getConnection() {
        return connection;
    }
    
    private Connection getSQLConnection() {
        String url = "jdbc:mysql://" + instance.sql_host + ":" + instance.sql_port + "/" + instance.sql_database;
        try {
            return DriverManager.getConnection(url, instance.sql_user, instance.sql_password);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private Connection geth2Connection() {
        return null;
    }
    
    private Connection getSQLiteConnection() {
        return null;
    }
    
    
}

enum DataManagerContext {
    MYSQL,
    SQLITE,
    H2;
}
