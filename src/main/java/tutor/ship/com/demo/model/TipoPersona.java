package tutor.ship.com.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.naming.Name;

@Data
@Entity
@Table(name = "tipopersona")
public class TipoPersona {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String tipo;
    private String estado;

}
