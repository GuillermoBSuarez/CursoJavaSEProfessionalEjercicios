package package2;

import package1.Uno;

public class Dos extends Uno {
	public void metodo() {
		a = 1;		// private, sólo visible en su clase Uno
		b = 1;		// default, sólo visible en su paquete package1
		c = 1;		// protected, visible en su clase y herederas
		d = 1;		// public, visible

		Uno uno = new Uno();
		uno.a = 1;	// private, sólo visible en su clase Uno
		uno.b = 1;	// default, sólo visible en su paquete package1
		uno.c = 1;	/* protected, sólo accede a los objetos públicos, no a los protected.
					   Antes veía el c protected porque sí se ven en clases herederas,
					   pero uno.c ya no está dentro de la herencia sino que un objeto nuevo. */
		uno.d = 1;	// public, visible
	}
}