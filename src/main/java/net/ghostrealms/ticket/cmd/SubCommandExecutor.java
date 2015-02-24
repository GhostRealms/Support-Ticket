package net.ghostrealms.ticket.cmd;

import org.bukkit.command.CommandSender;

/**
 * Created by River on 2/23/2015.
 * Class to manage and execute Sub Commands* 
 */

public abstract class SubCommandExecutor {
    
    public abstract void execute(CommandSender sender, String[] arguments);
}
