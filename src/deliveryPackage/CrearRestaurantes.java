package deliveryPackage;
import java.util.LinkedList;
import bankExample1.Bank;

public class CrearRestaurantes   {
	LinkedList <Restaurante> lista=null;
	int numRestaurantes;
	Bank b;	// todos los restaurantes comparten el mismo banco, pero cada uno tiene su cuenta
	
	public CrearRestaurantes (Bank _b, LinkedList <Restaurante> _lista, int _numRestaurantes) {
		lista=_lista;	
		numRestaurantes = _numRestaurantes;
		b = _b;
	}
	
	public void crear () {
		for (int i=0;i<numRestaurantes;i++) {	
			Restaurante r = new Restaurante (b.getAccount(i),
											""+i, 						// el nombre del Restaurante
											Config.numeroMoteros,  		// n�mero de moteros del restaurante
											Config.maxTimeRestaurante);	// m�ximo tiempo de reparto
			lista.add(r);
		}
	}
	
}
