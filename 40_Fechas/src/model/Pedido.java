package model;

import java.time.LocalDate;

public class Pedido {
	
	private String producto;
	private LocalDate fecha;
	private double precio;
	
	public Pedido (String producto, LocalDate fecha, double precio) {
		super();
		this.producto = producto;
		this.fecha = fecha;
		this.precio = precio;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
