package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.HashSet;

import model.Pedido;

public class ServicePedidos {
	
	String fichero = "c:\\temp\\pedidos.txt";
	
	// Si ejecutamos y, antes de grabar ningún pedido, pedimos listarlos
	// se provoca una excepción porque no existe el archivo. Esto lo evitamos con un constructor.
	public ServicePedidos() {
		File file = new File(fichero);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public void guardar (String producto, LocalDate fecha, double precio) {
		try (	FileOutputStream fos = new FileOutputStream(fichero, true);
				PrintStream ps = new PrintStream(fos)	) {
			ps.println(producto + "," + fecha + "," + precio);
		} catch (IOException e) { e.printStackTrace(); }
	}

	public Pedido masReciente() {
		String string;
		Pedido pedido = null;
		LocalDate maxFecha = LocalDate.of(1, 1, 1);
		
		try (	FileReader fr = new FileReader(fichero);
				BufferedReader br = new BufferedReader(fr)	) {
			while ((string = br.readLine()) != null) {
				Pedido p = new Pedido(string.split(",")[0],							// producto
									  LocalDate.parse(string.split(",")[1]),		// fecha
									  Double.parseDouble(string.split(",")[2]));	// precio
				if (p.fecha().isAfter(maxFecha)) {
					maxFecha = p.fecha();
					pedido = p;
				}
			}
		} catch (IOException e) { e.printStackTrace(); }
		return pedido;
	}

	
	public HashSet<Pedido> pedidosInf(double precio) {
		HashSet<Pedido> pedInf = new HashSet<>();	// Conjunto de pedidos que devolverá.
		String string;
		
		try (	FileReader fr = new FileReader(fichero);
				BufferedReader br = new BufferedReader(fr)	) {
			while ((string = br.readLine()) != null) {
				Pedido p = new Pedido(string.split(",")[0],
									  LocalDate.parse(string.split(",")[1]),
									  Double.parseDouble(string.split(",")[2]));
				if (p.precio() <= precio) pedInf.add(p);
			}
		} catch (IOException e) { e.printStackTrace(); }
		return pedInf;
	}

	
	public HashSet<Pedido> pedidosAnt(int meses) {
		HashSet<Pedido> pedAnt = new HashSet<>();	// Conjunto de pedidos que devolverá.
		String string;
		
		try (	FileReader fr = new FileReader(fichero);
				BufferedReader br = new BufferedReader(fr)	) {
			while ((string = br.readLine()) != null) {
				Pedido p = new Pedido(string.split(",")[0],
									  LocalDate.parse(string.split(",")[1]),
									  Double.parseDouble(string.split(",")[2]));
				if (p.fecha().isBefore((LocalDate.now().minusMonths(meses)))) pedAnt.add(p);
			}
		} catch (IOException e) { e.printStackTrace(); }
		return pedAnt;
	}
}