/*
Crear nueva clase CuentaMovimientos, heredera de CuentaLimite, que añade un método
obtenerMovimientos, que devuelve un ArrayList de movimientos.
*/
package service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import model.Movimiento;

public class CuentaMovimientos extends CuentaLimite {

	ArrayList<Movimiento> movimientos = new ArrayList<>();

	public CuentaMovimientos(String codigoCuenta, double saldo, double limite) {
		super(codigoCuenta, saldo, limite);
	}

	public ArrayList<Movimiento> obtenerMovimientos() {
		return movimientos;
	}

	@Override
	public void ingresar(double cantidad) {
		Movimiento mov = new Movimiento(cantidad, LocalDateTime.now(), "Ingreso");
		movimientos.add(mov);
		super.ingresar(cantidad);
	}

	@Override
	public void extraer(double cantidad) {
		Movimiento mov = new Movimiento(cantidad, LocalDateTime.now(), "Extracción");
		movimientos.add(mov);
		super.extraer(cantidad);
	}
}