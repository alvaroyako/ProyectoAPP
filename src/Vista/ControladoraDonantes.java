package Vista;

import java.net.URL;
import java.util.ResourceBundle;

import Controlador.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladoraDonantes {

	@FXML
	private TextField buscar;
	
	@FXML
	private Button a�adir;
	
	@FXML
    private Button eliminar;
    
    @FXML
    private Button modificar;
    
    @FXML
    private Button carnet;
    
    @FXML
    private Button busqueda;

	private Stage ventana;
	private Main ProgramaPrincipal;
	
	

	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
	}
	
	public void setProgramaPrincipal(Main ProgramaPrincipal) {
		this.ProgramaPrincipal=ProgramaPrincipal;
	}
	
	
	
	public void abrirAD() {
		this.ProgramaPrincipal.mostrarAnadirDonante();
	}

	public void abrirModDonante() {
		this.ProgramaPrincipal.mostrarModificarDonante();
	}



}