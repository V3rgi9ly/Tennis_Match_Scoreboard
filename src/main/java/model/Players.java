package model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PLAYERS")
public class Players {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "NAME")
    private String name;

    public Players() {

    }

    public Players(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }



}
