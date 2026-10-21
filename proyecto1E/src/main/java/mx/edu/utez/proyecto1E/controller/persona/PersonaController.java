package mx.edu.utez.proyecto1E.controller.persona;

import jakarta.validation.Valid;
import mx.edu.utez.proyecto1E.controller.persona.dto.RequestUpdatePersonaDto;
import mx.edu.utez.proyecto1E.model.persona.Persona;
import mx.edu.utez.proyecto1E.service.persona.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/persona")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
        Persona persona = personaService.findById(id);
        if (persona == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity
                .status(200)
                .body(persona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(
            @PathVariable Long id,
            @RequestBody @Valid RequestUpdatePersonaDto payload) {
        Persona persona = personaService.update(id, payload);
        if (persona == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity
                .status(200)
                .body(persona);
    }
}