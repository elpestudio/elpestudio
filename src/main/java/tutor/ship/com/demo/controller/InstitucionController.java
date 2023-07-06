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
import tutor.ship.com.demo.controller.dto.InstitucionDTO;
import tutor.ship.com.demo.model.Institucion;
import tutor.ship.com.demo.repository.InstitucionRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/institucion")
public class InstitucionController {
    @Autowired
    private InstitucionRepository institucionRepository;

    @GetMapping
    Page<Institucion> index(@PageableDefault(sort = "id", size = 10) Pageable pageable){
        return institucionRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    Institucion obtener(@PathVariable Integer id){
        return institucionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/store")
    Institucion store(@RequestBody @Validated InstitucionDTO institucionDTO){
        Institucion institucion = new ModelMapper().map(institucionDTO, Institucion.class);
        return institucionRepository.save(institucion);
    }
    @PutMapping("/{id}")
    Institucion update(@PathVariable Integer id, @RequestBody InstitucionDTO institucionDTO){
        Institucion institucion = institucionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        new ModelMapper().map(institucionDTO,institucion);
        return institucionRepository.save(institucion);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void destroy(@PathVariable Integer id){
        Institucion institucion = institucionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        institucionRepository.delete(institucion);
    }
}
