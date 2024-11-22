package LearningPath;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Usuario.Estudiante;

public class Quiz extends Actividad {

	private static String estado;
	
	public Quiz(String titulo, String descripcion, String objetivo, String dificultad, String tipo, boolean obligatoria,
			int duracionMinutos, LocalDate fechaLimite) {
		super(titulo, descripcion, objetivo, dificultad, tipo, obligatoria, duracionMinutos, fechaLimite);
		this.preguntas = new ArrayList<>();
        this.notaMinima = notaMinima;
        this.estado = "Pendiente";
	}

	private static List<Pregunta> preguntas;
    private double notaMinima;


    public static void entregarQuiz(ArrayList respuestas) {
    	if (estado.equals("Pendiente")) {
            estado = "Entregada";
            System.out.println("El quiz ha sido entregado.");
        } else {
            System.out.println("El quiz ya ha sido entregado.");
        }
    }

    public void agregarPregunta(Pregunta pregunta) {
        preguntas.add(pregunta);
        System.out.println("Pregunta agregada: " + pregunta.getEnunciado());
    }

    public void calificarQuiz(Estudiante estudiante, List<String> respuestas) {
        double puntajeObtenido = 0;
        for (int i = 0; i < preguntas.size(); i++) {
            Pregunta pregunta = preguntas.get(i);
            if (pregunta.verificarRespuesta(respuestas.get(i))) {
                puntajeObtenido += pregunta.getPuntaje();
            }
        }

        if (puntajeObtenido >= notaMinima) {
            System.out.println("El estudiante aprobó el quiz con una nota de: " + puntajeObtenido);
            //completarActividad(estudiante);
        } else {
            System.out.println("El estudiante no aprobó el quiz. Nota obtenida: " + puntajeObtenido);
        }
    }


    public static List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public double getNotaMinima() {
        return notaMinima;
    }

    public void setNotaMinima(double notaMinima) {
        this.notaMinima = notaMinima;
    }
}
