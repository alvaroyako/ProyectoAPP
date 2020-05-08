package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

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
	
	public String consultas1() throws SQLException{
		Statement stm = conexion.createStatement();
		String selectsql = "SELECT COUNT (NUM_DONANTE) FROM " + usr +".DONANTES";
		
		try{
			ResultSet resultado = stm.executeQuery(selectsql);
			

		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}
		ResultSet resultado = stm.executeQuery(selectsql);
		String con1 = resultado.getString(1);
		return con1;
	}
}