package pl.connectis.JpaTutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.connectis.JpaTutorial.domain.Engine;

public interface EngineRepository extends JpaRepository<Engine, String> {
}
