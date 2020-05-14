package com.example.cryptmessages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cryptmessages.controls.cipherMethods.Decrypt;
import com.example.cryptmessages.controls.cipherMethods.Encrypt;
import com.example.cryptmessages.controls.editingButtons.Clipboard;

public class MainActivity extends AppCompatActivity {
    EditText keyTa, cipherTextTa,plainTextTa;
    Button encryptBtn, decryptBtn, copyBtn, pasteBtn, clearBtn,seeKeyBtn;

    Decrypt decrypt = new Decrypt();
    Encrypt encrypt = new Encrypt();
    private ClipboardManager clipboardManager;
    private ClipData clipData;
    boolean vis=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cipherTextTa = findViewById(R.id.cipherTextTa);
        plainTextTa= findViewById(R.id.plainTextTA);
        keyTa = findViewById(R.id.keyTa);
        encryptBtn = findViewById(R.id.encryptBtn);
        decryptBtn = findViewById(R.id.decryptBtn);
        copyBtn = findViewById(R.id.copyBtn);
        pasteBtn = findViewById(R.id.pasteBtn);
        clearBtn = findViewById(R.id.clearBtn);
        seeKeyBtn=findViewById(R.id.seeKeyBtn);
        clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);

        encryptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                        String temp = plainTextTa.getText().toString();
                        cipherTextTa.setText(encrypt.encrypt(temp, keyTa.getText().toString()));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        decryptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    String temp = cipherTextTa.getText().toString();
                    plainTextTa.setText(decrypt.decrypt(temp, keyTa.getText().toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtcopy = cipherTextTa.getText().toString();
                clipData = ClipData.newPlainText("text",txtcopy);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(getApplicationContext(),"Data Copied to Clipboard", Toast.LENGTH_SHORT).show();
            }
        });
        pasteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipData pData = clipboardManager.getPrimaryClip();
                ClipData.Item item = pData.getItemAt(0);
                String txtpaste = item.getText().toString();
                cipherTextTa.setText(txtpaste);
                Toast.makeText(getApplicationContext(),"Data Pasted from Clipboard",Toast.LENGTH_SHORT).show();
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cipherTextTa.setText(null);
                plainTextTa.setText(null);
                keyTa.setText(null);

            }
        });
        seeKeyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!vis){
                    keyTa.setTransformationMethod(null);
                    vis=true;
                }else{
                    keyTa.setTransformationMethod(new PasswordTransformationMethod());
                    vis=false;
                }

            }
        });


    }


}
