package cl.otecprimavera.mvp_gestion.controlador;

import cl.otecprimavera.mvp_gestion.modelo.Usuario;
import cl.otecprimavera.mvp_gestion.servicio.MatriculaService;
import cl.otecprimavera.mvp_gestion.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private MatriculaService matriculaService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String dashboardEstudiante(Model model, Authentication authentication) {
        String username = authentication.getName();
        Usuario estudiante = usuarioService.findByUsername(username).orElse(null);
        
        if (estudiante != null) {
            model.addAttribute("matriculas", matriculaService.findByEstudiante(estudiante));
        }
        return "estudiante";
    }
}