// Implementación de interfaces funcionales ANTES de Java 8

package ImplementacionFuncionalClasica;

// 1. Dada una interfaz funcional...
interface Printer{
	void print(String s);
}

// 2. se crea una clase que implementa la interfaz y sobreescriba su método funcional.
class PrinterPantalla implements Printer{
	@Override
	public void print(String s) {
		System.out.println(s);
		
	}	
}

// 3. En el main se instancia un objeto de la clase y se llama al método sobreescrito.
public class ImplementacionFuncionalClasica {
	public static void main(String[] args) {
		Printer printer=new PrinterPantalla();
		printer.print("implementacion clásica");
	}
}