package LearningPath;

import java.time.LocalDate;

public class RecursoEducativo extends Actividad {
	
	private String tipo;

	public RecursoEducativo(String titulo, String descripcion, String objetivo, String dificultad, String tipo,
			boolean obligatoria, int duracionMinutos, LocalDate fechaLimite) {
		super(titulo, descripcion, objetivo, dificultad, tipo, obligatoria, duracionMinutos, fechaLimite);
	
	}
	
	public static void completarRecurso() {
		System.out.print("Se ha completado el recurso de tipo exitosamente.");
	}
	
	

}
