package com.example.cryptmessages.controls.editingButtons;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Clipboard extends AppCompatActivity {
    private ClipboardManager clipboardManager;
    private ClipData clipData;

    public Clipboard() {
        this.clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    }

    public void copyText(String text) {
        clipData = ClipData.newPlainText("text", text);
        clipboardManager.setPrimaryClip(clipData);
        Toast.makeText(getApplicationContext(), "Data Copied to Clipboard", Toast.LENGTH_SHORT).show();

    }

    public String pasteText() {
        ClipData pData = clipboardManager.getPrimaryClip();
        ClipData.Item item = pData.getItemAt(0);
        String textPaste = item.getText().toString();
        Toast.makeText(getApplicationContext(), "Data Pasted from Clipboard", Toast.LENGTH_SHORT).show();
        return textPaste;
    }
}
