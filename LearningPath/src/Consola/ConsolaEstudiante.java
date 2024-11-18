package Consola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import LearningPath.Actividad;
import LearningPath.LearningPath;
import Usuario.Profesor;
import Usuario.Estudiante;


public class ConsolaEstudiante {
    
    private Scanner entrada;
    

    public ConsolaEstudiante() {
        entrada = new Scanner(System.in);
    }
    
    public void mostrarMenu() {
        int opcion;
        
        do {
            System.out.println("1. Ver Learning Paths"); //bien
            System.out.println("2. Inscribir Learning Path"); //revisar
            System.out.println("3. Iniciar Actividad"); //revisar
            System.out.println("4. Ver Calificaciones"); //bien
            System.out.println("5. Dejar Reseña"); //bien
            System.out.println("6. Volver");
            System.out.print("Elija una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine(); 
            
            switch (opcion) {
                case 1:
                    verLearningPaths();
                    break;
                case 2:
                	inscribirLearningPath();
                    break;
                case 3:
                    iniciarActividad();
                    break;
                case 4:
                    verCalificaciones();
                    break;
                case 5:
                    dejarReseña();
                    break;
                case 6:
                    System.out.println("Fin.");
                    break;
                default:
                    System.out.println("La opción no es válida.");
            }
        } while (opcion != 6);
    }
    
    private void verLearningPaths() {
        
    	List<LearningPath> lp_creados = Profesor.getLearningPathsCreados();
    	for (LearningPath lp : lp_creados) {
    		System.out.println("-------------------------------");
    		System.out.println("Nombre LP: " + lp.getTitulo());
    		System.out.println("Actividades:");
    		List<Actividad> actividades = lp.getActividades();
    		for (Actividad act : actividades) {
    			System.out.println("- " + act.getTitulo());
    			System.out.println("Descripcion: " + act.getDescripcion());
    		}
    		System.out.println("-------------------------------");
    	}
    }
    
    private void inscribirLearningPath() {
        
    	System.out.print("Ingrese el nombre del Learning Path que desea inscribir: ");
    	String inscribir = entrada.nextLine(); 
    	List<LearningPath> lp_creados = Profesor.getLearningPathsCreados();
    	for (LearningPath lp : lp_creados) {
    		if (lp.getTitulo().equals(inscribir)) {
    			Estudiante.inscribirseEnLearningPath(lp);
    			System.out.println("Se ha inscrito exitosamente el Learning Path: " + inscribir);
    		}
    	
    	}
    }


    private void iniciarActividad() {
        
    	
    	System.out.print("Ingrese el nombre del Learning Path donde se encuentra la actividad: ");
    	String nombre = entrada.nextLine(); 
    	List<LearningPath> lp_creados = Profesor.getLearningPathsCreados();
    	LearningPath lp =  Profesor.getLearningPath(lp_creados, nombre);
    	
    	System.out.print("Ingrese la actividad que desea realizar: ");
    	String actividad = entrada.nextLine(); 
    	
    	List<Actividad> actividadesCreadas = lp.getActividades();
    	for (Actividad act : actividadesCreadas) {
    		if (act.getTitulo().equals(actividad)) {
    			Actividad.completarActividad(act);
    		}
    	}
    	}
    	
    	

    private void verCalificaciones() {
    	
    	List<String> notas = new ArrayList<>();
    	
    	System.out.print("Ingrese el nombre del estudiante para revisar calificaciones: ");
    	String nombre = entrada.nextLine(); 
    	
    	List<Estudiante> estudiantes = ConsolaAutenticacion.getEstudiantes();
    	for (Estudiante est: estudiantes) {
    		if (nombre.equals(est.getUsername()));
    			notas = est.getCalificaciones();
    			
    	}
    	
    	
        System.out.println("Mostrando calificaciones...");
        System.out.println(notas);
        
    }

    private void dejarReseña() {
        
    	System.out.println("Ingrese el nombre del Learning Path a reseñar");
    	String nombreLp = entrada.nextLine();

	    System.out.print("Ingrese un rating (1-5): ");
	    double calificacion = entrada.nextDouble();
	    entrada.nextLine(); 

	    if (calificacion < 1 || calificacion > 5) {
	        System.out.println("El rating debe estar entre 1 y 5.");
	        return;
	    }
	    
	    System.out.print("Ingrese su feedback: ");
	    String feedback = entrada.nextLine();
    	
        Profesor.añadirReseña(nombreLp, calificacion, feedback);
        System.out.println("Reseña dejada exitosamente.");
        
    }
}
