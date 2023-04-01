package com.example.tictactoe.stub;

import com.example.tictactoe.Board;
import com.example.tictactoe.enums.GameType;
import com.example.tictactoe.enums.OpponentType;

public class BoardStub extends Board{

    public BoardStub(OpponentType opponentType, GameType gameType) {
        super(opponentType, gameType);
    }

    public Board initializeBoard3x3WinColumnX() {
        String[][] gameBoard = new String[3][3];
        gameBoard[0][0] = "X"; gameBoard[0][1] = "O"; gameBoard[0][2] = "O";
        gameBoard[1][0] = "X"; gameBoard[1][1] = "O"; gameBoard[1][2] = "X";
        gameBoard[2][0] = "X"; gameBoard[2][1] = "X"; gameBoard[2][2] = "O";
        this.setGameBoard(gameBoard);
        return this;
    }

    public Board initializeBoard3x3WinColumnO() {
        String[][] gameBoard = new String[3][3];
        gameBoard[0][0] = "X"; gameBoard[0][1] = "O"; gameBoard[0][2] = "O";
        gameBoard[1][0] = "O"; gameBoard[1][1] = "O"; gameBoard[1][2] = "X";
        gameBoard[2][0] = "X"; gameBoard[2][1] = "O"; gameBoard[2][2] = "O";
        this.setGameBoard(gameBoard);
        return this;
    }

    public Board initializeBoard3x3WinRowX() {
        String[][] gameBoard = new String[3][3];
        gameBoard[0][0] = "X"; gameBoard[0][1] = "O"; gameBoard[0][2] = "O";
        gameBoard[1][0] = "X"; gameBoard[1][1] = "X"; gameBoard[1][2] = "X";
        gameBoard[2][0] = "O"; gameBoard[2][1] = "X"; gameBoard[2][2] = "O";
        this.setGameBoard(gameBoard);
        return this;
    }

    public Board initializeBoard3x3WinRowO() {
        String[][] gameBoard = new String[3][3];
        gameBoard[0][0] = "O"; gameBoard[0][1] = "O"; gameBoard[0][2] = "O";
        gameBoard[1][0] = "X"; gameBoard[1][1] = "X"; gameBoard[1][2] = "O";
        gameBoard[2][0] = "O"; gameBoard[2][1] = "X"; gameBoard[2][2] = "X";
        this.setGameBoard(gameBoard);
        return this;
    }

    public Board initializeBoard3x3WinCrossX() {
        String[][] gameBoard = new String[3][3];
        gameBoard[0][0] = "X"; gameBoard[0][1] = "O"; gameBoard[0][2] = "O";
        gameBoard[1][0] = "O"; gameBoard[1][1] = "X"; gameBoard[1][2] = "O";
        gameBoard[2][0] = "O"; gameBoard[2][1] = "X"; gameBoard[2][2] = "X";
        this.setGameBoard(gameBoard);
        return this;
    }

    public Board initializeBoard3x3WinCrossO() {
        String[][] gameBoard = new String[3][3];
        gameBoard[0][0] = "O"; gameBoard[0][1] = "X"; gameBoard[0][2] = "O";
        gameBoard[1][0] = "X"; gameBoard[1][1] = "O"; gameBoard[1][2] = "O";
        gameBoard[2][0] = "O"; gameBoard[2][1] = "X"; gameBoard[2][2] = "X";
        this.setGameBoard(gameBoard);
        return this;
    }

    public Board initializeBoard3x3NoWinner() {
        String[][] gameBoard = new String[3][3];
        gameBoard[0][0] = "O"; gameBoard[0][1] = "X"; gameBoard[0][2] = "X";
        gameBoard[1][0] = "X"; gameBoard[1][1] = "O"; gameBoard[1][2] = "O";
        gameBoard[2][0] = "O"; gameBoard[2][1] = "X"; gameBoard[2][2] = "X";
        this.setGameBoard(gameBoard);
        return this;
    }

    public Board initializeBoard3x3WrongMove() {
        String[][] gameBoard = {
                {"O", " ",  "O"},
                {" ", "X",  " "},
                {"O", " ",  "X"}
        };
        this.setGameBoard(gameBoard);
        return this;
    }

    public Board initializeBoard10x10WinColumnX() {
        String[][] gameBoard = {
                {"X", "X", "O", "O", "X", "X", "X", "X", "O","X"},
                {" ", " ", "O", "X", "X", " ", " ", " ", " "," "},
                {" ", " ", " ", "X", " ", " ", " ", " ", " "," "},
                {" ", " ", " ", "X", " ", " ", " ", " ", " "," "},
                {" ", " ", " ", "X", " ", " ", " ", " ", " "," "},
                {" ", " ", " ", "X", " ", " ", " ", " ", " "," "},
                {" ", " ", " ", "O", " ", " ", " ", " ", " "," "},
                {" ", " ", "O", "X", "X", " ", " ", " ", " "," "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " "," "},
                {" ", " ", "O", "X", "X", " ", " ", " ", " "," "}};
        this.setGameBoard(gameBoard);
        return this;
    }

    public Board initializeBoard10x10WinColumnO() {
        String[][] gameBoard = {
                {"X", "X", "O", "O", "X", "X", "X", "X", "O","X"},
                {" ", " ", "O", "X", "X", " ", "O", " ", " "," "},
                {" ", " ", " ", "X", " ", " ", "X", " ", " "," "},
                {" ", " ", " ", "O", " ", " ", "O", " ", " "," "},
                {" ", " ", " ", "X", " ", " ", "O", " ", " "," "},
                {" ", " ", " ", "X", " ", " ", "O", " ", " "," "},
                {" ", " ", " ", "O", " ", " ", "O", " ", " "," "},
                {" ", " ", "O", "X", "X", " ", "O", " ", " "," "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " "," "},
                {" ", " ", "O", "X", "X", " ", " ", " ", " "," "}};
        this.setGameBoard(gameBoard);
        return this;
    }

    public Board initializeBoard10x10WinRowX() {
        String[][] gameBoard = {
                {"X", "X", "O", "X", "X", "X", "X", "X", "O","X"},
                {" ", " ", "O", "X", "X", " ", " ", " ", " "," "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " "," "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " "," "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " "," "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " "," "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " "," "},
                {" ", " ", "O", "X", "X", " ", " ", " ", " "," "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " "," "},
                {" ", " ", "O", "X", "X", " ", " ", " ", " "," "}};
        this.setGameBoard(gameBoard);
        return this;
    }

    public Board initializeBoard10x10WinRowO() {
        String[][] gameBoard = {
                {"X", "X", "O", "X", "X", "O", "X", "X", "O","X"},
                {" ", " ", "O", "X", "X", " ", " ", " ", " "," "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " "," "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " "," "},
                {" ", " ", " ", "O", "O", "O", "O", "O", " "," "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " "," "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " "," "},
                {" ", " ", "O", "X", "X", " ", " ", " ", " "," "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " "," "},
                {" ", " ", "O", "X", "X", " ", " ", " ", " "," "}};
        this.setGameBoard(gameBoard);
        return this;
    }

    public Board initializeBoard10x10WinCrossX() {
        String[][] gameBoard = {
                {"X", "X", "O", "X", "X", "O", "X", "X", "O","X"},
                {" ", " ", "O", "X", "X", " ", " ", " ", " "," "},
                {" ", " ", "X", " ", " ", "X", " ", " ", " "," "},
                {" ", " ", " ", "X", " ", " ", "X", " ", " "," "},
                {" ", " ", " ", "O", "O", "O", "O", "X", " "," "},
                {" ", " ", " ", " ", " ", "X", " ", " ", " "," "},
                {" ", " ", " ", " ", " ", " ", "O", " ", " "," "},
                {" ", " ", "O", "X", "X", " ", " ", "O", " "," "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " "," "},
                {" ", " ", "O", "X", "X", " ", " ", " ", " "," "}};
        this.setGameBoard(gameBoard);
        return this;
    }

    public Board initializeBoard10x10WinCrossO() {
        String[][] gameBoard = {
                {"X", "X", "O", "X", "X", "O", "X", "X", "O","X"},
                {" ", " ", "O", "X", "X", " ", " ", " ", " "," "},
                {" ", " ", "X", " ", " ", " ", " ", " ", " "," "},
                {" ", " ", " ", "X", " ", " ", "X", " ", " "," "},
                {" ", " ", " ", "O", "O", "O", "O", "O", " "," "},
                {" ", " ", " ", " ", "O", "X", " ", " ", " "," "},
                {" ", " ", " ", "O", " ", " ", "X", " ", " "," "},
                {" ", " ", "O", "X", "X", " ", " ", "O", " "," "},
                {" ", "O", " ", " ", " ", " ", " ", " ", " "," "},
                {"X", " ", "O", "X", "X", " ", " ", " ", " "," "}};
        this.setGameBoard(gameBoard);
        return this;
    }

    public Board initializeBoard10x10NoWinner() {
        String[][] gameBoard = {
                {"X", "X", "O", "X", "X", "O", "X", "X", "O","X"},
                {"X", "X", "O", "X", "X", "X", "O", "O", "X","X"},
                {"O", "O", "X", "X", "O", "X", "O", "O", "X","O"},
                {"O", "O", "X", "O", "O", "X", "O", "O", "X","X"},
                {"X", "X", "O", "X", "X", "O", "X", "X", "O","X"},
                {"O", "O", "X", "O", "O", "X", "O", "O", "X","O"},
                {"X", "X", "O", "X", "X", "O", "X", "X", "O","X"},
                {"O", "O", "X", "O", "O", "X", "O", "O", "X","X"},
                {"X", "X", "O", "X", "X", "O", "X", "X", "O","O"},
                {"O", "O", "X", "O", "O", "X", "O", "O", "X","X"}};
        this.setGameBoard(gameBoard);
        return this;
    }

    public Board initializeBoard10x10WrongMove() {
        String[][] gameBoard = {
                {"X", "X", "O", "X", "X", "O", "X", "X", "O","X"},
                {" ", " ", "O", "X", "X", " ", " ", " ", " "," "},
                {" ", " ", "X", " ", " ", " ", " ", " ", " "," "},
                {" ", " ", " ", "X", " ", " ", "X", " ", " "," "},
                {" ", " ", " ", "O", "O", "O", "O", "O", " "," "},
                {" ", " ", " ", " ", "O", "X", " ", " ", " "," "},
                {" ", " ", " ", "O", " ", " ", "X", " ", " "," "},
                {" ", " ", "O", "X", "X", " ", " ", "O", " "," "},
                {" ", "O", " ", " ", " ", " ", " ", " ", " "," "},
                {"O", " ", "O", "X", "X", " ", " ", " ", " "," "}};
        this.setGameBoard(gameBoard);
        return this;
    }

    /*
    public Board initializeBoard10x10WinCrossNum() {
        String[][] gameBoard = {
                {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09"},
                {"10", "11", "12", "13", "14", "15", "16", "17", "18", "19"},
                {"20", "21", "22", "23", "24", "25", "26", "27", "28", "29"},
                {"30", "31", "32", "33", "34", "35", "36", "37", "38", "39"},
                {"40", "41", "42", "43", "44", "45", "46", "47", "48", "49"},
                {"50", "51", "52", "53", "54", "55", "56", "57", "58", "59"},
                {"60", "61", "62", "63", "64", "65", "66", "67", "68", "69"},
                {"70", "71", "72", "73", "74", "75", "76", "77", "78", "79"},
                {"80", "81", "82", "83", "84", "85", "86", "87", "88", "89"},
                {"90", "91", "92", "93", "94", "95", "96", "97", "98", "99"}};
        this.setGameBoard(gameBoard);
        return this;
    }
    */
}
