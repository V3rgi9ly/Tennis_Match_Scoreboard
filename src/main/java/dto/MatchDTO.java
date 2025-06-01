package dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import model.Players;

@Data
@NoArgsConstructor
public class MatchDTO {

    private Players player1, player2;
    private int setScorePlayerOne, setScorePlayerTwo;
    private int gamesScorePlayerOne, gamesScorePlayerTwo;
    private int pointScorePlayerOne, pointScorePlayerTwo;
    private boolean timeBreak=false;
    private boolean gameOver=false;
    private Players winner;


    public Players getPlayer1() {
        return player1;
    }

    public void setPlayer1(Players player1) {
        this.player1 = player1;
    }

    public Players getPlayer2() {
        return player2;
    }

    public void setPlayer2(Players player2) {
        this.player2 = player2;
    }

    public int getSetScorePlayerOne() {
        return setScorePlayerOne;
    }

    public void setSetScorePlayerOne(int setScorePlayerOne) {
        this.setScorePlayerOne = setScorePlayerOne;
    }

    public int getSetScorePlayerTwo() {
        return setScorePlayerTwo;
    }

    public void setSetScorePlayerTwo(int setScorePlayerTwo) {
        this.setScorePlayerTwo = setScorePlayerTwo;
    }

    public int getGamesScorePlayerOne() {
        return gamesScorePlayerOne;
    }

    public void setGamesScorePlayerOne(int gamesScorePlayerOne) {
        this.gamesScorePlayerOne = gamesScorePlayerOne;
    }

    public int getGamesScorePlayerTwo() {
        return gamesScorePlayerTwo;
    }

    public void setGamesScorePlayerTwo(int gamesScorePlayerTwo) {
        this.gamesScorePlayerTwo = gamesScorePlayerTwo;
    }

    public int getPointScorePlayerOne() {
        return pointScorePlayerOne;
    }

    public void setPointScorePlayerOne(int pointScorePlayerOne) {
        this.pointScorePlayerOne = pointScorePlayerOne;
    }

    public int getPointScorePlayerTwo() {
        return pointScorePlayerTwo;
    }

    public void setPointScorePlayerTwo(int pointScorePlayerTwo) {
        this.pointScorePlayerTwo = pointScorePlayerTwo;
    }



    public boolean isTimeBreak() {
        return timeBreak;
    }

    public void setTimeBreak(boolean timeBreak) {
        this.timeBreak = timeBreak;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Players getWinner() {
        return winner;
    }

    public void setWinner(Players winner) {
        this.winner = winner;
    }
}
