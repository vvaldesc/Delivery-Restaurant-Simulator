import java.util.List;

import pcd.util.Traza;

public class ControlMoteros {
	int numeroMoteros;
	Restaurante r;
	List<Motero> listaMot;
	
	public ControlMoteros (Restaurante _r, int _numeroMoteros) {
		r=_r;
		numeroMoteros = _numeroMoteros;
	}

	public void enviarPedido (Pedido p) {
		Traza.traza('-',2,"REPARTIENDO PEDIDO : "+p.getId());
		try {
			Thread.sleep(100);
			System.out.print('.');
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*public Pedido getPedido (String idMotero) {
	// llamado por el motero
		
		Motero(idMotero);
		int i;
		for(i=0;i<numeroMoteros;i++){
			if(aux.getIdMotero()==idMotero) {
				
			}
		}
	}*/
	
	public void regresaMotero (Motero m) {
		Traza.traza('-',2,"MOTERO REGRESANDO : "+m.getIdMotero());
		try {
			Thread.sleep(100);
			System.out.print('.');
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	public void puedoCocinar () {
	}
	*/
}
