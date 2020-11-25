package io.github.spikey84.spikeymanhunt;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class spikeymanhunt extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new eListener(),this);
        this.getCommand("target").setExecutor(new cListener());
        Bukkit.getServer().getLogger().info("REEEEEEEEEEEEEEEe");
    }

    @Override
    public void onDisable() {

    }
}
