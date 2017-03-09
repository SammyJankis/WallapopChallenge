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
        StringBuilder hexString = new StringBuilder();
        for (byte aMessageDigest : messageDigest) {
            String h = Integer.toHexString(0xFF & aMessageDigest);
            while (h.length() < 2)
                h = "0" + h;
            hexString.append(h);
        }

        return hexString.toString();

    }
}
