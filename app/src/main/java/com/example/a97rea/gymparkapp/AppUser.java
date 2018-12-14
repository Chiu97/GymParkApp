package com.example.a97rea.gymparkapp;

import cn.bmob.v3.BmobObject;

public class AppUser extends BmobObject {
    private String name;
    private String password;
    private String email;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
