package model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Match {

    private Players player1,
            player2;
//    private int idPlayerOne, idPlayerTwo;
    private int setScorePlayerOne, setScorePlayerTwo;
    private int gamesScorePlayerOne, gamesScorePlayerTwo;
    private String pointScorePlayerOne, pointScorePlayerTwo;
    private boolean tieBreak =false;
    private boolean setTiedAtFive=false;
    private boolean gameOver=false;
    private boolean advantage=false;
    private Players winner;

    public String getPointScorePlayerTwo() {return pointScorePlayerTwo;}

    public void setPointScorePlayerTwo(String pointScorePlayerTwo) {
        this.pointScorePlayerTwo = pointScorePlayerTwo;
    }

    public String getPointScorePlayerOne() {
        return pointScorePlayerOne;
    }

    public void setPointScorePlayerOne(String pointScorePlayerOne) {
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

    public boolean isTieBreak() {
        return tieBreak;
    }

    public void setTieBreak(boolean tieBreak) {
        this.tieBreak = tieBreak;
    }

    public Players getWinner() {
        return winner;
    }

    public void setWinner(Players winner) {
        this.winner = winner;
    }

    public boolean isAdvantage() {
        return advantage;
    }

    public void setAdvantage(boolean advantage) {
        this.advantage = advantage;
    }

    public boolean isSetTiedAtFive() {
        return setTiedAtFive;
    }

    public void setSetTiedAtFive(boolean setTiedAtFive) {
        this.setTiedAtFive = setTiedAtFive;
    }

    public Match(Players player1, Players player2, int setScorePlayerOne, int setScorePlayerTwo, int gamesScorePlayerOne, int gamesScorePlayerTwo, String pointScorePlayerOne, String pointScorePlayerTwo) {
        this.player1 = player1;
        this.player2 = player2;
        this.setScorePlayerOne = setScorePlayerOne;
        this.setScorePlayerTwo = setScorePlayerTwo;
        this.gamesScorePlayerOne = gamesScorePlayerOne;
        this.gamesScorePlayerTwo = gamesScorePlayerTwo;
        this.pointScorePlayerOne = pointScorePlayerOne;
        this.pointScorePlayerTwo = pointScorePlayerTwo;
    }
}
