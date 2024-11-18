package Usuario;

import LearningPath.LearningPath;

public class Reseña {

	private double calificacion;
	private String feedback;
	
	public Reseña( double calificacion, String feedback) {
		this.calificacion = calificacion;
		this.feedback = feedback;
		
	}

	
	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
}
