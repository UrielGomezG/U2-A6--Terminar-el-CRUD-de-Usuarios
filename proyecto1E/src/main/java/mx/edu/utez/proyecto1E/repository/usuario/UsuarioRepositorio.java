package mx.edu.utez.proyecto1E.repository.usuario;

import mx.edu.utez.proyecto1E.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

    //consulta por query method
    Optional<Usuario> findByUsername (String username);
}
