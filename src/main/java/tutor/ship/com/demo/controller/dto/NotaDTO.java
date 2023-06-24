package tutor.ship.com.demo.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import tutor.ship.com.demo.model.CronogramaCurso;
import tutor.ship.com.demo.model.Personas;

import java.util.Date;
@Getter
@Setter
public class NotaDTO {

    private CronogramaCurso cronograma_curso_id;

    private Personas alumno_id;

    private Personas docente_tutor_id;
    private Double nota;
    private Date fecha;
    private String estado;


}
