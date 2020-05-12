package Vista;


import java.sql.SQLException;
import java.util.Optional;

import Controlador.Main;
import Modelo.ConexionBBDD;
import Modelo.Donante;
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
    
    @FXML
	private TableView<Donante> tabla;

	@FXML
	private TableColumn<Donante,Integer> numero;

	@FXML
	private TableColumn<Donante,String> nombre;

	@FXML
	private TableColumn<Donante,String> apellido1;
	
	@FXML
	private TableColumn<Donante,String> apellido2;
	
	@FXML
	private TableColumn<Donante,String> DNI;

	@FXML
	private TableColumn<Donante,Character> col_sexo;
	
	@FXML
	private TableColumn<Donante,String> col_email;
	
	@FXML
	private TableColumn<Donante,String> ciclo;
	
	@FXML
	private TableColumn<Donante,String> situacion;
	
	@FXML
	private TableColumn<Donante,Integer> cp;
	
	@FXML
	private TableColumn<Donante,String> nacimiento;
	
	@FXML
	private TableColumn<Donante,String> pais;
	
	@FXML
	private TableColumn<Donante,Integer> tlf;
	
	@FXML
	private TableColumn<Donante,Integer> tlfmovil;
	
	@FXML
	private TableColumn<Donante,String> direccion;
	
	@FXML
	private TableColumn<Donante,String> provincia;
	
	@FXML
	private TableColumn<Donante,String> tipo_residencia;
	
	@FXML
	private TableColumn<Donante,String> poblacion;
	
	@FXML
	private TableColumn<Donante,String> sangre;

	
	
	ObservableList<Donante> datos = FXCollections.observableArrayList();

	
	
	

	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
	}
	
	public void setProgramaPrincipal(Main ProgramaPrincipal) {
		this.ProgramaPrincipal=ProgramaPrincipal;
	}
	
	
	public void initialize() throws SQLException{

		// Llamar a un método de la clase de manipulación de BBDD para que me devuelva un ObservableList<Persona> datos

		ConexionBBDD con = new ConexionBBDD();
		datos = con.ObtenerDonantes();

		tabla.setItems(datos);

		numero.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("ID"));
		nombre.setCellValueFactory(new PropertyValueFactory<Donante,String>("Nombre"));
		apellido1.setCellValueFactory(new PropertyValueFactory<Donante,String>("Apellido1"));
		apellido2.setCellValueFactory(new PropertyValueFactory<Donante,String>("Apellido2"));
		DNI.setCellValueFactory(new PropertyValueFactory<Donante,String>("DNIoPasaporte"));
		col_sexo.setCellValueFactory(new PropertyValueFactory<Donante,Character>("sexo"));
		col_email.setCellValueFactory(new PropertyValueFactory<Donante,String>("email"));
		ciclo.setCellValueFactory(new PropertyValueFactory<Donante,String>("Ciclo"));
		situacion.setCellValueFactory(new PropertyValueFactory<Donante,String>("Situacion"));
		cp.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("CP"));
		nacimiento.setCellValueFactory(new PropertyValueFactory<Donante,String>("Nacimiento"));
		pais.setCellValueFactory(new PropertyValueFactory<Donante,String>("PaisNacimiento"));
		tlf.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("TLF"));
		tlfmovil.setCellValueFactory(new PropertyValueFactory<Donante,Integer>("TLFMovil"));
		direccion.setCellValueFactory(new PropertyValueFactory<Donante,String>("Direccion"));
		provincia.setCellValueFactory(new PropertyValueFactory<Donante,String>("Provincia"));
		tipo_residencia.setCellValueFactory(new PropertyValueFactory<Donante,String>("TResidencia"));
		poblacion.setCellValueFactory(new PropertyValueFactory<Donante,String>("Poblacion"));
		sangre.setCellValueFactory(new PropertyValueFactory<Donante,String>("Sangre"));
		

	}
	
	public void Eliminar() throws SQLException{
		int index = tabla.getSelectionModel().getSelectedIndex();
		if( index >= 0){

			Donante seleccionada = tabla.getSelectionModel().getSelectedItem();

			// Se abre un dialog box de confirmacion de eliminar
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmación!!!");
			alert.setHeaderText("Por favor confirme el borrado");
			alert.setContentText("Desea borrar al usuario "+ seleccionada.getNombre() + " " +seleccionada.getApellido1() +" ?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
			    // ... user chose OK

				// Llamar a un método que realice el DELETE en la base de datos
				ConexionBBDD con = new ConexionBBDD();
				int res = con.BorrarDonante(seleccionada.getID());
				switch(res){
					case 0:
						alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("OK!");
						alert.setHeaderText("Borrado OK!");
						alert.setContentText("¡Persona borrada con éxito!");
						alert.showAndWait();

						// Actualizo los datos de la tabla
						datos = con.ObtenerDonantes();
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

		String buscarapellido = buscar.getText();

		// llama a un  método  que haga el select de la base de datos
		ConexionBBDD con = new ConexionBBDD();
		datos = con.BuscarPersonas(buscarapellido);

		tabla.setItems(datos);


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