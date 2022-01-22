package com.elitepusher.unitewarps.Commands;

import com.elitepusher.unitewarps.UniteWarps;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DelWarpCommand implements CommandExecutor {

    private UniteWarps plugin;

    public DelWarpCommand(UniteWarps plugin) {
        this.plugin = plugin;
        plugin.getCommand("delwarp").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage("This command cannot be run through console!");
            return false;
        }
        Player p = (Player) commandSender;
        if(!p.hasPermission("unitewarps.command.delwarp")) {
            p.sendMessage(UniteWarps.noperm);
            return false;
        }
        if(strings.length == 0) {
            p.sendMessage(UniteWarps.prefix + "§cYou have to provide a name!");
            return false;
        }
        String name = strings[0].toLowerCase();
        if(plugin.getConfig().get(name) == null) {
            p.sendMessage(UniteWarps.prefix + "§cThere's not a warp with that name!");
            return false;
        }
        plugin.getConfig().set(name, null);
        plugin.saveConfig();
        p.sendMessage(UniteWarps.prefix + "Warp §9" + name + " §7was successfully removed!");
        return true;
    }
}
