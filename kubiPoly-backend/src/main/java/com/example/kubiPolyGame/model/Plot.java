package com.example.kubiPolyGame.model;

public class Plot {
    private int id;
    private String name;
    private int price;
    private int rent;
    private Player owner;
    private int level;

    public Plot(int id, String name, int price, int rent, Player owner, int level) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rent = rent;
        this.owner = owner;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }


}
