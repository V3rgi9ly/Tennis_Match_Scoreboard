package model;


import lombok.*;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayersCurrentMathes {

    private int IdPlayersOne;
    private int IdPlayersTwo;

    private int SetsScorePlayerOne;
    private int SetsScorePlayerTwo;

    private int GamesScorePlayerOne;
    private int GamesScorePlayerTwo;

    private int PointsScorePlayerOne;
    private int PointsScorePlayerTwo;


    @Override
    public String toString() {
        return "PlayersCurrentMathes{" +
                "IdPlayersOne=" + IdPlayersOne +
                ", IdPlayersTwo=" + IdPlayersTwo +
                ", SetsScorePlayerOne=" + SetsScorePlayerOne +
                ", SetsScorePlayerTwo=" + SetsScorePlayerTwo +
                ", GamesScorePlayerOne=" + GamesScorePlayerOne +
                ", GamesScorePlayerTwo=" + GamesScorePlayerTwo +
                ", PointsScorePlayerOne=" + PointsScorePlayerOne +
                ", PointsScorePlayerTwo=" + PointsScorePlayerTwo +
                '}';
    }
}
