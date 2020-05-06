package Vista;

import java.net.URL;
import java.util.ResourceBundle;

import Controlador.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ControladoraMenu implements Initializable {

    private  Main ProgramaPrincipal;

    @FXML
    private Button donantes;
    
    @FXML
    private Button donaciones;
    
    @FXML
    private Button estadisticas;


    public void setProgramaPrincipal(Main ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /* Cuando se pulsa el botón tendrá que abrir ventana nueva
     * para eso llama al método del main */
    @FXML
    private void abrirDonantes() {
       	this.ProgramaPrincipal.mostrarDonantes();
    }
    
    @FXML
    private void abrirDonaciones() {
       	this.ProgramaPrincipal.mostrarDonaciones();
    }
    
    @FXML
    private void abrirEstadisticas() {
       	this.ProgramaPrincipal.mostrarEstadisticas();
    }
}