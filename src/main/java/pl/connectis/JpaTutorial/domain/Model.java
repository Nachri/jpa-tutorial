package pl.connectis.JpaTutorial.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@EqualsAndHashCode(of = "id")
@ToString
public class Model {

    @Id
    @GeneratedValue
    private long id;

    @Length(min = 3, max =8)
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id") // optional
    private Brand brand;

    @ManyToMany(mappedBy = "models")
    private Set<Engine> engines;
}
