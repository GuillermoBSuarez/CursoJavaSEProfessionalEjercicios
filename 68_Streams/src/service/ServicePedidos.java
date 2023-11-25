// Adaptación de 40_Fechas

package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Pedido;

public class ServicePedidos {
	/* PRIMERA VERSIÓN:
	ArrayList<Pedido> pedidos = new ArrayList<>();
	Intenté castear los resultados de los return a ArrayList<Pedido> pero crea un
	ClassCastException porque el List<Pedido> que devuelven las funciones no es
	de tipo ArrayList, así que en la nueva versión se cambia el tipo de objeto a
	la interfaz List<Pedido>. Siempre que trabajemos con streams y colecciones es
	mejor usar interfaces.
	*/

	List<Pedido> pedidos = new ArrayList<>();

	public void guardarPedido(String producto, LocalDate fechaPedido, double precio) {
		pedidos.add(new Pedido(producto, fechaPedido, precio));
	}

	public Pedido pedidoMasReciente() {
		return pedidos.stream()														// Stream<Pedido>
				.max((a, b) -> a.getFechaPedido().compareTo(b.getFechaPedido()))	// Optional<Pedido>
				.orElse(null);
		
		/* PRIMERA VERSIÓN
		Pedido pedido = pedidos.get(0);
		LocalDate fechaReciente = pedido.getFechaPedido();
		for(Pedido p:pedidos) {
			if(p.getFechaPedido().isAfter(fechaReciente)) {	// si encontramos una fecha más reciente,
			fechaReciente = p.getFechaPedido();				// actualizamos variables
			pedido = p; }
		}
		return pedido;
		*/
	}

	public List<Pedido> pedidosPrecio(double precioMax) {
		return pedidos.stream()								// Stream<Pedido>
				.filter(p -> p.getPrecio() < precioMax)		// Stream<Pedido>
				.toList();									// List<Pedido>
		
		/* PRIMERA VERSION
		ArrayList<Pedido> resultado = new ArrayList<Pedido>();
		for(Pedido p:pedidos) {
			if(p.getPrecio() < precioMax) { resultado.add(p); }
		}
		return resultado;
		*/
	}

	public List<Pedido> anteriores(int meses) {
		return pedidos.stream()																	// Stream<Pedido>
				.filter(p -> p.getFechaPedido().isBefore(LocalDate.now().minusMonths(meses)))	// Stream<Pedido>
				.toList();																		// List<Pedido>

		/* PRIMERA VERSION
		ArrayList<Pedido> resultado = new ArrayList<>();
		LocalDate referencia = LocalDate.now().minusMonths(meses);
		for(Pedido p:pedidos) {
			if(p.getFechaPedido().isBefore(referencia)) { resultado.add(p); }
		}
		return resultado;
		*/
	}

	// Devuelve una tabla con una partición de pedidos entre caros y baratos (más y menos de la media)
	public Map<Boolean, List<Pedido>> carosBaratos() {
		double media = pedidos.stream()
				.collect(Collectors.averagingDouble(Pedido::getPrecio));
		return pedidos.stream()
				.collect(Collectors.partitioningBy(p -> p.getPrecio() > media));
		/* Se podría hacer en una instrucción cambiando la variable media por el primer stream,
		pero por cada pedido tendría que hacer el cálculo del averaging otra vez. No es eficiente. */
	}
}