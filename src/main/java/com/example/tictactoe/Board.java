package com.example.tictactoe;

import com.example.tictactoe.enums.GameType;
import com.example.tictactoe.enums.OpponentType;

public class Board {

    private OpponentType opponentType;
    private GameType gameType;

    private String[][] gameBoard;
    private String turn;

    public Board(OpponentType opponentType, GameType gameType) {
        this.opponentType = opponentType;
        this.gameType = gameType;
    }

    public void initializeBoard() {
        this.gameBoard = new String[gameType.x][gameType.y];

        for (int i = 0; i < gameType.y; i++) {
            for (int j=0; j < gameType.x; j++) {
                gameBoard[i][j] = " ";
            }
        }
    }

    /* Board
            -------------          -----------------------------------------
            |   |   |   |          |   |   |   |   |   |   |   |   |   |   |
            -------------          -----------------------------------------
    */

    public void printBoard() {
        System.out.print("    ");
        for (int i = 0; i < gameType.x; i++) {
            System.out.print(i + 1 + "   ");
        }
        System.out.println();
        for (int i = 0; i < gameType.y; i++) {
            System.out.println("  " + "-".repeat(4 * gameType.y + 1));
            System.out.print(i<9 ? (i + 1 + " ") : (i + 1 + ""));
            for (int j = 0; j < gameType.x; j++) {
                System.out.print("| " + gameBoard[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("  " + "-".repeat(4 * gameType.x + 1));
    }

    public OpponentType getOpponentType() {
        return opponentType;
    }

    public GameType getGameType() {
        return gameType;
    }

    public String[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(String[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

}
