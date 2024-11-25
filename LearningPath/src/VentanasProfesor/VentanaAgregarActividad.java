package VentanasProfesor;

import LearningPath.Actividad;
import LearningPath.LearningPath;
import Persistencia.CentralPersistenciaActividades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class VentanaAgregarActividad extends JFrame {
	
	private CentralPersistenciaActividades cpa;

    public VentanaAgregarActividad(LearningPath learningPath) {
    	
    	cpa = new CentralPersistenciaActividades();
    	
        setTitle("Agregar Actividad");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 600);
        setLayout(new BorderLayout());

        JPanel panelCampos = new JPanel(new GridLayout(10, 2, 10, 10));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel labelTitulo = new JLabel("Título:");
        JTextField campoTitulo = new JTextField();

        JLabel labelTipo = new JLabel("Tipo:");
        JTextField campoTipo = new JTextField();

        JLabel labelDescripcion = new JLabel("Descripción:");
        JTextField campoDescripcion = new JTextField();

        JLabel labelObjetivo = new JLabel("Objetivo:");
        JTextField campoObjetivo = new JTextField();

        JLabel labelDificultad = new JLabel("Dificultad (Alta/Medio/Baja):");
        JTextField campoDificultad = new JTextField();

        JLabel labelDuracion = new JLabel("Duración (minutos):");
        JTextField campoDuracion = new JTextField();

        JLabel labelObligatoria = new JLabel("¿Es obligatoria? (sí/no):");
        JTextField campoObligatoria = new JTextField();

        JLabel labelFechaLimite = new JLabel("Fecha Límite (YYYY-MM-DD):");
        JTextField campoFechaLimite = new JTextField();

        panelCampos.add(labelTitulo);
        panelCampos.add(campoTitulo);
        panelCampos.add(labelTipo);
        panelCampos.add(campoTipo);
        panelCampos.add(labelDescripcion);
        panelCampos.add(campoDescripcion);
        panelCampos.add(labelObjetivo);
        panelCampos.add(campoObjetivo);
        panelCampos.add(labelDificultad);
        panelCampos.add(campoDificultad);
        panelCampos.add(labelDuracion);
        panelCampos.add(campoDuracion);
        panelCampos.add(labelObligatoria);
        panelCampos.add(campoObligatoria);
        panelCampos.add(labelFechaLimite);
        panelCampos.add(campoFechaLimite);

        add(panelCampos, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton botonGuardar = new JButton("Guardar");
        JButton botonCancelar = new JButton("Cancelar");

        panelBotones.add(botonGuardar);
        panelBotones.add(botonCancelar);

        add(panelBotones, BorderLayout.SOUTH);

        
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String titulo = campoTitulo.getText();
                    String tipo = campoTipo.getText();
                    String descripcion = campoDescripcion.getText();
                    String objetivo = campoObjetivo.getText();
                    String dificultad = campoDificultad.getText();
                    int duracionMinutos = Integer.parseInt(campoDuracion.getText());
                    boolean obligatoria = campoObligatoria.getText().equalsIgnoreCase("sí");
                    LocalDate fechaLimite = LocalDate.parse(campoFechaLimite.getText(), DateTimeFormatter.ISO_LOCAL_DATE);

                    Actividad nuevaActividad = new Actividad(titulo, descripcion, objetivo, dificultad, tipo, new ArrayList<>(), obligatoria, duracionMinutos, fechaLimite);
                    learningPath.getActividades().add(nuevaActividad);
                    cpa.guardarActividades(learningPath, nuevaActividad);

                    JOptionPane.showMessageDialog(VentanaAgregarActividad.this, "Actividad agregada exitosamente.");
                    

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(VentanaAgregarActividad.this, "Error al agregar actividad: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarVentana(new VentanaActividades(VentanaCrearLP.getLearningPathsCreados()));
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
