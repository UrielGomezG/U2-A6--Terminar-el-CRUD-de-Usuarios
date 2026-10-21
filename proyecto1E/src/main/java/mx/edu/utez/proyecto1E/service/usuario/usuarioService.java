package mx.edu.utez.proyecto1E.service.usuario;

import mx.edu.utez.proyecto1E.controller.usuario.dto.RequestCreateUserDto;
import mx.edu.utez.proyecto1E.controller.usuario.dto.RequestUpdateUserDto;
import mx.edu.utez.proyecto1E.model.persona.Persona;
import mx.edu.utez.proyecto1E.model.usuario.Roles;
import mx.edu.utez.proyecto1E.model.usuario.Usuario;
import mx.edu.utez.proyecto1E.repository.persona.personaRepository;
import mx.edu.utez.proyecto1E.repository.usuario.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class usuarioService {

    private final UsuarioRepositorio usuarioRepositorio;
    private final personaRepository personaRepository;

    public usuarioService(UsuarioRepositorio usuarioRepositorio, personaRepository personaRepository) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.personaRepository = personaRepository;
    }

    public List<Usuario> getAllUsers() {
        return usuarioRepositorio.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> optional = usuarioRepositorio.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public Usuario changeStatus(Long id, boolean status) {
        Usuario usuario = findById(id);
        if (usuario != null) {
            usuario.set_enable(status);
            return usuarioRepositorio.save(usuario);
        }
        return null;
    }

    public Usuario updatePartial(Long id, RequestUpdateUserDto dto) {
        Usuario usuario = findById(id);
        if (usuario != null) {
            usuario.setUsername(dto.getUsername());
            usuario.setDescrpcion(dto.getDescripcion());
            return usuarioRepositorio.save(usuario);
        }
        return null;
    }

    public Usuario createUser(RequestCreateUserDto payload) {
        Optional<Usuario> usuarioExist = usuarioRepositorio.findByUsername(payload.getUsername());

        if (usuarioExist.isPresent()) {
            return null;
        }

        Persona newPersona = new Persona();
        newPersona.setNombres(payload.getNombres());
        newPersona.setPrimerApellido(payload.getPrimerApellido());
        newPersona.setSegundoApellido(payload.getSegundoApellido());
        newPersona.setCurp(payload.getCurp());
        newPersona.setEmail(payload.getEmail());
        newPersona.setFechaNacimiento(payload.getFechaNacimiento());

        newPersona = personaRepository.save(newPersona);

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setUsername(payload.getUsername());
        nuevoUsuario.setPassword(payload.getPassword());
        nuevoUsuario.setDescrpcion(payload.getDescripcion());
        nuevoUsuario.setRol(Roles.valueOf(payload.getRol()));
        nuevoUsuario.set_enable(true);
        nuevoUsuario.setPersona(newPersona);

        return usuarioRepositorio.save(nuevoUsuario);
    }
}