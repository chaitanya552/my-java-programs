import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CalculatorProb {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		// Reading from the input reader
		/*
		 * FileReader fileReader = new FileReader(file); BufferedReader br = new
		 * BufferedReader(fileReader); String line;
		 */

	//	String str = "19*18";
		 String str ="2*3+4";
		// String str ="99+98";

		List<String> tokens = tokensp(str);
System.out.println(tokens);
		calc(tokens);

	}

	public static List<String> tokensp(String str) {

		List<String> tokens = new ArrayList<>();

		int start = 0;

		int end = 0;

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '+' || str.charAt(i) == '*') {

				end = i;

				tokens.add(str.substring(start, end));

				start = i + 1;

				tokens.add(str.charAt(i) + "");

			}

		}

		tokens.add(str.substring(start, str.length()));

		// System.out.println(tokens);

		return tokens;

	}

	public static void calc(List<String> tokens) {

		while (mult(tokens) != -1) {

			int r = Integer.parseInt(tokens.get(mult(tokens) - 1))
					* Integer.parseInt(tokens.get(mult(tokens) + 1));

			// System.out.println("r: "+r);

			tokens.set(mult(tokens) - 1, r + "");

			tokens.remove(mult(tokens) + 1);

			tokens.remove(mult(tokens));

		}

		while (add(tokens) != -1) {

			int r = Integer.parseInt(tokens.get(add(tokens) - 1))
					+ Integer.parseInt(tokens.get(add(tokens) + 1));

			// System.out.println("r: "+r);

			tokens.set(add(tokens) - 1, r + "");

			tokens.remove(add(tokens) + 1);

			tokens.remove(add(tokens));

		}

		System.out.println(Integer.parseInt(tokens.get(0)));

	}

	public static int mult(List<String> str) {

		// System.out.println("in mult");

		for (int i = 0; i < str.size(); i++) {

			// System.out.println(str.get(i));

			if (str.get(i).equals("*"))

				return i;

		}

		return -1;

	}

	public static int add(List<String> str) {

		for (int i = 0; i < str.size(); i++) {

			if (str.get(i).equals("+"))

				return i;

		}

		return -1;

	}

}