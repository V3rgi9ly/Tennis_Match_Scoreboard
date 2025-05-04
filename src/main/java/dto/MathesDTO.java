package dto;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor

public class MathesDTO {
    private int id;
    private int playerOne;
    private int playerTwo;
    private int winner;

    public MathesDTO( int playerOne, int playerTwo, int winner) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.winner = winner;
    }
}
