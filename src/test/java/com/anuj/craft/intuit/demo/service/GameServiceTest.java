package com.anuj.craft.intuit.demo.service;

import com.anuj.craft.intuit.demo.utility.FileReaderUtility;
import com.anuj.craft.intuit.demo.utility.GameUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class GameServiceTest extends TestCase {

    @InjectMocks
    GameService gameService;

    @Mock
    GameUtility gameUtility;

    @Mock
    FileReaderUtility fileReaderUtility;

    public void init(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void whenPassCorrdinate_then_checktheWinner() throws JsonProcessingException {
        List<Integer> position1 = Arrays.asList(3,5,6,1,9,4);
        List<Integer> position2 = Arrays.asList(3,5,6,1,4,9);
        String player1 = "Anuj";
        String player2 = "Rajat";
        Mockito.when(gameUtility.playGame(position1,player1, player2)).thenReturn("Congratulations! Anuj's have won! Thanks for playing.");
        Mockito.when(gameUtility.playGame(position2,player1, player2)).thenReturn("Congratulations! Rajat's have won! Thanks for playing.");
        assertEquals("Congratulations! Anuj's have won! Thanks for playing.",gameService.playGame(position1,player1, player2));
        assertEquals("Congratulations! Rajat's have won! Thanks for playing.",gameService.playGame(position2,player1, player2));
    }

}