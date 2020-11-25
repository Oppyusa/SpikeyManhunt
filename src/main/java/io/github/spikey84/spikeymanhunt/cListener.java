package io.github.spikey84.spikeymanhunt;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cListener implements CommandExecutor {

     public static Player tar;


    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        commandSender.sendMessage("worked!");
        if(args.length != 1) return false;
        tar = Bukkit.getPlayer(args[0]);
        return true;
    }
}
