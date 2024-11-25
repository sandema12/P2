package VentanasEstudiantes;

import Usuario.Estudiante;
import LearningPath.LearningPath;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaProgreso extends JFrame {

    public VentanaProgreso(Estudiante estudiante) {
        setTitle("Progreso del Estudiante");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel panelLista = new JPanel(new BorderLayout());
        JLabel labelTitulo = new JLabel("Progreso en Learning Paths:");
        JTextArea areaProgreso = new JTextArea(10, 30);
        areaProgreso.setEditable(false);

        StringBuilder progreso = new StringBuilder();
        List<LearningPath> learningPaths = estudiante.getLearningPathsInscritos();
        for (LearningPath lp : learningPaths) {
            progreso.append(lp.getTitulo()).append(": Progreso no implementado\n");
        }
        areaProgreso.setText(progreso.toString());

        panelLista.add(labelTitulo, BorderLayout.NORTH);
        panelLista.add(new JScrollPane(areaProgreso), BorderLayout.CENTER);

        JButton botonVolver = new JButton("Volver");
        botonVolver.addActionListener(e -> dispose());

        add(panelLista, BorderLayout.CENTER);
        add(botonVolver, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
