package service;

import java.util.Date;
import java.util.HashSet;

import model.Pedido;

public class ServicePedidos {
	
	HashSet<Pedido> pedidos = new HashSet<>();
	
	public void guardar (String producto, Date fecha, double precio) {
		pedidos.add(new Pedido(producto, fecha, precio));
	}

	public Pedido masReciente() {
		Pedido pedido = null;				// El pedido que devolverá.
		Date maxFecha = new Date(0);		// Donde irá guardando las fechas comparadas, quedándose con la máxima.
		for (Pedido p:pedidos) {
			if (p.getFecha().after(maxFecha)) {
				maxFecha = p.getFecha();
				pedido = p;
			}
		}
		return pedido;
	}
	
	public HashSet<Pedido> pedidosInf(double precio) {
		HashSet<Pedido> pedInf = new HashSet<>();	// Conjunto de pedidos que devolverá.
		for (Pedido ped:pedidos) {
			if (ped.getPrecio() <= precio) {
				pedInf.add(ped);
			}
		}
		return pedInf;
	}
}