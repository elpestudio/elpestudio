package tutor.ship.com.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "personas")
public class Personas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name ="tipopersona_id")
    TipoPersona tipopersona_id;

    @Column(name = "nombresapellidos")
    private String nombresApellidos;

    private String correo;
    private String matricula;
    private String usuario;
    private String password;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "institucion_id")
    Institucion institucion_id;
}
