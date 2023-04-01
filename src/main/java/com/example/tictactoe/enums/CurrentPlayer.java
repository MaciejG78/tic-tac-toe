package com.example.tictactoe.enums;

public enum CurrentPlayer {
    X("X"),
    O("O");

    private String value;

    CurrentPlayer(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
