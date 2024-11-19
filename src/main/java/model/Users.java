package model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

@NamedQuery(name = "User.findByUsername", query = "SELECT u FROM Users u WHERE username = ?1")
public class Users extends User {


    @ManyToMany
    private List<Book> books = new ArrayList<>();

    @ElementCollection(targetClass = Address.class)
    private List<Address> addressList = new ArrayList<>();


}
