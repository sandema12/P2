package Persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Consola.ConsolaProfesor;
import LearningPath.Actividad;
import LearningPath.LearningPath;
import Usuario.Profesor;
import VentanasProfesor.VentanaCrearLP;


public class CentralPersistenciaActividades {
    
	

    public static void guardarActividades(LearningPath lp, Actividad actividad) throws IOException, ClassNotFoundException {
    	
    	ArrayList<Actividad> actividades;
    	String titulo = lp.getTitulo();
    	try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./data/actividades/actividades_" + titulo + ".data"))) {
    		actividades = (ArrayList<Actividad>) ois.readObject();
	    } catch (FileNotFoundException e) {
	    	actividades = new ArrayList<>();
	    }
    	
    	actividades.add(actividad);

    	
    	
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./data/actividades/actividades_" + titulo + ".data"))) {
        	
            oos.writeObject(actividades);
            System.out.println("Actividades guardados exitosamente.");
            
        } 
    }


    @SuppressWarnings("unchecked")
    public static void cargarActividades(String nombre) throws IOException, ClassNotFoundException {
    	ArrayList<Actividad> actividades;
    	ArrayList<LearningPath> lps;
    	lps = (ArrayList<LearningPath>) VentanaCrearLP.getLearningPathsCreados();
        LearningPath lp = Profesor.getLearningPath(lps, nombre);
        	
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./data/actividades/actividades_" + nombre + ".data"))) {
        	
        	actividades = (ArrayList<Actividad>) ois.readObject();
        	
        	
            lp.setActividades(actividades);
            
            System.out.println("Actividades cargadas exitosamente. ");
            
             
        } catch (FileNotFoundException e) {
        	actividades = new ArrayList<>();
        	lp.setActividades(actividades);
            System.out.println("No se encontró el archivo de Actividades, iniciando con una lista vacía.");
        } 
    }
	
}
