package io.github.spikey84.spikeymanhunt;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SpikeyManhunt extends JavaPlugin {

    FileConfiguration config = this.getConfig();
    static Color customBlue = Color.fromRGB(0,196,255);
    static Color customRed = Color.fromRGB(225,59,0);
    static String prefix = ChatColor.BLUE+"["+ChatColor.RED+"SpikeyManhunt"+ChatColor.BLUE+ "] ";

    @Override
    public void onEnable() {
        config.addDefault("OverworldLoc", "world 0 0 0");
        config.addDefault("NetherLoc", "world_nether 0 0 0");
        config.addDefault("EndLoc", "world_the_end 0 0 0");
        config.options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents(new eListener(),this);

        this.getCommand("target").setExecutor(new cListener());
        this.getCommand("compass").setExecutor(new compassCommand());

        Bukkit.getServer().getLogger().info(prefix + "Enabled");
    }

    @Override
    public void onDisable() {

    }
}
