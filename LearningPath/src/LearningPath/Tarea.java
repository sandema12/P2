package LearningPath;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Tarea extends Actividad {

	private String estado; 

    public Tarea(String titulo, String descripcion, String objetivo, String dificultad, String tipo, List<Pregunta> preguntas, 
			boolean obligatoria, int duracionMinutos, LocalDate fechaLimite) {
		super(titulo, descripcion, objetivo, dificultad, tipo, preguntas, obligatoria, duracionMinutos, fechaLimite);
		this.estado = "Pendiente";
	}

    public void entregarTarea() {
        if (estado.equals("Pendiente")) {
            estado = "Entregada";
            System.out.println("La tarea ha sido entregada.");
        } else {
            System.out.println("La tarea ya ha sido entregada.");
        }
    }

    public String calificarTarea(String resultado) {
        if (estado.equals("Entregada")) {
            estado = "Calificado";
            setResultado(resultado);
            System.out.println("La tarea ha sido calificada de forma: " + resultado);
        } else {
            System.out.println("No se puede calificar una tarea que no ha sido entregada.");
        }
        return resultado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
