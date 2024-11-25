package LearningPath;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class RecursoEducativo extends Actividad {
	
	private String tipo;
	private String estado;

	public RecursoEducativo(String titulo, String descripcion, String objetivo, String dificultad, String tipo, List<Pregunta> preguntas, 
			boolean obligatoria, int duracionMinutos, LocalDate fechaLimite) {
		super(titulo, descripcion, objetivo, dificultad, tipo, preguntas, obligatoria, duracionMinutos, fechaLimite);
		this.tipo = tipo;
		this.estado = "Pendiente";
	
	}
	
	public void completarRecurso() {
		if (estado.equals("Pendiente")) {
            estado = "Completado";
            System.out.print("Se ha completado el recurso eduactivo exitosamente. \n");
        } else {
            System.out.println("El recurso educativo ya ha sido entregado.");
        }
		
		
	}
	
	public String getEstado() {
        return estado;
    }
	
	public String getTipo() {
        return tipo;
    }

}
