import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstRepeatedCharInSentence_Pru {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "this is a sentence";
		String str1 = str.replaceAll(" ", "");
		int len = str1.length();
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < len; i++) {
			if (!set.add(str1.charAt(i))) {
				System.out.println("first repeated char is: " + str1.charAt(i));
				break;
			}
		}

		// first non repeated character
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < len; i++) {
			if (!map.containsKey(str1.charAt(i))) {
				map.put(str1.charAt(i), 1);
			} else {
				int value = map.get(str1.charAt(i));
				value = value + 1;
				map.put(str1.charAt(i), value);
			}
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println("first non repeated character: "+entry.getKey());
				break;
			}
		}
	}
}
/*
 * //iterating over keys only for (Integer key : map.keySet()) {
 * System.out.println("Key = " + key); }
 * 
 * //iterating over values only for (Integer value : map.values()) {
 * System.out.println("Value = " + value); }
 */
