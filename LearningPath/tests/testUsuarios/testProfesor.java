package testUsuarios;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import LearningPath.Actividad;
import LearningPath.LearningPath;
import Usuario.Profesor;

class testProfesor {

    private Profesor profesor;

    @BeforeEach
    void setUp() {
        profesor = new Profesor("profesor", "contraseña", "Profesor");
    }

    @AfterEach
    void tearDown() {
        Profesor.getLearningPathsCreados().clear();
    }

    @Test
    void testCrearLearningPath() {
        Profesor.crearLearningPath(
            "Curso de Spring Boot",
            "Aprender a desarrollar aplicaciones con Spring Boot",
            "Aprendizaje avanzado",
            "Avanzado",
            600
        );

        List<LearningPath> creados = Profesor.getLearningPathsCreados();
        assertEquals(1, creados.size());
        assertEquals("Curso de Spring Boot", creados.get(0).getTitulo());
        assertEquals("Avanzado", creados.get(0).getDificultad());
    }

    @Test
    void testEditarLearningPath() throws ClassNotFoundException, IOException {
        LearningPath lp = new LearningPath(
            "Curso de Docker",
            "Aprender sobre contenedores Docker",
            "Básico",
            "Curso",
            150,
            0.0,
            LocalDateTime.now(),
            LocalDateTime.now(),
            1,
            new ArrayList<>(),
            new ArrayList<>()
        );

        Profesor.editarLearningPath(
            lp, 
            "Curso avanzado de Docker", 
            "Contenedores avanzados", 
            "Avanzado", 
            200, 
            0.0, 
            LocalDateTime.now(), 
            LocalDateTime.now(), 
            1, 
            new ArrayList<>(), 
            "Titulo"
            
        );

        assertEquals("Curso avanzado de Docker", lp.getTitulo());
        assertEquals("Contenedores avanzados", lp.getDescripcion());
        assertEquals("Avanzado", lp.getDificultad());
        assertEquals(200, lp.getDuracionTotalMinutos());
    }

    @Test
    void testCalificarActividad() {
        List<Actividad> actividades = new ArrayList<>();
        actividades.add(new Actividad("Actividad 1", "Descripción 1", "Objetivo", "Dificultad", "tarea", null, false, 60, LocalDate.now()));
        LearningPath lp = new LearningPath(
            "Curso de JavaScript",
            "Aprender JavaScript moderno",
            "Intermedio",
            "Curso",
            300,
            0.0,
            LocalDateTime.now(),
            LocalDateTime.now(),
            1,
            actividades,
            new ArrayList<>()
        );

        Profesor.calificarActividad("usuario3", "Curso de JavaScript", "Actividad 1", "95");

        assertEquals("95", actividades.get(0).getResultado());
    }

    @Test
    void testAñadirReseña() {
        LearningPath lp = new LearningPath(
            "Curso de Machine Learning",
            "Aprender conceptos básicos de Machine Learning",
            "Avanzado",
            "Curso",
            400,
            0.0,
            LocalDateTime.now(),
            LocalDateTime.now(),
            1,
            new ArrayList<>(),
            new ArrayList<>()
        );

        Profesor.getLearningPathsCreados().add(lp);

        try {
            Profesor.añadirReseña("Curso de Machine Learning", 4.5, "Excelente curso");
            Profesor.añadirReseña("Curso de Machine Learning", 5.0, "Muy claro y práctico");
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }

        assertEquals(2, lp.getReseñas().size());
        assertEquals(4.75, lp.getRating(), 0.01);
    }
}
