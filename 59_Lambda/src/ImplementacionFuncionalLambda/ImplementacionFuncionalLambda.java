// Implementación de interfaces funcionales DESDE de Java 8: expresiones lambda.

package ImplementacionFuncionalLambda;

import java.util.function.BiPredicate;

// 1. Dada una interfaz funcional...
interface Printer{
	void print(String s);
}

public class ImplementacionFuncionalLambda {
	public static void main(String[] args) {

		/* 2. directamente se crea un objeto del tipo de la interfaz con una implementación de la función.
		En este caso, se le envía un parámetro s que se va a imprimir. */
		Printer printer = s -> System.out.println(s);
		printer.print("Implementación con lambdas");
		
		
		/* Ejemplo de implementación de interfaces funcionales de Java:
		
		Con una expresión lambda, implementar BiPredicate<Integer, Integer> que evalúe
		si los números son iguales. */
		BiPredicate<Integer, Integer> impl1 = (a, b) -> a == b;
		System.out.println("BiPredicate 1: " + impl1.test(1, 1));
		
		// Otra que evalúe si ambos son positivos.
		BiPredicate<Integer, Integer> impl2 = (a, b) -> a > 0 && b > 0;
		System.out.println("BiPredicate 2: " + impl2.test(1, 1));
		
		// Partiendo de las anteriores, otra que evalúe si ambos son positivos e iguales.
		BiPredicate<Integer, Integer> impl3 = impl1.and(impl2);
		/* Método default and de BiPredicate:
		https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/BiPredicate.html#and(java.util.function.BiPredicate) */
		System.out.println("BiPredicate 3: " + impl3.test(1, 1));
	}
}