package dto;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import model.Players;

@Data
@NoArgsConstructor
public class MatchDTO {
    private PlayersDTO playersOne, playersTwo;
    private int setScorePlayerOne, setScorePlayerTwo;
    private int gamesScorePlayerOne, gamesScorePlayerTwo;
    private int pointScorePlayerOne, pointScorePlayerTwo;

    public PlayersDTO getPlayersOne() {
        return playersOne;
    }

    public void setPlayersOne(PlayersDTO playersOne) {
        this.playersOne = playersOne;
    }

    public PlayersDTO getPlayersTwo() {
        return playersTwo;
    }

    public void setPlayersTwo(PlayersDTO playersTwo) {
        this.playersTwo = playersTwo;
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
}
