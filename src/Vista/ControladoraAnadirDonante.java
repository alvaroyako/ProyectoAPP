package Vista;

import java.sql.SQLException;

import Modelo.ConexionBBDD;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControladoraAnadirDonante {
	
	@FXML
	private Button add;
	
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

	private Stage ventana;
	
	
	

	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
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
	
	public void addDonante() throws SQLException{
		

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


			// Añadir un chequeo de campos vacíos o de validación de formato como el email
			if(Numero.getText().equals("")||Nombre.getText().equals("") || Apellido1.getText().equals("") || Apellido2.getText().equals("")||DNIoPasaporte.getText().equals("")||Email.getText().equals("")||CP.getText().equals("")||PaisNacimiento.getText().equals("")||TLF.getText().equals("")||TlfMovil.getText().equals("")||Direccion.getText().equals("")||Provincia.getText().equals("")||Poblacion.getText().equals("")||Ciclo.getText().equals("")||Nacimiento.getText().equals("")||TipoResidencia.getText().equals("")||SituacionDonante.getText().equals("")||Sangre.getText().equals("")){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!!!");
				alert.setHeaderText("Observa que hayas introducido todos los datos");
				alert.setContentText("¡No se pueden grabar campos vacíos!");
				alert.showAndWait();
			}
			else{

					// Realizar el insertado de datos en la base de datos
					ConexionBBDD con = new ConexionBBDD();
					int res = con.InsertarDonante(id,Nombre.getText(),Apellido1.getText(),Apellido2.getText(),DNIoPasaporte.getText(),sexo,Email.getText(),Ciclo.getText(),SituacionDonante.getText(),cp,Nacimiento.getText(),PaisNacimiento.getText(),tlf,tlfm,Direccion.getText(),Provincia.getText(),TipoResidencia.getText(),Poblacion.getText(),Sangre.getText());
					switch (res){

					case 0:
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("OK!");
						alert.setHeaderText("Inserción OK!");
						alert.setContentText("¡Persona insertada con éxito!");
						alert.showAndWait();
						this.ventana.close();

						break;

					case 1:
						alert = new Alert(AlertType.WARNING);
						alert.setTitle("Aviso!");
						alert.setHeaderText("Inserción NOK!");
						alert.setContentText("¡Ya existe una persona con ese ID o DNI/Pasaporte!");
						alert.showAndWait();
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

			}

		
	}
	


