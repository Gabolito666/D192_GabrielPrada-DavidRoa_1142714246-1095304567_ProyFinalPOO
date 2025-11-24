package BD;

import modelo.Empleo;
import controlador_persistencia.ConexionBD;
import modelo.InterfaceCRUD;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpleoBD implements InterfaceCRUD<Empleo> {

    @Override
    public boolean insertar(Empleo emp) {
        ConexionBD conexion = new ConexionBD();

        String sql = "INSERT INTO Empleo (Id_Empleo, Nombre_Empleo, Tipo_Contrato, Id_Entidad) VALUES (" +
                emp.getIdEmpleo() + ", '" +
                emp.getNombreEmpleo() + "', '" +
                emp.getTipoContrato() + "', " +
                emp.getIdEntidad() + ")";

        boolean ok = conexion.insertarBD(sql);
        conexion.cerrarConexion();

        return ok;
    }

    @Override
    public ArrayList<Empleo> listar() {
        ArrayList<Empleo> lista = new ArrayList<>();
        ConexionBD conexion = new ConexionBD();

        String sql = "SELECT * FROM Empleo";
        ResultSet rs = conexion.consultarBD(sql);

        try {
            while (rs.next()) {
                Empleo emp = new Empleo();
                emp.setIdEmpleo(rs.getInt("Id_Empleo"));
                emp.setNombreEmpleo(rs.getString("Nombre_Empleo"));
                emp.setTipoContrato(rs.getString("Tipo_Contrato"));
                emp.setIdEntidad(rs.getInt("Id_Entidad"));

                lista.add(emp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer empleos: " + e.getMessage());
        }

        conexion.cerrarConexion();
        return lista;
    }

    @Override
    public boolean actualizar(Empleo emp) {
        ConexionBD conexion = new ConexionBD();

        String sql = "UPDATE Empleo SET " +
                "Nombre_Empleo = '" + emp.getNombreEmpleo() + "', " +
                "Tipo_Contrato = '" + emp.getTipoContrato() + "', " +
                "Id_Entidad = " + emp.getIdEntidad() +
                " WHERE Id_Empleo = " + emp.getIdEmpleo();

        boolean ok = conexion.actualizarBD(sql);
        conexion.cerrarConexion();

        return ok;
    }

    @Override
    public boolean eliminar(int id) {
        ConexionBD conexion = new ConexionBD();

        String sql = "DELETE FROM Empleo WHERE Id_Empleo = " + id;

        boolean ok = conexion.borrarBD(sql);
        conexion.cerrarConexion();

        return ok;
    }
}
