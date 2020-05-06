package Vista;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladoraDonaciones {

	@FXML
	private Button buttonclose;

	private Stage ventana3;

	public void setStagePrincipal(Stage ventana3) {
		// TODO Auto-generated method stub
		this.ventana3 = ventana3;
	}

	public void closeWindow(){
		this.ventana3.close();
	}



}