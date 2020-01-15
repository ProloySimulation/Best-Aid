package com.best_aid.proloy.lifesaver.Model;

public class Doctor {

    private int id;
    private String name; //title
    private String designation; //shortdesc
    //rating
    private double price;
    private int image;

    public Doctor(int id, String name, String designation,  double price, int image) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }


    public double getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

}
