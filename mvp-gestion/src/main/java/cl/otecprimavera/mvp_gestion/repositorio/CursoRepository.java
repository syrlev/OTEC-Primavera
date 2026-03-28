package cl.otecprimavera.mvp_gestion.repositorio;

import cl.otecprimavera.mvp_gestion.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}