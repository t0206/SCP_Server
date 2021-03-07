package com.scp.plugin.scp;

import com.scp.plugin.scp.commands.PasswordChange;

import com.scp.plugin.scp.commands.VpnCheckCmd;
import com.scp.plugin.scp.events.JoinEvent;
import com.scp.plugin.scp.models.LogText;
import com.scp.plugin.scp.utils.LogManager;
import io.javalin.Javalin;
import org.apache.commons.lang.RandomStringUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public final class SCP extends JavaPlugin {
    public static FileConfiguration config;
    public static String password;
    public static Plugin plugin;
    public static Integer jport = 7001;
    public static Javalin app = null;
    @Override
    public void onEnable() {
        PluginManager pm = Bukkit.getPluginManager();
        plugin = this;
        saveDefaultConfig( );
        config = getConfig( );
        password = config.getString( "password" );
        if ( password.equalsIgnoreCase( "default" ) ) {
            Bukkit.getLogger( ).info( "PASSWORD IS DEFAULT! Generating password..." );
            String pass = RandomStringUtils.randomAlphanumeric( 10 );
            config.set( "password",pass );
            Bukkit.getLogger( ).info( "PASSWORD: " + pass );
            Bukkit.getPluginManager( ).getPlugin( "SCP" ).saveConfig( );
            Bukkit.getPluginManager( ).getPlugin( "SCP" ).reloadConfig( );
            password = config.getString( "password" );
        }
        getCommand( "scp" ).setExecutor( new PasswordChange( ) );
        getCommand( "vpncheck" ).setExecutor( new VpnCheckCmd() );
        jport = config.getInt( "port" );
        Bukkit.getLogger().info( "Use "+Bukkit.getServer().getIp()+":"+jport+" to connect to the console of this server! (Port "+jport+" must be open!");
        setupWebServer();

        pm.registerEvents( new JoinEvent() , this );
    }
    private void setupWebServer()
    {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        Thread.currentThread().setContextClassLoader(SCP.class.getClassLoader());
        app = Javalin.create().start(jport);

        app.get("/logs", context ->{
            String log = LogManager.getLog();
            LogText logtext = new LogText( log );
            context.json( logtext );
        });

        Thread.currentThread().setContextClassLoader(classLoader); }


}
