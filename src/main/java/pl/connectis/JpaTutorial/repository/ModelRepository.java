package pl.connectis.JpaTutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.connectis.JpaTutorial.domain.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
