package service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;

import model.Pedido;

public class ServicePedidos {
	
	HashSet<Pedido> pedidos = new HashSet<>();
	
	public void guardar (String producto, LocalDate fecha, double precio) {
		pedidos.add(new Pedido(producto, fecha, precio));
	}

	public Pedido masReciente() {
		Pedido pedido = null;						// El pedido que devolverá.
		LocalDate maxFecha = LocalDate.of(1, 1, 1);	// Donde irá guardando las fechas comparadas, quedándose la máxima.
				  									// Comparamos con el 01/01/0001 porque no habrá ninguno más antiguo, se entiende.
		for (Pedido p:pedidos) {
			if (p.getFecha().isAfter(maxFecha)) {
				maxFecha = p.getFecha();
				pedido = p;
			}
		}
		return pedido;
	}
	
	public HashSet<Pedido> pedidosInf(double precio) {
		HashSet<Pedido> pedInf = new HashSet<>();
		for (Pedido p:pedidos) {
			if (p.getPrecio() <= precio) {
				pedInf.add(p);
			}
		}
		return pedInf;
	}

	public HashSet<Pedido> pedidosAnt(int meses) {
		HashSet<Pedido> pedAnt = new HashSet<>();
		for (Pedido p:pedidos) {
			if (p.getFecha().isBefore(LocalDate.now().minusMonths(meses))) {
				pedAnt.add(p);
			}
		}
		return pedAnt;
	}
}