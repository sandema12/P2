package Persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Consola.ConsolaProfesor;
import LearningPath.LearningPath;
import Usuario.Profesor;
import Usuario.Reseña;
import VentanasProfesor.VentanaCrearLP;

public class CentralPersistenciaReseñas {
	
    


    public static void guardarResenas(LearningPath lp, Reseña resena) throws IOException, ClassNotFoundException {
    	
    	ArrayList<Reseña> resenas;
    	String titulo = lp.getTitulo();
    	try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./data/resenas/resenas_" + titulo + ".data"))) {
    		resenas = (ArrayList<Reseña>) ois.readObject();
	    } catch (FileNotFoundException e) {
	    	resenas = new ArrayList<>();
	    }
    	
    	resenas.add(resena);

    	
    	
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./data/resenas/resenas_" + titulo + ".data"))) {
        	
            oos.writeObject(resenas);
            System.out.println("Reseñas guardados exitosamente.");
            
        } 
    }


    @SuppressWarnings("unchecked")
    public static void cargarResenas(String nombre) throws IOException, ClassNotFoundException {
    	ArrayList<Reseña> resenas;
    	ArrayList<LearningPath> lps;
    	lps = (ArrayList<LearningPath>) VentanaCrearLP.getLearningPathsCreados();
        LearningPath lp = Profesor.getLearningPath(lps, nombre);
        	
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./data/resenas/resenas_" + nombre + ".data"))) {
        	
        	resenas = (ArrayList<Reseña>) ois.readObject();
        	
        	
            lp.setReseñas(resenas);
            System.out.println("Reseñas cargadas exitosamente. ");
            
             
        } catch (FileNotFoundException e) {
        	resenas = new ArrayList<>();
        	lp.setReseñas(resenas);
            System.out.println("No se encontró el archivo de Reseñas, iniciando con una lista vacía.");
        } 
    }

}
