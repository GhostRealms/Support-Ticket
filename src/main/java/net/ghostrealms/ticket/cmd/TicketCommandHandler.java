package net.ghostrealms.ticket.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by River on 2/23/2015.
 */

public class TicketCommandHandler implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 0) {
            return true;
        }
        return false;
    }
    
}
