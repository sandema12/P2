package LearningPath;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Usuario.Reseña;

public class LearningPath  implements Serializable{
	
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 498287084730697217L;
	private String titulo;
    private String descripcion;
    private String objetivo;
    private String dificultad; 
    private int duracionTotalMinutos;
    public List<Reseña> reseñas = new ArrayList<>();
    public List<Double> ratings = new ArrayList<>();
    private double rating;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private int version;
    private List<Actividad> actividades;

   
    public LearningPath(String titulo, String descripcion, String objetivo, String dificultad, int duracionTotalMinutos, double rating, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion,  int version, List<Actividad> actividades, List<Reseña> reseñas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.dificultad = dificultad;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaModificacion = LocalDateTime.now();
        this.version = version;
        this.duracionTotalMinutos = duracionTotalMinutos;
        this.rating = rating;
        this.actividades=new ArrayList<>();
        
    }

   
    public void agregarActividad(String titulo, String descripcion, String objetivo, String dificultad, String tipo, List<Pregunta> preguntas,  boolean obligatoria, int duracionMinutos, LocalDate fechaLimite) {
        
    	Actividad nuevaActividad;

        switch (tipo.toLowerCase()) {
            case "quiz":
                nuevaActividad = new Quiz(titulo, descripcion, objetivo, dificultad, tipo, preguntas, obligatoria, duracionMinutos, fechaLimite);
                break;
            case "examen":
                nuevaActividad = new Examen(titulo, descripcion, objetivo, dificultad, tipo, preguntas, obligatoria, duracionMinutos, fechaLimite);
                break;
            case "tarea":
                nuevaActividad = new Tarea(titulo, descripcion, objetivo, dificultad, tipo, preguntas, obligatoria, duracionMinutos, fechaLimite);
                break;
            case "recurso educativo":
                nuevaActividad = new RecursoEducativo(titulo, descripcion, objetivo, dificultad, tipo, preguntas, obligatoria, duracionMinutos, fechaLimite);
                break;
            default:
                throw new IllegalArgumentException("Tipo de actividad no reconocido: " + tipo);
        }

        actividades.add(nuevaActividad);

		
        
    }
    
    /*public Actividad agregarActividad(String titulo, String descripcion, String objetivo, String dificultad, String tipo,  boolean obligatoria, int duracionMinutos, LocalDate fechaLimite) {
        
    	Actividad nuevaActividad = new Actividad(titulo, descripcion, objetivo, dificultad, tipo,  obligatoria, duracionMinutos, fechaLimite);
        
		actividades.add(nuevaActividad);
		
		return nuevaActividad;
		
        
    }*/
	
    public List<Reseña> getReseñas() {
		return reseñas;
	}
    
    public ArrayList<String> getFeedbacks(LearningPath lp) {
    	
    	ArrayList<Reseña> reseñas = (ArrayList<Reseña>) lp.getReseñas();
    	ArrayList<String> feedback = new ArrayList<>();
    	
    	for (Reseña i: reseñas) {
    		String texto = i.getFeedback();
    		feedback.add(texto);
    	}
    	
		return feedback;
	}
    
    public double actualizarRating() {
    	List<Double> calificaciones = new ArrayList<>();
    	List<Reseña> reseñas = getReseñas();
    	
    	for (Reseña res: reseñas) {
    		double rating = res.getCalificacion();
    		calificaciones.add(rating);
    		
    	}
    	Double suma = 0.0;
    	    	
    	for (Double i : calificaciones) {
    		suma += i;
    	}
    	double calificacion = suma/calificaciones.size();
    	setRating(calificacion);
		return calificacion;
    	
    }


	public void setReseñas(List<Reseña> reseñas) {
		this.reseñas = reseñas;
	}

	public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getObjetivos() {
        return objetivo;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String nuevaDificultad) {
        this.dificultad = nuevaDificultad;
    }

    public int getDuracionTotalMinutos() {
        return duracionTotalMinutos;
    }  
    
    public void setDuracionTotalMinutos(int duracionTotalMinutos) {
		this.duracionTotalMinutos = duracionTotalMinutos;
	}

	public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime date) {
        this.fechaModificacion = date;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }


	public List<Double> getRatings() {
		return ratings;
	}


	public void setRatings(List<Double> ratings) {
		this.ratings = ratings;
	}
	
    public static Actividad getActividad(List<Actividad> actividades, String nombre){
    	for (Actividad act : actividades) {
            if (act.getTitulo().equalsIgnoreCase(nombre)) {
                return act;                  
            }
        }
		return null;
    }
	
	
}
