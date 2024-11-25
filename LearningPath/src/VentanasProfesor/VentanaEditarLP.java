package VentanasProfesor;

import LearningPath.LearningPath;
import Usuario.Profesor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class VentanaEditarLP extends JFrame {

    private JTextField campoTitulo;
    private JTextField campoDescripcion;
    private JTextField campoDificultad;
    private JTextField campoDuracion;
    private JLabel labelDetalles;
    private JButton botonGuardar;
    private JButton botonCancelar;

    public VentanaEditarLP(List<LearningPath> learningPaths) {
        setTitle("Editar Learning Path");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 400);
        setLayout(new BorderLayout());

        JPanel panelBusqueda = new JPanel();
        panelBusqueda.setLayout(new FlowLayout());

        JLabel labelBuscar = new JLabel("Nombre del Learning Path a modificar: ");
        JTextField campoBuscar = new JTextField(20);
        JButton botonBuscar = new JButton("Buscar");

        panelBusqueda.add(labelBuscar);
        panelBusqueda.add(campoBuscar);
        panelBusqueda.add(botonBuscar);

        add(panelBusqueda, BorderLayout.NORTH);

        JPanel panelDetalles = new JPanel();
        panelDetalles.setLayout(new GridLayout(4, 2, 10, 10));
        panelDetalles.setBorder(BorderFactory.createTitledBorder("Detalles del Learning Path"));

        campoTitulo = new JTextField();
        campoDescripcion = new JTextField();
        campoDificultad = new JTextField();
        campoDuracion = new JTextField();

        labelDetalles = new JLabel("Selecciona un Learning Path para editar");

        panelDetalles.add(new JLabel("Título: "));
        panelDetalles.add(campoTitulo);
        panelDetalles.add(new JLabel("Descripción: "));
        panelDetalles.add(campoDescripcion);
        panelDetalles.add(new JLabel("Dificultad: "));
        panelDetalles.add(campoDificultad);
        panelDetalles.add(new JLabel("Duración (minutos): "));
        panelDetalles.add(campoDuracion);

        add(panelDetalles, BorderLayout.CENTER);

        JPanel panelEditarDatos = new JPanel();
        panelEditarDatos.setLayout(new GridLayout(4, 2, 10, 10));
        panelEditarDatos.setBorder(BorderFactory.createTitledBorder("Cambiar Datos"));

        JTextField nuevoTitulo = new JTextField();
        JTextField nuevaDescripcion = new JTextField();
        JTextField nuevaDificultad = new JTextField();
        JTextField nuevaDuracion = new JTextField();

        panelEditarDatos.add(new JLabel("Nuevo Título: "));
        panelEditarDatos.add(nuevoTitulo);
        panelEditarDatos.add(new JLabel("Nueva Descripción: "));
        panelEditarDatos.add(nuevaDescripcion);
        panelEditarDatos.add(new JLabel("Nueva Dificultad: "));
        panelEditarDatos.add(nuevaDificultad);
        panelEditarDatos.add(new JLabel("Nueva Duración (minutos): "));
        panelEditarDatos.add(nuevaDuracion);

        add(panelEditarDatos, BorderLayout.EAST);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());

        botonGuardar = new JButton("Guardar Cambios");
        botonCancelar = new JButton("Cancelar");

        panelBotones.add(botonGuardar);
        panelBotones.add(botonCancelar);

        add(panelBotones, BorderLayout.SOUTH);

        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoBuscar.getText();
                LearningPath lp = Profesor.getLearningPath(learningPaths, nombre);

                if (lp != null) {
                    labelDetalles.setText("Detalles actuales cargados");
                    campoTitulo.setText(lp.getTitulo());
                    campoDescripcion.setText(lp.getDescripcion());
                    campoDificultad.setText(lp.getDificultad());
                    campoDuracion.setText(String.valueOf(lp.getDuracionTotalMinutos()));
                } else {
                    JOptionPane.showMessageDialog(VentanaEditarLP.this, "Learning Path no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tituloCambiado = nuevoTitulo.getText().isEmpty() ? campoTitulo.getText() : nuevoTitulo.getText();
                String descripcionCambiada = nuevaDescripcion.getText().isEmpty() ? campoDescripcion.getText() : nuevaDescripcion.getText();
                String dificultadCambiada = nuevaDificultad.getText().isEmpty() ? campoDificultad.getText() : nuevaDificultad.getText();
                int duracionCambiada = 0;

                try {
                    duracionCambiada = nuevaDuracion.getText().isEmpty() ? Integer.parseInt(campoDuracion.getText()) : Integer.parseInt(nuevaDuracion.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(VentanaEditarLP.this, "Duración debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                LearningPath lp = Profesor.getLearningPath(learningPaths, campoBuscar.getText());

                if (lp != null) {
                    try {
						Profesor.editarLearningPath(lp, tituloCambiado, descripcionCambiada, dificultadCambiada, duracionCambiada,
						        lp.getRating(), lp.getFechaCreacion(), LocalDateTime.now(), lp.getVersion(), lp.getActividades(), lp.getTitulo());
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

                    JOptionPane.showMessageDialog(VentanaEditarLP.this, "Learning Path editado exitosamente.");
                    
                } else {
                    JOptionPane.showMessageDialog(VentanaEditarLP.this, "Error al guardar cambios. Learning Path no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					cambiarVentana(new VentanaProfesor());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void cambiarVentana(JFrame nuevaVentana) {
	    nuevaVentana.setVisible(true);
	    this.dispose();
	} 
}
