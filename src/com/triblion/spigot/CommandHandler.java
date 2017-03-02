package com.triblion.spigot;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getMotd;
import static org.bukkit.Bukkit.getServer;

public class CommandHandler implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player sender = (Player) commandSender;

        if(((Player) commandSender).performCommand("ic")) {
            sender.sendMessage("hi");
        }
        return false;

    }
}

