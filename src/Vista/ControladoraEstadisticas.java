package Vista;

import java.sql.SQLException;

import Modelo.ConexionBBDD;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladoraEstadisticas {
	
	ConexionBBDD con =new ConexionBBDD();
	
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
	
	
	@FXML
	   public void initialize() throws SQLException {

	       // TODO (don't really need to do anything here).
		ConexionBBDD con =new ConexionBBDD();
		String datos=con.consultas1();
		consulta1.setText(datos);

	   }
		
	
	



}