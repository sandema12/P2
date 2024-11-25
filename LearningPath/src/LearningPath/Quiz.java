package LearningPath;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Usuario.Estudiante;

public class Quiz extends Actividad {

	private String estado;
	private List<String> respuestasQuiz;
	private List<Pregunta> preguntas;
	private double notaMinima;
	
	public Quiz(String titulo, String descripcion, String objetivo, String dificultad, String tipo, List<Pregunta> preguntas,
			boolean obligatoria, int duracionMinutos, LocalDate fechaLimite) {
		super(titulo, descripcion, objetivo, dificultad, tipo, preguntas, obligatoria, duracionMinutos, fechaLimite);
		this.preguntas = new ArrayList<>(preguntas);
        this.notaMinima = 3.0;
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

    public float calificarQuiz() {
    	if (estado.equals("Entregada")) {
	        float puntajeObtenido = 0;
	        int correctas = 0;
	        for (int i = 0; i < preguntas.size(); i++) {
	            Pregunta pregunta = preguntas.get(i);
	            if (pregunta.verificarRespuesta(respuestasQuiz.get(i))) {
	            	correctas++;	                
	            }
	            puntajeObtenido = (float) ((correctas*5)/(double)preguntas.size());
	        }
	        estado = "Calificado";
	        if (puntajeObtenido >= notaMinima) {
	            System.out.println("El estudiante aprobó el quiz con una nota de: " + puntajeObtenido);
	        } else {
	            System.out.println("El estudiante no aprobó el quiz. Nota obtenida: " + puntajeObtenido);
	        }
	        super.setResultado(String.valueOf(puntajeObtenido));
	        return puntajeObtenido;
    	} else {
    		System.out.println("No se puede calificar un quiz que no ha sido entregado.");
    		return -1;
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
    
    public List<String> getRespuestasQuiz() {
		return respuestasQuiz;
	}
}
