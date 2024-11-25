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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import InterfazGrafica.InterfazAutenticación;
import VentanasEstudiantes.VentanaEstudiante;

public class PanelDatosProfesor extends JPanel implements ActionListener{
	

	private JButton botonCrear;
	private JButton botonEditar;
	private JButton botonCalificar;
	private JButton botonResena;
	private JButton botonVer;
	private JButton botonMenuAct;
	private JButton botonCerrarSesion;
	private VentanaProfesor padre;

	public PanelDatosProfesor(VentanaProfesor papa) {

		
		padre = papa;
		
		setBorder(new TitledBorder("Panel Datos"));		
		
		JPanel panelAux_Verde = new JPanel();
		
		GridLayout gl = new GridLayout(7,1);
		panelAux_Verde.setLayout(gl);
		
		botonCrear = new JButton("Crear Learning Path");
		botonCrear.addActionListener(this);
		botonCrear.setActionCommand("Crear");
		
		botonEditar = new JButton("Editar Learning Path");
		botonEditar.addActionListener(this);
		botonEditar.setActionCommand("Editar");
		
		botonCalificar = new JButton("Calificar actividad");
		botonCalificar.addActionListener(this);
		botonCalificar.setActionCommand("Calificar");
		
		botonResena = new JButton("Añadir reseña");
		botonResena.addActionListener(this);
		botonResena.setActionCommand("Reseña");
		
		botonVer = new JButton("Ver Learning Path");
		botonVer.addActionListener(this);
		botonVer.setActionCommand("Ver");
		
		botonMenuAct = new JButton("Abrir Menú Actividades");
		botonMenuAct.addActionListener(this);
		botonMenuAct.setActionCommand("Menu");
		
		botonCerrarSesion = new JButton("Cerrar Sesión");
		botonCerrarSesion.addActionListener(this);
		botonCerrarSesion.setActionCommand("Cerrar");
		
		
		
		panelAux_Verde.add(botonCrear);
		panelAux_Verde.add(botonEditar);
		panelAux_Verde.add(botonCalificar);
		panelAux_Verde.add(botonResena);
		panelAux_Verde.add(botonVer);
		panelAux_Verde.add(botonMenuAct);
		panelAux_Verde.add(botonCerrarSesion);
		
		
		
		
		
		BorderLayout bl = new BorderLayout();
		setLayout(bl);
		add(panelAux_Verde, BorderLayout.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String grito = e.getActionCommand();
		
		
		if (grito.equals("Crear")) {
	        padre.cambiarVentana(new VentanaCrearLP());
	    }else if (grito.equals("Editar")) {
	        padre.cambiarVentana(new VentanaEditarLP(VentanaCrearLP.getLearningPathsCreados()));
	    }else if (grito.equals("Reseña")) {
	        padre.cambiarVentana(new VentanaAñadirReseña(VentanaCrearLP.getLearningPathsCreados()));
	    }else if (grito.equals("Ver")) {
	        padre.cambiarVentana(new VentanaVerLearningPath(VentanaCrearLP.getLearningPathsCreados()));
	    }else if (grito.equals("Menu")) {
	        padre.cambiarVentana(new VentanaActividades(VentanaCrearLP.getLearningPathsCreados()));
	    }
	    
	    else if (grito.equals("Cerrar")) {
	        padre.cambiarVentana(new InterfazAutenticación());
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
	

}
