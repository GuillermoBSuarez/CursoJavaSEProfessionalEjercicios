package principal;

public class For_03 {

	public static void main(String[] args) {
		
		// ¿Hay algún número negativo? 
		
		int [] nums = {3, 5, 11, 2, -3, 7, 23, -4};
		
		String msg = "No hay negativos";
		
		for (var n:nums) {
			if (n<0) {
				msg = "Hay negativos";
				break;
			}
		}
		System.out.println(msg);
	}
}