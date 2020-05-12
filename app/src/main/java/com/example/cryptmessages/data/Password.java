package com.example.cryptmessages.data;

public class Password extends BaseEntity {
    private char[] password;

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
}
