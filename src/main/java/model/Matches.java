package model;


import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Table(name="MATCHES")
@NoArgsConstructor

public class Matches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne( cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH
    })
    @JoinColumn(name = "PLAYER1")
    private Players player1;

    @OneToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH
    })
    @JoinColumn(name = "PLAYER2")
    private Players player2;

    @OneToOne( cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH
    })
    @JoinColumn(name = "WINNER")
    private Players winner;

    public Players getWinner() {
        return winner;
    }

    public void setWinner(Players winner) {
        this.winner = winner;
    }

    public Players getPlayer2() {
        return player2;
    }

    public void setPlayer2(Players player2) {
        this.player2 = player2;
    }

    public Players getPlayer1() {
        return player1;
    }

    public void setPlayer1(Players player1) {
        this.player1 = player1;
    }
}
