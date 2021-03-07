package com.scp.plugin.scp.events;

import com.scp.plugin.scp.SCP;
import com.scp.plugin.scp.utils.VpnBlocker;
import com.scp.plugin.scp.utils.VpnPunish;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if( SCP.config.getBoolean( "anti-vpn.check-of-host-name" )){
            if(VpnBlocker.isVpnPlayer( e.getPlayer() )){
                VpnPunish.sendWars( e.getPlayer() );
                Bukkit.getLogger( ).warning( e.getPlayer().getName() + " is vpn (host name check)" );
                VpnPunish.vpnKick( e.getPlayer() );
            }
        }
    }
}
