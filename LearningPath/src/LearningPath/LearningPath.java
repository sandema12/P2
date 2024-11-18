package LearningPath;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Usuario.Reseña;

public class LearningPath {
    
    private String titulo;
    private String descripcion;
    private String dificultad; 
    private int duracionTotalMinutos;
    public static List<Reseña> reseñas = new ArrayList<>();
    public static List<Double> ratings = new ArrayList<>();
    private static double rating;
    private Date fechaCreacion;
    private LocalDateTime fechaModificacion;
    private int version;
    private static List<Actividad> actividades = new ArrayList<>();

   
    public LearningPath(String titulo, String descripcion, String dificultad, String tipo, int duracionTotalMinutos, double rating, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion,  int version, List<Actividad> actividades, List<Reseña> reseñas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        this.fechaCreacion = new Date();
        this.fechaModificacion = LocalDateTime.now();
        this.version = version;
        this.duracionTotalMinutos = duracionTotalMinutos;
        this.rating = 0.0;
        
    }

   
    public static void agregarActividad(String titulo, String descripcion, String objetivo, String dificultad, String tipo,  boolean obligatoria, int duracionMinutos, LocalDate fechaLimite) {
        
    	Actividad nuevaActividad = new Actividad(titulo, descripcion, objetivo, dificultad, tipo,  obligatoria, duracionMinutos, fechaLimite);
        
		actividades.add(nuevaActividad);
		
        
    }
	
    public static List<Reseña> getReseñas() {
		return reseñas;
	}
    
    public void actualizarRating() {
    	List<Double> calificaciones = getRatings();
    	Double suma = 0.0;
    	    	
    	for (Double i : calificaciones) {
    		suma += i;
    	}
    	double calificacion = suma/calificaciones.size();
    	setRating(calificacion);
    	
    }


	public static void setReseñas(List<Reseña> reseñas) {
		LearningPath.reseñas = reseñas;
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

    public Date getFechaCreacion() {
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

    public static List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }


	public static List<Double> getRatings() {
		return ratings;
	}


	public static void setRatings(List<Double> ratings) {
		LearningPath.ratings = ratings;
	}
}
