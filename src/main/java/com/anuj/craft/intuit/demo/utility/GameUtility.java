package com.anuj.craft.intuit.demo.utility;

import com.anuj.craft.intuit.demo.model.Player;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class GameUtility {

    static String[] board;
    static String turn;
    private int count = 0;

    static String checkWinner(String player1,String player2)
    {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("XXX")) {
                return  player1 == null || player1.isEmpty()?"X":player1;
            }

            else if (line.equals("OOO")) {
                return player2 == null || player2.isEmpty() ?"O":player2;
            }
        }

        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(a + 1))) {
                break;
            }
            else if (a == 8) {
                return "draw";
            }
        }
        System.out.println(
                turn + "'s turn; enter a slot number to place "
                        + turn + " in:");
        return null;
    }

    static void printBoard()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |");
        System.out.println("|---|---|---|");
    }

    public String playGame(List<Integer> positions, String player1, String player2) throws JsonProcessingException {
        String msg = "";
        board = new String[9];
        turn = "X";
        String winner = null;

        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }

        msg ="Welcome to 3x3 Tic Tac Toe.";
        printBoard();



        while (winner == null) {
            int numInput;
            for (int i : positions) {
                msg = turn.equals("X")?player1+" will play first. Enter a slot number to place X in:":player2+" will play first. Enter a slot number to place O in:";
                try {
                    numInput = i;
                    if (!(numInput > 0 && numInput <= 9)) {
                        msg = "Invalid input; re-enter slot number:";
                        continue;
                    }
                } catch (InputMismatchException e) {
                    msg = "Invalid input; re-enter slot number:";
                    continue;
                }
                if (board[numInput - 1].equals(
                        String.valueOf(numInput))) {
                    board[numInput - 1] = turn;

                    if (turn.equals("X")) {
                        turn = "O";
                    } else {
                        turn = "X";
                    }

                    printBoard();
                    winner = checkWinner(player1, player2);
                } else {
                    msg = "Slot already taken; re-enter slot number:";
                }
            }
            if(winner == null){
                msg = turn.equals("X")?"Missing Slot for player "+player1+". Enter a slot number to place X":"Missing Slot for player "+player2+". Enter a slot number to place O";
                winner = "";
            }else if (winner.equalsIgnoreCase("draw")) {
                msg = "It's a draw! Thanks for playing.";
            }
            else if (winner.equalsIgnoreCase("")) {
                msg = "Sorry";
            }
            else {
                msg = "Congratulations! " + winner + "'s have won! Thanks for playing.";
                writeTheScore(winner);
            }
        }
        return msg;
    }

    public void writeTheScore(String winner) throws JsonProcessingException {
        Random rand = new Random();
        int rand_int1 = rand.nextInt(100);
        count++;
        Player player = Player.builder()
                .id(count)
                .name(winner)
                .score(rand_int1)
                .build();

        FileWriterUtility.writeDataInTheFile(player);

    }
}
