package io.github.spikey84.spikeymanhunt;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class compassCommand implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (((Player)commandSender) == null) return false;
        if(commandSender.isOp() == false || args.length == 0) eListener.giveCompass(Bukkit.getPlayer(((Player) commandSender).getName())); else {
            if (Bukkit.getPlayer(args[0]) == null) return false;
            eListener.giveCompass(Bukkit.getPlayer(args[0]));
        }
        return true;

    }
}
