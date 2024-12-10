package com.example.kubiPolyGame.model;

import java.util.ArrayList;
import java.util.List;

public class Lobby {
    private String id;
    private List<Player> players;
    private boolean gameStarted;
    private List<Plot> plots;

    public Lobby(String id) {
        this.id = id;
        this.players = new ArrayList<>();
        this.gameStarted = false;
        this.plots = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
    public void removePlayer(Player player) {
        players.remove(player);
    }
    public Player getHost() {
        return players.stream().filter(Player::isHost).findFirst().orElse(null);
    }

    public boolean areAllPlayersReady() {
        return players.stream().allMatch(Player::isReady);
    }

    public String getId() {
        return id;
    }

    public void setId(String lobbyID) {
        this.id = lobbyID;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public List<Plot> getPlots() {
        return plots;
    }

    public void setPlots(List<Plot> plots) {
        this.plots = plots;
    }
}
