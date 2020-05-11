package Vista;


import Controlador.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladoraDonantes {
	
	private Stage ventana;
	private Main ProgramaPrincipal;

	@FXML
	private TextField buscar;
	
	@FXML
	private Button add;
	
	@FXML
    private Button eliminar;
    
    @FXML
    private Button modificar;
    
    @FXML
    private Button carnet;
    
    @FXML
    private Button busqueda;

	
	
	

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

	public void closeWindow() {
		this.ventana.close();
	}

}