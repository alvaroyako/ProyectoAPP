package Vista;


import java.sql.SQLException;

import Modelo.ConexionBBDD;
import Modelo.Consulta1;
import Modelo.Consulta2;
import Modelo.Consulta3;
import Modelo.Consulta4;
import Modelo.Consulta5;
import Modelo.Consulta6;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControladoraEstadisticas {

	@FXML
	private Button mostrar;
	
	@FXML
   	private TableView<Consulta1> tabla1;
	
	@FXML
   	private TableView<Consulta2> tabla2;
	
	@FXML
   	private TableView<Consulta3> tabla3;
	
	@FXML
   	private TableView<Consulta4> tabla4;
	
	@FXML
   	private TableView<Consulta5> tabla5;
	
	@FXML
   	private TableView<Consulta6> tabla6;
    
    @FXML
	private TableColumn<Consulta1,Integer> total;

	@FXML
	private TableColumn<Consulta2,Integer> masc;

	@FXML
	private TableColumn<Consulta3,Integer> fem;
	
	@FXML
	private TableColumn<Consulta4,Integer> valde;
	
	@FXML
	private TableColumn<Consulta5,Integer> aptos;
	
	@FXML
	private TableColumn<Consulta6,Integer> esp;
	
	ObservableList<Consulta1> datos = FXCollections.observableArrayList();
	ObservableList<Consulta2> datos2 = FXCollections.observableArrayList();
	ObservableList<Consulta3> datos3 = FXCollections.observableArrayList();
	ObservableList<Consulta4> datos4 = FXCollections.observableArrayList();
	ObservableList<Consulta5> datos5 = FXCollections.observableArrayList();
	ObservableList<Consulta6> datos6 = FXCollections.observableArrayList();

	private Stage ventana4;

	public void setStagePrincipal(Stage ventana4) {
		// TODO Auto-generated method stub
		this.ventana4 = ventana4;
		
	}
	
	public void mostrar() throws SQLException{

		
		ConexionBBDD con = new ConexionBBDD();
		datos = con.Consulta1();

		tabla1.setItems(datos);

		total.setCellValueFactory(new PropertyValueFactory<Consulta1,Integer>("consulta"));
		
		datos2 = con.Consulta2();

		tabla2.setItems(datos2);

		masc.setCellValueFactory(new PropertyValueFactory<Consulta2,Integer>("consulta"));
		
		datos3 = con.Consulta3();

		tabla3.setItems(datos3);

		fem.setCellValueFactory(new PropertyValueFactory<Consulta3,Integer>("consulta"));
		
		datos4 = con.Consulta4();

		tabla4.setItems(datos4);

		valde.setCellValueFactory(new PropertyValueFactory<Consulta4,Integer>("consulta"));
		
		datos5 = con.Consulta5();

		tabla5.setItems(datos5);

		aptos.setCellValueFactory(new PropertyValueFactory<Consulta5,Integer>("consulta"));
		
		datos6 = con.Consulta6();

		tabla6.setItems(datos6);

		esp.setCellValueFactory(new PropertyValueFactory<Consulta6,Integer>("consulta"));
	}
	
	
	



}