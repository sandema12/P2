package Consola;

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
            System.out.println("1. Ver Learning Paths");
            System.out.println("2. Inscribir Learning Path");
            System.out.println("3. Iniciar Actividad");
            System.out.println("4. Ver Calificaciones");
            System.out.println("6. Dejar Reseña");
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
        } while (opcion != 5);
    }
    
    private void verLearningPaths() {
        
    	
    	List<LearningPath> lp_creados = Profesor.getLearningPathsCreados();
    	for (LearningPath lp : lp_creados) {
    		System.out.println(lp.getTitulo());
    	}
    }
    
    private void inscribirLearningPath() {
        
    	System.out.print("Ingrese el nombre del Learning Path que desea inscribir: ");
    	String inscribir = entrada.nextLine(); 
    	List<LearningPath> lp_creados = Profesor.getLearningPathsCreados();
    	for (LearningPath lp : lp_creados) {
    		if (lp.getTitulo() == inscribir) {
    			Estudiante.inscribirseEnLearningPath(lp);
    			System.out.println("Se ha inscrito exitosamente el Learning Path: " + inscribir);
    		}
    	
    	}
    }

    private void iniciarActividad() {
        
    	System.out.print("Ingrese la actividad que desea realizar: ");
    	String actividad = entrada.nextLine(); 
    	Actividad actividadParaRealizar = null;
    	
    	List<Actividad> actividadesCreadas = LearningPath.getActividades();
    	for (Actividad act : actividadesCreadas) {
    		if (act.getTitulo() == actividad) {
    			actividadParaRealizar = act;
    		}
    	}
    	
    	Actividad.completarActividad(actividadParaRealizar);
    	
    	
 
    }

    private void verCalificaciones() {
        // Falta implementar
        System.out.println("Mostrando calificaciones...");
        
    }

    private void dejarReseña() {
        
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
    }
}
