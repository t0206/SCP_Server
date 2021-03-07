package com.scp.plugin.scp.commands;


import com.scp.plugin.scp.SCP;
import com.scp.plugin.scp.utils.VpnBlocker;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VpnCheckCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {
        if(sender.hasPermission( "scp.commands.vpncheck" )){
            if( SCP.config.getBoolean( "anti-vpn.check-of-host-name" )){
                if(args.length == 0){
                    sender.sendMessage( "§k-§r §c§lSCP-VPN-CHECKER §c/vpncheck <player>" );
                }else if(args.length == 1){
                    Player p = Bukkit.getPlayer( args[0]);
                 if(p !=null){
                     if( VpnBlocker.isVpnPlayer( p ) ){
                         sender.sendMessage( "§k-§r §c§lSCP-VPN-CHECKER §e"+args[0]+"§c is using vpn!" );
                     }else {
                         sender.sendMessage( "§k-§r §c§lSCP-VPN-CHECKER §e"+args[0]+"§c is not using vpn!" );
                     }
                 }else {
                     sender.sendMessage( "§k-§r §c§lSCP-VPN-CHECKER §e"+args[0]+"§c is not online!" );
                 }
                }
            }else {
                sender.sendMessage( "§k-§r §c§lSCP-VPN-CHECKER §cVpnChecker (Host Name Check ) is not enabled!" );
            }
        }else {
            sender.sendMessage( "§k-§r §c§lSCP-VPN-CHECKER §cYou can't use this command!" );
        }
        return true;
    }
}
