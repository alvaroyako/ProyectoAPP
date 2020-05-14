package Vista;

import java.sql.SQLException;
import java.util.Optional;

import Controlador.Main;
import Modelo.CodigoFormulario;
import Modelo.ConexionBBDD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControladoraFormulario {
	
	@FXML
	private TableView<CodigoFormulario> tabla;
	    
	@FXML
	private TableColumn<CodigoFormulario,Integer> codigo;
	    
	@FXML
    private Button eliminar;

	@FXML
	private Button continuar;
	
	@FXML
	private Button borrar;
	
	@FXML
	private TextField codigoformulario;
	
	@FXML
	private TextField codigodonante;
	
	@FXML
	private TextField fecha;
	
	
	@FXML
	RadioButton p1si;
	
	@FXML
	RadioButton p1no;
	
	@FXML
	ToggleGroup p1;
	
	@FXML
	RadioButton p2si;
	
	@FXML
	RadioButton p2no;
	
	@FXML
	ToggleGroup p2;
	
	@FXML
	RadioButton p3si;
	
	@FXML
	RadioButton p3no;
	
	@FXML
	ToggleGroup p3;
	
	@FXML
	RadioButton p4si;
	
	@FXML
	RadioButton p4no;
	
	@FXML
	ToggleGroup p4;
	
	@FXML
	RadioButton p5si;
	
	@FXML
	RadioButton p5no;
	
	@FXML
	ToggleGroup p5;
	
	@FXML
	RadioButton p6si;
	
	@FXML
	RadioButton p6no;
	
	@FXML
	ToggleGroup p6;
	
	@FXML
	RadioButton p7si;
	
	@FXML
	RadioButton p7no;
	
	@FXML
	ToggleGroup p7;
	
	@FXML
	RadioButton p8si;
	
	@FXML
	RadioButton p8no;
	
	@FXML
	ToggleGroup p8;
	
	@FXML
	RadioButton p9si;
	
	@FXML
	RadioButton p9no;
	
	@FXML
	ToggleGroup p9;
	
	@FXML
	RadioButton p10si;
	
	@FXML
	RadioButton p10no;
	
	@FXML
	ToggleGroup p10;
	
	@FXML
	RadioButton p11si;
	
	@FXML
	RadioButton p11no;
	
	@FXML
	ToggleGroup p11;
	
	@FXML
	RadioButton p12si;
	
	@FXML
	RadioButton p12no;
	
	@FXML
	ToggleGroup p12;
	
	@FXML
	RadioButton p13si;
	
	@FXML
	RadioButton p13no;
	
	@FXML
	ToggleGroup p13;
	
	@FXML
	RadioButton p14si;
	
	@FXML
	RadioButton p14no;
	
	@FXML
	ToggleGroup p14;
	
	@FXML
	RadioButton p15si;
	
	@FXML
	RadioButton p15no;
	
	@FXML
	ToggleGroup p15;
	
	@FXML
	RadioButton p16si;
	
	@FXML
	RadioButton p16no;
	
	@FXML
	ToggleGroup p16;
	
	@FXML
	RadioButton p17si;
	
	@FXML
	RadioButton p17no;
	
	@FXML
	ToggleGroup p17;
	
	@FXML
	RadioButton p18si;
	
	@FXML
	RadioButton p18no;
	
	@FXML
	ToggleGroup p18;
	
	@FXML
	RadioButton p19si;
	
	@FXML
	RadioButton p19no;
	
	@FXML
	ToggleGroup p19;
	
	@FXML
	RadioButton p20si;
	
	@FXML
	RadioButton p20no;
	
	@FXML
	ToggleGroup p20;
	
	@FXML
	RadioButton p21si;
	
	@FXML
	RadioButton p21no;
	
	@FXML
	ToggleGroup p21;
	
	@FXML
	RadioButton p22si;
	
	@FXML
	RadioButton p22no;
	
	@FXML
	ToggleGroup p22;
	
	@FXML
	RadioButton p23si;
	
	@FXML
	RadioButton p23no;
	
	@FXML
	ToggleGroup p23;
	
	@FXML
	RadioButton p24si;
	
	@FXML
	RadioButton p24no;
	
	@FXML
	ToggleGroup p24;
	
	@FXML
	RadioButton p25si;
	
	@FXML
	RadioButton p25no;
	
	@FXML
	ToggleGroup p25;
	
	@FXML
	RadioButton p26si;
	
	@FXML
	RadioButton p26no;
	
	@FXML
	ToggleGroup p26;
	
	@FXML
	RadioButton p27si;
	
	@FXML
	RadioButton p27no;
	
	@FXML
	ToggleGroup p27;
	
	@FXML
	RadioButton p28si;
	
	@FXML
	RadioButton p28no;
	
	@FXML
	ToggleGroup p28;
	
	@FXML
	RadioButton p29si;
	
	@FXML
	RadioButton p29no;
	
	@FXML
	ToggleGroup p29;
	
	@FXML
	RadioButton p30si;
	
	@FXML
	RadioButton p30no;
	
	@FXML
	ToggleGroup p30;
	
	@FXML
	RadioButton p31si;
	
	@FXML
	RadioButton p31no;
	
	@FXML
	ToggleGroup p31;
	

	private Stage ventanaF;
	private Main ProgramaPrincipal;
	
	ObservableList<CodigoFormulario> datos = FXCollections.observableArrayList();
	
	
	public void borrar() {
		codigoformulario.setText("");
		codigodonante.setText("");
		fecha.setText("");
	}
	

	public void setStagePrincipal(Stage ventanaF) {
		// TODO Auto-generated method stub
		this.ventanaF = ventanaF;
	}
	
	public void setProgramaPrincipal(Main ProgramaPrincipal) {
		this.ProgramaPrincipal=ProgramaPrincipal;
	}
	public void initialize() throws SQLException{

		ConexionBBDD con = new ConexionBBDD();
		datos = con.ObtenerFormulario();

		tabla.setItems(datos);

		codigo.setCellValueFactory(new PropertyValueFactory<CodigoFormulario,Integer>("id"));
		
	}
	
	public void Eliminar() throws SQLException{
		int index = tabla.getSelectionModel().getSelectedIndex();
		if( index >= 0){

			CodigoFormulario seleccionada = tabla.getSelectionModel().getSelectedItem();

			// Se abre un dialog box de confirmacion de eliminar
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmación!!!");
			alert.setHeaderText("Por favor confirme el borrado");
			alert.setContentText("Desea borrar el formulario "+ seleccionada.getId()+" ?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
			    // ... user chose OK

				// Llamar a un método que realice el DELETE en la base de datos
				ConexionBBDD con = new ConexionBBDD();
				int res = con.BorrarFormulario(seleccionada.getId());
				switch(res){
					case 0:
						alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("OK!");
						alert.setHeaderText("Borrado OK!");
						alert.setContentText("¡Formulario borrado con éxito!");
						alert.showAndWait();

						// Actualizo los datos de la tabla
						datos = con.ObtenerFormulario();
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
	
	
	public void abrirAnadirDonacion() throws SQLException {
		
		
		if(p1no.isSelected()||p3no.isSelected()||p12si.isSelected()||p14si.isSelected()||p16si.isSelected()||p17si.isSelected()) {
			ConexionBBDD con=new ConexionBBDD();
			char p1;
			char p2;
			char p3;
			char p4;
			char p5;
			char p6;
			char p7;
			char p8;
			char p9;
			char p10;
			char p11;
			char p12;
			char p13;
			char p14;
			char p15;
			char p16;
			char p17;
			char p18;
			char p19;
			char p20;
			char p21;
			char p22;
			char p23;
			char p24;
			char p25;
			char p26;
			char p27;
			char p28;
			char p29;
			char p30;
			char p31;
			
			String ids=codigoformulario.getText();
			int id=Integer.parseInt(ids);
			
			String ids2=codigodonante.getText();
			int id2=Integer.parseInt(ids2);
			
			if(p1si.isSelected())
				p1 = 'S';
			else
				p1 = 'N';
			
			if(p2si.isSelected())
				p2 = 'S';
			else
				p2 = 'N';
			
			if(p3si.isSelected())
				p3 = 'S';
			else
				p3 = 'N';
			
			if(p4si.isSelected())
				p4 = 'S';
			else
				p4 = 'N';
			
			if(p5si.isSelected())
				p5 = 'S';
			else
				p5 = 'N';
			
			if(p6si.isSelected())
				p6 = 'S';
			else
				p6 = 'N';
			
			if(p7si.isSelected())
				p7 = 'S';
			else
				p7 = 'N';
			
			if(p8si.isSelected())
				p8 = 'S';
			else
				p8 = 'N';
			
			if(p9si.isSelected())
				p9 = 'S';
			else
				p9 = 'N';
			
			if(p10si.isSelected())
				p10 = 'S';
			else
				p10 = 'N';
			
			if(p11si.isSelected())
				p11 = 'S';
			else
				p11 = 'N';
			
			if(p12si.isSelected())
				p12 = 'S';
			else
				p12 = 'N';
			
			if(p13si.isSelected())
				p13 = 'S';
			else
				p13 = 'N';
			
			if(p14si.isSelected())
				p14 = 'S';
			else
				p14 = 'N';
			
			if(p15si.isSelected())
				p15 = 'S';
			else
				p15 = 'N';
			
			if(p16si.isSelected())
				p16 = 'S';
			else
				p16 = 'N';
			
			if(p17si.isSelected())
				p17 = 'S';
			else
				p17 = 'N';
			
			if(p18si.isSelected())
				p18 = 'S';
			else
				p18 = 'N';
			
			if(p19si.isSelected())
				p19 = 'S';
			else
				p19 = 'N';
			
			if(p20si.isSelected())
				p20 = 'S';
			else
				p20 = 'N';
			
			if(p21si.isSelected())
				p21 = 'S';
			else
				p21 = 'N';
			
			if(p22si.isSelected())
				p22 = 'S';
			else
				p22 = 'N';
			
			if(p23si.isSelected())
				p23 = 'S';
			else
				p23 = 'N';
			
			if(p24si.isSelected())
				p24 = 'S';
			else
				p24 = 'N';
			
			if(p25si.isSelected())
				p25 = 'S';
			else
				p25 = 'N';
			
			if(p26si.isSelected())
				p26 = 'S';
			else
				p26 = 'N';
			
			if(p27si.isSelected())
				p27 = 'S';
			else
				p27 = 'N';
			
			if(p28si.isSelected())
				p28 = 'S';
			else
				p28 = 'N';
			
			if(p29si.isSelected())
				p29 = 'S';
			else
				p29 = 'N';
			
			if(p30si.isSelected())
				p30 = 'S';
			else
				p30 = 'N';
			
			if(p31si.isSelected())
				p31 = 'S';
			else
				p31 = 'N';
			
			
			int res=con.InsertarRespuestasTemporal(id2,id, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, fecha.getText());
			switch (res){

			case 0:
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("OK!");
				alert.setHeaderText("Inserción OK!");
				alert.setContentText("¡Respuestas insertadas con éxito!");
				alert.showAndWait();
				this.ventanaF.close();

				break;

			case 1:
				alert = new Alert(AlertType.WARNING);
				alert.setTitle("Aviso!");
				alert.setHeaderText("Inserción NOK!");
				alert.setContentText("¡Ya existe un formulario con ese ID");
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
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!!");
			alert.setHeaderText("EXCLUSION TEMPORAL");
			alert.setContentText("Debido a ciertas respuestas, quedas excluido temporalmente");
			alert.showAndWait();
			this.ventanaF.close();
		}else {
			ConexionBBDD con=new ConexionBBDD();
			char p2;
			char p4;
			char p5;
			char p6;
			char p7;
			char p8;
			char p9;
			char p10;
			char p11;
			char p13;
			char p15;
			char p18;
			char p19;
			char p20;
			char p21;
			char p22;
			char p23;
			char p24;
			char p25;
			char p26;
			char p27;
			char p28;
			char p29;
			char p30;
			char p31;
			
			String ids=codigoformulario.getText();
			int id=Integer.parseInt(ids);
			
			String ids2=codigodonante.getText();
			int id2=Integer.parseInt(ids2);
			
			if(p2si.isSelected())
				p2 = 'S';
			else
				p2 = 'N';
			
			if(p4si.isSelected())
				p4 = 'S';
			else
				p4 = 'N';
			
			if(p5si.isSelected())
				p5 = 'S';
			else
				p5 = 'N';
			
			if(p6si.isSelected())
				p6 = 'S';
			else
				p6 = 'N';
			
			if(p7si.isSelected())
				p7 = 'S';
			else
				p7 = 'N';
			
			if(p8si.isSelected())
				p8 = 'S';
			else
				p8 = 'N';
			
			if(p9si.isSelected())
				p9 = 'S';
			else
				p9 = 'N';
			
			if(p10si.isSelected())
				p10 = 'S';
			else
				p10 = 'N';
			
			if(p11si.isSelected())
				p11 = 'S';
			else
				p11 = 'N';
			
			if(p13si.isSelected())
				p13 = 'S';
			else
				p13 = 'N';
			
			if(p15si.isSelected())
				p15 = 'S';
			else
				p15 = 'N';
			
			if(p18si.isSelected())
				p18 = 'S';
			else
				p18 = 'N';
			
			if(p19si.isSelected())
				p19 = 'S';
			else
				p19 = 'N';
			
			if(p20si.isSelected())
				p20 = 'S';
			else
				p20 = 'N';
			
			if(p21si.isSelected())
				p21 = 'S';
			else
				p21 = 'N';
			
			if(p22si.isSelected())
				p22 = 'S';
			else
				p22 = 'N';
			
			if(p23si.isSelected())
				p23 = 'S';
			else
				p23 = 'N';
			
			if(p24si.isSelected())
				p24 = 'S';
			else
				p24 = 'N';
			
			if(p25si.isSelected())
				p25 = 'S';
			else
				p25 = 'N';
			
			if(p26si.isSelected())
				p26 = 'S';
			else
				p26 = 'N';
			
			if(p27si.isSelected())
				p27 = 'S';
			else
				p27 = 'N';
			
			if(p28si.isSelected())
				p28 = 'S';
			else
				p28 = 'N';
			
			if(p29si.isSelected())
				p29 = 'S';
			else
				p29 = 'N';
			
			if(p30si.isSelected())
				p30 = 'S';
			else
				p30 = 'N';
			
			if(p31si.isSelected())
				p31 = 'S';
			else
				p31 = 'N';
			
			
			int res=con.InsertarRespuestasApto(id2,id, 'S', p2, 'S', p4, p5, p6, p7, p8, p9, p10, p11, 'N', p13, 'N', p15, 'N', 'N', p18, p19, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, fecha.getText());
			switch (res){

			case 0:
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("OK!");
				alert.setHeaderText("Inserción OK!");
				alert.setContentText("¡Respuestas insertadas con éxito!");
				alert.showAndWait();
				this.ProgramaPrincipal.mostrarAnadirDonacion();
				this.ventanaF.close();

				break;

			case 1:
				alert = new Alert(AlertType.WARNING);
				alert.setTitle("Aviso!");
				alert.setHeaderText("Inserción NOK!");
				alert.setContentText("¡Ya existe un formulario con ese ID");
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