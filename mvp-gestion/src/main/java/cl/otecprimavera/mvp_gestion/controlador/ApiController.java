package cl.otecprimavera.mvp_gestion.controlador;

import cl.otecprimavera.mvp_gestion.modelo.Curso;
import cl.otecprimavera.mvp_gestion.servicio.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/cursos")
    public List<Curso> listarCursos() {
        return cursoService.findAll();
    }
}