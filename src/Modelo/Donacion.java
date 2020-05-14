package Modelo;

public class Donacion {
	private int id;
	private String ultdonacion;
	private String volumen;
	private String sangre;
	private String fecha;
	public Donacion(int id, String ultdonacion, String volumen, String sangre, String fecha) {
		super();
		this.id = id;
		this.ultdonacion = ultdonacion;
		this.volumen = volumen;
		this.sangre = sangre;
		this.fecha = fecha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUltdonacion() {
		return ultdonacion;
	}
	public void setUltdonacion(String ultdonacion) {
		this.ultdonacion = ultdonacion;
	}
	public String getVolumen() {
		return volumen;
	}
	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}
	public String getSangre() {
		return sangre;
	}
	public void setSangre(String sangre) {
		this.sangre = sangre;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
