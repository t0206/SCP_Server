package com.scp.plugin.scp.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SendChat {
    public static void sendChatMessaage(Player p,String msg){
        if(p !=null){
            p.chat( msg );
        }else {
            System.out.println( "[SCP]Failed of sending chat message for player is not online!" );
        }
    }
    public static void sendChatLog(String nick,String msg){
        Bukkit.broadcastMessage( "["+nick+"(SCP)] "+msg );
    }
}
