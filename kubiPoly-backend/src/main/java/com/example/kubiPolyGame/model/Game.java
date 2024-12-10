package com.example.kubiPolyGame.model;

import java.util.List;

public class Game {
    private String id;
    private List<Player> players;
    private List<Plot> plots;
    private Player turn;
    private int dice;
    private boolean isStarted;
}
