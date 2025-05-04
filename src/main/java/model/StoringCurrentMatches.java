package model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="STORINGCURRENTMATHES")
public class StoringCurrentMatches {

    @Id
    private UUID id;

    @Column(name = "PLAYERSMATCHE")
    private String playersCurrentMathes;
}
