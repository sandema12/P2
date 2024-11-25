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

import LearningPath.Examen;
import LearningPath.Pregunta;

public class testExamen {
	
	private Examen examen;
    private Pregunta pregunta1, pregunta2;
    private List<String> respuestasCorrectas;

    @BeforeEach
    void setUp() throws Exception {
        pregunta1 = new Pregunta("¿Cuál es la capital de Colombia?", Arrays.asList("Cali", "Barranquilla", "Bogotá", "Medellín"), "3");
        pregunta2 = new Pregunta("¿Cuál es la capital de Alemania?", Arrays.asList("Berlín", "París", "Madrid","Roma"), "1");
        
        List<Pregunta> preguntas = Arrays.asList(pregunta1, pregunta2);

        respuestasCorrectas = Arrays.asList("3", "1");
    
        examen = new Examen("Examen", "Examen fácil", "Evaluar conocimientos", "Media", "Examen",
                preguntas, true, 30, LocalDate.now());
    }

    @Test
    void testEntregarExamen() {
        examen.entregarExamen(respuestasCorrectas);
        assertEquals("Entregado", examen.getEstado(), "El examen no se entregó con éxito");
    }

    @Test
    void testEntregarExamenDosVeces() {
        examen.entregarExamen(respuestasCorrectas);
        assertEquals("Entregado", examen.getEstado(), "El examen no se entregó con éxito");
        
        examen.entregarExamen(respuestasCorrectas);
        assertEquals("Entregado", examen.getEstado());
    }

    @Test
    void testAgregarPregunta() {
        Pregunta preguntaNueva = new Pregunta("¿Cuál es la capital de Inglaterra?", Arrays.asList("Berlín", "Amsterdam", "Londres", "Lisboa"), "3");
        examen.agregarPregunta(preguntaNueva);

        assertTrue(examen.getPreguntas().contains(preguntaNueva));
    }

    @Test
    void testCalificarExamenAprobado() {
        examen.entregarExamen(respuestasCorrectas);
        examen.calificarExamen();

        assertEquals("Calificado", examen.getEstado(), "El estado del examen no cambió");
        assertEquals("5.0", examen.getResultado(), "El resultado no es el esperado");
    }

    @Test
    void testCalificarExamenNoAprobado() {
        List<String> respuestasIncorrectas = Arrays.asList("2", "4");

        examen.entregarExamen(respuestasIncorrectas);
        examen.calificarExamen();

        assertEquals("Calificado", examen.getEstado(), "El estado del examen no cambió");
        assertEquals("0.0", examen.getResultado(), "El resultado no es el esperado");
    }

    @Test
    void testCalificarSinEntregar() {
        examen.calificarExamen();

        assertNotEquals("Calificado", examen.getEstado(), "El estado del examen no es el esperado");
        assertNull(examen.getResultado());
    }
}
