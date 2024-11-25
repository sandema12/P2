package VentanasProfesor;

import LearningPath.Actividad;
import LearningPath.LearningPath;
import Persistencia.CentralPersistenciaActividades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class VentanaVerActividades extends JFrame {
	
	CentralPersistenciaActividades cpa;

    public VentanaVerActividades(LearningPath learningPath) throws ClassNotFoundException, IOException {
    	
    	 cpa = new CentralPersistenciaActividades();
        setTitle("Ver Actividades");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout());

        JTextArea areaActividades = new JTextArea();
        areaActividades.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaActividades);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Actividades"));
        cpa.cargarActividades(learningPath.getTitulo());
        List<Actividad> actividades = learningPath.getActividades();
        
        if (actividades.isEmpty()) {
            areaActividades.setText("No hay actividades registradas para este Learning Path.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Actividad act : actividades) {
                sb.append("-------------------------------\n");
                sb.append("Título: ").append(act.getTitulo()).append("\n");
                sb.append("Tipo: ").append(act.getTipo()).append("\n");
                sb.append("Preguntas: ").append(act.getEnunciados(act)).append("\n");
                sb.append("Descripción: ").append(act.getDescripcion()).append("\n");
                sb.append("Objetivo: ").append(act.getObjetivo()).append("\n");
                sb.append("Dificultad: ").append(act.getDificultad()).append("\n");
                sb.append("Duración: ").append(act.getDuracionMinutos()).append(" minutos\n");
                sb.append("Fecha Límite: ").append(act.getFechaLimite()).append("\n");
                sb.append("-------------------------------\n\n");
            }
            areaActividades.setText(sb.toString());
        }

        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBoton = new JPanel(new FlowLayout());
        JButton botonVolver = new JButton("Volver");
        panelBoton.add(botonVolver);
        add(panelBoton, BorderLayout.SOUTH);

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
				new VentanaActividades(VentanaCrearLP.getLearningPathsCreados());
				dispose();
            }
        });


        setLocationRelativeTo(null);
        setVisible(true);
    }
}