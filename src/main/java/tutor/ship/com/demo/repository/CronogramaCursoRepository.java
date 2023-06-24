package tutor.ship.com.demo.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import tutor.ship.com.demo.model.CronogramaCurso;

import java.awt.print.Pageable;
import java.sql.Date;
import java.util.Optional;

public interface CronogramaCursoRepository extends JpaRepository <CronogramaCurso, Integer> {

    @Override
    Optional<CronogramaCurso> findById(Integer id);
    Optional<CronogramaCurso> findOneById(Integer id);
    Optional<CronogramaCurso> findByFecha(Date fecha);
    Optional<CronogramaCurso> findByEstado(String estado);


}
