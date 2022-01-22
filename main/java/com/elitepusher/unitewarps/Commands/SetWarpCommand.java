package com.elitepusher.unitewarps.Commands;

import com.elitepusher.unitewarps.UniteWarps;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetWarpCommand implements CommandExecutor {

    private UniteWarps plugin;

    public SetWarpCommand(UniteWarps plugin) {
        this.plugin = plugin;
        plugin.getCommand("setwarp").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage("This command cannot be run through console!");
            return false;
        }
        Player p = (Player) commandSender;
        if(!p.hasPermission("unitewarps.command.setwarp")) {
            p.sendMessage(UniteWarps.noperm);
            return false;
        }
        if(strings.length == 0) {
            p.sendMessage(UniteWarps.prefix + "§cYou have to provide a name!");
            return false;
        }
        String name = strings[0].toLowerCase();
        if(plugin.getConfig().get(name) != null) {
            p.sendMessage(UniteWarps.prefix + "§cThere's already a warp with that name!");
            return false;
        }
        Location loc = p.getLocation();
        plugin.getConfig().set(name + ".world", loc.getWorld().getName());
        plugin.getConfig().set(name + ".X", loc.getX());
        plugin.getConfig().set(name + ".Y", loc.getY());
        plugin.getConfig().set(name + ".Z", loc.getZ());
        plugin.getConfig().set(name + ".Pitch", loc.getPitch());
        plugin.getConfig().set(name + ".Yaw", loc.getYaw());
        plugin.saveConfig();
        p.sendMessage(UniteWarps.prefix + "Warp §9" + name + " §7was successfully set!");
        return true;
    }
}
