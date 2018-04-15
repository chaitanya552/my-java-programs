public class CountPossibleEncodings {
	
	
	/**
	 * It may be assumed that the input contains valid digits from 0 to 9 and there 
	 * are no leading 0′s, no extra trailing 0′s and no two or more consecutive 0′s.
	 * 
	 * This is a recursive solution. Its time complexity is exponential:
	 * T(n) = T(n-1) + T(n-2) + O(1) 
	 *
	 * 
	 * @param digits
	 * @return
	 */
	static int countEncodingsRecursive1(String digits){
		
		// base case:
		int strLen = digits.length(); 
		if(strLen==1 || strLen==0)
			return 1; 
		
		int total=0; 
		if(isValidNumber(digits))
			total += 1;
		//A
		System.out.println("total now is"+ total);
		System.out.println(digits.substring(1));
		total += countEncodingsRecursive1(digits.substring(1)); 
		//b
		System.out.println("total at b "+total);
		if(strLen>2){ 
			String prefix = digits.substring(0,2); 
			System.out.println("prefix: " +prefix);
			String remain = digits.substring(2); 
			System.out.println("remain: " +remain);
			if( isValidNumber(prefix) )
				total += countEncodingsRecursive1(remain); 
		}
		return total ; 
	}

	
	 static boolean isValidNumber(String str){
		 System.out.println("function isvalid number on "+ str);
		int val = Integer.valueOf(str); 
		return (val>=0) && (val<=26); 
	}

	public static void main(String[] args) {
		String str="123";
		System.out.println(countEncodingsRecursive1(str)+" is answer");
	}
	}
	
	
