package principal;

import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		HashMap<Integer, String> dias = new HashMap<>();
		
		dias.put(125, "lunes");
		dias.put(300, "martes");
		dias.put(400, "miércoles");
		dias.put(200, "jueves");
		
		dias.put(300, "viernes");			// Sobreescribe el anterior
		System.out.println(dias.get(300));
		
		dias.remove(200);
		
		System.out.println(dias);
		
		for (String s:dias.values()) {
			System.out.println(s);
		}
		
		for (Integer k:dias.keySet()) {
			System.out.println(k);
		}
	}
}