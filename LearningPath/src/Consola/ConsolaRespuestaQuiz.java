package Consola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsolaRespuestaQuiz {
	
	private Scanner entrada;
	private List<String> respuestas;

    public ConsolaRespuestaQuiz() {
        entrada = new Scanner(System.in);
        this.respuestas = new ArrayList<>();
    }
    
    public void mostrarMenu() {        
        
            System.out.println("Ingrese su respuesta (1,2,3,4): ");
            String opcion = entrada.nextLine();
            respuestas.add(opcion);
                        
    }

	public List<String> getRespuestas() {
		return respuestas;
	}
    
    

}