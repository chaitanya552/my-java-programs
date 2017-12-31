import java.util.Arrays;
import java.util.Scanner;

class GS_FirstNonRepeatedCharacterM3 {
	// private static final int MAX = 100000; // Max size of Hashmap

	public static void main(String[] args) {

		int NO_OF_CHARS = 256;
		char count[] = new char[NO_OF_CHARS];
		String s = "ssddeefgh";
		char a[] = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			a[i] = s.charAt(i);
		}

		for (int i = 0; i < s.length(); i++) {
			int flag = 0;
			for (int j = 0; j < s.length(); j++) {
				if (a[i] == a[j]) {
					flag++;
				}
			}

			if (flag == 1) {
				System.out.println(a[i] + " is not repeated");
				break;
			}
		}
	}
}