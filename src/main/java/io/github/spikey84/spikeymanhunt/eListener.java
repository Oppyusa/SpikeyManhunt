package io.github.spikey84.spikeymanhunt;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;


public class eListener implements Listener {

    @EventHandler
    public void interactEvent(PlayerInteractEvent event) {
        if(event.getItem() == null) return;
        if(event.getItem().getType() != Material.COMPASS) return;
        Bukkit.getLogger().info("Compass");
        if(cListener.tar==null) return;
        event.getPlayer().setCompassTarget(cListener.tar.getLocation());
        event.getPlayer().sendMessage("Player " + cListener.tar.getName()+" located at "+ Integer.toString(cListener.tar.getLocation().getBlockX())+" "+Integer.toString(cListener.tar.getLocation().getBlockY())+ " "+Integer.toString(cListener.tar.getLocation().getBlockZ())+" in the "+ cListener.tar.getLocation().getWorld().getName());
        //event.get

    }
}
