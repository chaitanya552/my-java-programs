import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("MCMXCIV"));
		romanToInt("LVIII");
	}

	private static int romanToInt(String s) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);

		int len = s.length();

		int i = 0;
		int ans = 0;
		//for single char roman
		if (len==1) {
			return  map.get(s.substring(i, i + 1));
		}
		//first we check left >=right then we add digits else we subtract 
		while (i < len - 1) {

			if (map.get(s.substring(i, i + 1)) >= map.get(s.substring(i + 1, i + 2))) {
				ans = ans + map.get(s.substring(i, i + 1));
				i++;
			} else {
				ans = ans - map.get(s.substring(i, i + 1));
				i++;
			}
			if (i == len - 1) {
				ans = ans + map.get(s.substring(i, i + 1));
			}
		}
		return ans;
	}
}
