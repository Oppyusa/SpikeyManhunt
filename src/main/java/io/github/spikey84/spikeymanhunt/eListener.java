package io.github.spikey84.spikeymanhunt;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedMainHandEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;


public class eListener implements Listener {

    Location[] locs = new Location[3];


    public int world(Location IN) {
        if(IN.getWorld().getName().contains("the_end")) {
            return 2;
        } else if(IN.getWorld().getName().contains("nether")){
            return 1;
        } else {
            return 0;
        }
    }
    @EventHandler
    public void interactEvent(PlayerInteractEvent event) {
        if(event.getItem() == null) return;
        if(event.getItem().getType() != Material.COMPASS) return;
        Bukkit.getLogger().info("Compass");

        int currentWorld= world(event.getPlayer().getLocation());
        Location loc = locs[currentWorld];
        Bukkit.getLogger().info(Integer.toString(currentWorld));

        event.getPlayer().setCompassTarget(loc);
        event.getPlayer().sendMessage("Player " + cListener.tar.getName()+" located at "+ Integer.toString(loc.getBlockX())+" "+Integer.toString(loc.getBlockY())+ " "+Integer.toString(loc.getBlockZ())+" in the "+ loc.getWorld().getName());
        //event.get

    }

    @EventHandler
    public void moveEvent(PlayerMoveEvent event) {
        if(cListener.tar != event.getPlayer()) return;
        Player pl = event.getPlayer();
        locs[world(event.getFrom())] = event.getFrom();
        Bukkit.getLogger().info(event.getFrom().getWorld().getName());






    }
}
