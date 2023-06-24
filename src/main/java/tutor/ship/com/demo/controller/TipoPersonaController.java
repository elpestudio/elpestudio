package tutor.ship.com.demo.controller;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tutor.ship.com.demo.controller.dto.PersonaDTO;
import tutor.ship.com.demo.controller.dto.TipoPersonaDTO;
import tutor.ship.com.demo.model.Personas;
import tutor.ship.com.demo.model.TipoPersona;
import tutor.ship.com.demo.repository.TipoPersonaRepository;

@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("api/TipoPersona")
public class TipoPersonaController {
    @Autowired
    private  TipoPersonaRepository tipoPersonaRepository;

    @GetMapping
    Page<TipoPersona> index(@PageableDefault(sort = "id", size = 5) Pageable pageable){
        return tipoPersonaRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    TipoPersona obtener(@PathVariable Integer id){
        return tipoPersonaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    //Guardar
    TipoPersona store(@RequestBody @Validated TipoPersonaDTO tipoPersonaDTO){
        TipoPersona tipoPersona = new ModelMapper().map(tipoPersonaDTO, TipoPersona.class);
        return tipoPersonaRepository.save(tipoPersona);

    }
    @PutMapping("/{id}")
    TipoPersona update(@PathVariable Integer id,@RequestBody TipoPersonaDTO tipopersonaDTO){
        TipoPersona tipoPersona=tipoPersonaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        new ModelMapper().map(tipopersonaDTO,tipoPersona);
        return tipoPersonaRepository.save(tipoPersona);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete (@PathVariable Integer id) {
        TipoPersona tipoPersona = tipoPersonaRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        tipoPersonaRepository.delete(tipoPersona);
    }
}
