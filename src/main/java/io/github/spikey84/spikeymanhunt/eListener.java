package io.github.spikey84.spikeymanhunt;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;

import static io.github.spikey84.spikeymanhunt.cListener.tar;

public class eListener implements Listener {

    Location[] cLocs = new Location[3];
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

    public void checkCompass(ItemStack I, Player P) {
        if(I == null || I.getType() != Material.COMPASS || !I.getItemMeta().getDisplayName().contains("Tracking: ")) return;
        CompassMeta cM = (CompassMeta) I.getItemMeta();
        cM.setLodestoneTracked(false);
        cM.setLodestone(locs[world(P.getLocation())]);
        I.setItemMeta(cM);
    }

    public void giveCompass(Player P,PlayerInteractEvent E) {

        if(!P.isSneaking() || E.getMaterial() != Material.AIR) return;
        ItemStack comp = new ItemStack(Material.COMPASS);
        CompassMeta cM = (CompassMeta) comp.getItemMeta();
        cM.setLodestoneTracked(false);
        cM.setLodestone(cLocs[world(P.getPlayer().getLocation())]);
        if(tar != null) cM.setDisplayName("Tracking: " + tar.getName()); else cM.setDisplayName("Tracking: " + "None");
        comp.setItemMeta(cM);
        P.getPlayer().getInventory().setItemInMainHand(comp);
    }


    @EventHandler
    public void interactEvent(PlayerInteractEvent event) {

        giveCompass(event.getPlayer(),event);

        if(event.getItem() == null || event.getItem().getType() != Material.COMPASS) return;

        for(int i = 0;i<cLocs.length;i++) {
            locs[i] = cLocs[i];
        }
        Location loc = cLocs[world(event.getPlayer().getLocation())];
        if(loc == null) return;

        CompassMeta cM = (CompassMeta) event.getItem().getItemMeta();
        cM.setLodestoneTracked(false);
        cM.setLodestone(loc);
        cM.setDisplayName("Tracking: " + tar.getName());
        event.getItem().setItemMeta(cM);

        event.getPlayer().sendMessage("Player " + tar.getName()+" located at "+ Integer.toString(loc.getBlockX())+" "+Integer.toString(loc.getBlockY())+ " "+Integer.toString(loc.getBlockZ())+" in the "+ loc.getWorld().getName());
    }

    @EventHandler
    public void moveEvent(PlayerMoveEvent event) {
        if(tar != event.getPlayer()) return;
        cLocs[world(event.getFrom())] = event.getFrom();
    }

    @EventHandler
    public void moveWorld(PlayerChangedWorldEvent event) {
        for(int i = 0; i<event.getPlayer().getInventory().getContents().length;i++) checkCompass(event.getPlayer().getInventory().getContents()[i], event.getPlayer());
    }
}
