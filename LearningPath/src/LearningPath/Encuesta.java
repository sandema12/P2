package LearningPath;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Usuario.Estudiante;

public class Encuesta extends Actividad  {

    public Encuesta(String titulo, String descripcion, String objetivo, String dificultad, String tipo, List<Pregunta> preguntas,
			boolean obligatoria, int duracionMinutos, LocalDate fechaLimite) {
		super(titulo, descripcion, objetivo, dificultad, tipo, preguntas, obligatoria, duracionMinutos, fechaLimite);
		this.preguntas = new ArrayList<>();
	}

	private List<PreguntaAbierta> preguntas;

    

    public void agregarPregunta(PreguntaAbierta pregunta) {
        preguntas.add(pregunta);
        System.out.println("Pregunta abierta agregada: " + pregunta.getEnunciado());
    }

    public void completarEncuesta(Estudiante estudiante, List<String> respuestas) {
        System.out.println("El estudiante ha completado la encuesta: " + getDescripcion());
        for (int i = 0; i < preguntas.size(); i++) {
            PreguntaAbierta pregunta = preguntas.get(i);
            System.out.println("Respuesta a la pregunta \"" + pregunta.getEnunciado() + "\": " + respuestas.get(i));
        }
    }


    public List getPreguntas() {
        return preguntas;
    }

}
