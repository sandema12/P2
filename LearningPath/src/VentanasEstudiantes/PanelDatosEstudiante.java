package VentanasEstudiantes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import InterfazGrafica.InterfazAutenticación;
import Usuario.Estudiante;

public class PanelDatosEstudiante extends JPanel implements ActionListener {

    private JButton botonVerProgreso;
    private JButton botonVerCalificaciones;
    private JButton botonInscribirseLP;
    private JButton botonCerrarSesion;
    private VentanaEstudiante padre;

    public PanelDatosEstudiante(VentanaEstudiante papa) {
        padre = papa;

        setBorder(new TitledBorder("Panel Datos"));

        JPanel panelAux_Verde = new JPanel();

        GridLayout gl = new GridLayout(4, 1);
        panelAux_Verde.setLayout(gl);

        // Botón para ver progreso
        botonVerProgreso = new JButton("Ver Progreso");
        botonVerProgreso.addActionListener(this);
        botonVerProgreso.setActionCommand("VerProgreso");

        // Botón para ver calificaciones
        botonVerCalificaciones = new JButton("Ver Calificaciones");
        botonVerCalificaciones.addActionListener(this);
        botonVerCalificaciones.setActionCommand("VerCalificaciones");

        // Botón para inscribirse en un Learning Path
        botonInscribirseLP = new JButton("Inscribirse en LP");
        botonInscribirseLP.addActionListener(this);
        botonInscribirseLP.setActionCommand("Inscribirse");

        // Botón para cerrar sesión
        botonCerrarSesion = new JButton("Cerrar Sesión");
        botonCerrarSesion.addActionListener(this);
        botonCerrarSesion.setActionCommand("CerrarSesion");

        // Agregar botones al panel
        panelAux_Verde.add(botonVerProgreso);
        panelAux_Verde.add(botonVerCalificaciones);
        panelAux_Verde.add(botonInscribirseLP);
        panelAux_Verde.add(botonCerrarSesion);

        // Configuración del diseño
        BorderLayout bl = new BorderLayout();
        setLayout(bl);
        add(panelAux_Verde, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String grito = e.getActionCommand();

        if (grito.equals("VerProgreso")) {
            padre.verProgreso();
        } else if (grito.equals("VerCalificaciones")) {
            padre.verCalificaciones();
        } else if (grito.equals("Inscribirse")) {
            padre.inscribirseEnLearningPath();
        } else if (grito.equals("CerrarSesion")) {
            padre.cambiarVentana(new InterfazAutenticación());
        }
    }

    public static void addPlaceholder(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }
}