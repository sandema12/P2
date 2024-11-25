package LearningPath;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Usuario.Estudiante;

public class Quiz extends Actividad {

	private String estado;
	private List<String> respuestasQuiz;
	private static List<Pregunta> preguntas;
	private double notaMinima;
	
	public Quiz(String titulo, String descripcion, String objetivo, String dificultad, String tipo, List<Pregunta> preguntas,
			boolean obligatoria, int duracionMinutos, LocalDate fechaLimite) {
		super(titulo, descripcion, objetivo, dificultad, tipo, preguntas, obligatoria, duracionMinutos, fechaLimite);
		this.preguntas = preguntas;
        this.notaMinima = notaMinima;
        this.estado = "Pendiente";
	}


	public void entregarQuiz(List<String> respuestas) {
    	if (estado.equals("Pendiente")) {
    		this.respuestasQuiz = respuestas;
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
        } else {
            System.out.println("El estudiante no aprobó el quiz. Nota obtenida: " + puntajeObtenido);
        }
    }


    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public double getNotaMinima() {
        return notaMinima;
    }

    public void setNotaMinima(double notaMinima) {
        this.notaMinima = notaMinima;
    }
    
    public String getEstado() {
    	return estado;
    }
}
