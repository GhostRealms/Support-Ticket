package net.ghostrealms.ticket;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by River on 2/23/2015.
 * Main Class for the Support Tickets Plugin *
 * Licensed under Apache 2 *
 * Originally Created for the Ghost Realms server* 
 */
public class SupportTicket extends JavaPlugin {
    
    private static SupportTicket instance;
    
    protected boolean networkMode = false;
    protected String serverKey = "Local";
    
    protected boolean sql_mode = false;
    protected String sql_host = "127.0.0.1";
    protected String sql_user = "root";
    protected String sql_password;
    protected int sql_port = 3306;
    protected String sql_database = "tickets";
    protected String sql_table;
    
    protected boolean h2_mode = false;
    protected boolean sqlite_mode = false;
    
    private DataManager dataManager;
    private TicketManager ticketManager;

    @Override
    public void onEnable() {
        
        //Configuration
        this.saveDefaultConfig();
        sql_mode = this.getConfig().getBoolean("data.mysql");
        if(sql_mode) {
            sql_host = this.getConfig().getString("data.mysql.host");
            sql_user = this.getConfig().getString("data.mysql.user");
            sql_password = this.getConfig().getString("data.mysql.pass");
            sql_port = this.getConfig().getInt("data.mysql.port");
            sql_database = this.getConfig().getString("data.mysql.database");
            sql_table = this.getConfig().getString("data.mysql.table");
            dataManager = new DataManager(DataManagerContext.MYSQL, this);
        } else if (h2_mode) {
            disable("h2 is currently disabled");
        } else if(sqlite_mode) {
            disable("sqlite is currently disabled");
        }
        
        //Configuration - BungeeCord specific settings, for teleporting to ticket locations x-server
        networkMode = this.getConfig().getBoolean("bungeecord");
        serverKey = this.getConfig().getString("bungeecord.server-key");
        
        //Create the Ticket Manager, Load tickets into cache. Pass the Data Manager into the constructor
        ticketManager = new TicketManager(dataManager);
        
        
        instance = this;
    }
    
    @Override
    public void onDisable() {

    }
    
    public TicketManager getTicketManager() {
        return ticketManager;
    }
    
    public DataManager getDataManager() {
        return dataManager;
    }

    /**
     * Disable the Plugin, can be used by external classes rather than disabling using a constructed object 
     * @deprecated use {link #disable(String reason)}
     */
    @Deprecated
    protected void disable() {
        getLogger().info("Disabled by disable() Please NAG for better messages!");
        getServer().getPluginManager().disablePlugin(this);
    }
    
    protected void disable(String reason) {
        getLogger().info("Disabled by disable(): " + reason);
        getServer().getPluginManager().disablePlugin(this);
    }
    
    public static SupportTicket getInstance() {
        return instance;
    }
    
}
