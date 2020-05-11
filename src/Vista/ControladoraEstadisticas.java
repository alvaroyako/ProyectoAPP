package Vista;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladoraEstadisticas {

	
	@FXML
	private Button botonmosrar;

	@FXML
	private TextField consulta1;
	
	@FXML
	private TextField consulta2;
	
	@FXML
	private TextField consulta3;
	
	@FXML
	private TextField consulta4;
	
	@FXML
	private TextField consulta5;
	
	@FXML
	private TextField consulta6;
	
	@FXML
	private TextField consulta7;

	private Stage ventana4;

	public void setStagePrincipal(Stage ventana4) {
		// TODO Auto-generated method stub
		this.ventana4 = ventana4;
		
	}
	
	
	public void closeWindow() {
		this.ventana4.close();
	}
		
	
	



}