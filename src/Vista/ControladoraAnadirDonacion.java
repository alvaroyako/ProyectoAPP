package Vista;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladoraAnadirDonacion {

	@FXML
	private Button buttonclose;
	
	private Stage ventana;
	

	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
	}
	
	
	
	public void addDonacion() {
		this.ventana.close();
	}
}
