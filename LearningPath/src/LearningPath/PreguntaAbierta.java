package LearningPath;

import java.io.Serializable;

public class PreguntaAbierta implements Serializable{

    private String enunciado; 

    public PreguntaAbierta(String enunciado) {
        this.enunciado = enunciado;
    }

    String getEnunciado() {
        return enunciado;
    }

    public void mostrarPregunta() {
        System.out.println("Pregunta Abierta: " + enunciado);
    }
}