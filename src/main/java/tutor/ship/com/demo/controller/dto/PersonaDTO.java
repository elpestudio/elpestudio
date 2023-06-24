package tutor.ship.com.demo.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import tutor.ship.com.demo.model.Institucion;
import tutor.ship.com.demo.model.TipoPersona;
@Getter
@Setter
public class PersonaDTO {

    private TipoPersona tipopersona_id;
    private  String nombresApellidos;
    private String correo;
    private  String matricula;
    private  String usuario;
    private String password;
    private  String estado;
    private Institucion institucion_id;
}
