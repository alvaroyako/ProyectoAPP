package Vista;

import java.sql.SQLException;
import java.util.Optional;

import Controlador.Main;
import Modelo.ConexionBBDD;
import Modelo.Donacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
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
    
    @FXML
	private Button actualizar;
    
    @FXML
   	private TableView<Donacion> tabla;
    
    @FXML
	private TableColumn<Donacion,Integer> codigo;

	@FXML
	private TableColumn<Donacion,String> ultima;

	@FXML
	private TableColumn<Donacion,String> volumen;
	
	@FXML
	private TableColumn<Donacion,String> sangre;
	
	@FXML
	private TableColumn<Donacion,String> fecha;
	
	ObservableList<Donacion> datos = FXCollections.observableArrayList();

	private Stage ventana3;

	private Main ProgramaPrincipal;

	public void setStagePrincipal(Stage ventana3) {
		// TODO Auto-generated method stub
		this.ventana3 = ventana3;
	}
	
	public void initialize() throws SQLException{

		// Llamar a un método de la clase de manipulación de BBDD para que me devuelva un ObservableList<Persona> datos

		ConexionBBDD con = new ConexionBBDD();
		datos = con.ObtenerDonaciones();

		tabla.setItems(datos);

		codigo.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("id"));
		ultima.setCellValueFactory(new PropertyValueFactory<Donacion,String>("ultdonacion"));
		volumen.setCellValueFactory(new PropertyValueFactory<Donacion,String>("volumen"));
		sangre.setCellValueFactory(new PropertyValueFactory<Donacion,String>("sangre"));
		fecha.setCellValueFactory(new PropertyValueFactory<Donacion,String>("fecha"));
	}
	
	public void actualizar() throws SQLException {
		ConexionBBDD con = new ConexionBBDD();
		datos = con.ObtenerDonaciones();

		tabla.setItems(datos);

		codigo.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("id"));
		ultima.setCellValueFactory(new PropertyValueFactory<Donacion,String>("ultdonacion"));
		volumen.setCellValueFactory(new PropertyValueFactory<Donacion,String>("volumen"));
		sangre.setCellValueFactory(new PropertyValueFactory<Donacion,String>("sangre"));
		fecha.setCellValueFactory(new PropertyValueFactory<Donacion,String>("fecha"));
	}
	public void setProgramaPrincipal(Main ProgramaPrincipal) {
		this.ProgramaPrincipal=ProgramaPrincipal;
		
		
	}
	
	public void Eliminar() throws SQLException{
		int index = tabla.getSelectionModel().getSelectedIndex();
		if( index >= 0){

			Donacion seleccionada = tabla.getSelectionModel().getSelectedItem();

			// Se abre un dialog box de confirmacion de eliminar
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmación!!!");
			alert.setHeaderText("Por favor confirme el borrado");
			alert.setContentText("Desea borrar la donacion "+ seleccionada.getId()+" ?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
			    // ... user chose OK

				// Llamar a un método que realice el DELETE en la base de datos
				ConexionBBDD con = new ConexionBBDD();
				int res = con.BorrarDonacion(seleccionada.getId());
				switch(res){
					case 0:
						alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("OK!");
						alert.setHeaderText("Borrado OK!");
						alert.setContentText("¡Donacion borrada con éxito!");
						alert.showAndWait();

						// Actualizo los datos de la tabla
						datos = con.ObtenerDonaciones();
						tabla.setItems(datos);
						break;

					default:
						alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error!");
						alert.setHeaderText("Inserción NOK!");
						alert.setContentText("¡Ha habido un problema al realizar la inserción!");
						alert.showAndWait();
						break;
				}

				
			}

		}else{

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error en selección de datos");
			alert.setContentText("NO HAY NINGUN ELEMENTO SELECCIONADO!");
			alert.showAndWait();

		}
	}
	
	public void Buscar() throws SQLException{

		String buscarsangre = busqueda.getText();

		// llama a un  método  que haga el select de la base de datos
		ConexionBBDD con = new ConexionBBDD();
		datos = con.BuscarDonaciones(buscarsangre);

		tabla.setItems(datos);
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