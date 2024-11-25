package testsLogica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import LearningPath.LearningPath;
import LearningPath.Pregunta;
import Usuario.Estudiante;
import Usuario.Profesor;

public class testEstudianteInscribirLP {
	
	private Profesor profesor;
    private Estudiante estudiante;
    private LearningPath lp;
    private List<Pregunta> preguntas;
    @SuppressWarnings("static-access")
	@BeforeEach
    public void setUp() {
        profesor = new Profesor("profe", "profeCool", "Profesor");

        estudiante = new Estudiante("estudiante", "123", "Estudiante");

        lp = profesor.crearLearningPath("Cocina", "Hacer pasta", "Aprender a hacer pasta", "Medio", 45);
        
        lp.agregarActividad("Pasta al dente", "Trucos para una pasta perfecta", "Aprender a dejar la pasta al dente", "Medio", "recurso educativo", 
				preguntas, false, 15, LocalDate.now());
        
    }
    
    @SuppressWarnings("static-access")
	@Test
    public void testInscribirLearningPath() {        
        estudiante.inscribirseEnLearningPath(lp);
        
        assertTrue(estudiante.getLearningPathsInscritos().contains(lp), "El estudiante no inscrito en el LP");
        assertEquals(1, lp.getActividades().size(), "No hay actividades inscritas");
        assertEquals("Pasta al dente", lp.getActividades().get(0).getTitulo());
        assertEquals(15, lp.getActividades().get(0).getDuracionMinutos());
    }
    
    @SuppressWarnings("static-access")
	@Test
    public void testCompletarActividad() {
        estudiante.inscribirseEnLearningPath(lp);
        estudiante.completarActividad(lp.getActividades().get(0));

        assertEquals("Completada", lp.getActividades().get(0).getResultado(), "El recurso educativo no se completó con éxito");
    }

}
