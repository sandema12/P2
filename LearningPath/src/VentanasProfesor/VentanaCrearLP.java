package VentanasProfesor;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import LearningPath.LearningPath;
import Persistencia.CentralPersistenciaActividades;
import Persistencia.CentralPersistenciaLearningPath;
import Persistencia.CentralPersistenciaQuiz;
import Usuario.Profesor;

public class VentanaCrearLP extends JFrame {
	
	private static List<LearningPath> learningPathsCreados= new ArrayList<>();
    private CentralPersistenciaLearningPath cpl;
    private CentralPersistenciaActividades cpa;
    private CentralPersistenciaQuiz cpq;
    PanelDatosCrearLP panelDatos;
	
	public VentanaCrearLP() {
		
		cpl = new CentralPersistenciaLearningPath();
        cpa = new CentralPersistenciaActividades();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 400);
		setTitle("Crear Learning Path");
		
		BorderLayout bl = new BorderLayout();
		setLayout(bl);
		
		panelDatos = new PanelDatosCrearLP(this);
		add(panelDatos, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		
	
		setVisible(true);
	}
	
	public void crearLearningPath(String titulo, String descripcion, String objetivos, String dificultad, int duracionMinutos ) throws ClassNotFoundException, IOException {
		
	    LearningPath lp = Profesor.crearLearningPath(titulo, descripcion, objetivos, dificultad, duracionMinutos);
	    learningPathsCreados.add(lp);
	    cpl.guardarLearningPaths(lp);
	    JOptionPane.showMessageDialog(this, "Learning Path creado exitosamente");
			
		
		}
	
	
	
	public void cambiarVentana(JFrame nuevaVentana) {
	    nuevaVentana.setVisible(true);
	    this.dispose();
	}

	public static List<LearningPath> getLearningPathsCreados() {
		return learningPathsCreados;
	}

	public static void setLearningPathsCreados(List<LearningPath> learningPathsCreados) {
		VentanaCrearLP.learningPathsCreados = learningPathsCreados;
	}

	
}

