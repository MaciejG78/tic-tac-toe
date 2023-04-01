package com.example.tictactoe;

import com.example.tictactoe.enums.GameStatus;
import com.example.tictactoe.enums.GameType;
import com.example.tictactoe.enums.OpponentType;
import com.example.tictactoe.exception.InvalidMove;
import com.example.tictactoe.stub.BoardStub;
import org.junit.Assert;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GameTest {

    int testNumbers;

    @BeforeEach
    void beforeEach(TestInfo testInfo) {
        String dName = testInfo.getDisplayName();
        System.out.println("------------- Start: " + dName + "(" + testInfo.getTestMethod().orElseThrow().getName() + ") ---------------------");
        testNumbers++;
    }

    @AfterAll
    void after() {
        System.out.println("Number of run tests: " + testNumbers);
    }

    @Test
    @DisplayName("Testy weryfikujące zwycięstwa O w wierszach 3X3")
    void check3x3WinRowO() {
        //given
        BoardStub boardStub = new BoardStub(OpponentType.HUMAN, GameType.BOARD3x3);
        boardStub.initializeBoard3x3WinRowO();
        Game game = new Game(boardStub);
        //when
        game.checkWin();
        //then
        Assert.assertTrue(game.getGameStatus() == GameStatus.WIN_O );
    }

    @Test
    @DisplayName("Testy weryfikujące zwycięstwa O w kolumnach 3X3")
    void check3x3WinColumnO() {
        //given
        BoardStub boardStub = new BoardStub(OpponentType.HUMAN, GameType.BOARD3x3);
        boardStub.initializeBoard3x3WinColumnO();
        Game game = new Game(boardStub);
        //when
        game.checkWin();
        //then
        Assert.assertTrue(game.getGameStatus() == GameStatus.WIN_O );
    }

    @Test
    @DisplayName("Testy weryfikujące zwycięstwa O po przekątnych planszy 3X3")
    void checkWin3x3WinCrossO() {
        //given
        BoardStub boardStub = new BoardStub(OpponentType.HUMAN, GameType.BOARD3x3);
        boardStub.initializeBoard3x3WinCrossO();
        Game game = new Game(boardStub);
        //when
        game.checkWin();
        //then
        Assert.assertTrue(game.getGameStatus() == GameStatus.WIN_O );
    }

    @Test
    @DisplayName("Testy weryfikujące zwycięstwa X w wierszach 3X3")
    void checkWin3x3WinRowX() {
        //given
        BoardStub boardStub = new BoardStub(OpponentType.HUMAN, GameType.BOARD3x3);
        boardStub.initializeBoard3x3WinRowX();
        Game game = new Game(boardStub);
        //when
        game.checkWin();
        //then
        Assert.assertTrue(game.getGameStatus() == GameStatus.WIN_X );
    }

    @Test
    @DisplayName("Testy weryfikujące zwycięstwa X w kolumnach 3X3")
    void check3x3WinColumnX() {
        //given
        BoardStub boardStub = new BoardStub(OpponentType.HUMAN, GameType.BOARD3x3);
        boardStub.initializeBoard3x3WinColumnX();
        Game game = new Game(boardStub);
        //when
        game.checkWin();
        //then
        Assert.assertTrue(game.getGameStatus() == GameStatus.WIN_X );
    }

    @Test
    @DisplayName("Testy weryfikujące zwycięstwa X po przekątnych planszy 3X3")
    void checkWin3x3WinCrossX() {
        //given
        BoardStub boardStub = new BoardStub(OpponentType.HUMAN, GameType.BOARD3x3);
        boardStub.initializeBoard3x3WinCrossX();
        Game game = new Game(boardStub);
        //when
        game.checkWin();
        //then
        Assert.assertTrue(game.getGameStatus() == GameStatus.WIN_X );
    }

    @Test
    @DisplayName("Testy weryfikujące układy, które prowadzą do remisu 3X3")
    void checkWin3x3NoWinner() {
        //given
        BoardStub boardStub = new BoardStub(OpponentType.HUMAN, GameType.BOARD3x3);
        boardStub.initializeBoard3x3NoWinner();
        Game game = new Game(boardStub);
        //when
        game.checkWin();
        //then
        Assert.assertTrue(game.getGameStatus() == GameStatus.DRAW );
    }

    @Test
    @DisplayName("Testy weryfikujące, czy w przypadku błędnie wykonanych ruchów zostanie rzucony odpowiedni wyjątek 3X3")
    void checkWin3x3WrongMove() throws InvalidMove {
        //given
        BoardStub boardStub = new BoardStub(OpponentType.HUMAN, GameType.BOARD3x3);
        boardStub.initializeBoard3x3WrongMove();
        Game game = new Game(boardStub);
        //when, then
        InvalidMove ex = Assert.assertThrows(InvalidMove.class, () -> game.isCorrectHumanMove(0, 0));
        Assert.assertTrue(ex.getExceptionMessage().equals("Invalid move, field is not available, select another !!!"));
        ex = Assert.assertThrows(InvalidMove.class, () -> game.isCorrectHumanMove(0, 4));
        Assert.assertTrue(ex.getExceptionMessage().equals("Invalid values, select another !!!"));
        Assertions.assertDoesNotThrow(() -> game.isCorrectHumanMove(0, 1));

    }

    @Test
    @DisplayName("Testy weryfikujące zwycięstwa O w wierszach 10X10")
    void check10x10WinRowO() {
        //given
        BoardStub boardStub = new BoardStub(OpponentType.HUMAN, GameType.BOARD10x10);
        boardStub.initializeBoard10x10WinRowO();
        Game game = new Game(boardStub);
        //when
        game.checkWin();
        //then
        Assert.assertTrue(game.getGameStatus() == GameStatus.WIN_O );
    }

    @Test
    @DisplayName("Testy weryfikujące zwycięstwa O w kolumnach 10X10")
    void check10X10WinColumnO() {
        //given
        BoardStub boardStub = new BoardStub(OpponentType.HUMAN, GameType.BOARD10x10);
        boardStub.initializeBoard10x10WinColumnO();
        Game game = new Game(boardStub);
        //when
        game.checkWin();
        //then
        Assert.assertTrue(game.getGameStatus() == GameStatus.WIN_O );
    }

    @Test
    @DisplayName("Testy weryfikujące zwycięstwa O po przekątnych planszy 10X10")
    void checkWin10X10WinCrossO() {
        //given
        BoardStub boardStub = new BoardStub(OpponentType.HUMAN, GameType.BOARD10x10);
        boardStub.initializeBoard10x10WinCrossO();
        Game game = new Game(boardStub);
        //when
        game.checkWin();
        //then
        Assert.assertTrue(game.getGameStatus() == GameStatus.WIN_O );
    }

    @Test
    @DisplayName("Testy weryfikujące zwycięstwa X w wierszach 10X10")
    void checkWin10X10WinRowX() {
        //given
        BoardStub boardStub = new BoardStub(OpponentType.HUMAN, GameType.BOARD10x10);
        boardStub.initializeBoard10x10WinRowX();
        Game game = new Game(boardStub);
        //when
        game.checkWin();
        //then
        Assert.assertTrue(game.getGameStatus() == GameStatus.WIN_X );
    }

    @Test
    @DisplayName("Testy weryfikujące zwycięstwa X w kolumnach 10X10")
    void check10X10WinColumnX() {
        //given
        BoardStub boardStub = new BoardStub(OpponentType.HUMAN, GameType.BOARD10x10);
        boardStub.initializeBoard10x10WinColumnX();
        Game game = new Game(boardStub);
        //when
        game.checkWin();
        //then
        Assert.assertTrue(game.getGameStatus() == GameStatus.WIN_X );
    }

    @Test
    @DisplayName("Testy weryfikujące zwycięstwa X po przekątnych planszy 10X10")
    void checkWin10X10WinCrossX() {
        //given
        BoardStub boardStub = new BoardStub(OpponentType.HUMAN, GameType.BOARD10x10);
        boardStub.initializeBoard10x10WinCrossX();
        Game game = new Game(boardStub);
        //when
        game.checkWin();
        //then
        Assert.assertTrue(game.getGameStatus() == GameStatus.WIN_X );
    }

    @Test
    @DisplayName("Testy weryfikujące układy, które prowadzą do remisu 10X10")
    void checkWin10X10NoWinner() {
        //given
        BoardStub boardStub = new BoardStub(OpponentType.HUMAN, GameType.BOARD10x10);
        boardStub.initializeBoard10x10NoWinner();
        Game game = new Game(boardStub);
        //when
        game.checkWin();
        //then
        Assert.assertTrue(game.getGameStatus() == GameStatus.DRAW );
    }

    @Test
    @DisplayName("Testy weryfikujące, czy w przypadku błędnie wykonanych ruchów zostanie rzucony odpowiedni wyjątek 10X10")
    void checkWin10X10WrongMove() throws InvalidMove {
        //given
        BoardStub boardStub = new BoardStub(OpponentType.HUMAN, GameType.BOARD10x10);
        boardStub.initializeBoard10x10WrongMove();
        Game game = new Game(boardStub);
        //when, then
        InvalidMove ex = Assert.assertThrows(InvalidMove.class, () -> game.isCorrectHumanMove(0, 0));
        Assert.assertTrue(ex.getExceptionMessage().equals("Invalid move, field is not available, select another !!!"));
        ex = Assert.assertThrows(InvalidMove.class, () -> game.isCorrectHumanMove(15, 0));
        Assert.assertTrue(ex.getExceptionMessage().equals("Invalid values, select another !!!"));
        Assertions.assertDoesNotThrow(() -> game.isCorrectHumanMove(1, 0));
    }
}