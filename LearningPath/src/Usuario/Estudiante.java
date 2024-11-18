package Usuario;

import java.util.ArrayList;
import java.util.List;

import LearningPath.Actividad;
import LearningPath.LearningPath;

public class Estudiante extends Usuario {

    private static List<LearningPath> learningPathsInscritos = new ArrayList<>();

    public Estudiante(String username, String password, String nombre) {
        super(username, password, "Estudiante");
        
    }


    public static void inscribirseEnLearningPath(LearningPath learningPath) {
        if (!learningPathsInscritos.contains(learningPath)) {
            learningPathsInscritos.add(learningPath);
            System.out.println("Inscrito en el Learning Path: " + learningPath.getTitulo());
        } else {
            System.out.println("Ya estás inscrito en este Learning Path.");
        }
    }

    public void completarActividad(Actividad actividad) {
        System.out.println("Actividad completada: " + actividad.getDescripcion());

    }

    public void verProgreso() {
        System.out.println("Progreso en los Learning Paths:");
        for (LearningPath lp : learningPathsInscritos) {
            System.out.println(lp.getTitulo() + " - Progreso: " + "0% (sin implementar)");
        }
    }


    public List<LearningPath> getLearningPathsInscritos() {
        return learningPathsInscritos;
    }
}
