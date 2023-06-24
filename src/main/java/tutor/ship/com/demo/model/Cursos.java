package tutor.ship.com.demo.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cursos")
public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column (name ="id")
    private Integer id;

    private String denominacion;
    private String codigo;

    @OneToOne
    @JoinColumn(name ="persona_id")
    Personas persona_id;

    private String estado;
}
