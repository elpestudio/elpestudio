package tutor.ship.com.demo.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoPersonaDTO {
    @NotBlank
    @Size(min = 3, max = 50)
    private String tipo;
    @NotBlank
    private String estado;
}
