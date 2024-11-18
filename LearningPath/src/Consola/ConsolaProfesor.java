package Consola;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import LearningPath.Actividad;
import LearningPath.LearningPath;
import Usuario.Profesor;


public class ConsolaProfesor {
	

    private Scanner entrada;
    
    public ConsolaProfesor() {
        
        entrada = new Scanner(System.in);
    }
    
    public void mostrarMenu() {
		
        int opcion;
        
        do {
        
            System.out.println("1. Crear Learning Path");
            System.out.println("2. Editar Learning Path");
            System.out.println("3. Calificar actividad");
            System.out.println("4. Dejar reseña");
            System.out.println("5. Ver Learning Path");
            System.out.println("6. Volver");
            System.out.print("Elija una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();
            
            
            switch (opcion) {
            
            //Crear learningpath
            case 1:
            	System.out.print("Nombre del Learning Path: ");
                String titulo = entrada.nextLine();
                
                System.out.print("Descripción: ");
                String descripcion = entrada.nextLine();
                
                System.out.print("Objetivo: ");
                String objetivos = entrada.nextLine();
                
                System.out.print("Dificultad: ");
                String dificultad = entrada.nextLine();
                
                System.out.print("Duración total en minutos: ");
                int duracionMinutos = Integer.parseInt(entrada.nextLine());
            	
                Profesor.crearLearningPath(titulo, descripcion, objetivos, dificultad, duracionMinutos);
                break;
                
                
                
                
            //Editar learningpath
            case 2:
            	
            	System.out.println("Ingrese el nombre del Learning Path a modificar");
            	String nombre = entrada.nextLine();
            	List<LearningPath> lp_Lista = Profesor.getLearningPathsCreados();
            	LearningPath lp = Profesor.getLearningPath(lp_Lista, nombre);
            	
            	System.out.println("Detalles actuales del Learning Path:");
        	    System.out.println("Título: " + lp.getTitulo());
        	    System.out.println("Descripción: " + lp.getDescripcion());
        	    System.out.println("Dificultad: " + lp.getDificultad());
        	    System.out.println("Duración total en minutos: " + lp.getDuracionTotalMinutos());
        	    System.out.println("Fecha creacion: " + lp.getFechaCreacion());
        	    System.out.println("Fecha de modificacion " + lp.getFechaModificacion());
        	    System.out.println("Rating: " + lp.getRating());
        	    System.out.println("Versión: " + lp.getVersion());
        	    System.out.println("Reseñas: " + lp.getReseñas());
        	    
        	    
        	    System.out.print("Nuevo título (dejar en blanco para no cambiar): ");
        	    String nuevoTitulo = entrada.nextLine();
        	    

        	    System.out.print("Nueva descripción (dejar en blanco para no cambiar): ");
        	    String nuevaDescripcion = entrada.nextLine();
        	    

        	    System.out.print("Nueva dificultad (dejar en blanco para no cambiar): ");
        	    String nuevaDificultad = entrada.nextLine();
        	    

        	    System.out.print("Nueva duración total en minutos (poner 0 para no cambiar): ");
        	    int duracionInput = entrada.nextInt();
        	    
        	    
        	    
        	    double rating = lp.getRating();
        	    
        	    
        	    Date fechaCreacion = lp.getFechaCreacion();
        	    LocalDateTime fechaModificacion = lp.getFechaModificacion();
        	    int version = lp.getVersion();
        	    List<Actividad> listaActividades = lp.getActividades();

        	    System.out.println("Learning Path editado exitosamente.");
            	
                Profesor.editarLearningPath(lp, nuevoTitulo, nuevaDescripcion, nuevaDificultad, duracionInput, rating, fechaCreacion, fechaModificacion, version, listaActividades);
                break;
                
                
                
                
                
            case 3:
            	
            	System.out.println("Ingrese el nombre del Learning Path donde se encuentra la actividad:");
            	String nombreLp = entrada.nextLine();
            	System.out.println("Ingrese el nombre de la actividad a calificar:");
        	    String nombreAct = entrada.nextLine();
        	    
        	    
        	    System.out.println("Ingrese la calificacion (Exitoso/Inexitoso");
        	    String resultado = entrada.nextLine();
            	
                Profesor.calificarActividad();
                break;
                
                
            case 4:
            	//Dejar reseña
            	System.out.println("Ingrese el nombre del Learning Path a modificar");
            	String nombre1 = entrada.nextLine();
            	List<LearningPath> lp_Lista1 = Profesor.getLearningPathsCreados();
            	LearningPath lp1 = Profesor.getLearningPath(lp_Lista1, nombre1);
            
            	System.out.print("Ingrese el ID del Learning Path o Actividad para dejar una reseña: ");
        	    String id = entrada.nextLine(); 
        	    

        	    System.out.print("Ingrese un rating (1-5): ");
        	    double calificacion = entrada.nextDouble();
        	    entrada.nextLine(); 


        	    if (calificacion < 1 || calificacion > 5) {
        	        System.out.println("El rating debe estar entre 1 y 5.");
        	        return;
        	    }


        	    System.out.print("Ingrese su feedback: ");
        	    String feedback = entrada.nextLine();
            	
                LearningPath.añadirReseña(lp1, calificacion, feedback);
                System.out.println("Reseña dejada exitosamente.");
                
                break;
                
            case 5:
            	
            	System.out.println("Ingrese el nombre del Learning Path:");
            	String nombre11 = entrada.nextLine();
            	List<LearningPath> lp_Lista11 = Profesor.getLearningPathsCreados();
            	LearningPath lp11 = Profesor.getLearningPath(lp_Lista11, nombre11);
            	System.out.println("Detalles actuales del Learning Path:");
        	    System.out.println("Título: " + lp11.getTitulo());
        	    System.out.println("Descripción: " + lp11.getDescripcion());
        	    System.out.println("Dificultad: " + lp11.getDificultad());
        	    System.out.println("Duración total en minutos: " + lp11.getDuracionTotalMinutos());
        	    System.out.println("Fecha creacion: " + lp11.getFechaCreacion());
        	    System.out.println("Fecha de modificacion " + lp11.getFechaModificacion());
        	    System.out.println("Rating: " + lp11.getRating());
        	    System.out.println("Versión: " + lp11.getVersion());
        	    System.out.println("Reseñas: " + lp11.getReseñas());
            	
            	
            case 6:
                System.out.println("Fin.");
                break;
            default:
                System.out.println("La opción no es válida");

            }
            
        }while (opcion != 6);
	}
}
    
    
	