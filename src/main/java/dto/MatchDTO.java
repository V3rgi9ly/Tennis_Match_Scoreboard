package dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Players;

@NoArgsConstructor
@AllArgsConstructor

public class MatchDTO {


    @Getter @Setter
    private Players player1, player2;

    @Getter @Setter
    private int setScorePlayerOne, setScorePlayerTwo;

    @Getter @Setter
    private int gamesScorePlayerOne, gamesScorePlayerTwo;

    @Getter @Setter
    private String pointScorePlayerOne, pointScorePlayerTwo;

    @Getter @Setter
    private boolean gameOver=false;

    @Getter @Setter
    private Players winner;




}
