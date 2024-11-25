package VentanasEstudiantes;

import Usuario.Estudiante;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaCalificaciones extends JFrame {

    public VentanaCalificaciones(Estudiante estudiante) {
        setTitle("Calificaciones del Estudiante");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel panelLista = new JPanel(new BorderLayout());
        JLabel labelTitulo = new JLabel("Calificaciones:");
        JTextArea areaCalificaciones = new JTextArea(10, 30);
        areaCalificaciones.setEditable(false);

        StringBuilder calificaciones = new StringBuilder();
        List<String> notas = estudiante.getCalificaciones();
        for (String nota : notas) {
            calificaciones.append(nota).append("\n");
        }
        areaCalificaciones.setText(calificaciones.toString());

        panelLista.add(labelTitulo, BorderLayout.NORTH);
        panelLista.add(new JScrollPane(areaCalificaciones), BorderLayout.CENTER);

        JButton botonVolver = new JButton("Volver");
        botonVolver.addActionListener(e -> dispose());

        add(panelLista, BorderLayout.CENTER);
        add(botonVolver, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
