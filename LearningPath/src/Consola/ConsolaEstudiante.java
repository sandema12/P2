package Consola;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import LearningPath.Actividad;
import LearningPath.LearningPath;
import Persistencia.CentralPersistenciaActividades;
import Persistencia.CentralPersistenciaLearningPath;
import Usuario.Profesor;
import Usuario.Estudiante;


public class ConsolaEstudiante {
    
    private Scanner entrada;
    private CentralPersistenciaLearningPath cpl;
    private CentralPersistenciaActividades cpa;
    

    public ConsolaEstudiante() {
        entrada = new Scanner(System.in);
        cpl = new CentralPersistenciaLearningPath();
    }
    
    public void mostrarMenu() throws ClassNotFoundException, IOException {
    	cpl.cargarLearningPaths();
        int opcion;
        
        do {
            System.out.println("1. Ver Learning Paths");
            System.out.println("2. Inscribir Learning Path");
            System.out.println("3. Iniciar Actividad");
            System.out.println("4. Ver Calificaciones");
            System.out.println("5. Dejar Reseña");
            System.out.println("6. Cerrrar Sesión");
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
                	System.out.println("Sesion cerrada");
                    System.out.println("------------------------------");
                    break;
                default:
                    System.out.println("La opción no es válida.");
            }
        } while (opcion != 6);
    }
    
    private void verLearningPaths() throws ClassNotFoundException, IOException {
        
    	List<LearningPath> lp_creados = ConsolaProfesor.getLearningPathsCreados();
    	for (LearningPath lp : lp_creados) {
    		String nombre = lp.getTitulo();
    		System.out.println("-------------------------------");
    		System.out.println("Nombre LP: " + nombre);
    		System.out.println("Actividades:");
    		cpa.cargarActividades(nombre);
    		
    		List<Actividad> actividades = lp.getActividades();
    		for (Actividad act : actividades) {
    			System.out.println("- " + act.getTitulo());
    			System.out.println("	Descripcion: " + act.getDescripcion());
    			System.out.println("	Tipo: " + act.getTipo());
    		}
    		System.out.println("-------------------------------");
    	}
    }
    
    private void inscribirLearningPath() {
        
    	System.out.print("Ingrese el nombre del Learning Path que desea inscribir: ");
    	String inscribir = entrada.nextLine(); 
    	List<LearningPath> lp_creados = ConsolaProfesor.getLearningPathsCreados();
    	for (LearningPath lp : lp_creados) {
    		if (lp.getTitulo().equals(inscribir)) {
    			Estudiante.inscribirseEnLearningPath(lp);
    			System.out.println("Se ha inscrito exitosamente el Learning Path: " + inscribir);
    			System.out.println("------------------------------");
    		}
    	
    	}
    }


    private void iniciarActividad() {
        
    	
    	System.out.print("Ingrese el nombre del Learning Path donde se encuentra la actividad: ");
    	String nombre = entrada.nextLine(); 
    	List<LearningPath> lp_creados = ConsolaProfesor.getLearningPathsCreados();
    	LearningPath lp =  Profesor.getLearningPath(lp_creados, nombre);
    	
    	System.out.print("Ingrese la actividad que desea realizar: ");
    	String actividad = entrada.nextLine(); 
    	
    	List<Actividad> actividadesCreadas = lp.getActividades();
    	for (Actividad act : actividadesCreadas) {
    		if (act.getTitulo().equals(actividad)) {
    			act.completarActividad(act);
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

    private void dejarReseña() throws ClassNotFoundException, IOException {
        
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
        System.out.println("------------------------------");
        
    }
}
