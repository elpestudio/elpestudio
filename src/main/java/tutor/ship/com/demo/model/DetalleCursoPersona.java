package tutor.ship.com.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "detallecursopersona")
public class DetalleCursoPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Personas alumno_id;

    @ManyToOne
    @JoinColumn(name = "cronograma_curso_id")
    private CronogramaCurso cronograma_curso_id;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Personas tutor_id;

    private Date fecha;
    private String estado;
}
