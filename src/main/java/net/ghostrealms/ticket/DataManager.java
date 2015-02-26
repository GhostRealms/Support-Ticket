package net.ghostrealms.ticket;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

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
    
    public void write(String sql) {
        
    }
    
    public void write(String sql, int retry) {

    }

    /**
     * Convert a Location object to a store-able string * 
     * @param location to serialize
     * @return string value of location
     */
    public String serializeLocation(Location location) {
        String world = location.getWorld().getName();
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();
        float yaw = location.getYaw();
        float pitch = location.getPitch();
        
        return world + ":" + x + ":" + y + ":" + z + ":" + yaw + ":" + pitch;
    }

    /**
     * Convert serialized string objects back to Bukkit location objects.* 
     * @param string to convert
     * @return Bukkit location object
     */
    public Location deserializeLocation(String string) {
        World w;
        double x, y, z;
        float yaw, pitch;
        String[] strings = string.split(":");
        w = Bukkit.getWorld(strings[0]);
        x = Double.parseDouble(strings[1]);
        y = Double.parseDouble(strings[2]);
        z = Double.parseDouble(strings[3]);
        yaw = Float.parseFloat(strings[4]);
        pitch = Float.parseFloat(strings[5]);
        return new Location(w, x, y, z, yaw, pitch);
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
