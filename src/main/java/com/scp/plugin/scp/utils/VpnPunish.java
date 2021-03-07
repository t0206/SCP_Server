package com.scp.plugin.scp.utils;

import com.scp.plugin.scp.SCP;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class VpnPunish {
    public static void sendWars(Player p){
        if( SCP.config.getBoolean( "anti-vpn.check-of-host-name.punish.warn-to-chat.enable" )){
            if(SCP.config.getString( "anti-vpn.check-of-host-name.punish.warn-to-chat.permission" ).equalsIgnoreCase( "all" )){
            }else {
                String prms = SCP.config.getString( "anti-vpn.check-of-host-name.punish.warn-to-chat.permission" );
                for(Player alp: Bukkit.getOnlinePlayers( )){
                    if(alp.hasPermission( prms )){
                        alp.sendMessage("§k-§r §c§lSCP-VPN-CHECKER §e"+p.getName()+" §c is VPN!§7(host name check)");
                    }
                }
            }
        }
    }
    public static void vpnKick(Player p){
        if( SCP.config.getBoolean( "anti-vpn.check-of-host-name.punish.auto-punish" )){
            p.kickPlayer( "vpn is not allowed on this server! ( host name check )" );
        }
    }
}
