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
		String deletesql2= "DELETE " + usr +".REALIZAN WHERE NUM_DONANTE= ?";
		String deletesql3= "DELETE " + usr +".RELLENAN WHERE NUM_DONANTE= ?";
		PreparedStatement pstmt = conexion.prepareStatement (deletesql);
		PreparedStatement pstmt2 = conexion.prepareStatement (deletesql2);
		PreparedStatement pstmt3 = conexion.prepareStatement (deletesql3);
		pstmt.setInt(1, id);
		pstmt2.setInt(1, id);
		pstmt3.setInt(1, id);
		//ejecuto la sentencia
		try{
			int resultado2 = pstmt2.executeUpdate();
			int resultado3=pstmt3.executeUpdate();
			int resultado = pstmt.executeUpdate();
			
			if(resultado != 1)
				System.out.println("Error en el borrado " + resultado);
			else if(resultado2 != 1)
				System.out.println("Error en el borrado " + resultado2);
			else if(resultado3!=1)
				System.out.println("Error en el borrado " + resultado3);
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
			selectsql = "SELECT * FROM " + usr +".DONANTES WHERE APELLIDO1 LIKE ?";
			pstmt = conexion.prepareStatement (selectsql);
			pstmt.setString(1, apellido+"%");
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
	
	public int ModificarDonante(int iD, String nombre, String apellido1, String apellido2, String dNIoPasaporte, char sexo,
			String email, String ciclo, String situacion, int cP, String nacimiento, String paisNacimiento, int tLF,
			int tLFMovil, String direccion, String provincia, String tResidencia, String poblacion, String sangre) throws SQLException{


		// Preparo la sentencia SQL CrearTablaPersonas
		String updatesql = "UPDATE " + usr + ".DONANTES SET NOMBRE= ?, APELLIDO1 =?, APELLIDO2 =?, DNI_O_PASAPORTE=?, SEXO = ?, EMAIL=?, CICLO=?, SITUACION_COMO_DONANTE=?, CP=?, FECHA_NACIMIENTO=?, PAIS_NACIMIENTO=?, TLF=?, TLF_MOVIL=?, DIRECCION=?, PROVINCIA=?, T_RESIDENCIA=?, POBLACION=?, TIPO_SANGUINEO=? WHERE NUM_DONANTE= ?";

		PreparedStatement pstmt = conexion.prepareStatement (updatesql);
		
		pstmt.setString(1, nombre);
		pstmt.setString(2, apellido1);
		pstmt.setString(3, apellido2);
		pstmt.setString(4, dNIoPasaporte);
		pstmt.setString(5, Character.toString(sexo));
		pstmt.setString(6, email);
		pstmt.setString(7, ciclo);
		pstmt.setString(8, situacion);
		pstmt.setInt(9, cP);
		pstmt.setString(10, nacimiento);
		pstmt.setString(11, paisNacimiento);
		pstmt.setInt(12, tLF);
		pstmt.setInt(13, tLFMovil);
		pstmt.setString(14, direccion);
		pstmt.setString(15, provincia);
		pstmt.setString(16, tResidencia);
		pstmt.setString(17, poblacion);
		pstmt.setString(18, sangre);
		pstmt.setInt(19, iD);

		//ejecuto la sentencia
		try{
			int resultado = pstmt.executeUpdate();

			if(resultado != 1)
				System.out.println("Error en la actualización " + resultado);
			else
				System.out.println("Persona actualizada con éxito!!!");

			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			if(codeErrorSQL.equals("ORA-00001") ){
				System.out.println("Ya existe una persona con  ese ID o DNI/Pasaporte!!");
				return 1;
			}
			else{
				System.out.println("Ha habido algún problema con  Oracle al hacer la insercion");
				return 2;
			}

		}

	}
	
	public ObservableList<Donacion> ObtenerDonaciones() throws SQLException{

		ObservableList<Donacion> listadonaciones = FXCollections.observableArrayList();

		
		Statement stm = conexion.createStatement();

		
		String selectsql = "SELECT * FROM " + usr +".DONACIONES";
		
		
		

		//ejecuto la sentencia
		try{
			ResultSet resultado = stm.executeQuery(selectsql);

			int contador = 0;
			while(resultado.next()){
				contador++;
				int id=resultado.getInt(1);
				String ultima = resultado.getString(2);
				String volumen = resultado.getString(3);
				String sangre = resultado.getString(4);
				String fecha = resultado.getString(5);

				Donacion nueva = new Donacion(id,ultima, volumen,sangre,fecha);
				listadonaciones.add(nueva);
			}

			if(contador==0)
				System.out.println("no data found");

		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}

		return listadonaciones;
	}
	
	public int BorrarDonacion(int id) throws SQLException{

		// Preparo la sentencia SQL y la conexión para ejecutar sentencias SQL de tipo update
		String deletesql = "DELETE " + usr +".DONACIONES WHERE CODIGO_DONACION= ?";
		PreparedStatement pstmt = conexion.prepareStatement (deletesql);
		pstmt.setInt(1, id);
		//ejecuto la sentencia
		try{
			int resultado = pstmt.executeUpdate();
			
			if(resultado != 1)
				System.out.println("Error en el borrado " + resultado);
			else
				System.out.println("Donacion borrada con éxito!!!");

			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println("Ha habido algún problema con  Oracle al hacer el borrado" + codeErrorSQL);
			return 2;
		}

	}
	
	public ObservableList<Donacion> BuscarDonaciones(String sangre) throws SQLException{

		ObservableList<Donacion> listadonaciones = FXCollections.observableArrayList();
		PreparedStatement pstmt;

		String selectsql = "";
		if(sangre.equals("")){
			selectsql = "SELECT * FROM " + usr +".DONACIONES";
			pstmt = conexion.prepareStatement (selectsql);
		}
		else{
			selectsql = "SELECT * FROM " + usr +".DONACIONES WHERE TIPO_SANGUINEO LIKE ?";
			pstmt = conexion.prepareStatement (selectsql);
			pstmt.setString(1, sangre+"%");
		}



		//ejecuto la sentencia
		try{
			ResultSet resultado = pstmt.executeQuery();

			int contador = 0;
			while(resultado.next()){
				contador++;

				int id=resultado.getInt(1);
				String ultima = resultado.getString(2);
				String volumen = resultado.getString(3);
				String sangre2 = resultado.getString(4);
				String fecha = resultado.getString(5);

				Donacion nueva = new Donacion(id,ultima, volumen,sangre2,fecha);
				listadonaciones.add(nueva);
			}

			if(contador==0)
				System.out.println("no data found");

		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}

		return listadonaciones;
	}
	
	public ObservableList<CodigoFormulario> ObtenerFormulario() throws SQLException{

		ObservableList<CodigoFormulario> listaformularios = FXCollections.observableArrayList();

		//Preparo la conexión para ejecutar sentencias SQL de tipo update
		Statement stm = conexion.createStatement();

		// Preparo la sentencia SQL CrearTablaPersonas
		String selectsql = "SELECT CODIGO_FORMULARIO FROM " + usr +".FORMULARIO";
		
		
		

		//ejecuto la sentencia
		try{
			ResultSet resultado = stm.executeQuery(selectsql);

			int contador = 0;
			while(resultado.next()){
				contador++;
				int id=resultado.getInt(1);

				CodigoFormulario nueva = new CodigoFormulario(id);
				listaformularios.add(nueva);
			}

			if(contador==0)
				System.out.println("no data found");

		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}

		return listaformularios;
	}
	
	public int BorrarFormulario(int id) throws SQLException{

		// Preparo la sentencia SQL y la conexión para ejecutar sentencias SQL de tipo update
		String deletesql = "DELETE " + usr +".FORMULARIO WHERE CODIGO_FORMULARIO= ?";
		PreparedStatement pstmt = conexion.prepareStatement (deletesql);
		pstmt.setInt(1, id);

		//ejecuto la sentencia
		try{
			int resultado = pstmt.executeUpdate();
			
			if(resultado != 1)
				System.out.println("Error en el borrado " + resultado);
			else
				System.out.println("Formulario borrado con éxito!!!");

			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println("Ha habido algún problema con  Oracle al hacer el borrado" + codeErrorSQL);
			return 2;
		}

	}
	
	
	public int InsertarRespuestasApto(int iddonante,int id,char p1, char p2, char p3, char p4, char p5, char p6, char p7, char p8, char p9, char p10,
			char p11, char p12, char p13, char p14, char p15, char p16, char p17, char p18, char p19, char p20,
			char p21, char p22, char p23, char p24, char p25, char p26, char p27, char p28, char p29, char p30,
			char p31,String fecha) throws SQLException{


		// Preparo la sentencia SQL
		String insertsql = "INSERT INTO " + usr +".FORMULARIO VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NULL,'APTO')";
		String insertsql2 = "INSERT INTO " + usr +".RELLENAN VALUES(?,?)";
		
		PreparedStatement pstmt = conexion.prepareStatement (insertsql);
		pstmt.setInt(1, id);
		pstmt.setString(2, Character.toString(p1));
		pstmt.setString(3, Character.toString(p2));
		pstmt.setString(4, Character.toString(p3));
		pstmt.setString(5, Character.toString(p4));
		pstmt.setString(6, Character.toString(p5));
		pstmt.setString(7, Character.toString(p6));
		pstmt.setString(8, Character.toString(p7));
		pstmt.setString(9, Character.toString(p8));
		pstmt.setString(10, Character.toString(p9));
		pstmt.setString(11, Character.toString(p10));
		pstmt.setString(12, Character.toString(p11));
		pstmt.setString(13, Character.toString(p12));
		pstmt.setString(14, Character.toString(p13));
		pstmt.setString(15, Character.toString(p14));
		pstmt.setString(16, Character.toString(p15));
		pstmt.setString(17, Character.toString(p16));
		pstmt.setString(18, Character.toString(p17));
		pstmt.setString(19, Character.toString(p18));
		pstmt.setString(20, Character.toString(p19));
		pstmt.setString(21, Character.toString(p20));
		pstmt.setString(22, Character.toString(p21));
		pstmt.setString(23, Character.toString(p22));
		pstmt.setString(24, Character.toString(p23));
		pstmt.setString(25, Character.toString(p24));
		pstmt.setString(26, Character.toString(p25));
		pstmt.setString(27, Character.toString(p26));
		pstmt.setString(28, Character.toString(p27));
		pstmt.setString(29, Character.toString(p28));
		pstmt.setString(30, Character.toString(p29));
		pstmt.setString(31, Character.toString(p30));
		pstmt.setString(32, Character.toString(p31));
		pstmt.setString(33, fecha);
		PreparedStatement pstmt2 = conexion.prepareStatement (insertsql2);
		pstmt2.setInt(1, iddonante);
		pstmt2.setInt(2, id);
		//ejecuto la sentencia
		try{
			int resultado = pstmt.executeUpdate();
			int resultado2=pstmt2.executeUpdate();
			
			if(resultado != 1)
				System.out.println("Error en la inserción " + resultado);
			else if(resultado2 != 1)
				System.out.println("Error en la inserción " + resultado2);
			else
				System.out.println("respuestas insertadas con éxito!!!");

			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			if(codeErrorSQL.equals("ORA-00001") ){
				System.out.println("Ya existe un formulario con ese id");
				return 1;
			}
			else{
				System.out.println("Ha habido algún problema con  Oracle al hacer la insercion");
				return 2;
			}

		}

	}
	
	public int InsertarRespuestasTemporal(int iddonante,int id,char p1, char p2, char p3, char p4, char p5, char p6, char p7, char p8, char p9, char p10,
			char p11, char p12, char p13, char p14, char p15, char p16, char p17, char p18, char p19, char p20,
			char p21, char p22, char p23, char p24, char p25, char p26, char p27, char p28, char p29, char p30,
			char p31,String fecha) throws SQLException{


		// Preparo la sentencia SQL
		String insertsql = "INSERT INTO " + usr +".FORMULARIO VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'EXCLUIDO_TEMPORAL')";
		String insertsql2 = "INSERT INTO " + usr +".RELLENAN VALUES(?,?)";
		
		PreparedStatement pstmt = conexion.prepareStatement (insertsql);
		pstmt.setInt(1, id);
		pstmt.setString(2, Character.toString(p1));
		pstmt.setString(3, Character.toString(p2));
		pstmt.setString(4, Character.toString(p3));
		pstmt.setString(5, Character.toString(p4));
		pstmt.setString(6, Character.toString(p5));
		pstmt.setString(7, Character.toString(p6));
		pstmt.setString(8, Character.toString(p7));
		pstmt.setString(9, Character.toString(p8));
		pstmt.setString(10, Character.toString(p9));
		pstmt.setString(11, Character.toString(p10));
		pstmt.setString(12, Character.toString(p11));
		pstmt.setString(13, Character.toString(p12));
		pstmt.setString(14, Character.toString(p13));
		pstmt.setString(15, Character.toString(p14));
		pstmt.setString(16, Character.toString(p15));
		pstmt.setString(17, Character.toString(p16));
		pstmt.setString(18, Character.toString(p17));
		pstmt.setString(19, Character.toString(p18));
		pstmt.setString(20, Character.toString(p19));
		pstmt.setString(21, Character.toString(p20));
		pstmt.setString(22, Character.toString(p21));
		pstmt.setString(23, Character.toString(p22));
		pstmt.setString(24, Character.toString(p23));
		pstmt.setString(25, Character.toString(p24));
		pstmt.setString(26, Character.toString(p25));
		pstmt.setString(27, Character.toString(p26));
		pstmt.setString(28, Character.toString(p27));
		pstmt.setString(29, Character.toString(p28));
		pstmt.setString(30, Character.toString(p29));
		pstmt.setString(31, Character.toString(p30));
		pstmt.setString(32, Character.toString(p31));
		pstmt.setString(33, fecha);
		pstmt.setString(34, fecha);
		PreparedStatement pstmt2 = conexion.prepareStatement (insertsql2);
		pstmt2.setInt(1, iddonante);
		pstmt2.setInt(2, id);
		//ejecuto la sentencia
		try{
			int resultado = pstmt.executeUpdate();
			int resultado2=pstmt2.executeUpdate();
			
			if(resultado != 1)
				System.out.println("Error en la inserción " + resultado);
			else if(resultado2 != 1)
				System.out.println("Error en la inserción " + resultado2);
			else
				System.out.println("respuestas insertadas con éxito!!!");

			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			if(codeErrorSQL.equals("ORA-00001") ){
				System.out.println("Ya existe un formulario con ese id");
				return 1;
			}
			else{
				System.out.println("Ha habido algún problema con  Oracle al hacer la insercion");
				return 2;
			}

		}

	}
	
	public int InsertarDonacion(int iddonante,int id, String ultdonacion, String volumen, String sangre, String fecha) throws SQLException{


		// Preparo la sentencia SQL
		String insertsql = "INSERT INTO " + usr +".DONACIONES VALUES (?,?,?,?,?)";
		String insertsql2 = "INSERT INTO " + usr +".REALIZAN VALUES (?,?)";
		
		PreparedStatement pstmt = conexion.prepareStatement (insertsql);
		PreparedStatement pstmt2 = conexion.prepareStatement (insertsql2);
		pstmt.setInt(1, id);
		pstmt.setString(2, ultdonacion);
		pstmt.setString(3, volumen);
		pstmt.setString(4, sangre);
		pstmt.setString(5, fecha);
		
		pstmt2.setInt(1, iddonante);
		pstmt2.setInt(2, id);
		//ejecuto la sentencia
		try{
			int resultado = pstmt.executeUpdate();
			int resultado2=pstmt2.executeUpdate();

			if(resultado != 1||resultado2!=1)
				System.out.println("Error en la inserción " + resultado);
			else if(resultado2!=1)
				System.out.println("Error en la inserción " + resultado2);
			else
				System.out.println("Donacion insertada con éxito!!!");

			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			if(codeErrorSQL.equals("ORA-00001") ){
				System.out.println("Ya existe una donacion con  esa id!");
				return 1;
			}
			else{
				System.out.println("Ha habido algún problema con  Oracle al hacer la insercion");
				return 2;
			}

		}

	}
	
	public int ModificarDonacion(int id, String ultdonacion, String volumen, String sangre, String fecha) throws SQLException{


		// Preparo la sentencia SQL CrearTablaPersonas
		String updatesql = "UPDATE " + usr + ".DONACIONES SET ULTIMA_DONACION= ?, VOLUMEN =?, TIPO_SANGUINEO =?, FECHA=? WHERE CODIGO_DONACION= ?";

		PreparedStatement pstmt = conexion.prepareStatement (updatesql);
		
		pstmt.setString(1, ultdonacion);
		pstmt.setString(2, volumen);
		pstmt.setString(3, sangre);
		pstmt.setString(4, fecha);
		pstmt.setInt(5, id);

		//ejecuto la sentencia
		try{
			int resultado = pstmt.executeUpdate();

			if(resultado != 1)
				System.out.println("Error en la actualización " + resultado);
			else
				System.out.println("Donacion actualizada con éxito!!!");

			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			if(codeErrorSQL.equals("ORA-00001") ){
				System.out.println("Ya existe una donacion con ese ID!!");
				return 1;
			}
			else{
				System.out.println("Ha habido algún problema con  Oracle al hacer la insercion");
				return 2;
			}

		}

	}
	
	public ObservableList<Consulta1> Consulta1() throws SQLException{
		ObservableList<Consulta1> listaconsultas = FXCollections.observableArrayList();
		Statement stm = conexion.createStatement();		
		String selectsql = "SELECT COUNT (NUM_DONANTE) FROM " + usr +".DONANTES";
		try{
			ResultSet resultado = stm.executeQuery(selectsql);
			int contador = 0;
			while(resultado.next()){
				contador++;
				int n=resultado.getInt(1);

				Consulta1 nueva = new Consulta1(n);
				listaconsultas.add(nueva);
			}

			if(contador==0)
				System.out.println("no data found");

			
			
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}

		return listaconsultas;
	}
	
	public ObservableList<Consulta2> Consulta2() throws SQLException{
		ObservableList<Consulta2> listaconsultas = FXCollections.observableArrayList();
		Statement stm = conexion.createStatement();		
		String selectsql = "SELECT COUNT (NUM_DONANTE) FROM " + usr +".DONANTES WHERE SEXO='H'";
		try{
			ResultSet resultado = stm.executeQuery(selectsql);
			int contador = 0;
			while(resultado.next()){
				contador++;
				int n=resultado.getInt(1);

				Consulta2 nueva = new Consulta2(n);
				listaconsultas.add(nueva);
			}

			if(contador==0)
				System.out.println("no data found");

			
			
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}

		return listaconsultas;
	}
	
	public ObservableList<Consulta3> Consulta3() throws SQLException{
		ObservableList<Consulta3> listaconsultas = FXCollections.observableArrayList();
		Statement stm = conexion.createStatement();		
		String selectsql = "SELECT COUNT (NUM_DONANTE) FROM " + usr +".DONANTES WHERE SEXO='M'";
		try{
			ResultSet resultado = stm.executeQuery(selectsql);
			int contador = 0;
			while(resultado.next()){
				contador++;
				int n=resultado.getInt(1);

				Consulta3 nueva = new Consulta3(n);
				listaconsultas.add(nueva);
			}

			if(contador==0)
				System.out.println("no data found");

			
			
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}

		return listaconsultas;
	}
	
	public ObservableList<Consulta4> Consulta4() throws SQLException{
		ObservableList<Consulta4> listaconsultas = FXCollections.observableArrayList();
		Statement stm = conexion.createStatement();		
		String selectsql = "SELECT COUNT (NUM_DONANTE) FROM " + usr +".DONANTES WHERE POBLACION='VALDEMORO'";
		try{
			ResultSet resultado = stm.executeQuery(selectsql);
			int contador = 0;
			while(resultado.next()){
				contador++;
				int n=resultado.getInt(1);

				Consulta4 nueva = new Consulta4(n);
				listaconsultas.add(nueva);
			}

			if(contador==0)
				System.out.println("no data found");

			
			
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}

		return listaconsultas;
	}
	
	public ObservableList<Consulta5> Consulta5() throws SQLException{
		ObservableList<Consulta5> listaconsultas = FXCollections.observableArrayList();
		Statement stm = conexion.createStatement();		
		String selectsql = "SELECT COUNT (NUM_DONANTE) FROM " + usr +".DONANTES WHERE SITUACION_COMO_DONANTE='APTO'";
		try{
			ResultSet resultado = stm.executeQuery(selectsql);
			int contador = 0;
			while(resultado.next()){
				contador++;
				int n=resultado.getInt(1);

				Consulta5 nueva = new Consulta5(n);
				listaconsultas.add(nueva);
			}

			if(contador==0)
				System.out.println("no data found");

			
			
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}

		return listaconsultas;
	}
	
	public ObservableList<Consulta6> Consulta6() throws SQLException{
		ObservableList<Consulta6> listaconsultas = FXCollections.observableArrayList();
		Statement stm = conexion.createStatement();		
		String selectsql = "SELECT COUNT (NUM_DONANTE) FROM " + usr +".DONANTES WHERE PAIS_NACIMIENTO='ESPAÑA'";
		try{
			ResultSet resultado = stm.executeQuery(selectsql);
			int contador = 0;
			while(resultado.next()){
				contador++;
				int n=resultado.getInt(1);

				Consulta6 nueva = new Consulta6(n);
				listaconsultas.add(nueva);
			}

			if(contador==0)
				System.out.println("no data found");

			
			
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}

		return listaconsultas;
	}
	
	
}