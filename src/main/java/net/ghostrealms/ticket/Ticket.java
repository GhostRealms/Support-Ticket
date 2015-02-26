package net.ghostrealms.ticket;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

/**
 * Created by River on 2/23/2015.
 * Ticket Object Class* 
 */

public class Ticket {
    
    private int id;
    private long tstamp;
    private Location location;
    private String issue;
    private Map<Integer, String> comments;
    private UUID creator;
    private UUID assigned;
    
    public Ticket(int id) {
        
    }
    
    protected Ticket(UUID owner, Location location, String issue) {
        creator = owner;
        this.location = location;
        this.issue = issue;
    }
    
    public int getId() {
        return id;
    }
    
    public Location getLocation() {
        return location;
    }
    
    public String getIssue() {
        return issue;
    }
    
    public UUID getOwner() {
        return creator;
    }
    
    public UUID getAssignedStaff() {
        return assigned;
    }
    
    public long getTimestamp() {
        return tstamp;
    }
    
    public void teleport(Player user) {
        user.teleport(location);
    }
    
    public void setAssignedMember(UUID staff) {
        this.assigned = staff;
    }
    
    public void addComment(String comment) {
        long time = System.currentTimeMillis();
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
    
    public void update() {
        //TODO query the database using the DataManager and update the ticket values
    }
    
}
