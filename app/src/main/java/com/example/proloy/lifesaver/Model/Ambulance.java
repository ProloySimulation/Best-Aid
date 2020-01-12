package com.example.proloy.lifesaver.Model;

public class Ambulance {

    String driverName , mobile;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Ambulance(String driverName, String mobile) {
        this.driverName = driverName;
        this.mobile = mobile;
    }
}
