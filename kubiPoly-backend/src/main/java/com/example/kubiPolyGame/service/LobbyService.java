package com.example.kubiPolyGame.service;

import com.example.kubiPolyGame.model.Lobby;
import com.example.kubiPolyGame.model.Player;
import com.example.kubiPolyGame.model.Plot;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LobbyService {

    private final Map<String, Lobby> lobbies = new ConcurrentHashMap<>();


    public Lobby createLobby(String lobbyCode, String playerName) {
        Lobby lobby = new Lobby(lobbyCode);
        Player host = new Player(UUID.randomUUID().toString(), playerName, true);
        lobby.addPlayer(host);
        lobbies.put(lobbyCode, lobby);
        return lobby;
    }

    public Lobby addPlayerToLobby(String lobbyCode, String playerName) {
        Lobby lobby = lobbies.get(lobbyCode);
        Player newPlayer = new Player(UUID.randomUUID().toString(), playerName, false);
        lobby.addPlayer(newPlayer);
        return lobby;
    }

    public Collection<Lobby> getAllLobbies() {
        return lobbies.values(); // Mevcut lobilerin tümünü döndür
    }

    public Lobby setPlayerReady(String lobbyCode, String playerName) {
        Lobby lobby = lobbies.get((lobbyCode));
        if(lobby != null) {
            for(Player player : lobby.getPlayers()) {
                if(player.getName().equals(playerName)) {
                    player.setReady(true);
                    return lobby;
                }
            }
        }
        return null;
    }

    public Lobby startGame(String lobbyCode) {
        Lobby lobby = lobbies.get(lobbyCode);
        if (lobby != null) {
            if (lobby.areAllPlayersReady()) {
                lobby.setPlots(createAllPlots());
                for(Player player : lobby.getPlayers()) {
                    player.setMoney(1000000);
                    player.setPosition(1);
                }
                lobby.setGameStarted(true);
                return lobby;
            }
        }
        return null;
    }

    public List<Plot> createAllPlots () {
        List<Plot> gamePlots = new ArrayList<>();
        gamePlots.add(new Plot(2,"Hırdavatçı",40000,8000,null,1));
        gamePlots.add(new Plot(36,"Kenevir",2000000,400000,null,1));
        gamePlots.add(new Plot(20,"Zeytinlik",310000,50000,null,1));
        return gamePlots;
    }

    public Lobby getLobby(String lobbyCode) {
        return lobbies.get(lobbyCode);  // Lobi koduna göre lobi bilgisini döner
    }
}
