package com.anuj.craft.intuit.demo.controller;

import com.anuj.craft.intuit.demo.model.Player;
import com.anuj.craft.intuit.demo.model.PlayerCoordinate;
import com.anuj.craft.intuit.demo.service.IGameService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
public class GameController {


    @Autowired
    IGameService gameService;

    @GetMapping("/getList")
    public List<Player> getTopScorer(){
        return gameService.getScore();
    }

    @PostMapping("/playon")
    public ResponseEntity<String> startGame(@RequestBody PlayerCoordinate playerCoordinate){
        String msg = "fail";
        if(Objects.nonNull(playerCoordinate)) {
            try {
                msg = gameService.playGame(playerCoordinate.getPositions(),playerCoordinate.getFirstPlayer(),playerCoordinate.getSecondPlayer());
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity(msg, HttpStatus.OK);
    }
}
