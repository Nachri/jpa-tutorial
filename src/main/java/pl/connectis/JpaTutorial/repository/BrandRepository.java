package pl.connectis.JpaTutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.connectis.JpaTutorial.domain.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
