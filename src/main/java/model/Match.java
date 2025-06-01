package model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Match {

    private Players player1,
            player2;
//    private int idPlayerOne, idPlayerTwo;
    private int setScorePlayerOne=0, setScorePlayerTwo=0;
    private int gamesScorePlayerOne, gamesScorePlayerTwo;
    private int pointScorePlayerOne, pointScorePlayerTwo;
    private boolean timeBreak=false;
    private boolean gameOver=false;
    private Players winner;

    public int getPointScorePlayerTwo() {return pointScorePlayerTwo;}

    public void setPointScorePlayerTwo(int pointScorePlayerTwo) {
        this.pointScorePlayerTwo = pointScorePlayerTwo;
    }

    public int getPointScorePlayerOne() {
        return pointScorePlayerOne;
    }

    public void setPointScorePlayerOne(int pointScorePlayerOne) {
        this.pointScorePlayerOne = pointScorePlayerOne;
    }

    public int getGamesScorePlayerTwo() {
        return gamesScorePlayerTwo;
    }

    public void setGamesScorePlayerTwo(int gamesScorePlayerTwo) {
        this.gamesScorePlayerTwo = gamesScorePlayerTwo;
    }

    public int getGamesScorePlayerOne() {
        return gamesScorePlayerOne;
    }

    public void setGamesScorePlayerOne(int gamesScorePlayerOne) {
        this.gamesScorePlayerOne = gamesScorePlayerOne;
    }

    public int getSetScorePlayerTwo() {
        return setScorePlayerTwo;
    }

    public void setSetScorePlayerTwo(int setScorePlayerTwo) {
        this.setScorePlayerTwo = setScorePlayerTwo;
    }

    public int getSetScorePlayerOne() {
        return setScorePlayerOne;
    }

    public void setSetScorePlayerOne(int setScorePlayerOne) {
        this.setScorePlayerOne = setScorePlayerOne;
    }

    public Players getPlayer2() {
        return player2;
    }

    public void setPlayer2(Players player2) {
        this.player2 = player2;
    }

    public Players getPlayersOne() {
        return player1;
    }

    public void setPlayersOne(Players playersOne) {
        this.player1 = playersOne;
    }


    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isTimeBreak() {
        return timeBreak;
    }

    public void setTimeBreak(boolean timeBreak) {
        this.timeBreak = timeBreak;
    }

    public Players getWinner() {
        return winner;
    }

    public void setWinner(Players winner) {
        this.winner = winner;
    }
}
