package Controlador;

import BD.ClienteBD;
import modelo.Cliente;

import java.util.List;

public class ClienteControl {

    private ClienteBD clienteBD;

    public ClienteControl() {
        clienteBD = new ClienteBD();
    }

    // Crear Cliente
    public boolean crearCliente(Cliente cliente) {
        return clienteBD.insertar(cliente);
    }

    // Actualizar Cliente
    public boolean actualizarCliente(Cliente cliente) {
        return clienteBD.actualizar(cliente);
    }

    // Eliminar Cliente
    public boolean eliminarCliente(int id) {
        return clienteBD.eliminar(id);
    }

    // Listar todos los clientes
    public List<Cliente> listarClientes() {
        return clienteBD.listar();
    }
}
