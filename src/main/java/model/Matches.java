package model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="MATCHES")
@NoArgsConstructor

public class Matches {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    @OneToOne( cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH
    })
    @JoinColumn(name = "PLAYER1")
    private Players player1;

    @Getter
    @Setter
    @OneToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH
    })
    @JoinColumn(name = "PLAYER2")
    private Players player2;

    @Getter
    @Setter
    @OneToOne( cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH
    })
    @JoinColumn(name = "WINNER")
    private Players winner;

    public String toString() {
        return "Matches [player1=" + player1 + ", player2=" + player2+ ", winner=" + winner + "]";
    }
}
