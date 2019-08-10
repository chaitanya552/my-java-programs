
// find next element using adjacent method rather than finding all strings

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderBFS_LeetCode3
{

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        final String[] arr = { "hot", "hip", "hop", "pop", "dot", "kit", "kip", "mip" };
        final List<String> wordList = new ArrayList<String>(Arrays.asList(arr));

        final int answer = ladderLength("hit", "pop", wordList);
        System.out.println(answer);
    }

    public static int ladderLength(final String beginWord, final String endWord, final List<String> wordList)
    {
        final Set<String> dict = new HashSet<>(wordList);
        final Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        // System.out.println("queue" + queue);
        int level = 1;
        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int q = 0; q < size; q++) {
                final char[] currentWord = queue.poll().toCharArray();
                final String check = new String(currentWord);
                // System.out.println(check + "->check");
                // System.out.println("poll/ current element in queue: "+check);

                final Iterator<String> itr = dict.iterator();

                // traversing over HashSet System.out.println("Traversing over Set using Iterator");
                while (itr.hasNext()) {
                    final String nextWord = itr.next();
                    if (isAdjacent(currentWord, nextWord.toCharArray())) {
                        queue.add(nextWord);
                        // System.out.println(nextWord);
                        itr.remove();
                    }
                }

            }
            level++;
        }
        return level;
    }

    private static boolean isAdjacent(final char[] currentWord, final char[] nextWordCharArray)
    {
        int count = 0;
        for (int i = 0; i < currentWord.length; i++) {
            if (currentWord[i] != nextWordCharArray[i]) {
                count++;
            }
        }
        if (count == 1) {
            return true;
        }
        // TODO Auto-generated method stub
        return false;
    }

}
