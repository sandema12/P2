package Usuario;

import java.io.Serializable;

import LearningPath.LearningPath;

public class Reseña implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6051678988131258851L;
	private String nombreLp;
	private double calificacion;
	private String feedback;
	
	public Reseña(String nombreLp, double calificacion, String feedback) {
		this.setNombreLp(nombreLp);
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


	public String getNombreLp() {
		return nombreLp;
	}


	public void setNombreLp(String nombreLp) {
		this.nombreLp = nombreLp;
	}
	
	
}
