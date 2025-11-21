// java
// File: `UsuarioDAO.java`
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsuarioDAO {

    private final ConexionBD conexionBD;

    public UsuarioDAO() {
        this.conexionBD = new ConexionBD();
    }

    public boolean guardarUsuario(Usuario usuario) {
        Connection conn = conexionBD.getConnection();
        if (conn == null) return false;

        try {
            // begin transaction
            conexionBD.setAutoCommitBD(false);

            // insert user and get generated id
            int usuarioId;
            String sqlInsertUser = "INSERT INTO usuarios (nombre, correo) VALUES (?, ?)";
            try (PreparedStatement psUser = conn.prepareStatement(sqlInsertUser, Statement.RETURN_GENERATED_KEYS)) {
                psUser.setString(1, usuario.getNombre());
                psUser.setString(2, usuario.getCorreo());
                psUser.executeUpdate();
                try (ResultSet rs = psUser.getGeneratedKeys()) {
                    if (rs.next()) {
                        usuarioId = rs.getInt(1);
                    } else {
                        // if no generated key, try using object's id (if set) else fail
                        usuarioId = usuario.getId();
                        if (usuarioId == 0) throw new Exception("Failed to obtain generated user id");
                    }
                }
            }

            // insert habilidades and link to user
            for (Habilidad h : usuario.getHabilidades()) {
                int habilidadId;
                String sqlInsertH = "INSERT INTO habilidades (nombre) VALUES (?)";
                try (PreparedStatement psH = conn.prepareStatement(sqlInsertH, Statement.RETURN_GENERATED_KEYS)) {
                    psH.setString(1, h.getNombre());
                    psH.executeUpdate();
                    try (ResultSet rh = psH.getGeneratedKeys()) {
                        habilidadId = rh.next() ? rh.getInt(1) : h.getId();
                    }
                }

                String sqlLinkH = "INSERT INTO usuario_habilidad (usuario_id, habilidad_id) VALUES (?, ?)";
                try (PreparedStatement psLinkH = conn.prepareStatement(sqlLinkH)) {
                    psLinkH.setInt(1, usuarioId);
                    psLinkH.setInt(2, habilidadId);
                    psLinkH.executeUpdate();
                }
            }

            // insert cursos and link to user
            for (Curso c : usuario.getCursosTomados()) {
                int cursoId;
                String sqlInsertC = "INSERT INTO cursos (nombre) VALUES (?)";
                try (PreparedStatement psC = conn.prepareStatement(sqlInsertC, Statement.RETURN_GENERATED_KEYS)) {
                    psC.setString(1, c.getNombre());
                    psC.executeUpdate();
                    try (ResultSet rc = psC.getGeneratedKeys()) {
                        cursoId = rc.next() ? rc.getInt(1) : c.getId();
                    }
                }

                String sqlLinkC = "INSERT INTO usuario_curso (usuario_id, curso_id) VALUES (?, ?)";
                try (PreparedStatement psLinkC = conn.prepareStatement(sqlLinkC)) {
                    psLinkC.setInt(1, usuarioId);
                    psLinkC.setInt(2, cursoId);
                    psLinkC.executeUpdate();
                }
            }

            // commit transaction
            conexionBD.commitBD();
            conexionBD.setAutoCommitBD(true);
            return true;
        } catch (Exception ex) {
            // rollback on error
            conexionBD.rollbackBD();
            return false;
        } finally {
            conexionBD.cerrarConexion();
        }
    }
}

