package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;


import javax.swing.*;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;





public class PanelDatosAuth extends JPanel implements ActionListener{
	private JLabel label_n1;
	private JLabel label_n2;
	private JLabel label_n3;
	private JTextField campo_n1;
	private JTextField campo_n2;
	private JTextField campo_n3;

	private JButton botonRegistro;
	private JButton botonIniciar;
	private InterfazAutenticación padre;
	
	

	
	public PanelDatosAuth(InterfazAutenticación papa) {
		padre = papa;
		
		setBorder(new TitledBorder("Panel Datos"));
		
		JPanel panelAux_Naranja = new JPanel();
		GridLayout gl = new GridLayout(3,2);
		panelAux_Naranja.setLayout(gl);
		label_n1 = new JLabel("Usuario");
		campo_n1 = new JTextField();
		label_n2 = new JLabel("Contraseña");
		campo_n2 = new JTextField();
		label_n3 = new JLabel("Rol(Estudiante/Usuario)");
		campo_n3 = new JTextField();
		addPlaceholder(campo_n3, "Solo usar este espacio si se va a registrar por primera vez");
		
		
		panelAux_Naranja.add(label_n1);
		panelAux_Naranja.add(campo_n1);
		panelAux_Naranja.add(label_n2);
		panelAux_Naranja.add(campo_n2);
		panelAux_Naranja.add(label_n3);
		panelAux_Naranja.add(campo_n3);
		
		
		
		JPanel panelAux_Verde = new JPanel();
		
		FlowLayout fl = new FlowLayout();
		panelAux_Verde.setLayout(fl);
		
		botonRegistro = new JButton("Registrarse");
		botonRegistro.addActionListener(this);
		botonRegistro.setActionCommand("Registro");
		
		botonIniciar = new JButton("Iniciar Sesión");
		botonIniciar.addActionListener(this);
		botonIniciar.setActionCommand("Iniciar");
		
		panelAux_Verde.add(botonIniciar);
		panelAux_Verde.add(botonRegistro);
		
		BorderLayout bl = new BorderLayout();
		setLayout(bl);
		add(panelAux_Verde, BorderLayout.CENTER);
		add(panelAux_Naranja, BorderLayout.NORTH);
	}







	@Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		
		
		if (grito.equals("Registro")) {
	        String username = campo_n1.getText();
	        String password = campo_n2.getText();
	        String rol = campo_n3.getText();

	        try {
	            padre.crearUsuario(username, password, rol);
	            
	            
	            limpiarCampos();
	        } catch (IOException | ClassNotFoundException ex) {
	            JOptionPane.showMessageDialog(this, "Error al registrar usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
		
		if (grito.equals("Iniciar")) {
	        String username = campo_n1.getText();
	        String password = campo_n2.getText();
	        

	        try {
	            padre.autenticacion(username, password);
	           
	            
	            limpiarCampos();
	        } catch (IOException | ClassNotFoundException ex) {
	            JOptionPane.showMessageDialog(this, "Error al registrar usuario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
		
	}
	
	
	public static void addPlaceholder(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }
	
	private void limpiarCampos() {
	    campo_n1.setText("");
	    campo_n2.setText("");
	    campo_n3.setText("");
	}
	

}
