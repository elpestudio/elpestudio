package tutor.ship.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tutor.ship.com.demo.model.DetalleCursoPersona;

import java.util.Optional;

public interface DetalleCursoPersonaRepository extends JpaRepository<DetalleCursoPersona, Integer> {

    @Override
    Optional<DetalleCursoPersona> findById(Integer id);
    Optional<DetalleCursoPersona> findOneById(Integer id);;
    Optional<DetalleCursoPersona> findByEstado(String estado);
}
