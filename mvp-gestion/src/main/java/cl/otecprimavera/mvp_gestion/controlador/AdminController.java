package cl.otecprimavera.mvp_gestion.controlador;

import cl.otecprimavera.mvp_gestion.modelo.Curso;
import cl.otecprimavera.mvp_gestion.modelo.Matricula;
import cl.otecprimavera.mvp_gestion.modelo.Usuario;
import cl.otecprimavera.mvp_gestion.servicio.CursoService;
import cl.otecprimavera.mvp_gestion.servicio.MatriculaService;
import cl.otecprimavera.mvp_gestion.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CursoService cursoService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    public String dashboardAdmin(Model model) {
        model.addAttribute("cursos", cursoService.findAll());
        model.addAttribute("estudiantes", usuarioService.findByRol("ESTUDIANTE"));
        model.addAttribute("todasLasMatriculas", matriculaService.findAll());
        return "admin";
    }

    @PostMapping("/cursos/guardar")
    public String guardarCurso(Curso curso) {
        cursoService.save(curso);
        return "redirect:/admin";
    }

    @PostMapping("/cursos/eliminar")
    public String eliminarCurso(@RequestParam Long cursoId) {
        Curso curso = cursoService.findById(cursoId);
        if(curso != null) {
            // Eliminar matrículas asociadas primero para evitar error de SQL
            List<Matricula> matriculasDelCurso = matriculaService.findByCurso(curso);
            for(Matricula m : matriculasDelCurso) {
                matriculaService.deleteById(m.getId());
            }
            cursoService.deleteById(cursoId);
        }
        return "redirect:/admin";
    }
    
    @PostMapping("/matriculas/guardar")
    public String matricularEstudiante(@RequestParam Long estudianteId, @RequestParam Long cursoId) {
        Usuario estudiante = usuarioService.findById(estudianteId).orElse(null);
        Curso curso = cursoService.findById(cursoId);
        
        if(estudiante != null && curso != null) {
            Matricula matricula = new Matricula(estudiante, curso, "Inscrito", 0);
            matriculaService.save(matricula);
        }
        return "redirect:/admin";
    }

    @PostMapping("/matriculas/eliminar")
    public String eliminarMatricula(@RequestParam Long matriculaId) {
        matriculaService.deleteById(matriculaId);
        return "redirect:/admin";
    }
}