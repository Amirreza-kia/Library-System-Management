package model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Admin extends User {


    @ElementCollection(targetClass = Address.class)
    private List<Address> addressListAdmin = new ArrayList<>();

}
