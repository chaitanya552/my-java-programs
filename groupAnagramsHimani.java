
/*
 * leetcode 39
 * Given an array of strings, group anagrams together.
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagramsHimani
{

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        final String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        // final String[] strs = { "a", "a", "a" };
        System.out.println(groupAnagrams(strs));

    }

    public static List<List<String>> groupAnagrams(final String[] strs)
    {
        final HashMap<String, List<String>> map = new HashMap<>();
        final List<List<String>> result = new ArrayList<>();
        for (final String word : strs) {
            final char[] temp = word.toCharArray();
            Arrays.sort(temp);
            final String s = new String(temp);
            if (map.containsKey(s)) {
                final List<String> t = map.get(s);
                t.add(word);
                map.put(s, t);

            }
            else {
                final List<String> t = new ArrayList<>();
                t.add(word);
                map.put(s, t);
            }
        }
        for (final List<String> s : map.values()) {
            result.add(s);
        }
        return result;
    }

}
