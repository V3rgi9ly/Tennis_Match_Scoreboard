package model;


import jakarta.persistence.*;

@Entity
@Table(name="MATCHES")
public class Matches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int player1;

    private int player2;

    private int winner;
}
