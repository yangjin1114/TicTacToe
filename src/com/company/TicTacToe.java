package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicTacToe {

    private char[][] board = new char[3][3];


    TicTacToe() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                board[i][j] = '*';
            }
        }
    }

    public void play(Point p) {
        if (board[p.x][p.y] == '*') {
            board[p.x][p.y] = 'X';
        }
    }

    public void playBack() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] != '*') {
                    continue;
                }

                board[i][j] = 'O';
                if (winGame()) {
                    return;
                } else {
                    board[i][j] = '*';
                }
            }
        }

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] != '*') {
                    continue;
                }

                board[i][j] = 'X';
                if (winGame()) {
                    board[i][j] = 'O';
                    return;
                } else {
                    board[i][j] = '*';
                }
            }
        }

        int[] corner = new int[]{0, 2, 6, 8};
        int[] side = new int[]{1, 3, 5, 7};

        if (chooseFromList(board, corner)) {
            return;
        }

        if (board[1][1] == '*') {
            board[1][1] = 'O';
        }

        chooseFromList(board, side);
    }

    private boolean chooseFromList(char[][] board, int[] array) {
        List<Integer> empty = new ArrayList<>();

        for (int i = 0; i < array.length; ++i) {
            int x = array[i] / 3;
            int y = array[i] % 3;
            if (board[x][y] == '*') {
                empty.add(array[i]);
            }
        }

        if (empty.size() > 0) {
            Random random = new Random();
            int move = empty.get(random.nextInt(empty.size()));
            board[move / 3][move % 3] = 'O';
            return true;
        }

        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] == '*') {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean winGame() {
        for (int i = 0; i < 3; ++i) {
            if (board[0][i] != '*' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
            if (board[i][0] != '*' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }

        if (board[0][0] != '*' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != '*' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }

    public void drawBoard() {
        System.out.println();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }
    }
}
