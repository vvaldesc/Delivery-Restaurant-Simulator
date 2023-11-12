package deliveryPackage;
import java.util.List;
import java.util.Random;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Pedido implements Runnable {
	
	String idPedido;
	String direccion;			// Direcci�n del cliente
	int restaurante;			// Restaurante al que va el pedido
	Canal canal;				// Canal por el que viene el pedido (web, m�vil, etc)
	LocalDate fecha;			// Fecha del pedido
	LocalTime hora;				// Hora del pedido
	List<Producto> productos;	// Productos que conforman este pedido

	public Pedido (String _idPedido, String _direccion, int _restaurante, Canal _canal, LocalDate _fecha, LocalTime _hora, List<Producto> _productos) {
		idPedido = _idPedido;
		direccion = _direccion;
		restaurante = _restaurante;
		canal =_canal;
		fecha =_fecha;
		hora = _hora;
		productos = _productos;
	}
	
	public String getId() {
		return idPedido;
	}

	public int getRestaurante () {
		return restaurante;
	}
	
	public String getDireccion () {
		return direccion;
	}
	
	public List<Producto> getProductos() {
		return productos;
	}
	
	public Canal getCanal() {
		return canal;
	}
	
	public LocalDate getFecha () {
		return fecha;
	}
	
	public LocalTime getHora () {
		return hora;
	}
	
	public double getPrecioPedido () {
		double suma=0;
		
		List<Producto> productos = this.getProductos();
		for (Producto prod:productos) {
			suma+=prod.getPrecio();
		}
		return suma;
	}
	
	public void print () {
		System.out.println ("Pedido:    ");
		System.out.println ("Id: "+idPedido+" "+direccion+" "+restaurante+" "+canal+" "+fecha+" "+hora);
	}	
	
	public String printConRetorno () {
		return "Pedido: "+idPedido+" "+direccion+" "+restaurante+" "+canal+" "+fecha+" "+hora;
	}
	
	// GENERAR PEDIDOS
	public synchronized static List<Pedido> generaPedidos (int numPedidos, Canal _canal) {
		List<Pedido> listaPedidos = new ArrayList<>(numPedidos);
		String id;
		Canal canal;
		LocalDate d;
		LocalTime t;
		String direccion;
		int restaurante;
		Random r = new Random();

		for (int i=0;i<numPedidos;i++) {
			canal = _canal;
			direccion = "Direcci�n 1";
			restaurante = r.nextInt(Config.numeroRestaurantes);
			id = canal+"_"+"R"+restaurante+"_"+Ticket.getNumero();
			d = LocalDate.now();
			t = LocalTime.now();
			Pedido p = new Pedido (id, direccion, restaurante, canal, d, t, Producto.generaProductos(Config.numeroProductos));
			listaPedidos.add(p);
		}
		
		return listaPedidos;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.print ("1");
		lr1.get(p.getRestaurante()).tramitarPedido(p);
	}

}


