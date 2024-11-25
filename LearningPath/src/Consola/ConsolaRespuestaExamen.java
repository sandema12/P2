package Consola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsolaRespuestaExamen {
	
	private Scanner entrada;
	private List<String> respuestas;

    public ConsolaRespuestaExamen() {
        entrada = new Scanner(System.in);
        this.respuestas = new ArrayList<>();
    }
    
    public void mostrarMenu() {
		     
            System.out.println("Ingrese su respuesta: ");
            String opcion = entrada.nextLine();
            respuestas.add(opcion);        
            
    }

	public List<String> getRespuestas() {
		return respuestas;
	}
    
    

}