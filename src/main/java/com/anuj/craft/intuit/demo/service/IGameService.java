package com.anuj.craft.intuit.demo.service;

import com.anuj.craft.intuit.demo.model.Player;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface IGameService {

    public String playGame(List<Integer> positions, String player1, String player2) throws JsonProcessingException;

    public List<Player> getScore();
}
