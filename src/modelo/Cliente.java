package modelo;
import java.util.ArrayList;
import  java.util.List;

public class Cliente {

    private int identificacion;
    private String nombre;
    private String direccion;
    private int telefono;
    private List<Curso> cursosTomados;
    private int idOferta; // FK hacia Oferta (si se usa)
    private String contrasenia;
    private String usuario;
    private String rol; // nuevo atributo rol

    // Constructor vacío
    public Cliente() {}

    // Constructor completo
    public Cliente(int identificacion, String nombre,
                   String direccion, int telefono, int idOferta, List cursosTomados, String contrasenia, String usuario, String rol) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idOferta = idOferta;
        this.cursosTomados = cursosTomados;
        this.contrasenia = contrasenia;
        this.usuario = usuario;
        this.rol = rol;
    }

    // Comprobations - comprobar que el nombre no esté vacío y solo contenga letras
    public boolean isValidNombre() {
        return nombre != null && !nombre.trim().isEmpty() && nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
    }

    // Comprobations - comprobar que el teléfono tenga 7 a 15 dígitos
    public boolean isValidTelefono() {
        String telefonoStr = String.valueOf(telefono);
        return telefonoStr.matches("\\d{7,15}");
    }

    //Comprobations - comprobar que la dirección no esté vacía y contenga letras y números
    public boolean isValidDireccion() {
        return direccion != null && !direccion.trim().isEmpty() && direccion.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ,.\\-]+");
    }

    // Comprobations - comprobar que la identificación sea un número positivo
    public boolean isValidIdentificacion() {
        return identificacion > 0;
    }

    // Comprobations - comprobar que el usuario no esté vacío
    public boolean isValidUsuario() {
        return usuario != null && !usuario.trim().isEmpty();
    }

    // Comprobations - comprobar que la contraseña tenga al menos 6 caracteres, una mayuscula, una minúscula y un número
    public boolean isValidContrasenia() {
        return contrasenia != null && contrasenia.length() >= 6 &&
               contrasenia.matches(".*[A-Z].*") &&
               contrasenia.matches(".*[a-z].*") &&
               contrasenia.matches(".*\\d.*");
    }

    // Getters y setters
    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public List<Curso> getCursosTomados() {
        return cursosTomados;
    }

    public void setCursosTomados(List<Curso> cursosTomados) {
        this.cursosTomados = cursosTomados;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    //agregar la funcion agregar Curso
    public void agregarCurso(Curso curso) {
        if (cursosTomados == null) {
            cursosTomados = new ArrayList<>();
        }
        cursosTomados.add(curso);
    }
}
