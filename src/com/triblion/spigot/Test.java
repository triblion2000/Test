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

    //Heres the rest i should have given you before giving you your rank. Using the Spigot API (either 1.7 or 1.9) create a plugin that meets the following criteria:

        //Plugin supplies its own default config file that contains a message of the day.

        //Performs the six tasks below.

        //When the plugin is loaded:
        //- Build the default config (if config is not present) with a single string for message of the day (motd).
       // - Prints the message of the day to the console via configured motd.
       // - Starts a synchronous task to broadcast the message of the day every 10 minutes.
       // - Plays a sound to a player when they join the server.

      //  When the plugin is unloaded:
       // - Send a sad message to console that the console is being unloaded.
       // - Cancel all running tasks.

       // Once you've completed the project, upload it to github and reply with a link to the project. You have 4 days to complete this from the time of this message.