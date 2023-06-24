package tutor.ship.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tutor.ship.com.demo.model.Personas;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Personas, Integer> {
    @Override
    Optional<Personas>findById(Integer id);
    Optional<Personas> findByUsuarioAndPassword(String usuario, String password);
    Optional<Personas> findByEstado(String estado);
    Optional<Personas> findByMatricula(String matricula);
    Optional<Personas> findByNombresApellidos(String nombresApeliidos);


}
