package Vista;

import Controlador.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladoraFormulario {

	@FXML
	private Button buttonclose;
	

	private Stage ventanaF;
	private Main ProgramaPrincipal;
	
	

	public void setStagePrincipal(Stage ventanaF) {
		// TODO Auto-generated method stub
		this.ventanaF = ventanaF;
	}
	
	public void setProgramaPrincipal(Main ProgramaPrincipal) {
		this.ProgramaPrincipal=ProgramaPrincipal;
	}
	
	public void abrirAnadirDonacion() {
		this.ProgramaPrincipal.mostrarAnadirDonacion();
		this.ventanaF.close();
	}
	
	
	public void closeWindow() {
		this.ventanaF.close();
	}

	



}