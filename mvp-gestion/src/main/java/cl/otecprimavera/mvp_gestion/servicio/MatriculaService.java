package cl.otecprimavera.mvp_gestion.servicio;

import cl.otecprimavera.mvp_gestion.modelo.Curso;
import cl.otecprimavera.mvp_gestion.modelo.Matricula;
import cl.otecprimavera.mvp_gestion.modelo.Usuario;
import cl.otecprimavera.mvp_gestion.repositorio.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    public List<Matricula> findAll() {
        return matriculaRepository.findAll();
    }

    public Matricula save(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    public List<Matricula> findByEstudiante(Usuario estudiante) {
        return matriculaRepository.findByEstudiante(estudiante);
    }

    public List<Matricula> findByCurso(Curso curso) {
        return matriculaRepository.findByCurso(curso);
    }

    public Matricula findById(Long id) {
        return matriculaRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        matriculaRepository.deleteById(id);
    }
}