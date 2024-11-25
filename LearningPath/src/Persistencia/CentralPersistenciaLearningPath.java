package Persistencia;

import java.io.*;
import java.util.ArrayList;

import Consola.ConsolaProfesor;
import LearningPath.LearningPath;
import Usuario.Profesor;
import VentanasProfesor.VentanaCrearLP;


public class CentralPersistenciaLearningPath {

    private static final String FILE_NAME = "./data/learningPaths.data";
    
    private VentanaCrearLP consolaProfesor;

    public void guardarLearningPaths(LearningPath lp) throws IOException, ClassNotFoundException {
    	
    	ArrayList<LearningPath> lps;
    	
    	try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
	        lps = (ArrayList<LearningPath>) ois.readObject();
	    } catch (FileNotFoundException e) {
	        lps = new ArrayList<>();
	    }
    	
    	lps.add(lp);

    	
    	
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
        	
            oos.writeObject(lps);
            System.out.println("Learning Paths guardados exitosamente.");
            
        } 
    }


    @SuppressWarnings("unchecked")
    public void cargarLearningPaths() throws IOException, ClassNotFoundException {
    	ArrayList<LearningPath> lps;
    	
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
        	
            lps = (ArrayList<LearningPath>) ois.readObject();
            consolaProfesor.setLearningPathsCreados(lps);
            System.out.println("Learning Paths cargados exitosamente. " + Profesor.getNombresLearningPathsCreados(lps));
            
             
        } catch (FileNotFoundException e) {
        	lps = new ArrayList<>();
        	consolaProfesor.setLearningPathsCreados(lps);
            System.out.println("No se encontró el archivo de Learning Paths, iniciando con una lista vacía.");
        } 
    }
    
    
    
    public static boolean editarLearningPath(String titulo, LearningPath lpActualizado) throws IOException, ClassNotFoundException {
        ArrayList<LearningPath> lps;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            lps = (ArrayList<LearningPath>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de Learning Paths. No se puede editar.");
            return false;
        }

        boolean actualizado = false;
        for (int i = 0; i < lps.size(); i++) {
            if (lps.get(i).getTitulo().equals(titulo)) {
                lps.set(i, lpActualizado);
                actualizado = true;
                break;
            }
        }

        if (actualizado) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
                oos.writeObject(lps);
                System.out.println("Learning Path actualizado exitosamente.");
            }
        } else {
            System.out.println("No se encontró un Learning Path con el título: " + titulo);
        }

        return actualizado;
    }

}
