package Vista;

import Controlador.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladoraFormulario {

	@FXML
	private Button buttonclose;

	private Stage ventana;
	private Main ProgramaPrincipal;
	
	

	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
	}
	
	public void setProgramaPrincipal(Main ProgramaPrincipal) {
		this.ProgramaPrincipal=ProgramaPrincipal;
	}
	
	public void abrirAnadirDonacion() {
		this.ProgramaPrincipal.mostrarAnadirDonacion();
	}
	
	
	

	



}