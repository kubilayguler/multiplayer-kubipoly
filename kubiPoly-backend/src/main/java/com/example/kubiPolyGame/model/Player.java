package com.example.kubiPolyGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private String id;
    private String name;
    private boolean ready;
    private boolean host;
    private int position;
    private int money;
    private List<Plot> ownedPlots;

    public Player (String id, String name, boolean host) {
        this.id = id;
        this.name = name;
        this.host = host;
        this.ready = host; //if player is owner ready=true, else ready=false;
        this.position = -1;
        this.ownedPlots = new ArrayList<>();
        this.money = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public boolean isHost() {
        return host;
    }
    public void setHost(boolean bool) {
        host = bool;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<Plot> getOwnedPlots() {
        return ownedPlots;
    }

    public void addPlotToPlayer(Plot plot) {
        this.ownedPlots.add(plot);
    }
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Player getPlayerByName(String name) {
        if(this.name.equals(name))
            return this;
        else {
            return null;
        }
    }
    /*
    public int randomRollDice() {
        Random random = new Random();
        return random.nextInt(1,7);
    }
    */
}
