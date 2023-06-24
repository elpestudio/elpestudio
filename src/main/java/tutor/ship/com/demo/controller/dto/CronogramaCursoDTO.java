package tutor.ship.com.demo.controller.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import tutor.ship.com.demo.model.Cursos;
import tutor.ship.com.demo.model.Personas;

import java.sql.Date;
import java.sql.Time;
@Getter
@Setter
public class CronogramaCursoDTO {
    private Cursos curso_id;
    private Personas docente_id;
    private Personas tutor_id;
    private Time horaInicio;
    private Time horaFin;
    private Date fecha;
    private String estado;
}
