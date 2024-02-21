package guru.springframework.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Notes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //notes are owned by recipe - we don't want to delete a recipe when we delete a note - so no cascade is set here
    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;
}
