/*
Creamos una clase ListNumber para manejar enteros que amplía ArrayList.
Heredará ArrayList<Integer> e incorporará:
- Método first(): que devuelve el primer elemento.
- Método last(): que devuelve el último.
(ambos devuelven null si la lista está vacía)
- Método sum(): que devuelve la suma de todos los elementos.
- No debe permitir añadir números ya existentes
*/
package principal;

import java.util.ArrayList;

public class ListNumber extends ArrayList<Integer> {
	
	private static final long serialVersionUID = 1L;

	public int first() {
		return isEmpty()? null:get(0);
	}

	public int last() {
		return isEmpty()? null:get(size()-1);
	}
	
	public int sum() {
		int sum = 0;
		for (Integer i:this) { sum += i; }
		return sum;
	}
	
	@Override
	public boolean add(Integer e) {
		if (this.indexOf(e) == -1) {
			return super.add(e);
		} else {
			System.out.println("Ya existe");
			return false;
		}
	}
}