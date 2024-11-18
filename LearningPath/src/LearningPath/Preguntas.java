package LearningPath;

import java.util.ArrayList;
import java.util.List;

public class Preguntas {

    private List<PreguntaAbierta> preguntasAbiertas; 
    public Preguntas() {
        this.preguntasAbiertas = new ArrayList<>();
    }


    public void agregarPregunta(PreguntaAbierta pregunta) {
    	preguntasAbiertas.add(pregunta);
        System.out.println("Pregunta agregada: " + pregunta.getEnunciado());
    }


    public void mostrarPreguntas() {
        if (preguntasAbiertas.isEmpty()) {
            System.out.println("No hay preguntas registradas.");
            return;
        }
        
        System.out.println("Preguntas Abiertas:");
        for (int i = 0; i < preguntasAbiertas.size(); i++) {
            System.out.println((i + 1) + ". " + preguntasAbiertas.get(i).getEnunciado());
        }
    }

    public List<PreguntaAbierta> getPreguntas() {
        return preguntasAbiertas;
    }
}