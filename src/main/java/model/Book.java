package model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@NamedQueries({@NamedQuery(name = "findByFKAndDELETE",query = "SELECT b FROM Book b WHERE subjects = ?1"),
        @NamedQuery(name = "replaceFkKey",query = "SELECT b FROM Book b WHERE subjects.id = ?1 ")})

public class Book extends BaseModel{
     private String title;
     private String author;



     @ManyToOne
     @JoinColumn(name = "fk_subject")
     private Subjects subjects;






}
