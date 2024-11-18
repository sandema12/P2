package LearningPath;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import Usuario.Estudiante;
import LearningPath.RecursoEducativo;
import LearningPath.Tarea;
import LearningPath.Quiz;
import LearningPath.Examen;

public class Actividad {
   
	private String titulo;
    private String descripcion;
    private String objetivo;
    private String dificultad;
    private String tipo;
    private int duracionMinutos;
    private boolean obligatoria;
    private LocalDate fechaLimite;
    private static String resultado;


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


	public static void completarActividad(Actividad actividad) {
		
		if (actividad.getTipo().equalsIgnoreCase("Recurso Educativo")) {
			RecursoEducativo.completarRecurso();
    	}
		else if (actividad.getTipo().equalsIgnoreCase("Tarea")) {
			Tarea.entregarTarea();
		}
		else if (actividad.getTipo().equalsIgnoreCase("Quiz")) {
			System.out.println("Estas son las preguntas a resolver");
			List<Pregunta> preguntas = Quiz.getPreguntas();
			for (Pregunta preg : preguntas) {
				System.out.println(preg);
			}
		}
		else if (actividad.getTipo().equalsIgnoreCase("Examen")) {
			System.out.println("Estas son las preguntas a resolver");
			List<Pregunta> preguntas = Examen.getPreguntas();
			for (Pregunta preg : preguntas) {
				System.out.println(preg);
			}
		}
        System.out.println("El estudiante ha completado la actividad");
        resultado = "Completada";
    }

    public boolean verificarPrerequisitos(Estudiante estudiante) {
        System.out.println("Verificando requisitos previos para la actividad: " + descripcion);

        return true; 
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
