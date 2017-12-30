import java.util.Scanner;

import java.lang.Math.*;

public class Bcl_AutoStringConstruct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		System.out.println("find nth element : give number n");
		int elementNumber = scan.nextInt();
		scan.close();
		String loop = "0";
		// to find nth element number of loops to be run is log2(n)
		// because string is varying in the powers of 2
		int N = (int) (Math.log(elementNumber) / Math.log(2));

		int i = 1;

		while (i <= N + 1) {

			loop = concat(loop);

			i++;
		}
		System.out.println("resulted string is: " + loop);
		System.out.println(elementNumber
				+ "th element in the formed string is -> "
				+ loop.charAt(elementNumber-1));
	}

	public static String concat(String s) {
		String left = s;
		String[] var = new String[s.length()];

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				var[i] = "1";
			} else if (s.charAt(i) == '1') {
				var[i] = "2";
			} else if (s.charAt(i) == '2') {
				var[i] = "0";
			}
		}

		String right = "";
		for (int i = 0; i < s.length(); i++) {
			right = right + var[i];
		}

		String answer = left + right;

		return answer;
	}
}
