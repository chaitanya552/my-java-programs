import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderBFS_LeetCodeWithPath
{

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        final String[] arr = { "hot", "hip", "hop", "pop", "dot", "kit", "kip", "mip" };
        final List<String> wordList = new ArrayList<String>(Arrays.asList(arr));
        final Set<String> set = new HashSet<String>();
        for (final String s : arr) {
            set.add(s);
        }

        final int answer = ladderLength("hit", "pop", wordList);
        System.out.println(answer);

        System.out.println(findLadders("hit", "pop", set));
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
                final char[] cur = queue.poll().toCharArray();
                final String check = new String(cur);
                // System.out.println(check + "->check");
                // System.out.println("poll/ current element in queue: "+check);
                for (int i = 0; i < cur.length; i++) {
                    final char tmp = cur[i];
                    for (char chr = 'a'; chr <= 'z'; chr++) {
                        cur[i] = chr;
                        final String pathWord = new String(cur);
                        // System.out.println(pathWord);
                        if (dict.contains(pathWord)) {
                            if (pathWord.equals(endWord)) {
                                System.out.println("path word is end word: " + pathWord);
                                return level + 1;
                            }
                            System.out.println("path word ->" + pathWord);
                            queue.add(pathWord);
                            // System.out.println("current queue"+ queue);
                            dict.remove(pathWord);
                            // System.out.println("current dictionay"+dict);
                        }
                    }
                    cur[i] = tmp;
                }
            }
            level++;
        }
        return 0;
    }

    /*
     * we are essentially building a graph, from start, BF.
     * and at each level we find all reachable words from parent.
     * we stop if the current level contains end,
     * we return any path whose last node is end.
     * to achieve BFT, use a deuqe;
     * a key improvement is to remove all the words we already reached
     * in PREVIOUS LEVEL; we don't need to try visit them again
     * in subsequent level, that is guaranteed to be non-optimal solution.
     * at each new level, we will removeAll() words reached in previous level from dict.
     */
    public static List<List<String>> findLadders(final String start, final String end, final Set<String> dict)
    {
        final List<List<String>> results = new ArrayList<List<String>>();
        dict.add(end);
        // instead of storing words we are at, we store the paths.
        final Deque<List<String>> paths = new LinkedList<List<String>>();
        final List<String> path0 = new LinkedList<String>();
        path0.add(start);
        paths.add(path0);
        // if we found a path ending at 'end', we will set lastLevel,
        // use this data to stop iterating further.
        int level = 1, lastLevel = Integer.MAX_VALUE;
        final Set<String> wordsPerLevel = new HashSet<String>();
        while (!paths.isEmpty()) {
            final List<String> path = paths.pollFirst();
            if (path.size() > level) {
                dict.removeAll(wordsPerLevel);
                wordsPerLevel.clear();
                level = path.size();
                if (level > lastLevel) {
                    break; // stop and return
                }
            }
            // try to find next word to reach, continuing from the path
            final String last = path.get(level - 1);
            final char[] chars = last.toCharArray();
            for (int index = 0; index < last.length(); index++) {
                final char original = chars[index];
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[index] = c;
                    final String next = new String(chars);
                    if (dict.contains(next)) {
                        wordsPerLevel.add(next);
                        final List<String> nextPath = new LinkedList<String>(path);
                        nextPath.add(next);
                        if (next.equals(end)) {
                            results.add(nextPath);
                            lastLevel = level; // curr level is the last level
                        }
                        else {
                            paths.addLast(nextPath);
                        }
                    }
                }
                chars[index] = original;
            }
        }
        return results;
    }
}
