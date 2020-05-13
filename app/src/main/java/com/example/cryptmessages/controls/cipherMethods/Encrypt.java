package com.example.cryptmessages.controls.cipherMethods;


import android.util.Base64;

import com.example.cryptmessages.data.SecretKey;

import javax.crypto.Cipher;

import javax.crypto.spec.SecretKeySpec;

public class Encrypt {
    SecretKey secretKey;

    public Encrypt() {

    }

    public String encrypt(String data, String key) throws Exception {
        if (!key.equals("") && !data.equals("")) {
            this.secretKey = new SecretKey(key);
            SecretKeySpec keySpec = secretKey.getSecretKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] encVal = cipher.doFinal(data.getBytes());
            String encryptedValue = Base64.encodeToString(encVal, Base64.DEFAULT);
            return encryptedValue;
        }else return data;



    }

}
