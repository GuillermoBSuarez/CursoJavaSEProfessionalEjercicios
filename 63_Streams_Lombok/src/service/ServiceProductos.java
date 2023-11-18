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
		/* PRIMER MÉTODO: con replaceAll
		productos.replaceAll(p -> {
			p.setPrecio(p.getPrecio() * (1-porcentaje/100.0));
			return p;
		});
		
		SEGUNDO MÉTODO: con forEach */
		productos.forEach(p -> p.setPrecio(p.getPrecio() * (1-porcentaje/100.0)));
	}
	
	public void ordenarPorPrecio() {
		/* productos.sort((a, b) -> a.getPrecio() - b.getPrecio());
		No funciona porque la resta devuelve un int pero los precios son double y no se pueden convertir.
		Tampoco se puede hacer casting porque quizá la diferencia está en los decimales, que se pierden
		en el casting. Se podrían convertir ambos a Double.valueOf y hacer un compareTo,
		pero la propia clase Double ya tiene un método de comparación de dos doubles primitivos: */
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