import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FormattedOutputString {
	int table;

	// constructor


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("enter table value");
		int n = in.nextInt();
		FormattedOutputString t= new FormattedOutputString();
		t.table=n;
		if (n >= 2 && n <= 20) {
			multiply(n);
		}

	}

	public static void multiply(int n) {
		int i = 1;
		int result;
		for (i = 1; i <= 10; i++) {
			result = n * i;
		//	System.out.println(n + " x " + i + " = " + result);
			System.out.format("%2s%2s%2s%4s", n+"*", i,"=",result);
			System.out.println();
		}
	}
}