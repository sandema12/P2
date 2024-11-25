package VentanasProfesor;

import java.awt.BorderLayout;
import java.io.IOException;


import javax.swing.JFrame;

import Persistencia.CentralPersistenciaActividades;
import Persistencia.CentralPersistenciaLearningPath;
import Persistencia.CentralPersistenciaQuiz;


public class VentanaProfesor extends JFrame{
	
    private CentralPersistenciaLearningPath cpl;
    private CentralPersistenciaActividades cpa;
    private CentralPersistenciaQuiz cpq;
    PanelDatosProfesor panelDatos;
	
	public VentanaProfesor() throws ClassNotFoundException, IOException {
		
		cpl = new CentralPersistenciaLearningPath();
        cpa = new CentralPersistenciaActividades();
        cpl.cargarLearningPaths();
       
		
        setTitle("Menú Profesor " );
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelDatos = new PanelDatosProfesor(this);
		add(panelDatos, BorderLayout.CENTER);
        

        setLocationRelativeTo(null);
        
        setVisible(true);
    }
	
	public void cambiarVentana(JFrame nuevaVentana) {
	    nuevaVentana.setVisible(true);
	    this.dispose();
	}


}
