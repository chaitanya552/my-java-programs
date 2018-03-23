/*given a string peform left shifts and rights and print the result
 * string s ="abcd"
 * if 1 leftshift on abcd -> a has to be shifted to end in a cyclic manner and s becomes bcda
 * if 1 rightshift on abcd -> d has to be shifted to front in a cyclic manner and s becomes dabc
 * 
 *  s=abcd
 *  left shifts=3
 *  l1- bcda
 *  l2- cdab
 *  l3- dabc
 *  l4- abcd
 *  l5- bcda
 *  here we can observe that after left shifts of string length (4) we get original string again
 *  instead of performing 5 left shifts we do left shifts of 5%4(string length we get l=1->we save time
 *  
 *  s=abcd
 *  right shifts=3
 *  r1- dabc
 *  r2- cdab
 *  r3- bcda
 *  Algorithm
 *  if given l=1 and r=1
 *  abcd with l1 ->bcda
 *  bcda with r1-> abcd
 *  when l1 =r1 we dont need to do any shifts
 *  we should do only the difference of shifts l3 r1 implies 2 left shifts
 *                                             l1 r3 implies 2 right shifts
 *  
 * we can substring property to calculate new string
 * if it is l2  we have to pick forst two letters and add at the end of remaing string 
 * if it is r2  we have to pick last  two letters and add at the front of remaing string  
 */

public class LeftShiftRightShiftString_x0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getShiftedString("abcde", 2, 0));
	}

	static String getShiftedString(String s, int leftShifts, int rightShifts) {
		// Write your code here.
		int len = s.length();
		if (len == 1) {
			return s;
		}
		int val = leftShifts - rightShifts;
		String result = "";
		// if it is l2 we have to pick first two letters and add at the end of
		// remaing string

		if (val > 0) {
			int shifts = val % len;
			String left = s.substring(shifts, len);
			// System.out.println(left+"left");
			String right = s.substring(0, shifts);
			// System.out.println(right+"right");
			result = left + right;

			// left shift
			// if it is r2 we have to pick last two letters and add at the front
			// of remaing string
		}
		if (val < 0) {
			val = val * -1;
			int shifts = val % len;
			String left = s.substring(len - shifts, len);
			// System.out.println(left+"left");
			String right = s.substring(0, len - shifts);
			// System.out.println(right+"right");
			result = left + right;

			// left shift

		}

		return result;
	}
}
