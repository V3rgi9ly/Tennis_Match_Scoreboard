package dto;


import lombok.*;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayersDTO {

    private int id;
    private String name;

    public PlayersDTO( String name) {
        this.name = name;
    }
}
