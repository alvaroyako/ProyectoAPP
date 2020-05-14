package Vista;

import java.sql.SQLException;

import Modelo.ConexionBBDD;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControladoraAnadirDonacion {

	@FXML
	private Button add;
	
	@FXML
	private Button borrar;
	
	@FXML
	private TextField cod_donante;
	
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
	
	
	private Stage ventana;
	
	public void addDonacion() throws SQLException{
		
		String ids=cod_donacion.getText();
		int id=Integer.parseInt(ids);
		
		String ids2=cod_donante.getText();
		int id2=Integer.parseInt(ids2);


		// Añadir un chequeo de campos vacíos o de validación de formato como el email
		if(cod_donacion.getText().equals("")||cod_donante.getText().equals("")||fecha.getText().equals("") || volumen.getText().equals("") || ultima.getText().equals("")||sangre.getText().equals("")){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!!");
			alert.setHeaderText("Observa que hayas introducido todos los datos");
			alert.setContentText("¡No se pueden grabar campos vacíos!");
			alert.showAndWait();
		}
		else{

				// Realizar el insertado de datos en la base de datos
				ConexionBBDD con = new ConexionBBDD();
				int res = con.InsertarDonacion(id2,id,ultima.getText(),volumen.getText(),sangre.getText(),fecha.getText());
				switch (res){

				case 0:
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("OK!");
					alert.setHeaderText("Inserción OK!");
					alert.setContentText("¡Donacion insertada con éxito!");
					alert.showAndWait();
					this.ventana.close();

					break;

				case 1:
					alert = new Alert(AlertType.WARNING);
					alert.setTitle("Aviso!");
					alert.setHeaderText("Inserción NOK!");
					alert.setContentText("¡Ya existe una donacion con ese ID");
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
	public void Borrar(){
		cod_donante.setText("");
		cod_donacion.setText("");
		fecha.setText("");
		volumen.setText("");
		ultima.setText("");
		sangre.setText("");
	}

	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
	}
	
	
	
}
