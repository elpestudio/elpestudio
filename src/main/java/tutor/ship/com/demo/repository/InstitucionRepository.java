package tutor.ship.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tutor.ship.com.demo.model.Institucion;

public interface InstitucionRepository extends JpaRepository<Institucion, Integer> {
}
