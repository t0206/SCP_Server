package com.scp.plugin.scp.utils;

public class PropertyManager {
    public static String getPCData(){
        return System.getProperty( "os.name" ) + " : " + System.getProperty( "os.version" ) + " |  "+ System.getProperty( "java.version" );
    }
}
