package com.company;

public class Main {

    public static void main(String[] args) {
        // This is develop mode
        SnakesLadders game = new SnakesLadders();
        System.out.println(game.play(1, 1));
        System.out.println(game.play(1, 5));
        System.out.println(game.play(6, 2));
        System.out.println(game.play(1, 1));
    }
}
