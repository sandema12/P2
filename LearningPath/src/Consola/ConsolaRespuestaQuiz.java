package Consola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsolaRespuestaQuiz {
	
	private Scanner entrada;
	private ArrayList respuestas;

    public ConsolaRespuestaQuiz() {
        entrada = new Scanner(System.in);
        respuestas = new ArrayList<>();
    }
    
    public void mostrarMenu() {
		
        int opcion;
        
        
            System.out.println("Ingrese su respuesta: ");
            opcion = entrada.nextInt();
            respuestas.add(opcion);
            entrada.nextLine();
            

            
    }

	public ArrayList getRespuestas() {
		return respuestas;
	}
    
    

}