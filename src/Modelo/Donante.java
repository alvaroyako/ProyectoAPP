package Modelo;

public class Donante {
	private int ID;
	private String Nombre;
	private String Apellido1;
	private String Apellido2;
	private String DNIoPasaporte;
	private char Sexo;
	private String Email;
	private String Ciclo;
	private String Situacion;
	private int CP;
	private String Nacimiento;
	private String PaisNacimiento;
	private int TLF;
	private int TLFMovil;
	private String Direccion;
	private String Provincia;
	private String TResidencia;
	private String Poblacion;
	private String Sangre;
	public Donante(int iD, String nombre, String apellido1, String apellido2, String dNIoPasaporte, char sexo,
			String email, String ciclo, String situacion, int cP, String nacimiento, String paisNacimiento, int tLF,
			int tLFMovil, String direccion, String provincia, String tResidencia, String poblacion, String sangre) {
		super();
		ID = iD;
		Nombre = nombre;
		Apellido1 = apellido1;
		Apellido2 = apellido2;
		DNIoPasaporte = dNIoPasaporte;
		Sexo = sexo;
		Email = email;
		Ciclo = ciclo;
		Situacion = situacion;
		CP = cP;
		Nacimiento = nacimiento;
		PaisNacimiento = paisNacimiento;
		TLF = tLF;
		TLFMovil = tLFMovil;
		Direccion = direccion;
		Provincia = provincia;
		TResidencia = tResidencia;
		Poblacion = poblacion;
		Sangre = sangre;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido1() {
		return Apellido1;
	}
	public void setApellido1(String apellido1) {
		Apellido1 = apellido1;
	}
	public String getApellido2() {
		return Apellido2;
	}
	public void setApellido2(String apellido2) {
		Apellido2 = apellido2;
	}
	public String getDNIoPasaporte() {
		return DNIoPasaporte;
	}
	public void setDNIoPasaporte(String dNIoPasaporte) {
		DNIoPasaporte = dNIoPasaporte;
	}
	public char getSexo() {
		return Sexo;
	}
	public void setSexo(char sexo) {
		Sexo = sexo;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCiclo() {
		return Ciclo;
	}
	public void setCiclo(String ciclo) {
		Ciclo = ciclo;
	}
	public String getSituacion() {
		return Situacion;
	}
	public void setSituacion(String situacion) {
		Situacion = situacion;
	}
	public int getCP() {
		return CP;
	}
	public void setCP(int cP) {
		CP = cP;
	}
	public String getNacimiento() {
		return Nacimiento;
	}
	public void setNacimiento(String nacimiento) {
		Nacimiento = nacimiento;
	}
	public String getPaisNacimiento() {
		return PaisNacimiento;
	}
	public void setPaisNacimiento(String paisNacimiento) {
		PaisNacimiento = paisNacimiento;
	}
	public int getTLF() {
		return TLF;
	}
	public void setTLF(int tLF) {
		TLF = tLF;
	}
	public int getTLFMovil() {
		return TLFMovil;
	}
	public void setTLFMovil(int tLFMovil) {
		TLFMovil = tLFMovil;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	public String getTResidencia() {
		return TResidencia;
	}
	public void setTResidencia(String tResidencia) {
		TResidencia = tResidencia;
	}
	public String getPoblacion() {
		return Poblacion;
	}
	public void setPoblacion(String poblacion) {
		Poblacion = poblacion;
	}
	public String getSangre() {
		return Sangre;
	}
	public void setSangre(String sangre) {
		Sangre = sangre;
	}
	
	
	
	
	
}
