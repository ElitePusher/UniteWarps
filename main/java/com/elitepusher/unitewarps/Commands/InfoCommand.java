package com.elitepusher.unitewarps.Commands;

import com.elitepusher.unitewarps.UniteWarps;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class InfoCommand implements CommandExecutor {

    private UniteWarps plugin;

    public InfoCommand(UniteWarps plugin) {
        this.plugin = plugin;
        plugin.getCommand("uniteinfo");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
            commandSender.sendMessage(ChatColor.BLACK + "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛");
            commandSender.sendMessage(" ");
            commandSender.sendMessage(ChatColor.GRAY + "This plugin is developed by: §9ElitePusher#3574");
            commandSender.sendMessage(" ");
            commandSender.sendMessage(ChatColor.GRAY + "Version: §9 " +UniteWarps.ver);
            commandSender.sendMessage(" ");
            commandSender.sendMessage(ChatColor.AQUA + "@UniteWarps | All rights reserved!");
            commandSender.sendMessage(" ");
            commandSender.sendMessage(ChatColor.BLACK + "⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛");
        return true;
    }
}