public class Habilidad {

    private int id;
    private String nombre;
    private String descripcion;
    private NivelHabilidad nivel;

    public Habilidad(int id, String nombre, String descripcion, NivelHabilidad nivel) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public NivelHabilidad getNivel() {
        return nivel;
    }
}
