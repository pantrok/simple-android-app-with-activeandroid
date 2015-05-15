package com.synergy.activeandroidtest.beans;

/**
 * Created by daniel on 13/05/15.
 */
public class User {
    private int iduser;
    private String username;
    private String email;

    public int getIduser() {
        return iduser;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User ["+iduser+","+username+","+email+"]";
    }
}
