package tutor.ship.com.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tutor.ship.com.demo.model.Notas;

import java.util.Date;
import java.util.Optional;
public interface NotasRepository extends JpaRepository<Notas,Integer> {

    @Override
    Optional<Notas> findById(Integer id);
    Optional<Notas> findOneById(Integer id);
    //Optional<Notas> findOneByIdAndCronograma_curso_id(Integer id, Integer cronograma_curso_id);
   // Optional<Notas> findOneByIdAndAlumno_id(Integer id, Integer alumno_id);
   // Optional<Notas> findOneByIdAndDocente_tutor_id(Integer id, Integer docente_tutor_id);
  //  Optional<Notas> findOneByNota(Integer id, Integer nota);
    Optional<Notas> findOneByFecha(Date fecha);
    Optional<Notas> findOneByEstado(String estado);
}
