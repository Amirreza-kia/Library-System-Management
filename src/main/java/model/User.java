package model;

import lombok.*;
import model.enums.Gender;
import model.enums.UserType;

import javax.persistence.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQuery(name = "User.findByUsernameAndPassword",query = "SELECT u FROM User u WHERE username = ?1 AND password = ?2")
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private UserType userType;


}
