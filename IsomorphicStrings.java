import java.util.LinkedHashMap;
import java.util.Map;

public class IsomorphicStrings
{
    public static void main(final String[] args)
    {
        final String str1 = "abbd";
        final String str2 = "ceea";
        System.out.println(callMethod1(str1, str2));
        // System.out.println(callMethod2(str1, str2));
    }

    private static boolean callMethod1(final String str1, final String str2)
    {
        if (str1.length() != str2.length()) {
            return false;
        }
        final Map<Character, Character> m1 = new LinkedHashMap<>();
        final Map<Character, Character> m2 = new LinkedHashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            final Character c1 = str1.charAt(i);
            final Character c2 = str2.charAt(i);
            if (!m1.containsKey(c1)) {
                m1.put(c1, c2);
            }
            if (!m2.containsKey(c2)) {
                m2.put(c2, c1);
            }
            if (!c1.equals(m2.get(c2))) {
                return false;
            }
            if(m1.get(c1).equals(obj))
        }
        return true;
    }

    private static boolean callMethod2(final String str1, final String str2)
    {
        // TODO Auto-generated method stub
        return true;
    }
}
