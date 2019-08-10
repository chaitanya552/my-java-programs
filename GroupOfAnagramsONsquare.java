
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
import java.util.List;

class GroupOfAnagramsONsquare
{
    public static void main(final String[] args)
    {
        final String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        // final String[] strs = { "a", "a", "a" };
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(final String[] strs)
    {
        final List<String> input = new ArrayList<>();
        for (final String str : strs) {

            input.add(str);

        }
        if (input.size() == 0) {
            return null;
        }
        final List<List<String>> outerList = new ArrayList<>();
        while (input.size() > 1) {
            final List<String> innerList = new ArrayList<>();
            innerList.add(input.get(0));
            for (int j = 1; j < input.size(); j++) {

                if (isAnagram(input.get(0), input.get(j))) {

                    innerList.add(input.get(j));

                    input.remove(j);
                    // since we are removing element
                    j--;

                }
            }
            input.remove(0);

            outerList.add(innerList);
        }
        if (input.size() == 1) {
            final List<String> innerList = new ArrayList<>();
            innerList.add(input.get(0));
            outerList.add(innerList);
        }
        // System.out.println(outerList+"outer list");
        return outerList;
    }

    public static boolean isAnagram(final String a, final String b)
    {
        if (a.length() != b.length()) {
            return false;
        }
        final int[] count = new int[26];
        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i) - 'a']++;
            count[b.charAt(i) - 'a']--;

        }
        for (int j = 0; j < 26; j++) {
            if (count[j] != 0) {
                return false;
            }
        }
        return true;
    }
}