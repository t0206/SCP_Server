package com.scp.plugin.scp.utils;


import com.scp.plugin.scp.SCP;

public class ConfigManager {
    public static String getString(String path){
        return ""+SCP.config.get( path   );
    }
}
