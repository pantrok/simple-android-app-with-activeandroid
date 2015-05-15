package com.synergy.activeandroidtest.data;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by daniel on 13/05/15.
 */
@Table(name = "Users")
public class User extends Model{
    @Column(name = "Id_user")
    private int iduser;
    @Column(name = "Username")
    private String username;
    @Column(name = "Email")
    private String email;

    public User() {
        super();
    }

    public User(int id, String username, String email) {
        super();
        this.iduser = id;
        this.username = username;
        this.email = email;
    }

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
