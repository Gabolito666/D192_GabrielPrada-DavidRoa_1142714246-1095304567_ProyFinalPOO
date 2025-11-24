package vista;

import Controlador.CursoControl;
import modelo.Curso;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class CursoUI extends JFrame {

    private CursoControl control;

    private JTextField txtId, txtNombre, txtDuracion, txtGrupos, txtTipo, txtEntidad;
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public CursoUI() {
        control = new CursoControl();
        setTitle("Gestión de Cursos");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ------ FORMULARIO -------
        JPanel panelForm = new JPanel(new GridLayout(6, 2));
        panelForm.setBorder(BorderFactory.createTitledBorder("Datos del Curso"));

        panelForm.add(new JLabel("ID:"));
        txtId = new JTextField(); panelForm.add(txtId);

        panelForm.add(new JLabel("Nombre:"));
        txtNombre = new JTextField(); panelForm.add(txtNombre);

        panelForm.add(new JLabel("Duración:"));
        txtDuracion = new JTextField(); panelForm.add(txtDuracion);

        panelForm.add(new JLabel("Grupos:"));
        txtGrupos = new JTextField(); panelForm.add(txtGrupos);

        panelForm.add(new JLabel("Tipo:"));
        txtTipo = new JTextField(); panelForm.add(txtTipo);

        panelForm.add(new JLabel("ID Entidad:"));
        txtEntidad = new JTextField(); panelForm.add(txtEntidad);

        add(panelForm, BorderLayout.NORTH);

        // ------- BOTONES -------
        JPanel panelBotones = new JPanel();

        JButton btnInsertar = new JButton("Crear Curso");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnListar = new JButton("Refrescar Lista");

        panelBotones.add(btnInsertar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnListar);

        add(panelBotones, BorderLayout.CENTER);

        // ------- TABLA -------
        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String[]{"ID", "Nombre", "Duración", "Grupos", "Tipo", "Entidad"});
        tabla = new JTable(modeloTabla);
        add(new JScrollPane(tabla), BorderLayout.SOUTH);

        // -------------------------------
        //   EVENTO: INSERTAR CURSO
        // -------------------------------
        btnInsertar.addActionListener((ActionEvent e) -> {
            try {
                Curso c = new Curso(
                        Integer.parseInt(txtId.getText()),
                        txtNombre.getText(),
                        Integer.parseInt(txtDuracion.getText()),
                        txtGrupos.getText(),   // ← Grupos es STRING
                        txtTipo.getText(),
                        Integer.parseInt(txtEntidad.getText())
                );

                if (control.insertar(c)) {
                    agregarFilaTabla(c); // ← Se agrega automáticamente a la tabla
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        });

        // -------------------------------
        //   EVENTO: ACTUALIZAR
        // -------------------------------
        btnActualizar.addActionListener((ActionEvent e) -> {
            try {
                Curso c = new Curso(
                        Integer.parseInt(txtId.getText()),
                        txtNombre.getText(),
                        Integer.parseInt(txtDuracion.getText()),
                        txtGrupos.getText(),
                        txtTipo.getText(),
                        Integer.parseInt(txtEntidad.getText())
                );

                if (control.actualizar(c)) {
                    cargarTabla(); // recarga todo
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        });

        // -------------------------------
        //   EVENTO: ELIMINAR
        // -------------------------------
        btnEliminar.addActionListener((ActionEvent e) -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                if (control.eliminar(id)) {
                    cargarTabla();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        });

        // -------------------------------
        //   EVENTO: LISTAR / REFRESCAR
        // -------------------------------
        btnListar.addActionListener((ActionEvent e) -> cargarTabla());

        // -------------------------------
        //   CARGAR DATOS AUTOMÁTICAMENTE
        // -------------------------------
        cargarTabla();
    }

    // -------------------------------
    //   MÉTODO PARA AGREGAR A LA TABLA
    // -------------------------------
    private void agregarFilaTabla(Curso c) {
        modeloTabla.addRow(new Object[]{
                c.getId_Curso(),
                c.getNombre_Curso(),
                c.getDuracion(),
                c.getGrupos(),
                c.getTipo_Curso(),
                c.getId_Entidad()
        });
    }

    // -------------------------------
    //   MÉTODO PARA CARGAR LA TABLA
    // -------------------------------
    private void cargarTabla() {
        modeloTabla.setRowCount(0);
        ArrayList<Curso> lista = control.listar();

        for (Curso c : lista) {
            agregarFilaTabla(c);
        }
    }

    public static void main(String[] args) {
        new CursoUI().setVisible(true);
    }
}
