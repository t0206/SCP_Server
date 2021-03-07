package com.scp.plugin.scp.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SendCommands {
    public static void runCommandsByConsole(String cmd){
        Bukkit.getServer( ).dispatchCommand( Bukkit.getConsoleSender(), cmd);
    }
    public static void runCommandsByPlayer(Player p,String cmd){
        if(p !=null){
            Bukkit.getServer( ).dispatchCommand( Bukkit.getConsoleSender(), cmd);
        }else {
            System.out.println( "[SCP]Failed of sending command for player is not online!" );
        }
    }
}
