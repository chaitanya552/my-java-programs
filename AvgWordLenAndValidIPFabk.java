
public class AvgWordLenAndValidIPFabk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(averageWordLength(" hello world "));
System.out.println(averageWordLength(" hello hellos "));
System.out.println(validIpAddress("a27.0.0.1"));
System.out.println(isValidIPv6("ipv6"));
//sql same brand avg price>3 and atleast two diff products>=2
//products percentage with discounts


	}
private static Double averageWordLength(String input)
{
	String[] words= input.trim().split(" ");
	Double sum=0.0;
	for( String word: words)
	{
		sum+=word.trim().length();
	}
	return sum/words.length;
}

private static boolean validIpAddress(String input)
{
	String[] octects= input.split("\\.");	
	
	if(octects.length!=4)
	{
		return false;
	}
	int val;
	for( String octect: octects)
	{
		   if (octect.isEmpty() || octect.length() > 3) {
               return false;
           }
		try {		
		val= Integer.parseInt(octect);
		if(!(val>=0 && val <=255) || octect.startsWith("0"))
		{
			
			return false;
		}
		}
	catch (NumberFormatException e) {
		return false;
	}
	}
	return true;
}

public static boolean isValidIPv6(String ip) {
	if(ip.length()<15) return false;
	if(ip.charAt(0)==':') return false;
	if(ip.charAt(ip.length()-1)==':') return false;
	String[] tokens = ip.split(":");
	if(tokens.length!=8) return false;
	for(String token: tokens) {
		if(!isValidIPv6Token(token)) return false;
	}
	return true;
}

public static boolean isValidIPv6Token(String token) {
	if(token.length()>4 || token.length()==0) return false;
	char[] chars = token.toCharArray();
	for(char c:chars) {
		boolean isDigit = c>=48 && c<=57;
		boolean isUppercaseAF = c>=65 && c<=70;
		boolean isLowerCaseAF = c>=97 && c<=102;
		if(!(isDigit || isUppercaseAF || isLowerCaseAF)) 
			return false;
	}
	return true;
}
}
