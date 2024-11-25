package VentanasProfesor;

import Usuario.Profesor;

import javax.swing.*;

import LearningPath.LearningPath;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class VentanaAñadirReseña extends JFrame {
	
	JTextField campoNombre;
	JTextField campoFeedback;
	JTextField campoRating;
	
    public VentanaAñadirReseña(List<LearningPath> learningPaths) {
    	
        setTitle("Añadir Reseña a Learning Path");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLayout(new BorderLayout());
        
        JPanel panelPrincipal = new JPanel(new GridLayout(3, 2));
        panelPrincipal.setBorder(BorderFactory.createTitledBorder("Nueva Reseña"));

        JLabel labelNombre = new JLabel("Nombre del Learning Path:");
        campoNombre = new JTextField();

        JLabel labelFeedback = new JLabel("Feedback:");
         campoFeedback = new JTextField();

        JLabel labelRating = new JLabel("Rating (1-5):");
        campoRating = new JTextField();

        panelPrincipal.add(labelNombre);
        panelPrincipal.add(campoNombre);
        panelPrincipal.add(labelFeedback);
        panelPrincipal.add(campoFeedback);
        panelPrincipal.add(labelRating);
        panelPrincipal.add(campoRating);

        add(panelPrincipal, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton botonGuardar = new JButton("Añadir Reseña");
        JButton botonCancelar = new JButton("Volver");

        panelBotones.add(botonGuardar);
        panelBotones.add(botonCancelar);
        add(panelBotones, BorderLayout.SOUTH);

        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                String feedback = campoFeedback.getText();
                double rating;

                try {
                    rating = Double.parseDouble(campoRating.getText());

                    if (rating < 1 || rating > 5) {
                        JOptionPane.showMessageDialog(VentanaAñadirReseña.this, "El rating debe estar entre 1 y 5.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Profesor.añadirReseña(nombre, rating, feedback);
                    JOptionPane.showMessageDialog(VentanaAñadirReseña.this, "Reseña añadida exitosamente.");
                    limpiarCampos();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(VentanaAñadirReseña.this, "El rating debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(VentanaAñadirReseña.this, "Error al añadir la reseña: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
    
	private void limpiarCampos() {
		campoNombre.setText("");
		campoFeedback.setText("");
		campoRating.setText("");
	}
}
