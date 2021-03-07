package com.scp.plugin.scp.utils;

import java.io.PrintWriter;
import java.net.Socket;
import org.bukkit.Bukkit;
public class SocketSender {
    public static Socket s;
    private static PrintWriter pw;
    //Maybe I don't use it
    //and Idk it work..
    public static void sendSocket(String ip,Integer port,String msg) {
        try {
            if (s == null) {
                s = new Socket(ip, port);
                pw = new PrintWriter(s.getOutputStream(), true);
            }
            pw.println( msg );
            pw.close();
            s.close();
        } catch (Exception exception) {}
    }
}//        if(config.getBoolean( "sendData" )){
//            SocketSender.sendSocket( "",70102,"Started this plugin on ");
//            SocketSender.sendSocket( "",70102," BukkitVersion : "+Bukkit.getServer().getBukkitVersion() );
//            SocketSender.sendSocket( "",70102," JavaVersion : "+System.getProperty( "java.version" ) );
//            SocketSender.sendSocket( "",70102," OS : "+System.getProperty( "os.name" ) +" : " +System.getProperty( "os.version" ));
//            SocketSender.sendSocket( "",70102,"^");
//        }
