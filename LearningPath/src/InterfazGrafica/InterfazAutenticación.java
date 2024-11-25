package InterfazGrafica;

import javax.swing.*;

import Consola.ConsolaAutenticacion;
import Consola.ConsolaEstudiante;
import Consola.ConsolaProfesor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;

import Usuario.Estudiante;
import Usuario.Profesor;
import Usuario.Usuario;
import VentanasEstudiantes.VentanaEstudiante;
import VentanasProfesor.VentanaProfesor;
import Persistencia.centralPersistenciaUsuarios;

public class InterfazAutenticación extends JFrame{
	
	
	private ConsolaAutenticacion consola;
	PanelDatosAuth panelDatos;
	
	
	private static List<Usuario> usuarios = new ArrayList<>();
	private static List<Estudiante> estudiantes = new ArrayList<>();
	private static List<Profesor> profesores = new ArrayList<>();
	
	centralPersistenciaUsuarios centralPersistenciaUsuarios;
	
	public InterfazAutenticación() {
		consola = new ConsolaAutenticacion();
		centralPersistenciaUsuarios = new centralPersistenciaUsuarios(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 180);
		setTitle("Autenticación");
		
		BorderLayout bl = new BorderLayout();
		setLayout(bl);
		
		panelDatos = new PanelDatosAuth(this);
		add(panelDatos, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		
	
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		InterfazAutenticación v = new InterfazAutenticación();
	}
	
	
	public void crearUsuario(String username, String password, String rol) throws FileNotFoundException, IOException, ClassNotFoundException {		
		      
		
		Usuario nuevoUsuario;
		Estudiante nuevoEstudiante;
		Profesor nuevoProfesor;
		
		if (rol.equalsIgnoreCase("Profesor")) {
            nuevoUsuario = new Profesor(username, password, rol);
            nuevoProfesor = new Profesor(username, password, rol);
            profesores.add(nuevoProfesor);
            centralPersistenciaUsuarios.persistirProfesores(nuevoProfesor);
            JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.");
            
            
        } else if (rol.equalsIgnoreCase("Estudiante")) {
            nuevoUsuario = new Estudiante(username, password, rol);
            nuevoEstudiante = new Estudiante(username, password, rol);
            estudiantes.add(nuevoEstudiante);
            centralPersistenciaUsuarios.persistirEstudiantes(nuevoEstudiante);
            JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.");
            
        } else {
            System.out.println("Rol no válido. El registro ha sido cancelado.");
            return;
        }
		
		usuarios.add(nuevoUsuario);
		
		
		centralPersistenciaUsuarios.persistirUsuarios(nuevoUsuario);
		
	}	
	
	
	public void autenticacion(String username, String password) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		centralPersistenciaUsuarios.cargarUsuarios();
		centralPersistenciaUsuarios.cargarEstudiantes();
		centralPersistenciaUsuarios.cargarProfesores();
		
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                Usuario usuarioAutenticado = usuario;
                
                
                if (usuarioAutenticado.getPassword().equals(password)) {
                	JOptionPane.showMessageDialog(this, "Usuario autenticado exitosamente.");
                	
                	
                	if (usuarioAutenticado.getRol().equalsIgnoreCase("Estudiante")) {
                		cambiarVentana(new VentanaEstudiante(usuario.getUsername()));
                    
                    	}
                	else if (usuarioAutenticado.getRol().equalsIgnoreCase("Profesor")) {
                		cambiarVentana(new VentanaProfesor());

                    
                    	}
                	
                }else {
                	JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
                	
                }
            }
        }
        
	}
	
	public void cambiarVentana(JFrame nuevaVentana) {
	    nuevaVentana.setVisible(true);
	    this.dispose();
	}


	public static List<Usuario> getUsuarios() {
		return usuarios;
	}


	public static void setUsuarios(List<Usuario> usuarios) {
		InterfazAutenticación.usuarios = usuarios;
	}


	public static List<Estudiante> getEstudiantes() {
		return estudiantes;
	}


	public static void setEstudiantes(List<Estudiante> estudiantes) {
		InterfazAutenticación.estudiantes = estudiantes;
	}


	public static List<Profesor> getProfesores() {
		return profesores;
	}


	public static void setProfesores(List<Profesor> profesores) {
		InterfazAutenticación.profesores = profesores;
	}

}
