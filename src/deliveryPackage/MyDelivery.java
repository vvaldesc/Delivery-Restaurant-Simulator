package deliveryPackage;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import bankExample1.Bank;
import pcd.util.Traza;

public class MyDelivery{
	static Config config;
	static List<Restaurante> lr1;
	
	public static void lanzarPedidos (List<Pedido> lp, List<Restaurante> _lr) {
		lr1 = _lr;
		// Lanzamiento secuencial. 
		// T� tendr�s que cambiarlo por lanzamiento con threads
		
		
		Thread t= new Thread(lp.get(0));
		Thread t= new Thread(lr1.get(0));
		
		t.start();
		for (Pedido p:lp) {
				lr1.get(p.getRestaurante()).tramitarPedido(p);
				
			}
		
	}
		
	public static void main(String[] args) {
		// para facilitar las trazas
		Traza traza = new Traza (Config.modoTraza);
		
		// CREAR RESTAURANTES
		// Creando el banco de los restaurantes con 0 euros.
		Bank b = new Bank(Config.numeroRestaurantes,0);
		
		// Creando los restaurantes
		LinkedList<Restaurante> listaRestaurantes = new LinkedList<>();
		CrearRestaurantes crearRestaurantes = new CrearRestaurantes (b,listaRestaurantes,config.numeroRestaurantes);
		crearRestaurantes.crear();

		// CREAR PEDIDOS
		List<Pedido> pedidosCallCenter = Pedido.generaPedidos(config.numeroPedidos, Canal.CC);
		List<Pedido> pedidosWeb = Pedido.generaPedidos(config.numeroPedidos, Canal.Web);
		List<Pedido> pedidosMobile = Pedido.generaPedidos(config.numeroPedidos, Canal.Mobile);
		
		// LANZAR PEDIDOS
		long initialTime = new Date().getTime();
		lanzarPedidos (pedidosCallCenter,listaRestaurantes);
		lanzarPedidos (pedidosWeb,listaRestaurantes);
		lanzarPedidos (pedidosMobile,listaRestaurantes);
		
		// Auditor�as
		
		for (Restaurante r:listaRestaurantes) 
			System.out.print ("\nAuditor�a Restaurante "+r.getNombre()+" "+r.getBalance());
		
		System.out.println ("\nAuditoria Cadena: "+ b.audit(0, config.numeroRestaurantes));
		System.out.println ("Tiempo total invertido en la tramitaci�n: "+(new Date().getTime() - initialTime));
	}		
}
