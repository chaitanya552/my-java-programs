import java.util.Map;
import java.util.TreeMap;

/*
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class IntegerToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(intToRoman(1994));
		System.out.println(intToRomanM2(1994));
	}

	public static String intToRoman(int num) {
		String[] M = { "", "M", "MM", "MMM" };
		String[] C = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String[] X = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String[] I = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		return M[num / 1000] + C[num % 1000 / 100] + X[(num % 100) / 10] + I[num % 10];
	}

	public static String intToRomanM2(int num) {
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();

		map.put(1, "I");
		map.put(5, "V");
		map.put(10, "X");
		map.put(50, "L");
		map.put(100, "C");
		map.put(500, "D");
		map.put(1000, "M");
		map.put(4, "IV");
		map.put(9, "IX");
		map.put(40, "XL");
		map.put(90, "XC");
		map.put(400, "CD");
		map.put(900, "CM");

		StringBuilder ans = new StringBuilder();
		while (num != 0) {

			Map.Entry<Integer, String> entry = map.floorEntry(num);
			// Returns a key-value mapping associated with the greatest key less than or
			// equal to the given key, or null if there is no such key.

			System.out.println("entry: " + entry);
			ans.append(entry.getValue());
			num -= entry.getKey();
		}
		return ans.toString();
		/*
		 * Example
		 * 
		 *  entry: 1000=M entry: 900=CM entry: 90=XC entry: 4=IV MCMXCIV
		 */
	}
}
