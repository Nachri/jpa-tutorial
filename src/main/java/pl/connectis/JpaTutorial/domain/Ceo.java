package pl.connectis.JpaTutorial.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Setter
@Getter
@EqualsAndHashCode(of = "id")
@ToString
public class Ceo {

    @Id
    @GeneratedValue
    private long id;

    private String firstName;

    private String lastName;

    @OneToOne(mappedBy = "ceo")
    @JsonIgnore
    private Brand brand;
}
