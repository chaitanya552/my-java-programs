/*
 * check if a hexadecimal number is a perfect square and output the min number of partitions else return -1
 * 
 * if not divide into partitions [partitions from ending to start]
 * ex : 1a919 is not perfect square 
 * 2 partitions 
 * 919  1a ( check if these both are perfect sq) No
 * 3 partitions
 * 19 a9 1 ( all are perfect squares . hence 3 partions is answer
 * 
 */

/*
 * Approach 
 * hexadecimal sqares end with 0 ,1 , 4 , 9 else its not perfect square
 * if this is true then there are chances of perfect square
 * convert hex to decimal
 * now find sqrt of decimal
 * if sqrt is integer then 
 * using substrings do partitions
 */

public class HexadecimalPartitionsAndPerfecrSquareCheck_ZnP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String s = "896bb1";
		// String s = "999999";
		// String s ="abcdef";
		String s = "1a919";

		System.out.println("Minimum number of partitions are " + getMin(s));
	}

	static int getMin(String s) {
		// to check if a hexadecimal is square or not
		// the number will end with 0 1 4 9
		int len = s.length();

		for (int i = 1; i <= len; i++) {
			if (PartitionHexa(s, i) == true) {
				return i;
			}
		}
		return -1;
	}

	static boolean PartitionHexa(String s, int i) {
		int l = s.length();
		int count = 0;
// partioning when 5/2 is 2.5 then we have to take partition as 3 so we do math.round
		//abcde partitions for i =2 is cde ab
		//int partition = (int) Math.rint((double) l / i + 0.1);
		int partition = (int) Math.round((double) l / i);
		int end = l;
		int start = l - partition;
		StringBuilder sb = new StringBuilder(s);
		int segments = i;
		while (segments > 0) {

			System.out.println(sb.substring(start, end));
			segments--;
			if (sb.substring(end - 1, end).endsWith("0")
					|| sb.substring(end - 1, end).endsWith("1")
					|| sb.substring(end - 1, end).endsWith("4")
					|| sb.substring(end - 1, end).endsWith("9")) {
				// chances ofperfect square
				long n = Long.parseLong(sb.substring(start, end), 16);

				long t = (long) (Math.sqrt(n));
				if (t * t == n) {

					count = count + 1;
					// System.out.println("count"+ count +"true");
					if (count == i) {

						return true;

					}
				} else {
					break;
				}
			} else {
				break;
			}

			end = start;
			if (start - partition < 0 || segments == 1) {
				start = 0;
			} else {
				start = start - partition;
			}
		}
		System.out.println("false");
		return false;
	}
}
