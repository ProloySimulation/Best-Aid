package com.example.proloy.lifesaver.Model;

public class Donor {

    String name , mobile , adress , blood;

    public Donor(String name, String blood) {
        this.name = name;
        this.mobile = mobile;
        this.adress = adress;
        this.blood = blood;
    }

    public Donor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String blood) {
        this.adress = adress;
    }

    public String getBlood() {
        return adress;
    }

    public void setBlood(String blood) {
        this.adress = adress;
    }
}