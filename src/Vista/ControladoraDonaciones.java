package Vista;

import Controlador.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladoraDonaciones {

	
	@FXML
	private Button add;
	
	@FXML
    private Button eliminar;
    
    @FXML
    private Button modificar;
    
    @FXML
	private Button buscar;
    
    @FXML
    private TextField busqueda;

	private Stage ventana3;

	private Main ProgramaPrincipal;

	public void setStagePrincipal(Stage ventana3) {
		// TODO Auto-generated method stub
		this.ventana3 = ventana3;
	}
	
	public void setProgramaPrincipal(Main ProgramaPrincipal) {
		this.ProgramaPrincipal=ProgramaPrincipal;
		
		
	}
	
	public void abrirFormulario() {
		this.ProgramaPrincipal.mostrarFormulario();
	}
	
	
	
	public void abrirModDonacion() {
		this.ProgramaPrincipal.mostrarModDonacion();
	}

	public void closeWindow() {
		this.ventana3.close();
	}



}