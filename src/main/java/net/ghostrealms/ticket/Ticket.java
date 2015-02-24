package net.ghostrealms.ticket;

import org.bukkit.Location;

import java.util.Map;
import java.util.UUID;

/**
 * Created by River on 2/23/2015.
 * Ticket Object Class* 
 */

public class Ticket {
    
    private int id;
    private int tstamp;
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
    
}
