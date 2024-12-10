package com.example.kubiPolyGame.model;

public class GameState {
    private String lobbyCode;
    private boolean started;

    public GameState(String lobbyCode) {
        this.lobbyCode = lobbyCode;
        this.started = false;
    }

    public void startGame() {
        this.started = true;
    }

    public String getLobbyCode() {
        return lobbyCode;
    }

    public void setLobbyCode(String lobbyCode) {
        this.lobbyCode = lobbyCode;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }
}
