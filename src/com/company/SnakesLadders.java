package com.company;


import java.util.HashMap;
import java.util.Map;

public class SnakesLadders {
    private boolean isGameOVer = false;
    private Player player1Position = new Player();
    private Player player2Position = new Player();
    private boolean isPlayer1Turn = true;
    private static final Map<Integer, Integer> map;
    static {
       map = new HashMap<>();
       map.put(2,38);
       map.put(7,14);
       map.put(8,31);
       map.put(15,26);
       map.put(16,6);
       map.put(21,42);
       map.put(28,84);
       map.put(36,44);
       map.put(46,25);
       map.put(49,11);
       map.put(51,67);
       map.put(62,19);
       map.put(64,60);
       map.put(71,91);
       map.put(74,53);
       map.put(78,98);
       map.put(87,94);
       map.put(89,68);
       map.put(92,88);
       map.put(95,75);
       map.put(99,80);
    }


    public String play(int die1, int die2) {
        if (isGameOVer) {
            return "Game over!";
        }
        Player targetPlayerPosition = null;
        if (isPlayer1Turn) {
            targetPlayerPosition = player1Position;
        } else {
            targetPlayerPosition = player2Position;
        }

        targetPlayerPosition.setPosition(targetPlayerPosition.getPosition() + die1 + die2);

        if (targetPlayerPosition.getPosition() > 100) {
            targetPlayerPosition.setPosition(100 - (targetPlayerPosition.getPosition() - 100));
        }
        if (map.containsKey(targetPlayerPosition.getPosition())) {
            targetPlayerPosition.setPosition(map.get(targetPlayerPosition.getPosition()));
        }

        boolean isPlayerTurnCopy = isPlayer1Turn;
        if (die1 != die2) {
            isPlayer1Turn = !isPlayer1Turn;
        }

        if (targetPlayerPosition.getPosition() == 100) {
            isGameOVer = true;
            if (isPlayerTurnCopy) {
                return "Player 1 Wins!";
            }
             return "Player 2 Wins!";
        }

        if(isPlayerTurnCopy) {
            return "Player 1 is on square " + player1Position.getPosition();
        } else {
            return "Player 2 is on square " + player2Position.getPosition();
        }

    }
}


