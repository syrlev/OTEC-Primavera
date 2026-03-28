package cl.otecprimavera.mvp_gestion.seguridad;

import cl.otecprimavera.mvp_gestion.modelo.Usuario;
import cl.otecprimavera.mvp_gestion.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepository.findByUsername("admin").isEmpty()) {
            Usuario admin = new Usuario();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRol("ADMIN");
            usuarioRepository.save(admin);
        }

        if (usuarioRepository.findByUsername("alumno").isEmpty()) {
            Usuario alumno = new Usuario();
            alumno.setUsername("alumno");
            alumno.setPassword(passwordEncoder.encode("alumno123"));
            alumno.setRol("ESTUDIANTE");
            usuarioRepository.save(alumno);
        }
    }
}