package com.perennial.bookhub.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {
    public static String encrypt(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(password.getBytes());
        
        byte[] bytes = messageDigest.digest();
        
        StringBuilder builder = new StringBuilder();
        
        for(int i=0; i< bytes.length ;i++) {  
            builder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        return builder.toString();
    }
}
