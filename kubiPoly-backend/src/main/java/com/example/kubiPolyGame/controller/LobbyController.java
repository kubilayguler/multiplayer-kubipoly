package com.example.kubiPolyGame.controller;

import com.example.kubiPolyGame.model.Lobby;
import com.example.kubiPolyGame.model.LobbyRequest;
import com.example.kubiPolyGame.model.Player;
import com.example.kubiPolyGame.service.LobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class LobbyController {

    @Autowired
    private LobbyService lobbyService;
    private SimpMessagingTemplate template;

    public LobbyController(LobbyService lobbyService, SimpMessagingTemplate template) {
        this.lobbyService = lobbyService;
        this.template = template;
    }

    @MessageMapping("/createRoom")
    public Lobby createLobby(@Payload LobbyRequest request) {
        Lobby lobby = lobbyService.createLobby(request.getLobbyCode(), request.getPlayerName()); // Özel lobi koduyla lobi oluştur
        this.template.convertAndSend("/topic/lobby/" + lobby.getId(), lobby); // Lobi bilgilerini gönder
        return lobby;
    }


    @MessageMapping("/joinRoom")
    public Lobby joinRoom(@Payload LobbyRequest request) {
        Lobby updatedLobby = lobbyService.addPlayerToLobby(request.getLobbyCode(), request.getPlayerName());
        this.template.convertAndSend("/topic/lobby/" + updatedLobby.getId(), updatedLobby);
        return updatedLobby;
    }

    @MessageMapping("/getReady")
    public Lobby setPlayerReady(@Payload LobbyRequest request) {
        Lobby updatedLobby = lobbyService.setPlayerReady(request.getLobbyCode(), request.getPlayerName());
        this.template.convertAndSend("/topic/lobby/" + updatedLobby.getId(), updatedLobby);
        return updatedLobby;
    }

    @MessageMapping("/startGame")
    public Lobby startGame(@Payload LobbyRequest request) {
        Lobby updatedLobby = lobbyService.startGame(request.getLobbyCode());
        this.template.convertAndSend("/topic/lobby/" + updatedLobby.getId(), updatedLobby);
        return updatedLobby;
    }
}
