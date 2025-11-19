import java.util.List;

public class OfertaLaboral {

    private int id;
    private String titulo;
    private String descripcion;
    private List<Habilidad> habilidadesRequeridas;
    private double salario;
    private Empresa empresa;

    public OfertaLaboral(int id, String titulo, String descripcion, List<Habilidad> habilidadesRequeridas, double salario, Empresa empresa) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.habilidadesRequeridas = habilidadesRequeridas;
        this.salario = salario;
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<Habilidad> getHabilidadesRequeridas() {
        return habilidadesRequeridas;
    }

    public double getSalario() {
        return salario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }
}