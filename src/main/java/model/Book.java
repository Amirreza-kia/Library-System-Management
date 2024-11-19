package model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@NamedQuery(name = "findByFKAndDELETE",query = "SELECT b FROM Book b WHERE subjects = ?1")
public class Book extends BaseModel{
     private String title;
     private String author;



     @ManyToOne
     @JoinColumn(name = "fk_subject")
     private Subjects subjects;


}
