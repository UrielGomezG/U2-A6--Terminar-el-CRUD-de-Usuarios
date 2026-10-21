package mx.edu.utez.proyecto1E.service.persona;

import mx.edu.utez.proyecto1E.controller.persona.dto.RequestUpdatePersonaDto;
import mx.edu.utez.proyecto1E.model.persona.Persona;
import mx.edu.utez.proyecto1E.repository.persona.personaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaService {

    private final personaRepository personaRepository;

    public PersonaService(personaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public Persona findById(Long id) {
        Optional<Persona> optional = personaRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public Persona update(Long id, RequestUpdatePersonaDto dto) {
        Persona persona = findById(id);
        if (persona != null) {
            persona.setNombres(dto.getNombre());
            persona.setPrimerApellido(dto.getPrimerApellido());
            persona.setSegundoApellido(dto.getSegundoApellido());
            return personaRepository.save(persona);
        }
        return null;
    }
}