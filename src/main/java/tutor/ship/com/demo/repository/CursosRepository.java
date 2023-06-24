package tutor.ship.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tutor.ship.com.demo.model.Cursos;
import tutor.ship.com.demo.model.Notas;

import java.util.Optional;

public interface CursosRepository extends JpaRepository <Cursos, Integer > {
    @Override
    Optional<Cursos> findById(Integer id);
    //Optional<Cursos> finOneByIdAndCursos(Integer id,String cursos);
}
