package modelo;

import java.util.ArrayList;

public interface InterfaceCRUD<T> {

    boolean insertar(T objeto);
    ArrayList<T> listar();
    boolean actualizar(T objeto);
    boolean eliminar(int id);
}
