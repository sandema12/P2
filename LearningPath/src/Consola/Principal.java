package Consola;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ConsolaAutenticacion consola = new ConsolaAutenticacion();
        consola.mostrarMenu();
    }
}