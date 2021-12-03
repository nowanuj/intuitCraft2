package com.anuj.craft.intuit.demo.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import junit.framework.TestCase;
import org.junit.Before;
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
public class GameUtilityTest extends TestCase {

    @InjectMocks
    GameUtility gameUtility;



    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_game_WhenCoordinates__Has_BeingPassedThen_CheckWinner() throws JsonProcessingException {

        List<Integer> position1 = Arrays.asList(3,5,6,1,9,4);
        List<Integer> position2 = Arrays.asList(3,5,6,1,4,9);
        List<Integer> position3 = Arrays.asList(1,5,2,9,3,4);
        List<Integer> position4 = Arrays.asList(3,5,6,1,9,4);
        assertEquals("Congratulations! Anuj's have won! Thanks for playing.",gameUtility.playGame(position1,"Anuj","Rajat"));
        assertEquals("Congratulations! Rajat's have won! Thanks for playing.",gameUtility.playGame(position2,"Anuj","Rajat"));
        assertEquals("Congratulations! Anuj's have won! Thanks for playing.",gameUtility.playGame(position3,"Anuj","Rajat"));

    }


    @Test
    public void test_game_WhenCoordinates__Has_BeingPassedThen_CheckIfAnySlotMissign() throws JsonProcessingException {

        List<Integer> position1 = Arrays.asList(3,5,6,1,4);
        List<Integer> position2 = Arrays.asList(3,5,6,1);
        assertEquals("Missing Slot for player Rajat. Enter a slot number to place O",gameUtility.playGame(position1,"Anuj","Rajat"));
        assertEquals("Missing Slot for player Anuj. Enter a slot number to place X",gameUtility.playGame(position2,"Anuj","Rajat"));

    }



}