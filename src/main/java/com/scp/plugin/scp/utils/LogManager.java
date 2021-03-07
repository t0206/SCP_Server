package com.scp.plugin.scp.utils;

import com.scp.plugin.scp.SCP;
import org.bukkit.Bukkit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LogManager {
    public static String[] arglog;
    public static  Integer arglogv = 0;

    public static String getLog(){
        String log = "";
        try {
            @SuppressWarnings("resource")
            InputStream is = new FileInputStream(System.getProperty("user.dir")+"/logs/latest.log");
            int size = is.available();
            String test = "";
            arglogv = 0;
            for(int i = 0;i < size;i++){
                test += Character.toString((char)is.read());
                //arglog[arglogv] = Character.toString((char)is.read());
                //arglogv = arglogv + 1;
            }
            log = test;

        }catch(IOException e) {
            e.printStackTrace();
        }
        return log;
    }
    // maybe it not use ..?
//    public static String getLatestLog(){
//        String log = "";
//        getLog();
//        Integer allargs = arglog.length;
//        //最新のログ( config.ymlで変更可能)を送信するコードが思い浮かびません
//        if(SCP.config.getInt( "linage" ) > allargs){
//            Integer cs = SCP.config.getInt( "linage" ) - allargs;
//            Integer ars = SCP.config.getInt( "linage" ) - cs;
//            for(int ct1 = 0; ct1 == ars;){
//                log = log+ arglog[ct1]+"\n";
//                ct1 = ct1 + 1;
//            }
//        }else{
//
//        }
//        return log; //送信するのはこれって感じですね
//    }
}
