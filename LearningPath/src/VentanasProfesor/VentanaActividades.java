package VentanasProfesor;

import LearningPath.LearningPath;
import Usuario.Profesor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class VentanaActividades extends JFrame {

    public VentanaActividades(List<LearningPath> learningPaths) {
        setTitle("Menú de Actividades");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        JPanel panelBusqueda = new JPanel(new FlowLayout());
        JLabel labelBuscar = new JLabel("Nombre del Learning Path:");
        JTextField campoBuscar = new JTextField(20);
        JButton botonBuscar = new JButton("Buscar");

        panelBusqueda.add(labelBuscar);
        panelBusqueda.add(campoBuscar);
        panelBusqueda.add(botonBuscar);

        add(panelBusqueda, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(3, 1, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton botonAgregarActividad = new JButton("Agregar Actividad");
        JButton botonVerActividades = new JButton("Ver Actividades");
        JButton botonVolver = new JButton("Volver");

        panelBotones.add(botonAgregarActividad);
        panelBotones.add(botonVerActividades);
        panelBotones.add(botonVolver);

        add(panelBotones, BorderLayout.CENTER);


        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoBuscar.getText();
                LearningPath learningPath = Profesor.getLearningPath(learningPaths, nombre);

                if (learningPath != null) {
                    botonAgregarActividad.setEnabled(true);
                    botonVerActividades.setEnabled(true);

                    botonAgregarActividad.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cambiarVentana(new VentanaAgregarActividad(learningPath));
                            
                        }
                    });

                    botonVerActividades.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            cambiarVentana(new VentanaVerActividades(learningPath));
                        }
                    });

                } else {
                    JOptionPane.showMessageDialog(VentanaActividades.this, "Learning Path no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                    botonAgregarActividad.setEnabled(false);
                    botonVerActividades.setEnabled(false);
                }
            }
        });

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new VentanaProfesor();
                } catch (ClassNotFoundException | IOException ex) {
                    JOptionPane.showMessageDialog(VentanaActividades.this, "Error al volver: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                dispose();
            }
        });

        botonAgregarActividad.setEnabled(false);
        botonVerActividades.setEnabled(false);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void cambiarVentana(JFrame nuevaVentana) {
	    nuevaVentana.setVisible(true);
	    this.dispose();
	}
}

