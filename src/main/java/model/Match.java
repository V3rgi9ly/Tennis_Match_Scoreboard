package model;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Match {
    private Players playersOne, playersTwo;
//    private int idPlayerOne, idPlayerTwo;
    private int setScorePlayerOne, setScorePlayerTwo;
    private int gamesScorePlayerOne, gamesScorePlayerTwo;
    private int pointScorePlayerOne;

    public int getPointScorePlayerTwo() {
        return pointScorePlayerTwo;
    }

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

    public Players getPlayersTwo() {
        return playersTwo;
    }

    public void setPlayersTwo(Players playersTwo) {
        this.playersTwo = playersTwo;
    }

    public Players getPlayersOne() {
        return playersOne;
    }

    public void setPlayersOne(Players playersOne) {
        this.playersOne = playersOne;
    }

    private int pointScorePlayerTwo;
}
