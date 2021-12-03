package com.anuj.craft.intuit.demo.service;

import com.anuj.craft.intuit.demo.model.Player;
import com.anuj.craft.intuit.demo.utility.FileReaderUtility;
import com.anuj.craft.intuit.demo.utility.FileWriterUtility;
import com.anuj.craft.intuit.demo.utility.GameUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class GameService implements IGameService {

    @Autowired
    GameUtility gameUtility;

    @Autowired
    FileReaderUtility fileReaderUtility;

    @Override
    public String playGame(List<Integer> position, String player1, String player2) throws JsonProcessingException {
        return gameUtility.playGame(position, player1, player2);
    }

    @Override
    public List<Player> getScore() {
        List<Player> top5Player = new ArrayList<>();
        try {
            Map<Integer,Player> playerMap = fileReaderUtility.readFileData();
            Set set = playerMap.entrySet();
            Iterator i = set.iterator();

            int k=1;
            while (i.hasNext() && k<=5) {
                Map.Entry me = (Map.Entry)i.next();
                top5Player.add((Player) me.getValue());
                k++;
            }
        } catch (IOException e) {
            e.getMessage();
        }catch (Exception e){
            System.out.println("File Not Found");
        }
        return top5Player;
    }
}
