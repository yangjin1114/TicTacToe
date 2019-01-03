package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Start a new game:");

        TicTacToe ticTacToe = new TicTacToe();
        String[] input;
        int X;
        int Y;

        while (!ticTacToe.isFull()) {
            System.out.println("Next Step(x:1~3, y:1~3):");
            input = br.readLine().trim().split(",");
            X = Integer.parseInt(input[0].trim());
            Y = Integer.parseInt(input[1].trim());

            ticTacToe.play(new Point(X - 1, Y - 1));
            ticTacToe.drawBoard();

            if (ticTacToe.winGame()) {
                System.out.println("You win! Game Over!");
                System.out.println("Do you want to play again? (yes or no)");
                String line = br.readLine().trim().toLowerCase();
                if (line.equals("yes")) {
                    main(null);
                } else {
                    return;
                }
            }

            ticTacToe.playBack();
            ticTacToe.drawBoard();
            if (ticTacToe.winGame()) {
                System.out.println("Computer wins! Game Over!");
                System.out.println("Do you want to play again? (yes or no)");
                String line = br.readLine().trim().toLowerCase();
                if (line.equals("yes")) {
                    main(null);
                } else {
                    return;
                }
            }
        }

        System.out.println("Draw! Game Over!");
        System.out.println("Do you want to play again? (yes or no)");
        String line = br.readLine().trim().toLowerCase();
        if (line.equals("yes")) {
            main(null);
        } else {
            return;
        }
    }
}
