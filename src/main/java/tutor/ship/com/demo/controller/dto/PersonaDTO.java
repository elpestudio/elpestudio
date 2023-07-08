package tutor.ship.com.demo.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import tutor.ship.com.demo.model.Institucion;
import tutor.ship.com.demo.model.TipoPersona;
@Getter
@Setter
public class PersonaDTO {

    private TipoPersona tipopersona_id;

    @NotBlank
    @Size(min = 3, max = 50)
    private  String nombresApellidos;

    @NotBlank
    @Email
    private String correo;

    @NotBlank
    @Size(min = 3, max = 8)
    private  String matricula;

    @NotBlank
    private  String usuario;
    private String password;

    @NotBlank
    private  String estado;

    private Institucion institucion_id;
}
