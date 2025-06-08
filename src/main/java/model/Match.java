package model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Match {

    private Players player1,
            player2;
    private int setScorePlayerOne, setScorePlayerTwo;
    private int gamesScorePlayerOne, gamesScorePlayerTwo;
    private String pointScorePlayerOne, pointScorePlayerTwo;
    private boolean tieBreak =false;
    private boolean setTiedAtFive=false;
    private boolean gameOver=false;
    private boolean advantage=false;
    private Players winner;

    public Players getPlayersOne() {
        return player1;
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
