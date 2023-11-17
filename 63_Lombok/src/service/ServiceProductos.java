package service;

import java.util.ArrayList;
import java.util.List;

import model.Producto;

public class ServiceProductos {
	
	List<Producto> productos = new ArrayList<>();
	
	public void altaProducto(String producto, double precio, String categoria) {
		productos.add(new Producto(producto, precio, categoria));
	}

	public void bajarPrecios(int porcentaje) {
		// primera forma: replaceAll
		productos.replaceAll(p -> {
			p.setPrecio(p.getPrecio() * (1-porcentaje/100.0));
			return p;
		});
		
		// segunda forma: forEach
		productos.forEach(p -> p.setPrecio(p.getPrecio() * (1-porcentaje/100.0)));
	}
	
	public void ordenarPorPrecio() {
		// productos.sort((a, b) -> a.getPrecio() - b.getPrecio());
		// No chuta porque la resta devuelve un int y los precios son double y no se pueden convertir.
		// Tampoco se puede hacer casting porque a lo mejor la diferencia está en los decimales,ç
		// que se pierden en el casting.
		// Se pueden convertir cada uno a Double.valueOf y hacer un compareTo, pero la propia clase
		// Double tiene un método de comparación de dos doubles primitivos:
		productos.sort((a, b) -> Double.compare(a.getPrecio(), b.getPrecio()));
	}

	public void eliminarPorCategoria(String categoria) {
		productos.removeIf(p -> p.getCategoria().equals(categoria));
	}
	
	public void subirPrecioCategoria(int porcentaje, String categoria) {
		productos.replaceAll(p -> {
			if (p.getCategoria().equals(categoria)) {
				p.setPrecio(p.getPrecio() * (1-porcentaje/100.0));
			}
			return p;
		});
	}
	
	public List<Producto> obtenerProductos(){
		return productos;
	}
}
