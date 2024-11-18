package Usuario;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Consola.ConsolaActividad;
import Consola.ConsolaAutenticacion;
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
		version++;
		lp.setVersion(version);
		
		
		lp.setFechaModificacion(LocalDateTime.now());
		
		
	}	
	
	public static void calificarActividad(String nombreEst, String nombreLp, String nombreAct, String calificacion) {
		
		List<Estudiante> estudiantes = ConsolaAutenticacion.getEstudiantes();
		String texto = nombreAct + "" + calificacion;
		
		for (Estudiante est: estudiantes) {
			if (est.getUsername().equals(nombreEst)){
				Estudiante estudiante = est;
				List<LearningPath> lps = estudiante.getLearningPathsInscritos();
				
				for (LearningPath lp: lps) {
					if (lp.getTitulo().equals(nombreLp)){
						List<Actividad> actividades = lp.getActividades();
						
						for (Actividad act: actividades) {
							if (act.getTitulo().equals(nombreAct)){
								act.setResultado(calificacion);
								est.calificaciones.add(texto);
								
							}
						
						
					}
						
						
					}
					
				}
			}	
		}
		
		
		
		
	    
	    
	}	
	
	public static void añadirReseña(String nombre, double calificacion, String feedback) {
		
		Reseña reseña = new Reseña(calificacion, feedback);
		List<LearningPath> lista = getLearningPathsCreados();
		LearningPath lp = Profesor.getLearningPath(lista, nombre);
        
		
        lp.reseñas.add(reseña);    
        lp.ratings.add(calificacion);
        lp.actualizarRating();
            
		
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
