package testsLogica;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import LearningPath.LearningPath;
import LearningPath.Pregunta;
import Usuario.Profesor;

public class testProfesorCreaLP {
	
	private Profesor profesor;
	private LearningPath lp;
	private Pregunta pregunta1, pregunta2;
    private List<Pregunta> preguntas;
	
	@BeforeEach
    void setUp() throws Exception {
		profesor = new Profesor("profe", "profeCool", "Profesor");
		lp = new LearningPath("Cocina", "Hacer pasta", "Aprender a hacer pasta", "Medio", 45, 0, LocalDateTime.now(), LocalDateTime.now(), 1, 
								new ArrayList<>(), new ArrayList<>());
		
		pregunta1 = new Pregunta("¿Qué ingrediente no hace parte de la pasta?", Arrays.asList("Harina", "Huevo", "Agua", "Ajo"), "4");
        pregunta2 = new Pregunta("¿Qué rango de tiempo en minutos se tiene que dejar la pasta cocinando para que quede al dente?", 
        							Arrays.asList("8-12", "5-6", "15-18","20-22"), "1");
        
        preguntas = Arrays.asList(pregunta1, pregunta2);
	}
	
	@SuppressWarnings("static-access")
	@Test
    void testProfesor_CrearLearningPath_AgregarActividad() {
		lp = profesor.crearLearningPath("Cocina", "Hacer pasta", "Aprender a hacer pasta", "Medio", 45);
		
		assertNotNull(lp);
        assertEquals("Cocina", lp.getTitulo(), "El título del lp no es el esperado");
        assertEquals("Hacer pasta", lp.getDescripcion(), "La descripción del lp no es la esperada");
        assertEquals("Aprender a hacer pasta", lp.getObjetivos(), "El objetivo del lp no es el esperado");
        assertEquals("Medio", lp.getDificultad(), "La dificultad del lp no es la esperada");
        assertEquals(45, lp.getDuracionTotalMinutos(), "La duración del lp no es la esperada");
        assertEquals(0, lp.getActividades().size()); 
        
        lp.agregarActividad("Pasta al dente", "Trucos para una pasta perfecta", "Aprender a dejar la pasta al dente", "Medio", "quiz", 
        						preguntas, false, 15, LocalDate.now());
        
        assertEquals(1, lp.getActividades().size());
        assertEquals("Pasta al dente", lp.getActividades().get(0).getTitulo(), "El título de la actividad no es el esperado");
        assertEquals(15, lp.getActividades().get(0).getDuracionMinutos(), "La duración de la actividad no es la esperada");
        
        assertTrue(profesor.getLearningPathsCreados().contains(lp));
        
	}

}
