package tutor.ship.com.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Table(name = "cronogramacurso")
public class CronogramaCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn( name = "curso_id" )
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Cursos curso_id;

    @OneToOne
    @JoinColumn( name = "docente_id")
    private Personas docente_id;

    @ManyToOne
    @JoinColumn( name = "tutor_id")
    private Personas tutor_id;

    @Column(name = "horainicio")
    private Time horaInicio;

    @Column(name = "horafin")
    private Time horaFin;

    private Date fecha;
    private String estado;
}
