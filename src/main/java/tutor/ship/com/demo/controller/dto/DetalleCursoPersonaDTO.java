package tutor.ship.com.demo.controller.dto;

import lombok.Getter;
import lombok.Setter;
import tutor.ship.com.demo.model.CronogramaCurso;
import tutor.ship.com.demo.model.Personas;

import java.sql.Date;

@Getter
@Setter
public class DetalleCursoPersonaDTO {

    private Personas alumno_id;

    private CronogramaCurso cronograma_curso_id;

    private Personas tutor_id;

    private Date fecha;

    private String estado;
}
