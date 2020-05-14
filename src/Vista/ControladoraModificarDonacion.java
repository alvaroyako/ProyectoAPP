package Vista;

import java.sql.SQLException;

import Modelo.ConexionBBDD;
import Modelo.Donacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControladoraModificarDonacion {

	@FXML
	private Button add;
	
	@FXML
	private Button borrar;
	
	
	@FXML
	private TextField cod_donacion;
	
	@FXML
	private TextField fecha;

	@FXML
	private TextField volumen;

	@FXML
	private TextField ultima;
	
	@FXML
	private TextField sangre;
	
	@FXML
   	private TableView<Donacion> tabla;
    
    @FXML
	private TableColumn<Donacion,Integer> col_codigo;

	@FXML
	private TableColumn<Donacion,String> col_ultima;

	@FXML
	private TableColumn<Donacion,String> col_volumen;
	
	@FXML
	private TableColumn<Donacion,String> col_sangre;
	
	@FXML
	private TableColumn<Donacion,String> col_fecha;
	
	ObservableList<Donacion> datos = FXCollections.observableArrayList();
	
	private Stage ventana;

	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
	}
	
	private boolean edicion;
	private int indiceedicion;
	
	public void initialize() throws SQLException{

		// Llamar a un método de la clase de manipulación de BBDD para que me devuelva un ObservableList<Persona> datos

		ConexionBBDD con = new ConexionBBDD();
		datos = con.ObtenerDonaciones();

		tabla.setItems(datos);

		col_codigo.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("id"));
		col_ultima.setCellValueFactory(new PropertyValueFactory<Donacion,String>("ultdonacion"));
		col_volumen.setCellValueFactory(new PropertyValueFactory<Donacion,String>("volumen"));
		col_sangre.setCellValueFactory(new PropertyValueFactory<Donacion,String>("sangre"));
		col_fecha.setCellValueFactory(new PropertyValueFactory<Donacion,String>("fecha"));
	}
	
	public void Borrar(){
		cod_donacion.setText("");
		fecha.setText("");
		volumen.setText("");
		ultima.setText("");
		sangre.setText("");
	}
	
	public void Editar() throws SQLException{


		int index = tabla.getSelectionModel().getSelectedIndex();


		if( index >= 0){

			// Activo la "funcionalidad" de editar para luego que el botón guardar sepa a qué PErsona estoy "editando"
			edicion = true;
			indiceedicion = index;


			
		}
		
		String ids=cod_donacion.getText();
		int id=Integer.parseInt(ids);
		
		
		if(cod_donacion.getText().equals("")||fecha.getText().equals("") || volumen.getText().equals("") || ultima.getText().equals("")||sangre.getText().equals("")){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!!");
			alert.setHeaderText("Observa que hayas introducido todos los datos");
			alert.setContentText("¡No se pueden grabar campos vacíos!");
			alert.showAndWait();
		}else {
		
		ConexionBBDD con = new ConexionBBDD();
		int res = con.ModificarDonacion(id, ultima.getText(), volumen.getText(), sangre.getText(), fecha.getText());
		switch (res){

			case 0:
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("OK!");
				alert.setHeaderText("Modificación OK!");
				alert.setContentText("¡Donacion modificada con éxito!");
				alert.showAndWait();
				this.ventana.close();

				break;

			default:
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error!");
					alert.setHeaderText("Modificación NOK!");
					alert.setContentText("¡Ha habido un problema al realizar el update!");
					alert.showAndWait();
					break;

				}
		}
		
	}
	
	
}
