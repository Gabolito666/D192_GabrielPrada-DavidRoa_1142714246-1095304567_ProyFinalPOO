package Controlador;

import controlador_persistencia.ConexionBD;
import modelo.Curso;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CursoControl {

    private ConexionBD conexion;

    public CursoControl() {
        conexion = new ConexionBD(); // SE CREA UNA CONEXIÓN QUE NO SE CIERRA
    }

    // INSERTAR CURSO
    public boolean insertar(Curso c) {

        String sql = "INSERT INTO Cursos (Id_Curso, Nombre_Curso, Duracion, Grupos, Tipo_Curso, Id_Entidad) VALUES (" +
                c.getId_Curso() + ", '" + c.getNombre_Curso() + "', " + c.getDuracion() + ", '" +
                c.getGrupos() + "', '" + c.getTipo_Curso() + "', " + c.getId_Entidad() + ");";

        boolean ok = conexion.insertarBD(sql);

        return ok;
    }

    // LISTAR CURSOS
    public ArrayList<Curso> listar() {

        ArrayList<Curso> lista = new ArrayList<>();
        String sql = "SELECT * FROM Cursos;";

        ResultSet rs = conexion.consultarBD(sql);

        if (rs == null) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener resultados de la BD.");
            return lista;
        }

        try {
            while (rs.next()) {
                Curso c = new Curso();

                c.setId_Curso(rs.getInt("Id_Curso"));
                c.setNombre_Curso(rs.getString("Nombre_Curso"));
                c.setDuracion(rs.getInt("Duracion"));
                c.setGrupos(rs.getString("Grupos"));
                c.setTipo_Curso(rs.getString("Tipo_Curso"));
                c.setId_Entidad(rs.getInt("Id_Entidad"));

                lista.add(c);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar cursos: " + e.getMessage());
        }

        return lista;
    }

    // ACTUALIZAR CURSO
    public boolean actualizar(Curso c) {

        String sql = "UPDATE Cursos SET " +
                "Nombre_Curso='" + c.getNombre_Curso() + "', " +
                "Duracion=" + c.getDuracion() + ", " +
                "Grupos='" + c.getGrupos() + "', " +
                "Tipo_Curso='" + c.getTipo_Curso() + "', " +
                "Id_Entidad=" + c.getId_Entidad() +
                " WHERE Id_Curso=" + c.getId_Curso() + ";";

        boolean ok = conexion.actualizarBD(sql);

        return ok;
    }

    // ELIMINAR CURSO
    public boolean eliminar(int id) {

        String sql = "DELETE FROM Cursos WHERE Id_Curso=" + id + ";";

        boolean ok = conexion.borrarBD(sql);

        return ok;
    }
}
