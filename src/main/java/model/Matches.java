package model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
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


    public Matches(Players player1, Players player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public String toString() {
        return "Matches{" +
                "id=" + id +
                ", player1=" + player1 +
                ", player2=" + player2 +
                ", winner=" + winner +
                '}';
    }
}
