package BD;

import controlador_persistencia.ConexionBD;
import modelo.Cliente;
import modelo.InterfaceCRUD;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteBD implements InterfaceCRUD<Cliente> {

    private ConexionBD conexion;

    public ClienteBD() {
        conexion = new ConexionBD();
    }

    // ---------------------------------
    // INSERTAR CLIENTE
    // ---------------------------------
    @Override
    public boolean insertar(Cliente c) {

        if (!c.isValidUsuario() && !c.isValidContrasenia() && !c.isValidDireccion() && !c.isValidNombre() && !c.isValidTelefono() && !c.isValidIdentificacion()) {
            JOptionPane.showMessageDialog(null, "Usuario y contraseña no válidos, la dirección y el nombre no pueden estar vacíos, y la identificación y el teléfono deben ser números positivos.");
            conexion.cerrarConexion();
            return false;
        } else if (!c.isValidUsuario()) {
            JOptionPane.showMessageDialog(null, "El usuario no es válido.");
            conexion.cerrarConexion();
            return false;
        } else if (!c.isValidContrasenia()) {
            JOptionPane.showMessageDialog(null, "La contraseña no es válida.");
            conexion.cerrarConexion();
            return false;
        } else if (!c.isValidDireccion()) {
            JOptionPane.showMessageDialog(null, "La dirección no puede estar vacía.");
            conexion.cerrarConexion();
            return false;
        } else if (!c.isValidNombre()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
            conexion.cerrarConexion();
            return false;
        } else if (!c.isValidIdentificacion()) {
            JOptionPane.showMessageDialog(null, "La identificación debe ser un número positivo.");
            conexion.cerrarConexion();
            return false;
        } else if (!c.isValidTelefono()) {
            JOptionPane.showMessageDialog(null, "El teléfono debe ser un número positivo.");
            conexion.cerrarConexion();
            return false;
        } else {

            String sql = "INSERT INTO Cliente (identificacion, nombre, direccion, telefono, idOferta, usuario, contrasenia, rol) VALUES (" +
                    c.getIdentificacion() + ", " +
                    "'" + c.getNombre() + "', " +
                    "'" + c.getDireccion() + "', " +
                    c.getTelefono() + ", " +
                    c.getIdOferta() + ", " +
                    c.getUsuario() + ", " +
                    c.getContrasenia() + ", " +
                    c.getRol() + ");";

            boolean ok = conexion.insertarBD(sql);

            if (ok)
                JOptionPane.showMessageDialog(null, "Cliente insertado correctamente.");
            else
                JOptionPane.showMessageDialog(null, "Error al insertar Cliente.");

            conexion.cerrarConexion();
            return ok;
        }
    }

    // ---------------------------------
    // LISTAR CLIENTES
    // ---------------------------------
    @Override
    public ArrayList<Cliente> listar() {

        ArrayList<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM Cliente;";

        ResultSet rs = conexion.consultarBD(sql);

        try {
            while (rs.next()) {

                Cliente c = new Cliente();

                c.setIdentificacion(rs.getInt("identificacion"));
                c.setNombre(rs.getString("nombre"));
                c.setDireccion(rs.getString("direccion"));
                c.setTelefono(rs.getInt("telefono"));
                c.setIdOferta(rs.getInt("idOferta"));
                c.setContrasenia(rs.getString("contrasenia"));
                c.setUsuario(rs.getString("usuario"));
                c.setRol(rs.getString("rol"));

                lista.add(c);
            }

            conexion.cerrarConexion();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar clientes: " + e.getMessage());
        }

        return lista;
    }

    // ---------------------------------
    // ACTUALIZAR
    // ---------------------------------
    @Override
    public boolean actualizar(Cliente c) {

        if (!c.isValidUsuario() && !c.isValidContrasenia() && !c.isValidDireccion() && !c.isValidNombre() && !c.isValidTelefono() && !c.isValidIdentificacion()) {
            JOptionPane.showMessageDialog(null, "Usuario y contraseña no válidos, la dirección y el nombre no pueden estar vacíos, y la identificación y el teléfono deben ser números positivos.");
            conexion.cerrarConexion();
            return false;
        } else if (!c.isValidUsuario()) {
            JOptionPane.showMessageDialog(null, "El usuario no es válido.");
            conexion.cerrarConexion();
            return false;
        } else if (!c.isValidContrasenia()) {
            JOptionPane.showMessageDialog(null, "La contraseña no es válida.");
            conexion.cerrarConexion();
            return false;
        } else if (!c.isValidDireccion()) {
            JOptionPane.showMessageDialog(null, "La dirección no puede estar vacía.");
            conexion.cerrarConexion();
            return false;
        } else if (!c.isValidNombre()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
            conexion.cerrarConexion();
            return false;
        } else if (!c.isValidIdentificacion()) {
            JOptionPane.showMessageDialog(null, "La identificación debe ser un número positivo.");
            conexion.cerrarConexion();
            return false;
        } else if (!c.isValidTelefono()) {
            JOptionPane.showMessageDialog(null, "El teléfono debe ser un número positivo.");
            conexion.cerrarConexion();
            return false;
        } else {

            String sql = "UPDATE Cliente SET " +
                    "nombre='" + c.getNombre() + "', " +
                    "direccion='" + c.getDireccion() + "', " +
                    "telefono=" + c.getTelefono() + ", " +
                    "idOferta=" + c.getIdOferta() + ", " +
                    "usuario='" + c.getUsuario() + "', " +
                    "contrasenia='" + c.getContrasenia() +
                    "rol='" + c.getRol() + "'" +
                    " WHERE identificacion=" + c.getIdentificacion() + ";";

            boolean ok = conexion.actualizarBD(sql);

            if (ok)
                JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente.");
            else
                JOptionPane.showMessageDialog(null, "Error al actualizar Cliente.");

            conexion.cerrarConexion();
            return ok;
        }
    }

    // ---------------------------------
    // ELIMINAR
    // ---------------------------------
    @Override
    public boolean eliminar(int id) {

        String sql = "DELETE FROM Cliente WHERE identificacion=" + id + ";";

        boolean ok = conexion.borrarBD(sql);

        if (ok)
            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
        else
            JOptionPane.showMessageDialog(null, "Error al eliminar Cliente.");

        conexion.cerrarConexion();
        return ok;
    }
}
