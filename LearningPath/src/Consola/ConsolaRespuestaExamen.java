package Consola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsolaRespuestaExamen {
	
	private Scanner entrada;
	private List<String> respuestas;

    public ConsolaRespuestaExamen() {
        entrada = new Scanner(System.in);
        respuestas = new ArrayList<>();
    }
    
    public void mostrarMenu() {
		
        String opcion;
        
        
            System.out.println("Ingrese su respuesta: ");
            opcion = entrada.next();
            respuestas.add(opcion);
            entrada.nextLine();
            

            
    }

	public List<String> getRespuestas() {
		return respuestas;
	}
    
    

}