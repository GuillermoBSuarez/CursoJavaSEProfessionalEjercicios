package service;

public class Cuenta {
	
	private String codigoCuenta;
	private double saldo;
	
	public Cuenta(String codigoCuenta, double saldo) {			// Constructor con 2 parámetros
		this.codigoCuenta = codigoCuenta;
		this.saldo = saldo;
	}

	public Cuenta(String codigoCuenta) {						// Constructor con 1 parámetro
		this.codigoCuenta = codigoCuenta;
		this.saldo = 50;
	}
	
	// métodos
	public void ingresar (double cantidad) {
		saldo += cantidad;
	}

	public void extraer (double cantidad) {
		saldo -= cantidad;
	}

	public double getSaldo () {
		return saldo;
	}
}