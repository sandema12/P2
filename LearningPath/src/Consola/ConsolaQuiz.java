package Consola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import LearningPath.Pregunta;

public class ConsolaQuiz {
	
	private Scanner entrada;

    public ConsolaQuiz() {
        entrada = new Scanner(System.in);
    }
    
    public void mostrarMenu() {
		
        int opcion;
        
        
            System.out.println("1. Crear Learning Path");
            opcion = entrada.nextInt();
            entrada.nextLine();
            
            if (opcion == 1) {
            	
            	System.out.println("Ingrese la pregunta:");
            	String pregunta = entrada.nextLine();
            	
            	System.out.println("Ingrese las opciones:");
            	
            	List<String> opciones = new ArrayList<String>();

                
                for (int i = 1; i <= 4; i++) {
                    System.out.print("Opción " + i + ": ");
                    String opcionRespuesta = entrada.nextLine();
                    opciones.add(opcionRespuesta);  
                }
                System.out.println("Ingrese la respuesta correcta(1, 2, 3 o 4):");
            	int numPreguntaCorrecta = entrada.nextInt();
            	
            	
                
            }
            
    }

}
