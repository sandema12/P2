package Usuario;


import java.io.IOException;
import java.io.Serializable;
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
import Persistencia.CentralPersistenciaLearningPath;
import Persistencia.CentralPersistenciaReseñas;
import Persistencia.centralPersistenciaUsuarios;

public class Profesor extends Usuario implements Serializable {
	private static final long serialVersionUID = 1563643892269891790L;

    private static List<LearningPath> learningPathsCreados= new ArrayList<>();


    public Profesor(String username, String password, String rol) {
        super(username, password, "Profesor");
        
        
    }


    public static LearningPath crearLearningPath(String titulo, String descripcion, String objetivo, String dificultad, int duracionMinutos ) {
		
        double rating = 0.0;
        
        LocalDateTime fechaCreacion = LocalDateTime.now();
        LocalDateTime fechaModificacion = LocalDateTime.now();

        int version = 1;
       
      
        List<Actividad> actividades = new ArrayList<>();
        List<Reseña> reseñas = new ArrayList<>();
        LearningPath nuevoLearningPath = new LearningPath(titulo, descripcion, objetivo, dificultad, duracionMinutos, rating, fechaCreacion, fechaModificacion, version, actividades, reseñas);
        learningPathsCreados.add(nuevoLearningPath);
        
		return nuevoLearningPath;
	}
	
	public static void editarLearningPath(LearningPath lp, String titulo, String descripcion, String dificultad, int duracionTotalMinutos, double rating, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion,  int version, List<Actividad> actividades, String tituloAnterior) throws ClassNotFoundException, IOException {
	   
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
		lp.setRating(rating);
		version++;
		lp.setVersion(version);
		
		
		lp.setFechaModificacion(LocalDateTime.now());
		
		CentralPersistenciaLearningPath.editarLearningPath(tituloAnterior, lp);
		
		
		
	}
	
	public void agregarActividad() {
		
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
	
	public static void añadirReseña(String nombre, double calificacion, String feedback) throws ClassNotFoundException, IOException {
		
		Reseña reseña = new Reseña(nombre, calificacion, feedback);
		List<LearningPath> lista = ConsolaProfesor.getLearningPathsCreados();
		LearningPath lp = Profesor.getLearningPath(lista, nombre);
        
		
        lp.reseñas.add(reseña);    
        lp.ratings.add(calificacion);
        lp.actualizarRating();
        CentralPersistenciaReseñas.guardarResenas(lp, reseña);
            
		
	}
	

    public static void setLearningPathsCreados(List<LearningPath> learningPathsCreados) {
		Profesor.learningPathsCreados = learningPathsCreados;
	}


	public static List<LearningPath> getLearningPathsCreados() {
        return learningPathsCreados;
    }
	
	public static ArrayList<String> getNombresLearningPathsCreados(ArrayList<LearningPath> lps) {
		
    
    	ArrayList<String> nombres = new ArrayList<>();
    	
    	for (LearningPath i: lps) {
    		String texto = i.getTitulo();
    		nombres.add(texto);
    	}
    	
		return nombres;
		
        
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
