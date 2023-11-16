package model;

import java.util.Date;

public class Pedido {
	
	private String producto;
	private Date fecha;
	private double precio;
	
	public Pedido (String producto, Date fecha, double precio) {
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
