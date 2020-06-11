/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.recycling.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author WINDOWS
 */
public class Cryptography {
    public static String criptografia(String password){
        String passwordModified = null;
        MessageDigest messageDigest;
        
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            BigInteger bigInteger = new BigInteger(1,messageDigest.digest(password.getBytes()));
            passwordModified = bigInteger.toString(16);
        } catch (NoSuchAlgorithmException ex) {
            System.err.println(ex.getMessage());
        }
       
        return passwordModified;
    }
}
