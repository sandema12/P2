package testsLogica;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import LearningPath.LearningPath;
import LearningPath.Quiz;
import LearningPath.RecursoEducativo;
import LearningPath.Tarea;
import LearningPath.Actividad;
import LearningPath.Examen;
import Usuario.Reseña;

public class testLearningPath {

	private LearningPath learningPath;

    @BeforeEach
    void setUp() throws Exception {
        List<Actividad> actividades = new ArrayList<>();
        List<Reseña> reseñas = new ArrayList<>();
        learningPath = new LearningPath("Introducción a la programación", "LearningPath introductorio de Python", "Aprender las bases de Python", 
        								"Medio", 300, 0, LocalDateTime.now(), LocalDateTime.now(), 1, actividades, reseñas);
    }
    
    @Test
    void testAgregarQuiz() {
        learningPath.agregarActividad("Quiz Python 1", "Preguntas sobre variables en Python", "Evaluar los conocimientos", "Bajo", "quiz", new ArrayList<>(), 
        								true, 25, LocalDate.now());

        assertEquals("Quiz Python 1", learningPath.getActividades().get(0).getTitulo(), "El título de la actividad no es el esperado");
        assertEquals(25, learningPath.getActividades().get(0).getDuracionMinutos(), "La duración total de la actividad no es el esperado");
        assertEquals(1, learningPath.getActividades().size(), "El tamaño no es el esperado");
        
        assertTrue(learningPath.getActividades().get(0) instanceof Quiz);
    }
    
    @Test
    void testAgregarExamen() {
        learningPath.agregarActividad("Examen Python 1", "Preguntas sobre variables en Python", "Evaluar los conocimientos", "Bajo", "examen", new ArrayList<>(), 
        								true, 90, LocalDate.now());

        assertEquals("Examen Python 1", learningPath.getActividades().get(0).getTitulo(), "El título de la actividad no es el esperado");
        assertEquals(90, learningPath.getActividades().get(0).getDuracionMinutos(), "La duración total de la actividad no es el esperado");
        assertEquals(1, learningPath.getActividades().size(), "El tamaño no es el esperado");
        
        assertTrue(learningPath.getActividades().get(0) instanceof Examen);
    }
    
    @Test
    void testAgregarTarea() {
        learningPath.agregarActividad("Tarea Python 1", "Investigación sobre variables en Python", "Familiarizar la teoría", "Bajo", "tarea", new ArrayList<>(), 
        								true, 100, LocalDate.now());

        assertEquals("Tarea Python 1", learningPath.getActividades().get(0).getTitulo(), "El título de la actividad no es el esperado");
        assertEquals(100, learningPath.getActividades().get(0).getDuracionMinutos(), "La duración total de la actividad no es el esperado");
        assertEquals(1, learningPath.getActividades().size(), "El tamaño no es el esperado");
        
        assertTrue(learningPath.getActividades().get(0) instanceof Tarea);
    }
    
    @Test
    void testAgregarRecurso() {
        learningPath.agregarActividad("Video Python 1", "Afianzar los conceptos", "Familiarizar la teoría", "Bajo", "recurso educativo", new ArrayList<>(), 
        								false, 15, LocalDate.now());

        assertEquals("Video Python 1", learningPath.getActividades().get(0).getTitulo(), "El título de la actividad no es el esperado");
        assertEquals(15, learningPath.getActividades().get(0).getDuracionMinutos(), "La duración total de la actividad no es el esperado");
        assertEquals(1, learningPath.getActividades().size(), "El tamaño no es el esperado");
        
        assertTrue(learningPath.getActividades().get(0) instanceof RecursoEducativo);
    }
    
    @Test
    void testAgregarActividadNoReconocida() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            learningPath.agregarActividad("Cómo hacer arroz", "Haz arroz sin que se te queme", "Aprende a hacer arroz fácil", "Bajo", "articulo", 
                new ArrayList<>(), true, 15, LocalDate.now());
        });

        assertEquals("Tipo de actividad no reconocido: articulo", exception.getMessage());
    }
    
    @Test
    void testActualizarRating() {
    	List<Reseña> reseñas = new ArrayList<>();
        Reseña reseña1 = new Reseña("Introducción a la programación", 4.5, "Interesante curso");
        Reseña reseña2 = new Reseña("Introducción a la programación", 5.0, "Excelente LearningPath. Muy buenos recursos y profesores");
        reseñas.add(reseña1);
        reseñas.add(reseña2);
        learningPath.setReseñas(reseñas);

        assertEquals(4.75, learningPath.actualizarRating(), "El rating no es el esperado");
        assertEquals(4.75, learningPath.getRating(), "El rating no es el esperado");
    }

}
