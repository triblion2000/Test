package com.triblion.spigot;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Test extends JavaPlugin implements Listener {

    private Player player;
    private String motd;


    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(motd);
        end();
    }

    public void end() {
        for(Player pl: getServer().getOnlinePlayers()) {
            pl.playSound(pl.getLocation(), Sound.ENTITY_ENDERDRAGON_FIREBALL_EXPLODE, 1, 1);
        }
    }



    @Override
    public void onEnable() {

        timer();

        getServer().getPluginManager().registerEvents(this, this);
        saveDefaultConfig();

        motd = getConfig().getString("motd");
        getLogger().info("Plugin Enabled your MOTD is: " + motd);
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled, come back soon");

    }

    public void timer()
    {
        this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
                {
                    public void run()
                    {
                        getServer().broadcastMessage(motd);
                        getLogger().info(motd);
                    }
                }
                , 12000, 12000);
    }


    }
