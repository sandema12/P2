package VentanasEstudiantes;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaEstudiante extends JFrame {
	
	public VentanaEstudiante(String usuario) {
		
        setTitle("Menú: " + usuario);
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Hola, " + usuario + ", esta es tu ventana de estudiante.", JLabel.CENTER);
        add(label, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

}
