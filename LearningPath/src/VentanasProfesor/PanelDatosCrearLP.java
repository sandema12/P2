package VentanasProfesor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelDatosCrearLP extends JPanel implements ActionListener{

	
	VentanaCrearLP padre;
	
	private JLabel label_n1;
	private JLabel label_n2;
	private JLabel label_n3;
	private JLabel label_n4;
	private JLabel label_n5;
	private JTextField campo_n1;
	private JTextField campo_n2;
	private JTextField campo_n3;
	private JTextField campo_n4;
	private JTextField campo_n5;
	
	private JButton botonCrear;
	private JButton botonVolver;
	
	public PanelDatosCrearLP(VentanaCrearLP papa) {
		padre = papa;
		
		setBorder(new TitledBorder("Panel Datos"));	
		
		JPanel panelAux_Naranja = new JPanel();
		GridLayout gl = new GridLayout(5,2);
		panelAux_Naranja.setLayout(gl);
		label_n1 = new JLabel("Nombre del Learning Path");
		campo_n1 = new JTextField();
		label_n2 = new JLabel("Descripción del Learning Path");
		campo_n2 = new JTextField();
		label_n3 = new JLabel("Objetivo");
		campo_n3 = new JTextField();
		label_n4 = new JLabel("Dificultad");
		campo_n4 = new JTextField();
		label_n5 = new JLabel("Duración total en minutos");
		campo_n5 = new JTextField();
		

		
		
		panelAux_Naranja.add(label_n1);
		panelAux_Naranja.add(campo_n1);
		panelAux_Naranja.add(label_n2);
		panelAux_Naranja.add(campo_n2);
		panelAux_Naranja.add(label_n3);
		panelAux_Naranja.add(campo_n3);
		panelAux_Naranja.add(label_n4);
		panelAux_Naranja.add(campo_n4);
		panelAux_Naranja.add(label_n5);
		panelAux_Naranja.add(campo_n5);
		
		
		
		JPanel panelAux_Verde = new JPanel();
		
		FlowLayout fl = new FlowLayout();
		panelAux_Verde.setLayout(fl);
		
		botonCrear = new JButton("Guardar");
		botonCrear.addActionListener(this);
		botonCrear.setActionCommand("Crear");
		
		
		botonVolver = new JButton("Volver");
		botonVolver.addActionListener(this);
		botonVolver.setActionCommand("Volver");
		
		panelAux_Verde.add(botonCrear);
		panelAux_Verde.add(botonVolver);
		
		BorderLayout bl = new BorderLayout();
		setLayout(bl);
		add(panelAux_Verde, BorderLayout.CENTER);
		add(panelAux_Naranja, BorderLayout.NORTH);
		
		
		
		
	}
	
	
	private void limpiarCampos() {
	    campo_n1.setText("");
	    campo_n2.setText("");
	    campo_n3.setText("");
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		
		
		if (grito.equals("Crear")) {
	        String nombre = campo_n1.getText();
	        String descripcion = campo_n2.getText();
	        String objetivo = campo_n3.getText();
	        String dificultad = campo_n4.getText();
	        int duracion = Integer.parseInt(campo_n5.getText());

	        try {
	            padre.crearLearningPath(nombre, descripcion, objetivo, dificultad, duracion);
	            
	            
	            limpiarCampos();
	        } catch (IOException | ClassNotFoundException ex) {
	            JOptionPane.showMessageDialog(this, "Error al registrar usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }else if (grito.equals("Volver")) {
	        try {
				padre.cambiarVentana(new VentanaProfesor());
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
	    }
		
		
		
	}



}
