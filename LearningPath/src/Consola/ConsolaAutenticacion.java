package Consola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Usuario.Estudiante;
import Usuario.Profesor;
import Usuario.Usuario;

public class ConsolaAutenticacion {
	List<Usuario> usuarios = new ArrayList<>();
    private Scanner entrada;
	
	
    public ConsolaAutenticacion() {
        entrada = new Scanner(System.in);
    }
	
	
	public void mostrarMenu() {
		
        int opcion;
        
        do {
        
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();
            
            
            switch (opcion) {
            case 1:
                crearUsuario();
                break;
            case 2:
                autenticacion();
                break;
            case 3:
                System.out.println("Fin.");
                break;
            default:
                System.out.println("La opción no es válida");

            }
            
        }while (opcion != 3);
	}
	



	private void crearUsuario() {
		
        System.out.print("Nombre de usuario: ");
        String username = entrada.nextLine();
        
        System.out.print("Contraseña: ");
        String password = entrada.nextLine();
        
        System.out.print("Rol (Profesor/Estudiante): ");
        String rol = entrada.nextLine();		
		
		Usuario nuevoUsuario;
		
		if (rol.equalsIgnoreCase("Profesor")) {
            nuevoUsuario = new Profesor(username, password, rol);
            
        } else if (rol.equalsIgnoreCase("Estudiante")) {
            nuevoUsuario = new Estudiante(username, password, rol);
        } else {
            System.out.println("Rol no válido. El registro ha sido cancelado.");
            return;
        }
		
		usuarios.add(nuevoUsuario);
		
        System.out.println("Usuario registrado exitosamente.");
		
	}	
	
	private void autenticacion() {
		System.out.print("Nombre de usuario: ");
        String username = entrada.nextLine();
        System.out.print("Contraseña: ");
        String password = entrada.nextLine();
        
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                Usuario usuarioAutenticado = usuario;
                
                
                if (usuarioAutenticado.getPassword().equals(password)) {
                	System.out.println("Inicio de sesión exitoso. Bienvenido, " + usuario.getUsername());	
                	
                	
                	if (usuarioAutenticado.getRol().equalsIgnoreCase("Estudiante")) {
                		ConsolaEstudiante consolaEstudiante = new ConsolaEstudiante();
                        consolaEstudiante.mostrarMenu();
                    
                    	}
                	else if (usuarioAutenticado.getRol().equalsIgnoreCase("Profesor")) {
                		ConsolaProfesor consolaProfesor = new ConsolaProfesor();
                        consolaProfesor.mostrarMenu();
                    
                    	}
                	
                }else {
                	System.out.println("Usuario o contraseña incorrectos.");
                	
                }
            }
        }
        
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
	
