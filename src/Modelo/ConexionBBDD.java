package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConexionBBDD {

	private String url= "";
	private   String user = "";
	private String pwd = "";
	private   String usr = "";
	private   Connection conexion;

	public ConexionBBDD()  {


		Properties propiedades = new Properties();
		InputStream entrada = null;
		try {
			File miFichero = new File("src/Modelo/bbdd.ini");
			if (miFichero.exists()){
				entrada = new FileInputStream(miFichero);
				propiedades.load(entrada);
				url=propiedades.getProperty("url");
				user=propiedades.getProperty("user");
				pwd=propiedades.getProperty("pwd");
				usr=propiedades.getProperty("usr");
			}

			else
				System.out.println("Fichero no encontrado");
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, user, pwd);

			if(conexion.isClosed())
				System.out.println("Fallo en Conexión con la Base de Datos");


		}catch (Exception e) {
			System.out.println("ERROR en conexión con ORACLE");
			e.printStackTrace();
		}
	}
	
	public int InsertarDonante(int iD, String nombre, String apellido1, String apellido2, String dNIoPasaporte, char sexo,
			String email, String ciclo, String situacion, int cP, String nacimiento, String paisNacimiento, int tLF,
			int tLFMovil, String direccion, String provincia, String tResidencia, String poblacion, String sangre) throws SQLException{


		// Preparo la sentencia SQL
		String insertsql = "INSERT INTO " + usr +".DONANTES VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NULL)";

		PreparedStatement pstmt = conexion.prepareStatement (insertsql);
		pstmt.setInt(1, iD);
		pstmt.setString(2, nombre);
		pstmt.setString(3, apellido1);
		pstmt.setString(4, apellido2);
		pstmt.setString(5, dNIoPasaporte);
		pstmt.setString(6, Character.toString(sexo));
		pstmt.setString(7, email);
		pstmt.setString(8, ciclo);
		pstmt.setString(9, situacion);
		pstmt.setInt(10, cP);
		pstmt.setString(11, nacimiento);
		pstmt.setString(12, paisNacimiento);
		pstmt.setInt(13, tLF);
		pstmt.setInt(14, tLFMovil);
		pstmt.setString(15, direccion);
		pstmt.setString(16, provincia);
		pstmt.setString(17, tResidencia);
		pstmt.setString(18, poblacion);
		pstmt.setString(19, sangre);
		//ejecuto la sentencia
		try{
			int resultado = pstmt.executeUpdate();

			if(resultado != 1)
				System.out.println("Error en la inserción " + resultado);
			else
				System.out.println("Persona insertada con éxito!!!");

			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			if(codeErrorSQL.equals("ORA-00001") ){
				System.out.println("Ya existe una persona con  ese id de donante o con ese DNI/Pasaporte!!");
				return 1;
			}
			else{
				System.out.println("Ha habido algún problema con  Oracle al hacer la insercion");
				return 2;
			}

		}

	}
	
	public ObservableList<Donante> ObtenerDonantes() throws SQLException{

		ObservableList<Donante> listadonantes = FXCollections.observableArrayList();

		//Preparo la conexión para ejecutar sentencias SQL de tipo update
		Statement stm = conexion.createStatement();

		// Preparo la sentencia SQL CrearTablaPersonas
		String selectsql = "SELECT * FROM " + usr +".DONANTES";
		
		
		

		//ejecuto la sentencia
		try{
			ResultSet resultado = stm.executeQuery(selectsql);

			int contador = 0;
			while(resultado.next()){
				contador++;
				int id=resultado.getInt(1);
				String nombre = resultado.getString(2);
				String apellido1 = resultado.getString(3);
				String apellido2 = resultado.getString(4);
				String DNIoPasaporte = resultado.getString(5);
				char sexo = resultado.getString(6).charAt(0);
				String email = resultado.getString(7);
				String ciclo = resultado.getString(8);
				String situacion = resultado.getString(9);
				int cp = resultado.getInt(10);
				String nacimiento = resultado.getString(11);
				String paisnacimiento = resultado.getString(12);
				int tlf = resultado.getInt(13);
				int tlfmovil = resultado.getInt(14);
				String direccion = resultado.getString(15);
				String provincia = resultado.getString(16);
				String tiporesidencia = resultado.getString(17);
				String poblacion = resultado.getString(18);
				String sangre = resultado.getString(19);

				Donante nueva = new Donante(id,nombre, apellido1,apellido2,DNIoPasaporte,sexo,email,ciclo,situacion,cp,nacimiento,paisnacimiento,tlf,tlfmovil,direccion,provincia,tiporesidencia,poblacion,sangre);
				listadonantes.add(nueva);
			}

			if(contador==0)
				System.out.println("no data found");

		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}

		return listadonantes;
	}
	
	public int BorrarDonante(int id) throws SQLException{

		// Preparo la sentencia SQL y la conexión para ejecutar sentencias SQL de tipo update
		String deletesql = "DELETE " + usr +".DONANTES WHERE NUM_DONANTE= ?";
		PreparedStatement pstmt = conexion.prepareStatement (deletesql);
		pstmt.setInt(1, id);

		//ejecuto la sentencia
		try{
			int resultado = pstmt.executeUpdate();

			if(resultado != 1)
				System.out.println("Error en el borrado " + resultado);
			else
				System.out.println("Persona borrada con éxito!!!");

			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println("Ha habido algún problema con  Oracle al hacer el borrado" + codeErrorSQL);
			return 2;
		}

	}
	
	public ObservableList<Donante> BuscarPersonas(String apellido) throws SQLException{

		ObservableList<Donante> listadonantes = FXCollections.observableArrayList();
		PreparedStatement pstmt;

		String selectsql = "";
		if(apellido.equals("")){
			selectsql = "SELECT * FROM " + usr +".DONANTES";
			pstmt = conexion.prepareStatement (selectsql);
		}
		else{
			selectsql = "SELECT * FROM " + usr +".DONANTES WHERE APELLIDO1 LIKE ?%";
			pstmt = conexion.prepareStatement (selectsql);
			pstmt.setString(1, apellido);
		}



		//ejecuto la sentencia
		try{
			ResultSet resultado = pstmt.executeQuery();

			int contador = 0;
			while(resultado.next()){
				contador++;

				int id=resultado.getInt(1);
				String nombre = resultado.getString(2);
				String apellido1 = resultado.getString(3);
				String apellido2 = resultado.getString(4);
				String DNIoPasaporte = resultado.getString(5);
				char sexo = resultado.getString(6).charAt(0);
				String email = resultado.getString(7);
				String ciclo = resultado.getString(8);
				String situacion = resultado.getString(9);
				int cp = resultado.getInt(10);
				String nacimiento = resultado.getString(11);
				String paisnacimiento = resultado.getString(12);
				int tlf = resultado.getInt(13);
				int tlfmovil = resultado.getInt(14);
				String direccion = resultado.getString(15);
				String provincia = resultado.getString(16);
				String tiporesidencia = resultado.getString(17);
				String poblacion = resultado.getString(18);
				String sangre = resultado.getString(19);

				Donante nueva = new Donante(id,nombre, apellido1,apellido2,DNIoPasaporte,sexo,email,ciclo,situacion,cp,nacimiento,paisnacimiento,tlf,tlfmovil,direccion,provincia,tiporesidencia,poblacion,sangre);
				listadonantes.add(nueva);
			}

			if(contador==0)
				System.out.println("no data found");

		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}

		return listadonantes;
	}
}