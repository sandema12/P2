package Consola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import LearningPath.Pregunta;

public class ConsolaExamen {
	
	private Scanner entrada;

    public ConsolaExamen() {
        entrada = new Scanner(System.in);
    }
    
    public List<Pregunta> mostrarMenu() {
    	List<Pregunta> preguntas = new ArrayList<>();
    	
    	System.out.print("Ingrese el numero de preguntas del examen: ");
        int numPreguntas = entrada.nextInt();
        entrada.nextLine();
        
        for(int i=1; i<=numPreguntas; i++) {
        	System.out.println("Ingrese la pregunta #" + i + ": ");
        	String pregunta = entrada.nextLine();
        	Pregunta nuevaPregunta = new Pregunta (pregunta, null, "");
            preguntas.add(nuevaPregunta);
        	
        }
            
        return preguntas;
            
    }

}
