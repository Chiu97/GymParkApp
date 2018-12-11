package com.example.a97rea.gymparkapp;
//this is a private trainer model,when user click to browser Trainer List,we will show their information
public class Trainer {
    private String name;
    private String phoneNumber;
    private String email;

    public int getTrainerPic() {
        return TrainerPic;
    }

    private int TrainerPic;

    public Trainer(String name, String phoneNumber, String email,int picID) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.TrainerPic=picID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
