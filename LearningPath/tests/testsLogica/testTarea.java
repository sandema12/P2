package testsLogica;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import LearningPath.Tarea;

public class testTarea {

	private Tarea tarea;
	
	@BeforeEach
    void setUp() throws Exception {
           
        tarea = new Tarea("Tarea", "Ensayo sobre la mitocondria", "Aprender sobre la mitocondria", "Alta", "Tarea",
                null, true, 60, LocalDate.now());
    }
	
	@Test
    void testCrearRecurso() {
    	assertEquals("Tarea", tarea.getTitulo(), "El título no es el esperado");
        assertEquals("Ensayo sobre la mitocondria", tarea.getDescripcion(), "La descripción no es la esperada");
        assertEquals("Aprender sobre la mitocondria", tarea.getObjetivo(), "El objetivo no es el esperado");
        assertEquals("Alta", tarea.getDificultad(), "La dificultad no es la esperada");
        assertEquals("Tarea", tarea.getTipo(), "El tipo no es el esperado");
        assertTrue(tarea.isObligatoria());
        assertEquals(60, tarea.getDuracionMinutos(), "La duración no es la esperada");
    }
	
	@Test
    void testCompletarRecurso() {
        tarea.entregarTarea();

        assertEquals("Entregada", tarea.getEstado(), "La tarea no se entregó con éxito");
    }
	
	@Test
    void testCalificarTareaExitosa() {
        tarea.entregarTarea();
        tarea.calificarTarea("Exitoso");

        assertEquals("Calificado", tarea.getEstado(), "El estado de la tarea no cambió");
        assertEquals("Exitoso", tarea.getResultado(), "El resultado no es el esperado");
    }
}
