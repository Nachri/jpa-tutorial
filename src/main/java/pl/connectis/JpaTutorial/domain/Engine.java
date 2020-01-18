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
@ToString
@EqualsAndHashCode(of = "code")
public class Engine {

    @Id
    private String code;

    @Enumerated(EnumType.STRING)
    private EngineType type;

    @ManyToMany
    @JoinTable(
            name = "model_engines",
            joinColumns = @JoinColumn(name = "engine_code"),
            inverseJoinColumns = @JoinColumn(name = "model_id")
    )
    private Set<Model> models;
}
