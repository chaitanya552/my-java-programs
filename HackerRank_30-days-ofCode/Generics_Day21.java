/* generics are for code re-use
enerics parameterize type and allow you to use apply the same interface,
class, or method using different data types while still restricting operations to that data type
The letters below are commonly-used generic type parameters:

E - Element
K - Key
V - Value
N - Number
T - Type (e.g.: data type)
S,U,V, etc. These are second, third, and fourth types for when T is already in use.*/

import java.util.Scanner;


import java.util.*;

class Printer<T> {

	/**
	 * Method Name: printArray Print each element of the generic array on a new
	 * line. Do not return anything.
	 * 
	 * @param A
	 *            generic array
	 **/

	// Write your code here
	public static <E> void printArray(E[] Array) {
		for (E i : Array)
			System.out.println(i);

	}
}

public class Generics_Day21 {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Integer[] intArray = new Integer[n];
		for (int i = 0; i < n; i++) {
			intArray[i] = scanner.nextInt();
		}

		n = scanner.nextInt();
		String[] stringArray = new String[n];
		for (int i = 0; i < n; i++) {
			stringArray[i] = scanner.next();
		}

		Printer<Integer> intPrinter = new Printer<Integer>();
		Printer<String> stringPrinter = new Printer<String>();
		intPrinter.printArray(intArray);
		stringPrinter.printArray(stringArray);
		if (Printer.class.getDeclaredMethods().length > 1) {
			System.out
					.println("The Printer class should only have 1 method named printArray.");
		}
	}
}
