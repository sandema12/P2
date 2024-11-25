package Consola;

import java.io.IOException;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import LearningPath.Actividad;
import LearningPath.LearningPath;
import Persistencia.CentralPersistenciaActividades;
import Persistencia.CentralPersistenciaLearningPath;
import Persistencia.CentralPersistenciaQuiz;
import Persistencia.CentralPersistenciaReseñas;
import Usuario.Estudiante;
//import Persistencia.CentralPersistenciaLearningPaths;
import Usuario.Profesor;


public class ConsolaProfesor{
	
	/**
	 * 
	 */
	private static List<LearningPath> learningPathsCreados= new ArrayList<>();
    private Scanner entrada;
    private CentralPersistenciaLearningPath cpl;
    private CentralPersistenciaActividades cpa;
    private CentralPersistenciaQuiz cpq;
    

    
    public ConsolaProfesor() {
        
        entrada = new Scanner(System.in);
        cpl = new CentralPersistenciaLearningPath();
        cpa = new CentralPersistenciaActividades();

    }
    
    public void mostrarMenu() throws ClassNotFoundException, IOException { 
		
    	cpl.cargarLearningPaths();
    	
        int opcion;
        
        do {
        
            System.out.println("1. Crear Learning Path"); //bien
            System.out.println("2. Editar Learning Path");//bien
            System.out.println("3. Calificar actividad");//bien
            System.out.println("4. Dejar reseña");//bien
            System.out.println("5. Ver Learning Path");//bien
            System.out.println("6. Menú Actividades");//bien
            System.out.println("7. Ver Calificaciones de un Estudiante");//bien
            System.out.println("8. Cerrar Sesión");//bien
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
            	
                LearningPath lp23 = Profesor.crearLearningPath(titulo, descripcion, objetivos, dificultad, duracionMinutos);
                learningPathsCreados.add(lp23);
                cpl.guardarLearningPaths(lp23);
                
                break;
                
                
                
                
            //Editar learningpath
            case 2:
            	
            	System.out.println("Ingrese el nombre del Learning Path a modificar");
            	String nombre = entrada.nextLine();
            	List<LearningPath> lp_Lista = ConsolaProfesor.getLearningPathsCreados();
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
        	    
        	    String tituloAnterior = lp.getTitulo();
        	    
        	    double rating = lp.getRating();
        	    
        	    
        	    LocalDateTime fechaCreacion = lp.getFechaCreacion();
        	    LocalDateTime fechaModificacion = lp.getFechaModificacion();
        	    int version = lp.getVersion();
        	    List<Actividad> listaActividades = lp.getActividades();

        	    System.out.println("Learning Path editado exitosamente.");
            	
                Profesor.editarLearningPath(lp, nuevoTitulo, nuevaDescripcion, nuevaDificultad, duracionInput, rating, fechaCreacion, fechaModificacion, version, listaActividades, tituloAnterior);
                System.out.println("------------------------------");
                
                break;
                
                
                
                
            //Calificar actividad    
            case 3:
            	
            	System.out.println("Ingrese el nombre del estudiante a calificar:");
            	String nombreEstudiante = entrada.nextLine();
            	
            	System.out.println("Ingrese el nombre del Learning Path donde se encuentra la actividad:");
            	String nombreLearningPath = entrada.nextLine();
            	
            	System.out.println("Ingrese el nombre de la actividad a calificar:");
        	    String nombreActividad = entrada.nextLine();
        	    
        	    
        	    
        	    
        	    System.out.println("Ingrese la calificacion (Exitoso/Inexitoso");
        	    String resultado = entrada.nextLine();
            	
                Profesor.calificarActividad(nombreEstudiante, nombreLearningPath, nombreActividad, resultado);
                System.out.println("------------------------------");
                break;
                
               
            //Dejar reseña
            case 4:
            	
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
                
                break;
                
            //Ver learning path
            case 5:           	
            	            	
            	System.out.println("Ingrese el nombre del Learning Path:");
            	String nombre11 = entrada.nextLine();
            	
            	cpa.cargarActividades(nombre11);
            	
            	CentralPersistenciaReseñas.cargarResenas(nombre11);
            	
            	List<LearningPath> lp_Lista11 = ConsolaProfesor.getLearningPathsCreados();
            	LearningPath lp11 = Profesor.getLearningPath(lp_Lista11, nombre11);
            	            	
            	List<Actividad> lista_Actividades = lp11.getActividades();
            	ArrayList<String> nombres = new ArrayList<>();
            	
            	
            	for (Actividad i: lista_Actividades) {
            		
            		String texto = i.getTitulo();
            		nombres.add(texto);
            		
            		cpq.cargarQuiz(lp11, texto);
            	}
            	
            	System.out.println("Detalles actuales del Learning Path:");
        	    System.out.println("Título: " + lp11.getTitulo());
        	    System.out.println("Descripción: " + lp11.getDescripcion());
        	    System.out.println("Dificultad: " + lp11.getDificultad());
        	    System.out.println("Duración total en minutos: " + lp11.getDuracionTotalMinutos());
        	    System.out.println("Actividades: " + nombres);
        	    System.out.println("Fecha creacion: " + lp11.getFechaCreacion());
        	    System.out.println("Fecha de modificacion " + lp11.getFechaModificacion());
        	    
        	    System.out.println("Rating: " + lp11.actualizarRating());
        	   
        	    System.out.println("Versión: " + lp11.getVersion());
        	    System.out.println("Reseñas: " + lp11.getFeedbacks(lp11));
        	    
        	    break;
            	
            
        	//Menu actividades
            case 6:
            	
            	System.out.println("Ingrese el nombre del Learning Path para entrar a su menú de actividades:");
            	String nombre12 = entrada.nextLine();
            	
            	cpa.cargarActividades(nombre12);
            	
            	List<LearningPath> lp_Lista111 = ConsolaProfesor.getLearningPathsCreados();
            	LearningPath lp12 = Profesor.getLearningPath(lp_Lista111, nombre12);
            	ConsolaActividad cActividad = new ConsolaActividad();
            	cActividad.mostrarMenu(lp12);
            	break;
            	
            	//Ver calificaciones
            case 7:
            	List<String> notas = new ArrayList<>();
            	
            	System.out.print("Ingrese el nombre del estudiante para revisar calificaciones: ");
            	String nombreEstudianteCalificar = entrada.nextLine(); 
            	
            	List<Estudiante> estudiantes = ConsolaAutenticacion.getEstudiantes();
            	for (Estudiante est: estudiantes) {
            		if (nombreEstudianteCalificar.equals(est.getUsername()));
            			notas = est.getCalificaciones();
            			
            	}
            	
                System.out.println(notas);
            	break;
            	
            	
            case 8:
            	System.out.println("Sesion cerrada");
                System.out.println("------------------------------");
                break;
                
            default:
                System.out.println("La opción no es válida");

            }
            
        }while (opcion != 8);
	}

	public static List<LearningPath> getLearningPathsCreados() {
		return learningPathsCreados;
	}

	public static void setLearningPathsCreados(List<LearningPath> learningPathsCreados) {
		ConsolaProfesor.learningPathsCreados = learningPathsCreados;
	}
}
    
    
	