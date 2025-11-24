package Controlador;

import controlador_persistencia.ConexionBD;
import modelo.empleo;
import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpleoControl {

    private ConexionBD conexion;

    public EmpleoControl() {
        conexion = new ConexionBD();
    }

    // ===========================================
    // INSERTAR
    // ===========================================
    public boolean insertar(empleo emp) {
        String sql = "INSERT INTO Empleo (Id_Empleo, Nombre_Empleo, Tipo_Contrato, Id_Entidad) VALUES (" +
                emp.getIdEmpleo() + ", '" +
                emp.getNombreEmpleo() + "', '" +
                emp.getTipoContrato() + "', " +
                emp.getIdEntidad() + ");";

        return conexion.insertarBD(sql);
    }

    // ===========================================
    // ACTUALIZAR
    // ===========================================
    public boolean actualizar(empleo emp) {
        String sql = "UPDATE Empleo SET " +
                "Nombre_Empleo = '" + emp.getNombreEmpleo() + "', " +
                "Tipo_Contrato = '" + emp.getTipoContrato() + "', " +
                "Id_Entidad = " + emp.getIdEntidad() +
                " WHERE Id_Empleo = " + emp.getIdEmpleo() + ";";

        return conexion.actualizarBD(sql);
    }

    // ===========================================
    // ELIMINAR
    // ===========================================
    public boolean eliminar(int id) {
        String sql = "DELETE FROM Empleo WHERE Id_Empleo = " + id + ";";
        return conexion.borrarBD(sql);
    }

    // ===========================================
    // SELECCIONAR (listar todos)
    // ===========================================
    public ArrayList<empleo> seleccionar() {
        ArrayList<empleo> lista = new ArrayList<>();

        String sql = "SELECT * FROM Empleo;";
        ResultSet rs = conexion.consultarBD(sql);

        try {
            while (rs != null && rs.next()) {
                empleo emp = new empleo();
                emp.setIdEmpleo(rs.getInt("Id_Empleo"));
                emp.setNombreEmpleo(rs.getString("Nombre_Empleo"));
                emp.setTipoContrato(rs.getString("Tipo_Contrato"));
                emp.setIdEntidad(rs.getInt("Id_Entidad"));

                lista.add(emp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al obtener empleos\n" + e.getMessage());
        }

        return lista;
    }
}
