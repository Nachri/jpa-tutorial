package pl.connectis.JpaTutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.connectis.JpaTutorial.domain.Model;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {

    List<Model> findByName(String name);
}
