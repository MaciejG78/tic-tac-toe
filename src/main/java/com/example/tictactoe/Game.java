package com.example.tictactoe;

import com.example.tictactoe.enums.CurrentPlayer;
import com.example.tictactoe.enums.GameStatus;
import com.example.tictactoe.enums.OpponentType;
import com.example.tictactoe.exception.InvalidMove;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class Game {

    private static final String FILENAME = "rankingList.txt";

    private final Board board;
    private GameStatus gameStatus = GameStatus.PLAYING;
    private CurrentPlayer currentPlayer = CurrentPlayer.X;
    private String userName;

    private static Scanner in = new Scanner(System.in);
    private static Random random = new Random();
    private File file = new File(FILENAME);
    private Map<String, String> map = new HashMap<>(); //Nazwa_uzytkownika|liczba_rozegranych|liczba_wygranych|data

    public Game(Board board) {
        this.board = board;
    }

    public void initializeGame(OpponentType opponentType) {
        setUserName();
        board.printBoard();
        loadResults();
        do {
            if ((opponentType == OpponentType.HUMAN)) {
                stepGameWithHuman();
            } else {
                stepGameWithComputer();
            }
            board.printBoard();
            checkWin();
            printWinnerMessage();
            currentPlayer = (currentPlayer == CurrentPlayer.X) ? CurrentPlayer.O : CurrentPlayer.X;
        } while (gameStatus == GameStatus.PLAYING);
    }

    private void setUserName() {
        System.out.println("Input yours name: ");
        userName = in.next();
    }

    private void printWinnerMessage() {
        if (gameStatus == GameStatus.WIN_O) {
            System.out.println("THE WINNER IS \"O\"!!!");
        } else if (gameStatus == GameStatus.WIN_X) {
            System.out.println("THE WINNER IS \"X\"!!!");
        } else if (gameStatus == GameStatus.DRAW) {
            System.out.println("It's a Draw!\nBye!");
        }
    }

    private void stepGameWithHuman() {
        boolean validInput;
        do {
            validInput = humanMove(false);
        } while (!validInput);
    }

    private void stepGameWithComputer() {
        boolean validInput = false;
        do {
            if (currentPlayer == CurrentPlayer.X) {
                validInput = humanMove(validInput);
            } else {
                validInput = computerMove();
            }
        } while (!validInput);
    }

    private boolean humanMove(boolean validInput) {
        System.out.print("Player " + currentPlayer.getValue() + ", enter your move (row[1-" + board.getGameType().x + "] column[1-" + board.getGameType().x + "]): ");
        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;
        try {
            isCorrectHumanMove(x, y);
            board.getGameBoard()[x][y] = currentPlayer.getValue();
            validInput = true;
        } catch (InvalidMove e) {
            System.out.println(e.getExceptionMessage());
        }
        return validInput;
    }

    private boolean computerMove() {
        boolean isValidComputerMove = false;
        do {
            int x = random.nextInt(board.getGameType().x);
            int y = random.nextInt(board.getGameType().x);
            if (isCorrectComputerMove(x, y)) {
                board.getGameBoard()[x][y] = "O";
                System.out.println("Computer 'O' move [" + (x + 1) + "] [" + (y + 1) + "]");
                isValidComputerMove = true;
            }
        } while (!isValidComputerMove);
        return true;
    }

    public void isCorrectHumanMove(int x, int y) throws InvalidMove {
        if (!(x >= 0 && x < board.getGameType().x && y >= 0 && y < board.getGameType().y)) {
            throw new InvalidMove("Invalid values, select another !!!");
        }
        if (!board.getGameBoard()[x][y].equals(" ")) {
            throw new InvalidMove("Invalid move, field is not available, select another !!!");
        }
    }

    private boolean isCorrectComputerMove(int x, int y) {
        return board.getGameBoard()[x][y].equals(" ");
    }

    public void checkWin() {
        checkResultForRows();
        checkResultForColumns();
        checkResultForCrossLeftDown();
        checkResultForCrossLeftUp();
        checkIsPossibleNextMove();
    }

    private void checkResultForRows() {
        for (int i = 0; i < board.getGameType().x; i++) {
            StringBuilder rowResult = new StringBuilder();
            for (int j = 0; j < board.getGameType().y; j++) {
                rowResult.append(board.getGameBoard()[i][j]);
            }
            checkWinner(rowResult.toString());
        }
    }

    private void checkResultForColumns() {
        for (int j = 0; j < board.getGameType().y; j++) {
            StringBuilder columnResult = new StringBuilder();
            for (int i = 0; i < board.getGameType().x; i++) {
                columnResult.append(board.getGameBoard()[i][j]);
            }
            checkWinner(columnResult.toString());
        }
    }

    private void checkResultForCrossLeftDown() {
        StringBuilder crossResultMiddle = new StringBuilder();
        for (int i = 0, j = 0; i < board.getGameType().x && j < board.getGameType().y; i++, j++) {
            crossResultMiddle.append(board.getGameBoard()[i][j]);
        }
        checkWinner(crossResultMiddle.toString());

        if (board.getGameType().x > 3) {
            for (int k = board.getGameType().x - 4; k > 0; k--) {
                StringBuilder crossResultX = new StringBuilder();
                for (int i = k, j = 0; i < board.getGameType().x && j < board.getGameType().y; i++, j++) {
                    crossResultX.append(board.getGameBoard()[i][j]);
                }
                checkWinner(crossResultX.toString());

                StringBuilder crossResultY = new StringBuilder();
                for (int i = 0, j = k; i < board.getGameType().x && j < board.getGameType().y; i++, j++) {
                    crossResultY.append(board.getGameBoard()[i][j]);
                }
                checkWinner(crossResultY.toString());
            }
        }
    }

    private void checkResultForCrossLeftUp() {
        StringBuilder crossResultMiddle = new StringBuilder();
        for (int i = board.getGameType().x - 1, j = 0; i >= 0 && j < board.getGameType().y; i--, j++) {
            crossResultMiddle.append(board.getGameBoard()[i][j]);
        }
        checkWinner(crossResultMiddle.toString());

        if (board.getGameType().x > 3) {
            for (int k = 3; k < board.getGameType().x - 1; k++) {
                StringBuilder crossResultX = new StringBuilder();
                for (int i = k, j = 0; i >= 0 && j < board.getGameType().y; i--, j++) {
                    crossResultX.append(board.getGameBoard()[i][j]);
                }
                checkWinner(crossResultX.toString());

                StringBuilder crossResultY = new StringBuilder();
                for (int i = board.getGameType().x - 1, j = k - 2; i > 0 && j < board.getGameType().y; i--, j++) {
                    crossResultY.append(board.getGameBoard()[i][j]);
                }
                checkWinner(crossResultY.toString());
            }
        }
    }

    private void checkIsPossibleNextMove() {
        if (gameStatus == GameStatus.PLAYING && Arrays.stream(board.getGameBoard()).flatMap(Arrays::stream).noneMatch(field -> field.equals(" "))) {
            this.gameStatus = GameStatus.DRAW;
            saveResults();
        }
    }

    private void checkWinner(String result) {
        if (gameStatus == GameStatus.PLAYING) {
            int repeatableNumber = board.getGameType().x <= 5 ? board.getGameType().x : 5;
            if (result.contains("O".repeat(repeatableNumber))) {
                gameStatus = GameStatus.WIN_O;
                saveResults();
            } else if (result.contains("X".repeat(repeatableNumber))) {
                gameStatus = GameStatus.WIN_X;
                saveResults();
            }
        }
    }

    private void saveResults() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            map.put(userName, userName.concat("|").concat("5").concat("|").concat("3").concat("|").concat(LocalDateTime.now().toString()));
            for (Map.Entry<String, String> entry : map.entrySet()) {
                bw.write(entry.getKey() + ":" + entry.getValue());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadResults() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                String name = parts[0].trim();
                String restOfFile = parts[1].trim();

                if (!name.equals("") && !restOfFile.equals("")) {
                    map.put(name, restOfFile);
                }
            }
            map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + "->" + entry.getValue()));
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku do odczytu. Zostanie utworzony nowy plik.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
}
