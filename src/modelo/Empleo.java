package modelo;

public class Empleo {

    private int id_Empleo;
    private String nombre_Empleo;
    private String tipo_Contrato;
    private int id_Entidad; // FK hacia EntidadEmpleo

    public Empleo() {}

    public Empleo(int idEmpleo, String nombreEmpleo,
                  String tipoContrato, int idEntidad) {
        this.id_Empleo = idEmpleo;
        this.nombre_Empleo = nombreEmpleo;
        this.tipo_Contrato = tipoContrato;
        this.id_Empleo = idEntidad;
    }

    public int getIdEmpleo() {
        return id_Empleo;
    }

    public void setIdEmpleo(int idEmpleo) {
        this.id_Empleo = idEmpleo;
    }

    public String getNombreEmpleo() {
        return nombre_Empleo;
    }

    public void setNombreEmpleo(String nombreEmpleo) {
        this.nombre_Empleo = nombreEmpleo;
    }

    public String getTipoContrato() {
        return tipo_Contrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipo_Contrato = tipoContrato;
    }

    public int getIdEntidad() {
        return id_Entidad;
    }

    public void setIdEntidad(int idEntidad) {
        this.id_Entidad = idEntidad;
    }
}
