package testUsuarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LearningPath.LearningPath;
import Usuario.Estudiante;

public class testEstudiante {

    private Estudiante estudiante;

    @Before
    public void setUp() {
        estudiante = new Estudiante("usuario", "contraseña", "Estudiante");
    }

    @After
    public void limpiarEstado() {
        estudiante.getLearningPathsInscritos().clear();
        estudiante.getCalificaciones().clear();
    }

    // PRUEBAS UNITARIAS
    @Test
    public void testInscribirseEnLearningPath() {
        LearningPath lp = new LearningPath(
            "Curso de Java",
            "Aprende programación en Java desde cero",
            "Intermedio",
            "Curso",
            300,
            0.0,
            LocalDateTime.now(),
            LocalDateTime.now().plusDays(10),
            1,
            new ArrayList<>(),
            new ArrayList<>()
        );

        estudiante.inscribirseEnLearningPath(lp);
        List<LearningPath> inscritos = estudiante.getLearningPathsInscritos();

        assertEquals(1, inscritos.size());
        assertEquals("Curso de Java", inscritos.get(0).getTitulo());
    }

    @Test
    public void testInscribirseEnLearningPathDuplicado() {
        LearningPath lp = new LearningPath(
            "Curso de Python",
            "Aprender Python básico",
            "Básico",
            "Curso",
            200,
            0.0,
            LocalDateTime.now(),
            LocalDateTime.now(),
            1,
            new ArrayList<>(),
            new ArrayList<>()
        );

        estudiante.inscribirseEnLearningPath(lp);
        estudiante.inscribirseEnLearningPath(lp);

        List<LearningPath> inscritos = estudiante.getLearningPathsInscritos();
        assertEquals(1, inscritos.size());
    }

    @Test
    public void testVerCalificaciones() {
        estudiante.getCalificaciones().add("Actividad 1: 90");
        estudiante.getCalificaciones().add("Actividad 2: 80");

        List<String> calificaciones = estudiante.getCalificaciones();

        assertNotNull(calificaciones);
        assertEquals(2, calificaciones.size());
        assertEquals("Actividad 1: 90", calificaciones.get(0));
    }
}
