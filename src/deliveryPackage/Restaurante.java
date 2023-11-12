package deliveryPackage;
import java.time.LocalTime;
import bankExample1.*;
import pcd.util.Traza;

 class Restaurante {
	private String nombre;						// nombre del restaurante
	private Account account;					// cuenta bancaria para registrar la recaudaci�n
	private LocalTime maxTime;					// m�ximo tiempo de reparto
	private Cocina cocina = new Cocina (this);	// la cocina de este restaurante
	private ControlMoteros controlMoteros; 
	
	public Restaurante (Account _ac, String _nombre, int _numeroMoteros, int _maxTime) {
		account = _ac;
		nombre = _nombre;
		maxTime = LocalTime.of (0,_maxTime);
		controlMoteros = new ControlMoteros (this, Config.numeroMoteros);
		Traza.traza('=',3,"Creando restaurante: "+nombre);
	}
	
	public String getNombre () {
		return nombre;
	}
	
	public LocalTime getMaxTime () {
		return maxTime;
	}
	
	public double getBalance (){
		return account.getBalance();
	}
	
	public Account getAccount () {
		return account;
	}
	
	public void tramitarPedido (Pedido _p) {
		Pedido p =_p;
		account.deposit(p.getPrecioPedido());
		//account.deposit(p.getPrecioPedido());
		cocina.cocinar(p);
		controlMoteros.enviarPedido(p);
		
	}
}
