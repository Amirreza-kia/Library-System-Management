package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

}
