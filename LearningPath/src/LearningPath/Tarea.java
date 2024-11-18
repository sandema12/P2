package LearningPath;

import java.time.LocalDate;

public class Tarea extends Actividad {

    public Tarea(String titulo, String descripcion, String objetivo, String dificultad, String tipo,
			boolean obligatoria, int duracionMinutos, LocalDate fechaLimite) {
		super(titulo, descripcion, objetivo, dificultad, tipo, obligatoria, duracionMinutos, fechaLimite);
		this.estado = "Pendiente";
	}

	private static String estado; 



    public static void entregarTarea() {
        if (estado.equals("Pendiente")) {
            estado = "Entregada";
            System.out.println("La tarea ha sido entregada.");
        } else {
            System.out.println("La tarea ya ha sido entregada.");
        }
    }

    public void calificarTarea(String resultado) {
        if (estado.equals("Entregada")) {
            estado = "Calificada";
            setResultado(resultado);
            System.out.println("La tarea ha sido calificada con: " + resultado);
        } else {
            System.out.println("No se puede calificar una tarea que no ha sido entregada.");
        }
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
