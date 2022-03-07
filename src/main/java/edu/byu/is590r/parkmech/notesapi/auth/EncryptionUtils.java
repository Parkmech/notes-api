package edu.byu.is590r.parkmech.notesapi.auth;

import org.apache.commons.codec.digest.DigestUtils;

public class EncryptionUtils {
    private static String salt;
    public static String encryptString(String value) {
        return DigestUtils.sha256Hex(value + salt);
    }
}
