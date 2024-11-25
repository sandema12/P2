package testsLogica;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import LearningPath.RecursoEducativo;

public class testRecursoEducativo {

	private RecursoEducativo recurso;
	
	@BeforeEach
    void setUp() throws Exception {
           
        recurso = new RecursoEducativo("Video", "Video sobre la mitocondria", "Aprender sobre la mitocondria", "Media", "Recurso Educativo",
                null, true, 15, LocalDate.now());
    }
	
	@Test
    void testCrearRecurso() {
    	assertEquals("Video", recurso.getTitulo(), "El título no es el esperado");
        assertEquals("Video sobre la mitocondria", recurso.getDescripcion(), "La descripción no es la esperada");
        assertEquals("Aprender sobre la mitocondria", recurso.getObjetivo(), "El objetivo no es el esperado");
        assertEquals("Media", recurso.getDificultad(), "La dificultad no es la esperada");
        assertEquals("Recurso Educativo", recurso.getTipo(), "El tipo no es el esperado");
        assertTrue(recurso.isObligatoria());
        assertEquals(15, recurso.getDuracionMinutos(), "La duración no es la esperada");
    }
	
	@Test
    void testCompletarRecurso() {
        recurso.completarRecurso();

        assertEquals("Completado", recurso.getEstado(), "El recurso no se entregó con éxito");
    }
}
