package io.github.spikey84.spikeymanhunt;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cListener implements CommandExecutor {

     public static Player tar;


    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if(args.length != 1) return false;
        if(Bukkit.getPlayer(args[0]) == null) {
            commandSender.sendMessage(spikeymanhunt.prefix+"Invalid Player.");
            return true;
        }
        tar = Bukkit.getPlayer(args[0]);
        commandSender.sendMessage(spikeymanhunt.prefix+tar.getName()+" is now being tracked.");
        return true;
    }

}
