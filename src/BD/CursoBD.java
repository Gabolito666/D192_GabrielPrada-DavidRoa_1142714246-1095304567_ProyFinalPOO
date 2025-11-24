package BD;

import controlador_persistencia.ConexionBD;
import modelo.Curso;
import modelo.InterfaceCRUD;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class CursoBD implements InterfaceCRUD<Curso> {

    private final ConexionBD conexion;

    public CursoBD() {
        conexion = new ConexionBD(); // conexión permanente
    }

    // -----------------------------------------
    // INSERTAR CURSO
    // -----------------------------------------
    @Override
    public boolean insertar(Curso c) {

        String sql = "INSERT INTO Cursos (Id_Curso, Nombre_Curso, Duracion, Grupos, Tipo_Curso, Id_Entidad) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        if (!c.isValidDuracion() && !c.isValidNombreCurso()) {
            JOptionPane.showMessageDialog(null, "El nombre del Curso no es valido y la duración debe ser un número positivo.");
            return false;
        } else if (!c.isValidNombreCurso()) {
            JOptionPane.showMessageDialog(null, "El nombre del Curso no es valido.");
            return false;
        } else if (!c.isValidDuracion()) {
            JOptionPane.showMessageDialog(null, "La duración debe ser un número positivo.");
            return false;
        } else {
            // Datos válidos, proceder con la inserción
            try {
                PreparedStatement ps = conexion.getConnection().prepareStatement(sql);

                ps.setInt(1, c.getId_Curso());
                ps.setString(2, c.getNombre_Curso());
                ps.setInt(3, c.getDuracion());
                ps.setString(4, c.getGrupos());
                ps.setString(5, c.getTipo_Curso());
                ps.setInt(6, c.getId_Entidad());

                ps.executeUpdate();
                return true;

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al insertar: " + e.getMessage());
                return false;
            }
        }

    }

    // -----------------------------------------
    // LISTAR CURSOS
    // -----------------------------------------
    @Override
    public ArrayList<Curso> listar() {

        ArrayList<Curso> lista = new ArrayList<>();
        String sql = "SELECT * FROM Cursos";

        if (conexion.getConnection() == null) {
            JOptionPane.showMessageDialog(null, "Error: No hay conexión a la base de datos.");
            return lista; // Retorna lista vacía si no hay conexión
        }

        if (!new Curso(0, "", 1, "", "", 0).isValidNombreCurso() && !new Curso(0, "", -1, "", "", 0).isValidDuracion()) {
            JOptionPane.showMessageDialog(null, "Error: El nombre del Curso no es valido y su duracion debe ser un numero positivo.");
            return lista; // Retorna lista vacía si el nombre del Curso no es válido
        } else if (!new Curso(0, "", -1, "", "", 0).isValidDuracion()) {
            JOptionPane.showMessageDialog(null, "Error: La duración debe ser un número positivo.");
            return lista; // Retorna lista vacía si la duración no es válida
        } else if (!new Curso(0, "", 1, "", "", 0).isValidNombreCurso()) {
            JOptionPane.showMessageDialog(null, "Error: El nombre del Curso no es valido.");
            return lista; // Retorna lista vacía si el nombre del Curso no es válido
        } else {
            // Datos válidos, proceder con la consulta
            try {
                PreparedStatement ps = conexion.getConnection().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Curso c = new Curso(
                            rs.getInt("Id_Curso"),
                            rs.getString("Nombre_Curso"),
                            rs.getInt("Duracion"),
                            rs.getString("Grupos"),
                            rs.getString("Tipo_Curso"),
                            rs.getInt("Id_Entidad")
                    );
                    lista.add(c);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al leer cursos: " + e.getMessage());
            }
        }
        return lista;
    }

    // -----------------------------------------
    // ACTUALIZAR CURSO
    // -----------------------------------------
    @Override
    public boolean actualizar(Curso c) {

        String sql = "UPDATE Cursos SET Nombre_Curso=?, Duracion=?, Grupos=?, Tipo_Curso=?, Id_Entidad=? "
                + "WHERE Id_Curso=?";

        if (!c.isValidDuracion() && !c.isValidNombreCurso()) {
            JOptionPane.showMessageDialog(null, "El nombre del Curso no es valido y la duración debe ser un número positivo.");
            return false;
        } else if (!c.isValidNombreCurso()) {
            JOptionPane.showMessageDialog(null, "El nombre del Curso no es valido.");
            return false;
        } else if (!c.isValidDuracion()) {
            JOptionPane.showMessageDialog(null, "La duración debe ser un número positivo.");
            return false;
        } else {
            // Datos válidos, proceder con la actualización

            try {
                PreparedStatement ps = conexion.getConnection().prepareStatement(sql);

                ps.setString(1, c.getNombre_Curso());
                ps.setInt(2, c.getDuracion());
                ps.setString(3, c.getGrupos());
                ps.setString(4, c.getTipo_Curso());
                ps.setInt(5, c.getId_Entidad());
                ps.setInt(6, c.getId_Curso());

                ps.executeUpdate();
                return true;

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage());
                return false;
            }
        }
    }

    // -----------------------------------------
    // ELIMINAR CURSO
    // -----------------------------------------
    @Override
    public boolean eliminar(int id) {

        String sql = "DELETE FROM Cursos WHERE Id_Curso=?";

        if (!new Curso(0, "", 1, "", "", 0).isValidNombreCurso() && !new Curso(0, "", -1, "", "", 0).isValidDuracion()) {
            JOptionPane.showMessageDialog(null, "El nombre del Curso no es valido y la duración debe ser un número positivo.");
            return false;
        } else if (!new Curso(0, "", -1, "", "", 0).isValidDuracion()) {
            JOptionPane.showMessageDialog(null, "La duración debe ser un número positivo.");
            return false;
        } else if (!new Curso(0, "", 1, "", "", 0).isValidNombreCurso()) {
            JOptionPane.showMessageDialog(null, "El nombre del Curso no es valido.");
            return false;
        } else {

            // Datos válidos, proceder con la eliminación

            try {
                PreparedStatement ps = conexion.getConnection().prepareStatement(sql);

                ps.setInt(1, id);

                ps.executeUpdate();
                return true;

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.getMessage());
                return false;
            }
        }
    }
}
