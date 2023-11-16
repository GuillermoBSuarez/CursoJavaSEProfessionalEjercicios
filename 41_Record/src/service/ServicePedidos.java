package service;

import java.time.LocalDate;
import java.util.HashSet;

import model.Pedido;

public class ServicePedidos {
	
	HashSet<Pedido> pedidos = new HashSet<>();
	
	public void guardar (String producto, LocalDate fecha, double precio) {
		pedidos.add(new Pedido(producto, fecha, precio));
	}

	public Pedido masReciente() {
		Pedido pedido = null;
		LocalDate maxFecha = LocalDate.of(1, 1, 1);
		for (Pedido p:pedidos) {
			if (p.fecha().isAfter(maxFecha)) {
				maxFecha = p.fecha();
				pedido = p;
			}
		}
		return pedido;
	}
	
	public HashSet<Pedido> pedidosInf(double precio) {
		HashSet<Pedido> pedInf = new HashSet<>();
		for (Pedido p:pedidos) {
			if (p.precio() <= precio) {
				pedInf.add(p);
			}
		}
		return pedInf;
	}

	public HashSet<Pedido> pedidosAnt(int meses) {
		HashSet<Pedido> pedAnt = new HashSet<>();
		for (Pedido p:pedidos) {
			if (p.fecha().isBefore(LocalDate.now().minusMonths(meses))) {
				pedAnt.add(p);
			}
		}
		return pedAnt;
	}
}