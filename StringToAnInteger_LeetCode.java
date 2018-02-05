/*
 * 1. null or empty string
2. white spaces
3. +/- sign
4. calculate real value
5. handle min & max
 */
public class StringToAnInteger_LeetCode {
	public int atoi(String str) {
		
		if (str == null || str.length() < 1)
			return 0;
	 
		// trim white spaces
		str = str.trim();
	 
		int sign=1;
	 
		// check negative or positive
		int i = 0;
		if (str.charAt(0) == '-') {
			sign=-1;
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		// use double to store result
		double result = 0;
	 
		// calculate value
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
	 
		if (sign == -1)
			result = sign*result;
	 
		// handle max and min
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
	 
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
	 
		return (int) result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringToAnInteger_LeetCode instance= new StringToAnInteger_LeetCode();
		int a=instance.atoi("   -2345   ");
		System.out.println(a);
	}

}
