package cl.otecprimavera.mvp_gestion.repositorio;

import cl.otecprimavera.mvp_gestion.modelo.Curso;
import cl.otecprimavera.mvp_gestion.modelo.Matricula;
import cl.otecprimavera.mvp_gestion.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    
    List<Matricula> findByEstudiante(Usuario estudiante);
    List<Matricula> findByCurso(Curso curso);
}