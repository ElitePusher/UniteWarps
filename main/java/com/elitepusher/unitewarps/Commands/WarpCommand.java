package com.elitepusher.unitewarps.Commands;

import com.elitepusher.unitewarps.UniteWarps;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCommand implements CommandExecutor {

    private UniteWarps plugin;

    public WarpCommand(UniteWarps plugin) {
        this.plugin = plugin;
        plugin.getCommand("warp").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage("This command cannot be run through console!");
            return false;
        }
        Player p = (Player) commandSender;
        if (strings.length == 0) {
            p.sendMessage(UniteWarps.prefix + "§cYou have to provide a name!");
            return false;
        }
        String name = strings[0].toLowerCase();
        if (plugin.getConfig().get(name) == null) {
            p.sendMessage(UniteWarps.prefix + "§cThere's not a warp with that name!");
            return false;
        }

        Location loc;
        double x = plugin.getConfig().getDouble(name + ".X");
        double y = plugin.getConfig().getDouble(name + ".Y");
        double z = plugin.getConfig().getDouble(name + ".Z");
        float yaw = (float) plugin.getConfig().getDouble(name + ".Yaw");
        float pitch = (float) plugin.getConfig().getDouble(name + ".Pitch");
        String world = plugin.getConfig().getString(name + ".world");
        loc = new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
        p.teleport(loc);
        p.sendMessage(UniteWarps.prefix + "Teleported to §9" + name);
        return true;
    }
}
