package tutor.ship.com.demo.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstitucionDTO {
    @NotBlank
    @Size(min = 11, max = 11)
    private String ruc;

    @NotBlank
    private String nombre;

    private String direccion;
    private String correo;
    private  String celular;
    private String  estado;
}
