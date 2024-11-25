package Persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import LearningPath.Actividad;
import LearningPath.LearningPath;
import LearningPath.Pregunta;


public class CentralPersistenciaQuiz {
	
	
    public static void guardarQuiz(List<Pregunta> preguntas, Actividad actividad) throws IOException, ClassNotFoundException {
    	
    	
    	String titulo = actividad.getTitulo();
    	

    	
    	
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./data/preguntasQuiz/preguntas_" + titulo + ".data"))) {
        	
            oos.writeObject(preguntas);
            System.out.println("Preguntas guardados exitosamente.");
            
        } 
    }


    @SuppressWarnings("unchecked")
    public static void cargarQuiz(LearningPath lp, String nombreAct) throws IOException, ClassNotFoundException {
    	
    	ArrayList<Pregunta> preguntas;
    	ArrayList<Actividad> actividades = (ArrayList<Actividad>) lp.getActividades();
    	Actividad actividad = lp.getActividad(actividades, nombreAct);
    	
        
        	
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./data/preguntasQuiz/preguntas_" + nombreAct + ".data"))) {
        	
        	preguntas = (ArrayList<Pregunta>) ois.readObject();
        	
        	
            actividad.setPreguntas(preguntas);
            
            System.out.println("Preguntas cargadas exitosamente. ");
            
             
        } catch (FileNotFoundException e) {
        	preguntas = new ArrayList<>();
        	actividad.setPreguntas(preguntas);
            System.out.println("No se encontró el archivo de Preguntas, iniciando con una lista vacía.");
        } 
    }

}
