package com.scp.plugin.scp.commands;

import com.scp.plugin.scp.SCP;
import com.scp.plugin.scp.utils.LogManager;
import org.apache.commons.lang.RandomStringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PasswordChange implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {
        if(sender.hasPermission("scp.commands.password" )){


            if(args.length == 0){
                sender.sendMessage( "§c§lUSAGE: /scp <oldPassword> <newPassword>" );
            }else if(args.length == 1){
                sender.sendMessage( "§c§lUSAGE: /scp <oldPassword> <newPassword>" );
            }else if(args.length == 2){
                if(SCP.password.equals( args[0] )){
                    if(SCP.password.equals( args[1] )){
                        sender.sendMessage( "§c§lSame as the password before the change!" );
                    }else {
                        if(args[1].equalsIgnoreCase( "default" )){
                            sender.sendMessage( "§c§lPGenerating Password..." );
                            String pass = RandomStringUtils.randomAlphanumeric(10);
                            SCP.config.set( "password", pass );
                            Bukkit.getLogger().info( "PASSWORD: "+ pass );
                            Bukkit.getPluginManager().getPlugin("SCP").saveConfig();
                            Bukkit.getPluginManager().getPlugin("SCP").reloadConfig();
                            SCP.password = SCP.config.getString( "password" );
                            sender.sendMessage( "§c§lPassword: "+pass );
                        }else {
                            SCP.password = args[1];
                            SCP.config.set( "password", args[1] );
                            Bukkit.getPluginManager().getPlugin("SCP").saveConfig();
                            Bukkit.getPluginManager().getPlugin("SCP").reloadConfig();
                            SCP.password = SCP.config.getString( "password" );
                            sender.sendMessage( "§c§lPassword: "+args[1] );
                        }
                    }
                }else {
                    sender.sendMessage( "§c§lWrong password!" );
                }
            }else {
                sender.sendMessage( "§c§lUSAGE: /scp <oldPassword> <newPassword>" );
            }

        }

        return true;
    }
}
