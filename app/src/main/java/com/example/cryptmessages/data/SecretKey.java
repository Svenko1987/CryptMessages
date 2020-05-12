package com.example.cryptmessages.data;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.spec.SecretKeySpec;

public class SecretKey {
    private SecretKeySpec secretKey;
    private byte[] keyByte;


    public SecretKey(String myKey) {
        try {


            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            this.keyByte = myKey.getBytes("UTF-8");
            digest.update(this.keyByte, 0, this.keyByte.length);
            byte[] key = digest.digest();
            this.secretKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public SecretKeySpec getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(SecretKeySpec secretKey) {
        this.secretKey = secretKey;
    }

    public byte[] getKeyByte() {
        return keyByte;
    }

    public void setKeyByte(byte[] keyByte) {
        this.keyByte = keyByte;
    }
}
