package pl.connectis.JpaTutorial.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@EqualsAndHashCode(of = "id")
@Setter
@Getter
@ToString
public class Brand {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Country origin;

    @OneToOne
    private Ceo ceo;

    @OneToMany(mappedBy = "brand")
    private Set<Model> models;
}
