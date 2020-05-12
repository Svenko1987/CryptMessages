package com.example.cryptmessages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cryptmessages.controls.textMethods.Decrypt;
import com.example.cryptmessages.controls.textMethods.Encrypt;
import com.example.cryptmessages.data.SecretKey;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class MainActivity extends AppCompatActivity {
    EditText keyTa, messageTa;
    Button encryptBtn, decryptBtn;

    Decrypt decrypt = new Decrypt();
    Encrypt encrypt = new Encrypt();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageTa = findViewById(R.id.messageTa);
        keyTa = findViewById(R.id.keyTa);
        encryptBtn = findViewById(R.id.encryptBtn);
        decryptBtn = findViewById(R.id.decryptBtn);

        encryptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    String temp = messageTa.getText().toString();
                    messageTa.setText(encrypt.encrypt(temp, keyTa.getText().toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        decryptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    String temp = messageTa.getText().toString();
                    messageTa.setText(decrypt.decrypt(temp, keyTa.getText().toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }


}
