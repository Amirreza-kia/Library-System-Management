package model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subjects extends BaseModel{
    @Column(unique=true)
    String name;



    @OneToMany(mappedBy = "subjects")
    private List<Book> books = new ArrayList<>();



}
