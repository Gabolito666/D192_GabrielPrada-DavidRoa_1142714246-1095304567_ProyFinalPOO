import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private int id;
    private String nombre;
    private String correo;
    private String sector;
    private List<OfertaLaboral> ofertas;

    public Empresa(int id, String nombre, String correo, String sector) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.sector = sector;
        this.ofertas = new ArrayList<>();
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

    public String getSector() {
        return sector;
    }

    public List<OfertaLaboral> getOfertas() {
        return ofertas;
    }

    public void publicarOferta(OfertaLaboral oferta) {
        ofertas.add(oferta);
    }
}