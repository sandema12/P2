package LearningPath;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import Consola.ConsolaRespuestaExamen;
import Consola.ConsolaRespuestaQuiz;

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
    private List<Pregunta> preguntas;
    private int duracionMinutos;
    private boolean obligatoria;
    private LocalDate fechaLimite;
    private String resultado;


    public Actividad(String titulo, String descripcion, String objetivo, String dificultad, String tipo, List<Pregunta> preguntas,  boolean obligatoria, int duracionMinutos, LocalDate fechaLimite) {
        this.titulo = titulo;
    	this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.dificultad = dificultad;
        this.tipo = tipo;
        this.preguntas = preguntas;
        this.duracionMinutos = duracionMinutos;
        this.obligatoria = obligatoria;
        this.fechaLimite = fechaLimite;
        
    }


    public void completarActividad(Actividad actividad) {
		System.out.println("Tipo de actividad: "+ actividad.getTipo());
		
		if (actividad.getTipo().equalsIgnoreCase("Recurso Educativo")) {
			if (actividad instanceof RecursoEducativo) {
				RecursoEducativo recursoEducativo = (RecursoEducativo) actividad;
				recursoEducativo.completarRecurso();
			}
    	}
		else if (actividad.getTipo().equalsIgnoreCase("Tarea")) {
			if (actividad instanceof Tarea) {
			    Tarea tarea = (Tarea) actividad;
			    tarea.entregarTarea();
			}
		}
		else if (actividad.getTipo().equalsIgnoreCase("Quiz")) {
			List<String> respuestas = new ArrayList<>();
			ConsolaRespuestaQuiz consolaRespQuiz = new ConsolaRespuestaQuiz();
			System.out.println("Estas son las preguntas del quiz: ");
			List<Pregunta> preguntas = actividad.getPreguntas();
			for (Pregunta preg : preguntas) {
				int x=1;
				System.out.println("Pregunta #"+x+": " + preg.getEnunciado());
				List<String> opciones = preg.getOpciones();
				int i=1;
				for(String opcion : opciones) {
					System.out.println("Opcion "+i+": " + opcion);
					i++;
				}
				x++;
				consolaRespQuiz.mostrarMenu();
			}
			respuestas = consolaRespQuiz.getRespuestas();
			if (actividad instanceof Quiz) {
	            Quiz quiz = (Quiz) actividad;  
	            quiz.entregarQuiz(respuestas); 
			}
			
		}
		else if (actividad.getTipo().equalsIgnoreCase("Examen")) {
			List<String> respuestas = new ArrayList<>();
			ConsolaRespuestaExamen consolaRespExamen = new ConsolaRespuestaExamen();
			System.out.println("Estas son las preguntas del examen: ");
			List<Pregunta> preguntas = actividad.getPreguntas();
			for (Pregunta preg : preguntas) {
				System.out.println("Pregunta: " + preg.getEnunciado());
				consolaRespExamen.mostrarMenu();
			}
			respuestas = consolaRespExamen.getRespuestas();
			if (actividad instanceof Examen) {
	            Examen examen = (Examen) actividad;  
	            examen.entregarExamen(respuestas); 
			}
			
		}
        System.out.println("El estudiante ha completado la actividad");
        System.out.println("------------------------------");
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
	
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}
	
	
    public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}


	public ArrayList<String> getEnunciados(Actividad actividad) {
    	
    	ArrayList<Pregunta> preguntas = (ArrayList<Pregunta>) actividad.getPreguntas();
    	ArrayList<String> enunciados = new ArrayList<>();
    	
    	for (Pregunta i: preguntas) {
    		String texto = i.getEnunciado();
    		enunciados.add(texto);
    	}
    	
		return enunciados;
	}
	
}
