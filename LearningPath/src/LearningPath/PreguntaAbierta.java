package LearningPath;



public class PreguntaAbierta {

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