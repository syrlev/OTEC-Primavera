package cl.otecprimavera.mvp_gestion.controlador;

import cl.otecprimavera.mvp_gestion.servicio.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public String dashboardAdmin(Model model) {
        model.addAttribute("cursos", cursoService.findAll());
        return "admin";
    }
}