package LearningPath;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Examen extends Actividad  {
    private List<Pregunta> preguntas;
    private String estado; 
    private List<String> respuestasExamen;
    
    
    public Examen(String titulo, String descripcion, String objetivo, String dificultad, String tipo, List<Pregunta> preguntas,
			boolean obligatoria, int duracionMinutos, LocalDate fechaLimite) {
		super(titulo, descripcion, objetivo, dificultad, tipo, preguntas, obligatoria, duracionMinutos, fechaLimite);
		this.preguntas = new ArrayList<>(preguntas);
        this.estado = "Pendiente";
	}
    
    public void entregarExamen(List<String> respuestas) {
        if (estado.equals("Pendiente")) {
        	respuestasExamen = respuestas;
            estado = "Entregado";
            System.out.println("El examen ha sido entregado.");
        } else {
            System.out.println("El examen ya ha sido entregado.");
        }
    }

    public void agregarPregunta(Pregunta pregunta) {
        preguntas.add(pregunta);
        System.out.println("Pregunta agregada al examen: " + pregunta.getEnunciado());
    }


    public float calificarExamen() {
    	if (estado.equals("Entregado")) {
	        float puntajeObtenido = 0;
	        int correctas = 0;
	        for (int i = 0; i < preguntas.size(); i++) {
	            Pregunta pregunta = preguntas.get(i);
	            if (pregunta.verificarRespuesta(respuestasExamen.get(i))) {
	            	correctas++;                
	            }
	            puntajeObtenido = (float) ((correctas*5)/(double)preguntas.size());
	        }
	        estado = "Calificado";
	        setResultado("Nota obtenida: " + puntajeObtenido);
	        System.out.println("El examen del estudiante ha sido calificado con: " + puntajeObtenido);
	        super.setResultado(String.valueOf(puntajeObtenido));
	        return puntajeObtenido;
    	} else {
    		System.out.println("No se puede calificar una tarea que no ha sido entregada.");
    		return -1;
    	}
    }
    

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

	public List<String> getRespuestasExamen() {
		return respuestasExamen;
	}
    
    
}
