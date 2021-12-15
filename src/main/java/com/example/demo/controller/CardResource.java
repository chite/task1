package com.example.demo.controller;

import com.example.demo.entity.Card;
import com.example.demo.entity.Player;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/card", produces = MediaType.APPLICATION_JSON_VALUE)
public class CardResource {

    @Autowired
    CardService cardService;

    @RequestMapping(value = "/{number}", method = RequestMethod.GET)
    public ResponseEntity<Object> getCards(@PathVariable(value = "number") int playerNum) {
        List<Player> players = cardService.getCard(playerNum);
        for (Player player : players) {
            System.out.printf("player%s: %s\n", player.getName(), player.getCard());
        }
        return ResponseEntity.noContent().build();
    }
}
