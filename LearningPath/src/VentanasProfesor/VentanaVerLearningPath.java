package VentanasProfesor;

import LearningPath.Actividad;
import LearningPath.LearningPath;
import Persistencia.CentralPersistenciaActividades;
import Persistencia.CentralPersistenciaQuiz;
import Persistencia.CentralPersistenciaReseñas;
import Usuario.Profesor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VentanaVerLearningPath extends JFrame {
	
	private CentralPersistenciaActividades cpa;
	private CentralPersistenciaReseñas cpr;
	private CentralPersistenciaQuiz cpq;

    public VentanaVerLearningPath(List<LearningPath> learningPaths) {
    	cpa = new CentralPersistenciaActividades();
    	cpr = new CentralPersistenciaReseñas();
    	
        setTitle("Ver Learning Path");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 600);
        setLayout(new BorderLayout());

        JPanel panelBusqueda = new JPanel(new FlowLayout());
        JLabel labelBuscar = new JLabel("Nombre del Learning Path:");
        JTextField campoBuscar = new JTextField(20);
        JButton botonBuscar = new JButton("Buscar");

        panelBusqueda.add(labelBuscar);
        panelBusqueda.add(campoBuscar);
        panelBusqueda.add(botonBuscar);

        add(panelBusqueda, BorderLayout.NORTH);

        JPanel panelDetalles = new JPanel(new GridLayout(11, 2, 10, 10));
        panelDetalles.setBorder(BorderFactory.createTitledBorder("Detalles del Learning Path"));

        JLabel labelTitulo = new JLabel("Título:");
        JTextField campoTitulo = new JTextField();
        campoTitulo.setEditable(false);

        JLabel labelDescripcion = new JLabel("Descripción:");
        JTextField campoDescripcion = new JTextField();
        campoDescripcion.setEditable(false);

        JLabel labelDificultad = new JLabel("Dificultad:");
        JTextField campoDificultad = new JTextField();
        campoDificultad.setEditable(false);

        JLabel labelDuracion = new JLabel("Duración (minutos):");
        JTextField campoDuracion = new JTextField();
        campoDuracion.setEditable(false);

        JLabel labelActividades = new JLabel("Actividades:");
        JTextField campoActividades = new JTextField();
        campoActividades.setEditable(false);

        JLabel labelFechaCreacion = new JLabel("Fecha de Creación:");
        JTextField campoFechaCreacion = new JTextField();
        campoFechaCreacion.setEditable(false);

        JLabel labelFechaModificacion = new JLabel("Fecha de Modificación:");
        JTextField campoFechaModificacion = new JTextField();
        campoFechaModificacion.setEditable(false);

        JLabel labelRating = new JLabel("Rating:");
        JTextField campoRating = new JTextField();
        campoRating.setEditable(false);

        JLabel labelVersion = new JLabel("Versión:");
        JTextField campoVersion = new JTextField();
        campoVersion.setEditable(false);

        JLabel labelResenas = new JLabel("Reseñas:");
        JTextField campoResenas = new JTextField();
        campoResenas.setEditable(false);

        panelDetalles.add(labelTitulo);
        panelDetalles.add(campoTitulo);
        panelDetalles.add(labelDescripcion);
        panelDetalles.add(campoDescripcion);
        panelDetalles.add(labelDificultad);
        panelDetalles.add(campoDificultad);
        panelDetalles.add(labelDuracion);
        panelDetalles.add(campoDuracion);
        panelDetalles.add(labelActividades);
        panelDetalles.add(campoActividades);
        panelDetalles.add(labelFechaCreacion);
        panelDetalles.add(campoFechaCreacion);
        panelDetalles.add(labelFechaModificacion);
        panelDetalles.add(campoFechaModificacion);
        panelDetalles.add(labelRating);
        panelDetalles.add(campoRating);
        panelDetalles.add(labelVersion);
        panelDetalles.add(campoVersion);
        panelDetalles.add(labelResenas);
        panelDetalles.add(campoResenas);

        add(panelDetalles, BorderLayout.CENTER);


        JPanel panelBoton = new JPanel(new FlowLayout());
        JButton botonVolver = new JButton("Volver");
        panelBoton.add(botonVolver);
        add(panelBoton, BorderLayout.SOUTH);


        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoBuscar.getText();
                LearningPath lp = Profesor.getLearningPath(learningPaths, nombre);
                try {
					cpa.cargarActividades(nombre);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                try {
					cpr.cargarResenas(nombre);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                List<Actividad> lista_Actividades = lp.getActividades();
            	ArrayList<String> nombres = new ArrayList<>();
            	
            	
            	for (Actividad i: lista_Actividades) {
            		
            		String texto = i.getTitulo();
            		nombres.add(texto);
            		
            		try {
						cpq.cargarQuiz(lp, texto);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}

                if (lp != null) {
                    campoTitulo.setText(lp.getTitulo());
                    campoDescripcion.setText(lp.getDescripcion());
                    campoDificultad.setText(lp.getDificultad());
                    campoDuracion.setText(String.valueOf(lp.getDuracionTotalMinutos()));
                    campoActividades.setText(nombres.toString());
                    campoFechaCreacion.setText(lp.getFechaCreacion().toString());
                    campoFechaModificacion.setText(lp.getFechaModificacion().toString());
                    campoRating.setText(String.valueOf(lp.actualizarRating()));
                    campoVersion.setText(String.valueOf(lp.getVersion()));
                    campoResenas.setText(lp.getFeedbacks(lp).toString());
                } else {
                    JOptionPane.showMessageDialog(VentanaVerLearningPath.this, "Learning Path no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new VentanaProfesor();
                } catch (ClassNotFoundException | IOException ex) {
                    JOptionPane.showMessageDialog(VentanaVerLearningPath.this, "Error al volver: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                dispose();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
