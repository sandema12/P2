package Persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Consola.ConsolaAutenticacion;
import InterfazGrafica.InterfazAutenticación;
import Usuario.Estudiante;
import Usuario.Profesor;
import Usuario.Usuario;

public class centralPersistenciaUsuarios implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1882595537808982257L;
	private InterfazAutenticación interfaz;
	
	public centralPersistenciaUsuarios(InterfazAutenticación interfaz1) {
	    this.interfaz = interfaz1; 
	}
	
	public void cargarUsuarios() throws FileNotFoundException, IOException, ClassNotFoundException {
	    ArrayList<Usuario> usuarios;

	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./data/usuarios.data"))) {
	        usuarios = (ArrayList<Usuario>) ois.readObject(); 
	        interfaz.setUsuarios(usuarios);          
	        
	    } catch (FileNotFoundException e) {
	        
	        usuarios = new ArrayList<>();
	        interfaz.setUsuarios(usuarios);
	        
	        
	    }
	    
	    
	}

	
	public void persistirUsuarios(Usuario usuario) throws FileNotFoundException, IOException, ClassNotFoundException {

	    ArrayList<Usuario> usuarios;

	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./data/usuarios.data"))) {
	        usuarios = (ArrayList<Usuario>) ois.readObject();
	    } catch (FileNotFoundException e) {
	        usuarios = new ArrayList<>();
	    }

	    usuarios.add(usuario);

	    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./data/usuarios.data"))) {
	        oos.writeObject(usuarios);
	    }

	    
	}
	
	
	public void cargarEstudiantes() throws FileNotFoundException, IOException, ClassNotFoundException {
	    ArrayList<Estudiante> estudiantes;

	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./data/estudiantes.data"))) {
	        estudiantes = (ArrayList<Estudiante>) ois.readObject(); 
	        interfaz.setEstudiantes(estudiantes);          
	        
	    } catch (FileNotFoundException e) {
	        
	        estudiantes = new ArrayList<>();
	        interfaz.setEstudiantes(estudiantes);
	        
	        
	    }
	}

	
	public void persistirEstudiantes(Estudiante usuario) throws FileNotFoundException, IOException, ClassNotFoundException {

	    ArrayList<Estudiante> estudiantes;

	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./data/estudiantes.data"))) {
	        estudiantes = (ArrayList<Estudiante>) ois.readObject();
	    } catch (FileNotFoundException e) {
	        estudiantes = new ArrayList<>();
	    }

	    estudiantes.add(usuario);

	    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./data/estudiantes.data"))) {
	        oos.writeObject(estudiantes);
	    }

	    
	}
	
	public void cargarProfesores() throws FileNotFoundException, IOException, ClassNotFoundException {
	    ArrayList<Profesor> profesores;

	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./data/profesores.data"))) {
	        profesores = (ArrayList<Profesor>) ois.readObject(); 
	        interfaz.setProfesores(profesores);          
	        
	    } catch (FileNotFoundException e) {
	        
	        profesores = new ArrayList<>();
	        interfaz.setProfesores(profesores);
	        
	        
	    }

	}

	
	public void persistirProfesores(Profesor usuario) throws FileNotFoundException, IOException, ClassNotFoundException {

	    ArrayList<Profesor> profesores;

	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./data/profesores.data"))) {
	        profesores = (ArrayList<Profesor>) ois.readObject();
	    } catch (FileNotFoundException e) {
	        profesores = new ArrayList<>();
	    }

	    profesores.add(usuario); 

	    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./data/profesores.data"))) {
	        oos.writeObject(profesores);
	    }

	    
	}
	

}
