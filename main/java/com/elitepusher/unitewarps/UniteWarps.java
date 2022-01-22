package com.elitepusher.unitewarps;

import com.elitepusher.unitewarps.Commands.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class UniteWarps extends JavaPlugin {

    public Plugin plugin;

    public static String noperm,prefix,ver;

    @Override
    public void onEnable() {
        plugin = this;
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        prefix = getConfig().getString("Messages.Prefix").replace("&", "§");
        noperm = getConfig().getString("Messages.NoPermission").replace("&", "§");
        ver = getConfig().getString("Version.Version");
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.println(" ");
        System.out.println(" [UniteWarps] ▪ Plugin was successfully enabled!");
        System.out.println(" ");
        System.out.println(" [UniteWarps] ▪ Version: " + ver);
        System.out.println(" ");
        System.out.println(" [UniteWarps] ▪ Developed by: ElitePusher#3574");
        System.out.println(" ");
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        new DelWarpCommand(this);
        new SetWarpCommand(this);
        new WarpCommand(this);
        new InfoCommand(this);
    }

    @Override
    public void onDisable() {
        plugin = null;
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.println(" ");
        System.out.println(" [UniteWarps] ▪ Plugin was successfully disabled!");
        System.out.println(" ");
        System.out.println(" [UniteWarps] ▪ Thank you for using, goodbye!");
        System.out.println(" ");
        System.out.println(" [UniteWarps] ▪ Developed by: ElitePusher#3574");
        System.out.println(" ");
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
    }
}
