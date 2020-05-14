package com.example.cryptmessages.controls.cipherMethods;

import android.util.Base64;

import com.example.cryptmessages.data.SecretKey;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Decrypt {
    SecretKey secretKey;

    public Decrypt() {

    }

    public String decrypt(String data , String key) throws Exception{
        if (!key.equals("") && !data.equals("")) {

            this.secretKey= new SecretKey(key);
            SecretKeySpec keySpec = secretKey.getSecretKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] decVal= Base64.decode(data, Base64.DEFAULT);
            byte[] decodedValue= cipher.doFinal(decVal);
            String decryptedValue= new String(decodedValue);
            return decryptedValue;
        }else return data;


    }
}
