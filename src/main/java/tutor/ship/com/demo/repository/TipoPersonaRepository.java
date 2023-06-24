package tutor.ship.com.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tutor.ship.com.demo.model.TipoPersona;

import java.util.Optional;

public interface TipoPersonaRepository extends JpaRepository<TipoPersona, Integer> {
    Optional<TipoPersona> findById(Integer id);
}
