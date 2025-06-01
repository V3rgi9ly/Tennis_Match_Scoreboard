package dto;


import lombok.*;


@NoArgsConstructor

public class MathesDTO {

    @Getter
    @Setter
    private int id;
    @Setter
    @Getter
    private PlayersDTO player1;
    @Setter
    @Getter
    private PlayersDTO player2;
    @Setter
    @Getter
    private PlayersDTO winner;

    public MathesDTO(PlayersDTO player1, PlayersDTO player2, PlayersDTO winner) {
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;
    }

    public String toString() {
        return player1 + "\t" + player2 + "\t" + winner;
    }
}
