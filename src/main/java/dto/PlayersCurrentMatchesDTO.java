package dto;

import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayersCurrentMatchesDTO {
    private int IdPlayersOne;
    private int IdPlayersTwo;

    private int SetsScorePlayerOne;
    private int SetsScorePlayerTwo;

    private int GamesScorePlayerOne;
    private int GamesScorePlayerTwo;

    private int PointsScorePlayerOne;
    private int PointsScorePlayerTwo;
}
