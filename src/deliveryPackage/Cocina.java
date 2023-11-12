package deliveryPackage;
import pcd.util.Traza;

public class Cocina {
	
	public Cocina (Restaurante r) {

	}
	
	public void cocinar (Pedido p) {
		Traza.traza('=', 2, "Cocinando el pedido: "+p.printConRetorno());
	}
}