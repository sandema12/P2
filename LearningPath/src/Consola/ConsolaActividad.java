package Consola;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import LearningPath.Actividad;
import LearningPath.LearningPath;
import Persistencia.CentralPersistenciaActividades;
import Persistencia.CentralPersistenciaLearningPath;
import Usuario.Profesor; 

public class ConsolaActividad implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2023901694741553570L;
	private Scanner entrada;
	private List<Actividad> actividades = new ArrayList<>();
	private CentralPersistenciaActividades cpa;
	
	
    public ConsolaActividad() {
        entrada = new Scanner(System.in);
        cpa = new CentralPersistenciaActividades();
        
    }

    public List<Actividad> mostrarMenu(LearningPath lp2) throws ClassNotFoundException, IOException {
        
        int opcion;

        do {
            System.out.println("1. Agregar Actividad");
            System.out.println("2. Ver Actividades");
            System.out.println("3. Volver");
            System.out.print("Elija una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine(); 

            switch (opcion) {
                case 1:
//                	System.out.print("Ingrese el nombre del Learning Path donde quiere agregar la actividad: ");
//                    String nombreLp = entrada.nextLine();
                    
//                    ArrayList<LearningPath> lista_LP = (ArrayList<LearningPath>) ConsolaProfesor.getLearningPathsCreados();
//                    LearningPath lp = Profesor.getLearningPath(lista_LP, nombreLp);
                	
                	System.out.print("Ingrese el titulo de la actividad: ");
                    String titulo = entrada.nextLine();
                    
                    System.out.print("Ingrese el tipo de actividad: ");
                    String tipo = entrada.nextLine();
                	
                    System.out.print("Descripción de la actividad: ");
                    String descripcion = entrada.nextLine();

                    System.out.print("Objetivo de la actividad: ");
                    String objetivo = entrada.nextLine();

                    System.out.print("Dificultad de la actividad (Alta/Medio/Baja): ");
                    String dificultad = entrada.nextLine();

                    System.out.print("Duración de la actividad en minutos: ");
                    int duracionMinutos = Integer.parseInt(entrada.nextLine());

                    System.out.print("¿Es esta actividad obligatoria? (sí/no): ");
                    boolean obligatoria = entrada.nextLine().equalsIgnoreCase("sí");
                    
                    System.out.print("Ingrese la fecha límite (YYYY-MM-DD): ");
                    String fechaLimiteStr = entrada.nextLine();
                    LocalDate fechaLimite = LocalDate.parse(fechaLimiteStr, DateTimeFormatter.ISO_LOCAL_DATE);

                	
                    Actividad act = lp2.agregarActividad(titulo, descripcion, objetivo, dificultad, tipo,  obligatoria, duracionMinutos, fechaLimite);
                    cpa.guardarActividades(lp2, act);
                    
                    break;
                case 2:
                	
                    verActividades(lp2);
                    break;
                case 3:
                    System.out.println("Fin.");
                    break;
                default:
                    System.out.println("La opción no es válida");
            }
        } while (opcion != 3);

        return actividades; 
    }
    
    
    
    



    private void verActividades(LearningPath lp) {
    	
    	
    	List<Actividad> actividadesExistentes = lp.getActividades();
    	for (Actividad act : actividadesExistentes) {
    		System.out.println("-------------------------------");
    		System.out.println("Titulo:" + act.getTitulo());
    		System.out.println("Tipo:" + act.getTipo());
    		System.out.println("Descripcion:" + act.getDescripcion());
    		System.out.println("Objetivo:" + act.getObjetivo());
    		System.out.println("Dificultad:" + act.getDificultad());
    		System.out.println("Duracion:" + act.getDuracionMinutos());
    		System.out.println("Fecha limite:" + act.getFechaLimite());
    		System.out.println("-------------------------------");
    		
    	}
    }
}
