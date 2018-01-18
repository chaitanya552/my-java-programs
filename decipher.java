/*
 * This program takes a string and changes it to a new string(encoding) 
 * The decoding method converts it back to the original string 
 * This is the same method used in sending 
 */
public class decipher {
	private static String encode(String text) {
		System.out.println("encoding");
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			b.append(c += c + i);
		}

		return b.reverse().toString();
	}

	static String decode(String encodedMessage) {
		System.out.println("----------------------------------------");
		System.out.println("decoding");
		StringBuilder bu = new StringBuilder(encodedMessage);
		String reversed = bu.reverse().toString();
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < reversed.length(); i++) {
			char c = reversed.charAt(i);
			// int val = (int)c; val=val-i; val=val/2;
			// c = (char)(val);
			c = (char) ((c - i) / 2);
			res.append(c);
		}

		return res.toString();
	}

	public static void main(String[] args) {
		String encodedMessage = encode("hello sushma");
		System.out.println(encodedMessage);
		System.out.println(decode(encodedMessage));
	}
}
