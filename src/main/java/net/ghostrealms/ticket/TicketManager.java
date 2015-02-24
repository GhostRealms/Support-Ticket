package net.ghostrealms.ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * Created by River on 2/23/2015.
 * Ticket Manager for Loading, caching, and updating tickets throughout the database system* 
 */

public class TicketManager {
    
    private final DataManager manager;
    private Random random = new Random(System.currentTimeMillis());
    private Map<UUID, Integer> sessions = new HashMap<>();
    
    //Stored Objects
    private int lastNumber;
    
    //Configuration values
    private boolean sequential = false;
    
    public TicketManager(DataManager manager) {
        this.manager = manager;
    }
    
    public Ticket createTicket() {
        return null;
    }
    
    public void saveTicket() {
        
    }
    
    public Ticket updateTicket() {
        return null;
    }
    
    public int generateTicketNumber() {
        //TODO check for duplicate numbers
        return random.nextInt(5);
    }
    
    protected Map<UUID, Integer> getAllSessions() {
        return sessions;
    }
    
    public void createSession(UUID user, Integer ticketId) {
        sessions.put(user, ticketId);
    }
    
    public void expireSession(UUID id) {
        sessions.remove(id);
    }
    
    public void updateSession(UUID user, int newSession) {
        sessions.remove(user);
        sessions.put(user, newSession);
    }
    
    
    
    
    
}
