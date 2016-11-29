package com.antasexample.loginapp;

import android.util.Base64;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by antas on 2016-11-29.
 */

public class PasswordHash {

    public static String doTigerHashCheck(String pass) throws Exception
    {

        //String Hex = toHex(pass);

        byte[] bytesOfMessage = pass.getBytes("UTF-8");

        MessageDigest md = MessageDigest.getInstance("MD5");
         byte[] thedigest = md.digest(bytesOfMessage);
        String hashPassword = Base64.encodeToString(thedigest, 1);

        //String  = toHex(tempHash);
        return  hashPassword;

    }

    private static String toHex(String arg) {
        return String.format("%016x", new BigInteger(arg.getBytes(/*YOUR_CHARSET?*/)));
       //String a =  Base64.encode(arg);
    }

}
