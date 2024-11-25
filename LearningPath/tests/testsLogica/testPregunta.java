package testsLogica;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import LearningPath.Pregunta;

public class testPregunta  {

	private Pregunta pregunta;
	List<String> opciones = new ArrayList<>();
	
	 @BeforeEach
	void setUp() throws Exception {
		 opciones = Arrays.asList("Marte", "Tierra", "Mercurio", "Venus");
	     pregunta = new Pregunta("¿Cuál es primer planeta del sistema solar?", opciones, "3");
	 }
	@Test
    void testAgregarPregunta() {
        assertEquals("¿Cuál es primer planeta del sistema solar?", pregunta.getEnunciado());
        assertEquals(opciones, pregunta.getOpciones());
        assertEquals("3", pregunta.getRespuestaCorrecta());
    }
}
