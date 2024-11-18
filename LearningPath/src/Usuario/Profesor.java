package Usuario;

import static LearningPath.LearningPath.reseñas;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Consola.ConsolaActividad;
import Consola.ConsolaEstudiante;
import Consola.ConsolaProfesor;
import LearningPath.Actividad;
import LearningPath.LearningPath;

public class Profesor extends Usuario {

    private static List<LearningPath> learningPathsCreados= new ArrayList<>();

    public Profesor(String username, String password, String rol) {
        super(username, password, "Profesor");
    }


public static void crearLearningPath(String titulo, String descripcion, String objetivo, String dificultad, int duracionMinutos ) {
		
		
        
        //Implementar calcular rating
        double rating = 0.0;
        
        LocalDateTime fechaCreacion = LocalDateTime.now();
        LocalDateTime fechaModificacion = LocalDateTime.now();

        int version = 1;
       
        ConsolaActividad consolaActividad = new ConsolaActividad();
        List<Actividad> actividades = consolaActividad.mostrarMenu();
        List<Reseña> reseñas = null;
        LearningPath nuevoLearningPath = new LearningPath(titulo, descripcion, objetivo, dificultad, duracionMinutos, rating, fechaCreacion, fechaModificacion, version, actividades, reseñas);
        learningPathsCreados.add(nuevoLearningPath);
	}
	
	public static void editarLearningPath(LearningPath lp, String titulo, String descripcion, String dificultad, int duracionTotalMinutos, double rating, Date fechaCreacion, LocalDateTime fechaModificacion,  int version, List<Actividad> actividades) {
	   
		if (!titulo.isEmpty()) {
	        lp.setTitulo(titulo);
	    }
		
		if (!descripcion.isEmpty()) {
	        lp.setDescripcion(descripcion);
	    }
		
		if (!dificultad.isEmpty()) {
		      
	        lp.setDificultad(dificultad);
	    }
		
		if (!(duracionTotalMinutos == 0)) {
			
			lp.setDuracionTotalMinutos(duracionTotalMinutos);
			
		}
		
		lp.setFechaModificacion(fechaModificacion);
		lp.getReseñas();
		version++;
		lp.setVersion(version);
		
		
		lp.setFechaModificacion(LocalDateTime.now());
		
		
	}	
	
	public static void calificarActividad() {
	   
	   

	    
	    
	}	
	


    public static List<LearningPath> getLearningPathsCreados() {
        return learningPathsCreados;
    }
    
    public static LearningPath getLearningPath(List<LearningPath> lp_lista, String nombre){
    	for (LearningPath lp : lp_lista) {
            if (lp.getTitulo().equals(nombre)) {
                return lp;
                
                
              
            }
        }
		return null;
    }
}
