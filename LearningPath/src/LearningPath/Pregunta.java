package LearningPath;

import java.util.List;

public class Pregunta {

    private String enunciado; 
    private List<String> opciones;
    private String respuestaCorrecta; 
    private double puntaje; 

    public Pregunta(String enunciado, List<String> opciones, String respuestaCorrecta, double puntaje) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
        
    }

    
    public boolean verificarRespuesta(String respuesta) {
        return respuestaCorrecta.equalsIgnoreCase(respuesta);
    }

    
    public List<String> getOpciones() {
        return opciones;
    }

    
    public void mostrarPregunta() {
        System.out.println(enunciado);
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ". " + opciones.get(i));
        }
    }

    
    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }
}


