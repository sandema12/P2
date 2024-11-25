package testsLogica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import LearningPath.Examen;
import LearningPath.Pregunta;
import LearningPath.Quiz;
import LearningPath.RecursoEducativo;
import LearningPath.Tarea;

class testActividad {
    private Tarea tarea;
    private Quiz quiz;
    private Examen examen;
    private RecursoEducativo recurso;
    private Pregunta pregunta1, pregunta2;

    @BeforeEach
    void setUp() throws Exception {
        pregunta1 = new Pregunta("¿Cuánto es 9+8?", Arrays.asList("20", "17", "19", "18"), "2");
        pregunta2 = new Pregunta("¿Cuánto es 3+6+9?", Arrays.asList("18", "21", "19", "20"), "1");

        List<Pregunta> preguntas = Arrays.asList(pregunta1, pregunta2);

        tarea = new Tarea("Primera tarea", "Resolver problemas matemáticos", "Estudiar matemáticas", 
            "Baja", "Tarea", preguntas, true, 10, LocalDate.now());

        quiz = new Quiz("Quiz1", "Preguntas de matemáticas", "Evaluar sumas de 2 y 3 términos", 
            "Media", "Quiz", preguntas, true, 10, LocalDate.now());

        examen = new Examen("Examen1", "Examen parcial", "Evaluar progreso en matemáticas", 
            "Alta", "Examen", preguntas, true, 20, LocalDate.now());

        recurso = new RecursoEducativo("Módulo 1 - Video1", "Video sobre sumas de 2 y 3 términos", 
            "Entender la suma de 2 y 3 términos", "Baja", "Recurso Educativo", preguntas, false, 15, LocalDate.now());
    }

    @Test
    void testEntregarTarea() {
        tarea.entregarTarea();
        assertEquals("Entregada", tarea.getEstado(), "La tarea no se entregó con éxito");
    }

    @Test
    void testEntregarQuiz() {
        quiz.entregarQuiz(Arrays.asList("2", "1"));
        assertEquals("Entregada", quiz.getEstado(), "El quiz no se entregó con éxito");
    }

    @Test
    void testEntregarExamen() {
        examen.entregarExamen(Arrays.asList("2", "1"));
        assertEquals("Entregado", examen.getEstado(), "El examen no se entregó con éxito");
    }

    @Test
    void testCompletarRecursoEducativo() {
        recurso.completarRecurso();
        assertEquals("Completado", recurso.getEstado(), "El recurso educativo no se completó con éxito");
    }
}