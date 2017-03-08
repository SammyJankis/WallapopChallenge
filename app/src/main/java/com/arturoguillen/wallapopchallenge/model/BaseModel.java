package com.arturoguillen.wallapopchallenge.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by artu on 3/8/17.
 */

public class BaseModel {

    public static String md5(String s) throws NoSuchAlgorithmException {
        // MD5 Hash
        MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
        digest.update(s.getBytes());
        byte messageDigest[] = digest.digest();

        // Hex String
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < messageDigest.length; i++)
            hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
        return hexString.toString();

    }
}
