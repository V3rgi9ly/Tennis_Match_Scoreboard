package dto;


import lombok.*;

@Data
@Getter @Setter
@NoArgsConstructor
public class PlayersDTO {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public PlayersDTO( String name) {
        this.name = name;
    }
}
