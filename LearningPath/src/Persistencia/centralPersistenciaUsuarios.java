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
import Usuario.Estudiante;
import Usuario.Profesor;
import Usuario.Usuario;

public class centralPersistenciaUsuarios implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1882595537808982257L;
	private ConsolaAutenticacion usuarios_consola; 
	
	public centralPersistenciaUsuarios(ConsolaAutenticacion consola) {
	    this.usuarios_consola = consola; 
	}
	
	public void cargarUsuarios() throws FileNotFoundException, IOException, ClassNotFoundException {
	    ArrayList<Usuario> usuarios;

	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./data/usuarios.data"))) {
	        usuarios = (ArrayList<Usuario>) ois.readObject(); 
	        usuarios_consola.setUsuarios(usuarios);          
	        System.out.println("Usuarios cargados exitosamente.");
	    } catch (FileNotFoundException e) {
	        
	        usuarios = new ArrayList<>();
	        usuarios_consola.setUsuarios(usuarios);
	        System.out.println("El archivo no existe. Inicializando lista de usuarios vacía.");
	        
	    }
	    
	    System.out.println("Usuarios: "+ Usuario.getUsernames(usuarios));
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

	    System.out.println("Usuario añadido exitosamente.");
	}
	
	
	public void cargarEstudiantes() throws FileNotFoundException, IOException, ClassNotFoundException {
	    ArrayList<Estudiante> estudiantes;

	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./data/estudiantes.data"))) {
	        estudiantes = (ArrayList<Estudiante>) ois.readObject(); 
	        usuarios_consola.setEstudiantes(estudiantes);          
	        System.out.println("Estudiantes cargados exitosamente.");
	    } catch (FileNotFoundException e) {
	        
	        estudiantes = new ArrayList<>();
	        usuarios_consola.setEstudiantes(estudiantes);
	        System.out.println("El archivo no existe. Inicializando lista de usuarios vacía.");
	        
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

	    System.out.println("Estudiante añadido exitosamente.");
	}
	
	public void cargarProfesores() throws FileNotFoundException, IOException, ClassNotFoundException {
	    ArrayList<Profesor> profesores;

	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./data/profesores.data"))) {
	        profesores = (ArrayList<Profesor>) ois.readObject(); 
	        usuarios_consola.setProfesores(profesores);          
	        System.out.println("Profesores cargados exitosamente.");
	    } catch (FileNotFoundException e) {
	        
	        profesores = new ArrayList<>();
	        usuarios_consola.setProfesores(profesores);
	        System.out.println("El archivo no existe. Inicializando lista de usuarios vacía.");
	        
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

	    System.out.println("Profesor añadido exitosamente.");
	}
	

}
