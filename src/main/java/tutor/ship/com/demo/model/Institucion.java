package tutor.ship.com.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "institucion")
public class Institucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String ruc;
    private String nombre;
    private String direccion;
    private String correo;
    private String celular;
    private String estado;
}
