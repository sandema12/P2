package Usuario;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Consola.ConsolaAutenticacion;
import LearningPath.Actividad;
import LearningPath.LearningPath;

public class Estudiante extends Usuario {

    private static List<LearningPath> learningPathsInscritos = new ArrayList<>();
    static List<String> calificaciones = new ArrayList<>();
    

    public Estudiante(String username, String password, String nombre) {
        super(username, password, "Estudiante");
        
    }


    public static void inscribirseEnLearningPath(LearningPath learningPath) {
        if (!learningPathsInscritos.contains(learningPath)) {
            learningPathsInscritos.add(learningPath);
        } else {
            System.out.println("Ya estás inscrito en este Learning Path.");
        }
    }

    public void completarActividad(Actividad actividad) {
        System.out.println("Actividad completada: " + actividad.getDescripcion());

    }
    public List<String> verCalificaciones(String nombre) {
    	List<Estudiante> estudiantes = ConsolaAutenticacion.getEstudiantes();
    	for (Estudiante est: estudiantes) {
    		if (nombre.equals(est.getUsername()));
    			List<String> notas = est.getCalificaciones();
    			return notas;
    	}
		return null;
    	
    }

    public void verProgreso() {
        System.out.println("Progreso en los Learning Paths:");
        for (LearningPath lp : learningPathsInscritos) {
            System.out.println(lp.getTitulo() + " - Progreso: " + "0% (sin implementar)");
        }
    }


    public static List<LearningPath> getLearningPathsInscritos() {
        return learningPathsInscritos;
    }


	public static List<String> getCalificaciones() {
		return calificaciones;
	}


	public static void setCalificaciones(List<String> calificaciones) {
		Estudiante.calificaciones = calificaciones;
	}
}
