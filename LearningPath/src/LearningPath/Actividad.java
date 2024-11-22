package LearningPath;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import Consola.ConsolaRespuestaExamen;
import Consola.ConsolaRespuestaQuiz;
import Usuario.Estudiante;
import LearningPath.RecursoEducativo;
import LearningPath.Tarea;
import LearningPath.Quiz;
import LearningPath.Examen;

public class Actividad implements Serializable {
   
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3077444340536470283L;
	private String titulo;
    private String descripcion;
    private String objetivo;
    private String dificultad;
    private String tipo;
    private int duracionMinutos;
    private boolean obligatoria;
    private LocalDate fechaLimite;
    private String resultado;


    public Actividad(String titulo, String descripcion, String objetivo, String dificultad, String tipo,  boolean obligatoria, int duracionMinutos, LocalDate fechaLimite) {
        this.titulo = titulo;
    	this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.dificultad = dificultad;
        this.tipo = tipo;
        this.duracionMinutos = duracionMinutos;
        this.obligatoria = obligatoria;
        this.fechaLimite = fechaLimite;
        this.resultado = resultado; 
        
    }


    public void completarActividad(Actividad actividad) {
		
		if (actividad.getTipo().equalsIgnoreCase("Recurso Educativo")) {
			RecursoEducativo.completarRecurso();
    	}
		else if (actividad.getTipo().equalsIgnoreCase("Tarea")) {
			Tarea.entregarTarea();
		}
		else if (actividad.getTipo().equalsIgnoreCase("Quiz")) {
			ArrayList respuestas = new ArrayList<>();
			ConsolaRespuestaQuiz consolaRespQuiz = new ConsolaRespuestaQuiz();
			System.out.println("Estas son las preguntas del quiz: ");
			List<Pregunta> preguntas = Quiz.getPreguntas();
			for (Pregunta preg : preguntas) {
				System.out.println(preg);
				consolaRespQuiz.mostrarMenu();
			}
			respuestas = consolaRespQuiz.getRespuestas();
			Quiz.entregarQuiz(respuestas);
		}
		
		else if (actividad.getTipo().equalsIgnoreCase("Examen")) {
			List<String> respuestas = new ArrayList<>();
			ConsolaRespuestaExamen consolaRespExamen = new ConsolaRespuestaExamen();
			System.out.println("Estas son las preguntas del examen: ");
			List<Pregunta> preguntas = Examen.getPreguntas();
			for (Pregunta preg : preguntas) {
				System.out.println(preg);
				consolaRespExamen.mostrarMenu();
			}
			respuestas = consolaRespExamen.getRespuestas();
			Examen.entregarExamen(respuestas);
			
		}
        System.out.println("El estudiante ha completado la actividad");
        resultado = "Completada";
    }

	
    public LocalDate calcularFechaLimite() {
        return fechaLimite;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public boolean isObligatoria() {
        return obligatoria;
    }

    public void setObligatoria(boolean obligatoria) {
        this.obligatoria = obligatoria;
    }



    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    
	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
