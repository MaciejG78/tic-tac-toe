package com.example.tictactoe.exception;

public class InvalidMove extends Throwable {
    private String exceptionMessage;

    public InvalidMove(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
