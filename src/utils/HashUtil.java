package utils;

import java.security.MessageDigest;

public class HashUtil {

    public static String sha1(String content) throws Exception {

        MessageDigest md = MessageDigest.getInstance("SHA-1");

        byte[] hashBytes = md.digest(content.getBytes());

        StringBuilder hash = new StringBuilder();

        for (byte b : hashBytes) {
            hash.append(String.format("%02x", b));
        }

        return hash.toString();
    }
}