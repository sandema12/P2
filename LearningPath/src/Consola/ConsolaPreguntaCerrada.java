package Consola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import LearningPath.Pregunta;

public class ConsolaPreguntaCerrada {
    private Scanner entrada;

    public ConsolaPreguntaCerrada() {
        entrada = new Scanner(System.in);
    }

    public List<Pregunta> mostrarMenu() {
        List<Pregunta> preguntas = new ArrayList<>();
        int opcion;

        do {
            System.out.println("1. Agregar Pregunta Cerrada");
            System.out.println("2. Ver Preguntas");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine(); 

            switch (opcion) {
                case 1:
                    Pregunta nuevaPregunta = agregarPregunta();
                    if (nuevaPregunta != null) {
                        preguntas.add(nuevaPregunta);
                    }
                    break;
                case 2:
                    verPreguntas(preguntas);
                    break;
                case 3:
                    System.out.println("Fin.");
                    break;
                default:
                    System.out.println("La opción no es válida.");
            }
        } while (opcion != 3);

        return preguntas; 
    }

    //Implementar respuestas
    private Pregunta agregarPregunta() {
        System.out.print("Enunciado de la pregunta: ");
        String enunciado = entrada.nextLine();

        List<String> opciones = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            System.out.print("Opción " + i + ": ");
            String opcion = entrada.nextLine();
            opciones.add(opcion);
        }

        System.out.print("Ingrese el número de la opción correcta (1-4): ");
        int opcionCorrecta = entrada.nextInt();
        entrada.nextLine(); 

        
        if (opcionCorrecta < 1 || opcionCorrecta > 4) {
            System.out.println("Opción incorrecta. La pregunta no ha sido agregada.");
            return null;
        }

       
        String respuestaCorrecta = opciones.get(opcionCorrecta - 1);
        double puntaje = 5; 
        Pregunta nuevaPregunta = new Pregunta(enunciado, opciones, respuestaCorrecta, puntaje);

        System.out.println("Pregunta cerrada agregada exitosamente.");
        return nuevaPregunta; 
    }

    private void verPreguntas(List<Pregunta> preguntas) {
        if (preguntas.isEmpty()) {
            System.out.println("No hay preguntas agregadas.");
            return;
        }

        System.out.println("Preguntas Cerradas:");
        for (int i = 0; i < preguntas.size(); i++) {
            Pregunta pregunta = preguntas.get(i);
            System.out.println((i + 1) + ". " + pregunta.getEnunciado());
            System.out.println("   Opciones: ");

        }
    }
}
