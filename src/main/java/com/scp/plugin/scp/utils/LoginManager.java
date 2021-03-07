package com.scp.plugin.scp.utils;

import com.scp.plugin.scp.SCP;

public class LoginManager {
    public static boolean tryLogin(String pass){
        if(pass.equals( SCP.password )){
            return true;
        }else {
            return false;
        }
    }
}
