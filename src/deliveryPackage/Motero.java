package deliveryPackage;
import pcd.util.Traza;

public class Motero {
	boolean disponible;
	String idMotero;
	
	
	public Motero(String idMotero) {
		//super();
		this.idMotero = idMotero;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public String getIdMotero() {
		return idMotero;
	}
	public void setIdMotero(String idMotero) {
		this.idMotero = idMotero;
	}
}
