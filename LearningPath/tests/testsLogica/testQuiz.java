package testsLogica;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import LearningPath.Pregunta;
import LearningPath.Quiz;

public class testQuiz {
	
	private Quiz quiz;
	private Pregunta pregunta1, pregunta2;
    private List<Pregunta> preguntas;
    private List<String> respuestasCorrectas;
    
    @BeforeEach
    void setUp() throws Exception {
        pregunta1 = new Pregunta("¿Cuál es la capital de Colombia?", Arrays.asList("Cali", "Barranquilla", "Bogotá", "Medellín"), "3");
        pregunta2 = new Pregunta("¿Cuál es la capital de Alemania?", Arrays.asList("Berlín", "París", "Madrid","Roma"), "1");
        
        preguntas = Arrays.asList(pregunta1, pregunta2);
        
        respuestasCorrectas = Arrays.asList("3", "1");

        quiz = new Quiz("Quiz", "Quiz fácil", "Evaluar conocimientos", "Media", "Quiz", preguntas, true, 30, LocalDate.now());
    }
    
    @Test
    void testCrearExamen() {
    	assertEquals("Quiz", quiz.getTitulo(), "El título no es el esperado");
        assertEquals("Quiz fácil", quiz.getDescripcion(), "La descripción no es la esperada");
        assertEquals("Evaluar conocimientos", quiz.getObjetivo(), "El objetivo no es el esperado");
        assertEquals(30, quiz.getDuracionMinutos(), "La duración no es la esperada");
        assertEquals(preguntas, quiz.getPreguntas(), "Las preguntas no son las esperadas");
    }
    
    @Test
    void testEntregarQuiz() {
        quiz.entregarQuiz(respuestasCorrectas);

        assertEquals("Entregada", quiz.getEstado(), "El examen no se entregó con éxito");
        assertEquals(respuestasCorrectas, quiz.getRespuestasQuiz(), "Las respuestas del quiz no son las esperadas");
    }
    
    @Test
    void testAgregarPregunta() {
        Pregunta preguntaNueva = new Pregunta("¿Cuál es la capital de Inglaterra?", Arrays.asList("Berlín", "Amsterdam", "Londres", "Lisboa"), "3");
        quiz.agregarPregunta(preguntaNueva);

        assertTrue(quiz.getPreguntas().contains(preguntaNueva));
    }
    
    @Test
    void testCalificarExamenAprobado() {
        quiz.entregarQuiz(respuestasCorrectas);
        quiz.calificarQuiz();

        assertEquals("Calificado", quiz.getEstado(), "El estado del quiz no cambió");
        assertEquals("5.0", quiz.getResultado(), "El resultado no es el esperado");
    }
    
    @Test
    void testCalificarExamenNoAprobado() {
        List<String> respuestasIncorrectas = Arrays.asList("3", "4");

        quiz.entregarQuiz(respuestasIncorrectas);
        quiz.calificarQuiz();

        assertEquals("Calificado", quiz.getEstado(), "El estado del quiz no cambió");
        assertEquals("2.5", quiz.getResultado(), "El resultado no es el esperado");
    }
    
    
    @Test
    void testCalificarSinEntregar() {
        quiz.calificarQuiz();

        assertNotEquals("Calificado", quiz.getEstado(), "El estado del quiz no es el esperado");
        assertNull(quiz.getResultado());
    }
    
}
