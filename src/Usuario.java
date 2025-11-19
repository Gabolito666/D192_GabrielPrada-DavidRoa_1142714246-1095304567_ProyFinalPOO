import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private int id;
    private String nombre;
    private String correo;
    private List<Habilidad> habilidades;
    private List<Curso> cursosTomados;

    public Usuario(int id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.habilidades = new ArrayList<>();
        this.cursosTomados = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    public List<Curso> getCursosTomados() {
        return cursosTomados;
    }

    public void agregarHabilidad(Habilidad habilidad) {
        habilidades.add(habilidad);
    }

    public void agregarCurso(Curso curso) {
        cursosTomados.add(curso);
    }
}