package mx.edu.utez.proyecto1E.controller.usuario;

import jakarta.validation.Valid;
import mx.edu.utez.proyecto1E.controller.usuario.dto.RequestCreateUserDto;
import mx.edu.utez.proyecto1E.controller.usuario.dto.RequestUpdateUserDto;
import mx.edu.utez.proyecto1E.model.usuario.Usuario;
import mx.edu.utez.proyecto1E.service.usuario.usuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/usuario")
public class UsuarioController {

    private final usuarioService usuarioService;

    public UsuarioController(usuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers() {
        return ResponseEntity
                .status(200)
                .body(usuarioService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity
                .status(200)
                .body(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody @Valid RequestCreateUserDto payload) {
        return ResponseEntity
                .status(201)
                .body(usuarioService.createUser(payload));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Usuario> changeStatus(@PathVariable Long id, @RequestParam boolean status) {
        Usuario usuario = usuarioService.changeStatus(id, status);
        if (usuario == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity
                .status(200)
                .body(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(
            @PathVariable Long id,
            @RequestBody @Valid RequestUpdateUserDto payload) {
        Usuario usuario = usuarioService.updatePartial(id, payload);
        if (usuario == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity
                .status(200)
                .body(usuario);
    }
}