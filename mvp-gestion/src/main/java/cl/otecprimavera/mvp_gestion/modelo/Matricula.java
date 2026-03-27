package cl.otecprimavera.mvp_gestion.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "matriculas")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario estudiante;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private String estado;
    private Integer avancePorcentaje;

    public Matricula() {
    }

    public Matricula(Usuario estudiante, Curso curso, String estado, Integer avancePorcentaje) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.estado = estado;
        this.avancePorcentaje = avancePorcentaje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Usuario estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getAvancePorcentaje() {
        return avancePorcentaje;
    }

    public void setAvancePorcentaje(Integer avancePorcentaje) {
        this.avancePorcentaje = avancePorcentaje;
    }
}