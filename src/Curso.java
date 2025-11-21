public class Curso {

    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private Habilidad habilidadAsociada;
    private int duracionHoras;

    public Curso(int id, String nombre, String descripcion, double precio, Habilidad habilidadAsociada, int duracionHoras) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.habilidadAsociada = habilidadAsociada;
        this.duracionHoras = duracionHoras;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
    public Habilidad getHabilidadAsociada() { return habilidadAsociada; }
    public int getDuracionHoras() { return duracionHoras; }
}
