package cl.otecprimavera.mvp_gestion.servicio;

import cl.otecprimavera.mvp_gestion.modelo.Curso;
import cl.otecprimavera.mvp_gestion.repositorio.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso findById(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }
}