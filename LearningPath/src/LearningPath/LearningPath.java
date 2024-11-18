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
        this.duracionTotalMinutos = 0;
        this.rating = 0.0;
        
    }

   
    public static void agregarActividad(String titulo, String descripcion, String objetivo, String dificultad, String tipo,  boolean obligatoria, int duracionMinutos, LocalDate fechaLimite) {
        
    	Actividad nuevaActividad = new Actividad(titulo, descripcion, objetivo, dificultad, tipo,  obligatoria, duracionMinutos, fechaLimite);
        
		actividades.add(nuevaActividad);
		
        
    }
    
//    public double calcularRating() {
//        if (actividades.isEmpty()) {
//            System.out.println("No hay actividades disponibles para calcular el rating.");
//            return 0.0;
//        }
//
//        double sumaRatings = 0.0;
//        int cantidadRatings = 0;
//
//        for (Actividad actividad : actividades) {
//            
//            double ratingActividad = getRating(); 
//            if (ratingActividad >= 0) { 
//                sumaRatings += ratingActividad;
//                cantidadRatings++;
//            }
//        }
//
//        if (cantidadRatings == 0) {
//            System.out.println("No hay ratings válidos para calcular el promedio.");
//            return 0.0;
//        }
//
//        // Calcular promedio
//        this.rating = sumaRatings / cantidadRatings;
//        System.out.println("El nuevo rating promedio del Learning Path es: " + this.rating);
//        return this.rating;
//    }


	public static void añadirReseña(LearningPath lp, double calificacion, String feedback) {
		Reseña reseña = new Reseña(lp, calificacion, feedback);
	    
	    reseñas.add(reseña);
	    //actualizarRatingPromedio();
		
	}
	
//	private static void actualizarRatingPromedio() {
//        double sumaCalificaciones = reseñas.stream().mapToDouble(Reseña::getCalificacion).sum();
//        double rating = sumaCalificaciones / reseñas.size();
//    }

    public static List<Reseña> getReseñas() {
		return reseñas;
	}
    
    public void actualizarRating() {
    	double rating;
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
}
