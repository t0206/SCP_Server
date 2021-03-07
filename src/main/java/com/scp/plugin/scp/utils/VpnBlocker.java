package com.scp.plugin.scp.utils;


import com.scp.plugin.scp.SCP;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.json.simple.JSONObject;
import sun.misc.IOUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

public class VpnBlocker {
    public static boolean isVpnPlayer(Player p) {
        if ( p != null ) {
            if(
                    p.getAddress().getHostName().contains( "vpngate" ) ||
                    p.getAddress().getHostName().contains( "vpn.goldenfrog.com" ) ||
                    p.getAddress().getHostName().contains( "nordvpn.com" )||
                    p.getAddress().getHostName().contains( "ipvanish.com" )||
                    p.getAddress().getHostName().contains( "comcast.net" ) ||
                    p.getAddress().getHostName().contains( "jumptoserver.com" )||
                    p.getAddress().getHostName().contains( "opengw.net" )||
                    p.getAddress().getHostName().contains( "open.ad.jp" )||
                    p.getAddress().getHostName().contains( "goldenfrog.com" )
            ) {
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
