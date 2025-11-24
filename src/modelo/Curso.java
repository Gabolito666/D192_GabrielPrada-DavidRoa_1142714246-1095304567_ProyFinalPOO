package modelo;

public class Curso {

    private int Id_Curso;
    private String Nombre_Curso;
    private int Duracion;
    private String Grupos;
    private String Tipo_Curso;
    private int Id_Entidad;  // FK hacia EntidadCurso

    // Constructor vacío
    public Curso() {
    }

    // Constructor completo
    public Curso(int id_Curso, String nombre_Curso, int duracion,
                 String grupos, String tipo_Curso, int id_Entidad) {
        this.Id_Curso = id_Curso;
        this.Nombre_Curso = nombre_Curso;
        this.Duracion = duracion;
        this.Grupos = grupos;
        this.Tipo_Curso = tipo_Curso;
        this.Id_Entidad = id_Entidad;
    }

    //Comprobations - comprobar que la duracion es positiva
    public boolean isValidDuracion() {
        return Duracion > 0;
    }
    //Comprobations - comprobar que el nombre del Curso no esté vacío y contenga letras

    public boolean isValidNombreCurso() {
        return Nombre_Curso != null && !Nombre_Curso.trim().isEmpty() && Nombre_Curso.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
    }




    // Getters y Setters
    public int getId_Curso() {
        return Id_Curso;
    }

    public void setId_Curso(int id_Curso) {
        Id_Curso = id_Curso;
    }

    public String getNombre_Curso() {
        return Nombre_Curso;
    }

    public void setNombre_Curso(String nombre_Curso) {
        Nombre_Curso = nombre_Curso;
    }

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int duracion) {
        Duracion = duracion;
    }

    public String getGrupos() {
        return Grupos;
    }

    public void setGrupos(String grupos) {
        Grupos = grupos;
    }

    public String getTipo_Curso() {
        return Tipo_Curso;
    }

    public void setTipo_Curso(String tipo_Curso) {
        Tipo_Curso = tipo_Curso;
    }

    public int getId_Entidad() {
        return Id_Entidad;
    }

    public void setId_Entidad(int id_Entidad) {
        Id_Entidad = id_Entidad;
    }
}
