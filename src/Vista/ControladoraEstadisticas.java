package Vista;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladoraEstadisticas {

	@FXML
	private Button buttonclose;

	private Stage ventana4;

	public void setStagePrincipal(Stage ventana4) {
		// TODO Auto-generated method stub
		this.ventana4 = ventana4;
	}

	public void closeWindow(){
		this.ventana4.close();
	}



}