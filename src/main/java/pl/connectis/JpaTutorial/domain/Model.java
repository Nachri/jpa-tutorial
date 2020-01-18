package pl.connectis.JpaTutorial.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id") // optional
    private Brand brand;

    @ManyToMany(mappedBy = "models")
    private Set<Engine> engines;
}
