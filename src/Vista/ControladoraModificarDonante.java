package Vista;

import java.sql.SQLException;

import Modelo.ConexionBBDD;
import Modelo.Donante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControladoraModificarDonante {
	
	@FXML
	private Button buttonclose;

	private Stage ventana;
	
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
	
	@FXML
	private Button editar;
	
	@FXML
	private Button borrar;
	
	@FXML
	private TextField Numero;
	
	@FXML
	private TextField Nombre;
	
	@FXML
	private TextField Apellido1;
	
	@FXML
	private TextField Apellido2;
	
	@FXML
	private TextField DNIoPasaporte;
	
	@FXML
	private TextField Email;
	
	@FXML
	private TextField CP;
	
	@FXML
	private TextField PaisNacimiento;
	
	@FXML
	private TextField TLF;
	
	@FXML
	private TextField TlfMovil;
	
	@FXML
	private TextField Direccion;
	
	@FXML
	private TextField Provincia;
	
	@FXML
	private TextField Poblacion;
	
	@FXML
	private TextField Ciclo;
	
	@FXML
	private TextField Nacimiento;
	
	@FXML
	private TextField TipoResidencia;
	
	@FXML
	private TextField SituacionDonante;
	
	@FXML
	private TextField Sangre;
	
	@FXML
	RadioButton hombre;

	@FXML
	RadioButton mujer;

	@FXML
	ToggleGroup sexo;
	
	private boolean edicion;
	private int indiceedicion;
	
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
	
	public void Borrar(){
		Numero.setText("");
		Nombre.setText("");
		Apellido1.setText("");
		Apellido2.setText("");
		DNIoPasaporte.setText("");
		Email.setText("");
		CP.setText("");
		PaisNacimiento.setText("");
		TLF.setText("");
		TlfMovil.setText("");
		Direccion.setText("");
		Provincia.setText("");
		Poblacion.setText("");
		Ciclo.setText("");
		Nacimiento.setText("");
		TipoResidencia.setText("");
		SituacionDonante.setText("");
		Sangre.setText("");
		
	}
	
	public void Editar() throws SQLException{


		int index = tabla.getSelectionModel().getSelectedIndex();


		if( index >= 0){

			// Activo la "funcionalidad" de editar para luego que el botón guardar sepa a qué PErsona estoy "editando"
			edicion = true;
			indiceedicion = index;


			
		}
		char sexo;
		
		String ids=Numero.getText();
		int id=Integer.parseInt(ids);
		
		String cps=CP.getText();
		int cp=Integer.parseInt(cps);
		
		String tlfs=TLF.getText();
		int tlf=Integer.parseInt(tlfs);
		
		String tlfms=TlfMovil.getText();
		int tlfm=Integer.parseInt(tlfms);

		if(hombre.isSelected())
			sexo = 'H';
		else
			sexo = 'M';
		
		if(Numero.getText().equals("")||Nombre.getText().equals("") || Apellido1.getText().equals("") || Apellido2.getText().equals("")||DNIoPasaporte.getText().equals("")||Email.getText().equals("")||CP.getText().equals("")||PaisNacimiento.getText().equals("")||TLF.getText().equals("")||TlfMovil.getText().equals("")||Direccion.getText().equals("")||Provincia.getText().equals("")||Poblacion.getText().equals("")||Ciclo.getText().equals("")||Nacimiento.getText().equals("")||TipoResidencia.getText().equals("")||SituacionDonante.getText().equals("")||Sangre.getText().equals("")){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!!");
			alert.setHeaderText("Observa que hayas introducido todos los datos");
			alert.setContentText("¡No se pueden grabar campos vacíos!");
			alert.showAndWait();
		}else {
		
		ConexionBBDD con = new ConexionBBDD();
		int res = con.ModificarDonante(id,Nombre.getText(),Apellido1.getText(),Apellido2.getText(),DNIoPasaporte.getText(),sexo,Email.getText(),Ciclo.getText(),SituacionDonante.getText(),cp,Nacimiento.getText(),PaisNacimiento.getText(),tlf,tlfm,Direccion.getText(),Provincia.getText(),TipoResidencia.getText(),Poblacion.getText(),Sangre.getText());
		switch (res){

			case 0:
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("OK!");
				alert.setHeaderText("Modificación OK!");
				alert.setContentText("¡Persona modificada con éxito!");
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

	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
	}
	

}
