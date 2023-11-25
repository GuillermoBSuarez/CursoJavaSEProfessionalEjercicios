//Adaptación del 68_Streams

package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import model.Pedido;

public class ServicePedidos {

	String dir = "c:\\temp\\pedidos.txt";
	Path path;

	public ServicePedidos() {
		File file = new File(dir);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		path = Path.of(dir);
	}

	private Stream<Pedido> getPedidos() {
		try {
			return Files.lines(path)
					.map(s -> new Pedido(
							s.split("[,-]")[0],
							LocalDate.parse(s.split(",")[1]),
							Double.parseDouble(s.split(",")[2])));
		} catch (IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
	}

	public void guardarPedido(String producto, LocalDate fechaPedido, double precio) {
		try {
			Files.writeString(
					path,
					(producto + "," + fechaPedido + "," + precio) + System.lineSeparator(),
					StandardOpenOption.APPEND);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public Pedido pedidoMasReciente() {
		return getPedidos()
				.max((a, b) -> a.getFechaPedido().compareTo(b.getFechaPedido()))
				.orElse(null);
	}

	public List<Pedido> pedidosPrecio(double precioMax) {
		return getPedidos()
				.filter(p -> p.getPrecio() <= precioMax)
				.toList();
	}

	public List<Pedido> anteriores(int meses) {
		return getPedidos()
				.filter(p -> p.getFechaPedido().isBefore(LocalDate.now().minusMonths(meses)))
				.toList();
	}
}