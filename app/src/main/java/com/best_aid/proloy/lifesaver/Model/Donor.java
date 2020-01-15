package com.best_aid.proloy.lifesaver.Model;

public class Donor {

    String name , mobile , adress , blood;

    public Donor(String name, String blood , String mobile) {
        this.name = name;
        this.mobile = mobile;
        this.adress = adress;
        this.blood = blood;
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
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }
}

