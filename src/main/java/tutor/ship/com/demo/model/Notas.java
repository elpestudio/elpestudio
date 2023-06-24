package tutor.ship.com.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "notas")
public class Notas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name ="cronograma_curso_id" )
    private CronogramaCurso cronograma_curso_id;

    @ManyToOne
    @JoinColumn(name ="alumno_id")
    private Personas alumno_id;

    @ManyToOne
    @JoinColumn(name ="docente_tutor_id")
    private Personas docente_tutor_id;

    private double nota;
    private Date fecha;
    private String estado;
}
