/*
Crear nueva clase heredera, CuentaLimite, con
- atributo límite, que es lo máximo que se puede ingresar o extraer, si se pide más lo cambia por el límite.
- método ajustaLimite(), que define el límite a la mitad del saldo. No es automático tras cada operación.
*/

package service;

public class CuentaLimite extends Cuenta {

	private double limite;

	public CuentaLimite(String codigoCuenta, double saldo, double limite) {
		super(codigoCuenta, saldo);
		this.limite = limite;
	}

	public void ajustarLimite(double limite) {
		this.limite = getSaldo() / 2;
	}

	@Override
	public void ingresar(double cantidad) {
		if (cantidad > limite)
			cantidad = limite;
		super.ingresar(cantidad);
		/* Aquí no podemos hacer saldo+=cantidad; porque no se puede acceder a saldo
		porque el atributo cuenta.saldo no es visible desde aquí, es private. */
	}

	@Override
	public void extraer(double cantidad) {
		if (cantidad > limite)
			cantidad = limite;
		super.extraer(cantidad);
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
}