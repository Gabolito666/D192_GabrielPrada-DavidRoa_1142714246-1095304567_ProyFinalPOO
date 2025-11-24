package Main;

import controlador_persistencia.ConexionBD;

public class Main {
    public static void main(String[] args) {

        ConexionBD conexion = new ConexionBD();

        if (conexion.getConnection() != null) {
            System.out.println("✅ Conexión exitosa a la base de datos remota.");
        } else {
            System.out.println("❌ Error: No se pudo conectar a la base de datos.");
        }

        conexion.cerrarConexion();
    }

    }

