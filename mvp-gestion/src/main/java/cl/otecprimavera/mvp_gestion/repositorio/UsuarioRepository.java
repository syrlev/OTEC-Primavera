package cl.otecprimavera.mvp_gestion.repositorio;

import cl.otecprimavera.mvp_gestion.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Optional<Usuario> findByUsername(String username);
    List<Usuario> findByRol(String rol);
}