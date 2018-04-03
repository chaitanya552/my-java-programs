import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BfsPathWordLadder_minCost {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String[] arr = { "hot", "hip", "hop", "pop", "dot", "kit", "kip",
		// "mip" };
		// mod check String[] arr =
		// {"appse","appls","mppse","ppse","apply","appy","app","appl","aple","apl"};
		// del check String[] arr = {"health","heath","heats","hents","hends"};
		// anaagram String[] arr = { "appo", "app", "pp", "ppo", "ppoy", "appl" };
		String[] arr={"team","mate","tea","mat","ate","aten"};
		Set<String> wordList = new HashSet<String>(Arrays.asList(arr));

		// System.out.println(findLadders("pop", "hit", wordList));
		// System.out.println(findLadders("ap", "apple", wordList));
		// System.out.println(findLadders("hands", "health", wordList));
		//System.out.println(findLadders("ppoye", "app", wordList));
		System.out.println(findLadders("aten", "tea", wordList));
	}

	public static List<List<String>> findLadders(String endWord,
			String beginWord, Set<String> wordList) {
		wordList.add(endWord);
		Queue<Node> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>(), unvisited = new HashSet<>();
		unvisited.addAll(wordList);
		int level = 0, minDist = Integer.MAX_VALUE;
		List<List<String>> result = new ArrayList<>();

		queue.add(new Node(beginWord, null, 0));
		visited.add(beginWord);

		while (!queue.isEmpty()) {
			Node current = queue.remove();
			if (current.val.equals(endWord) && current.dist <= minDist) {
				minDist = current.dist;
				addPath(result, current);
				continue;
			}

			if (current.dist > minDist) {
				break;
			}

			if (current.dist > level) {
				unvisited.removeAll(visited);
				level = current.dist;
			}

			addNeighbours(queue, visited, unvisited, current);
		}

		return result;
	}

	private static void addNeighbours(Queue<Node> queue, Set<String> visited,
			Set<String> unvisited, Node current) {
		System.out.println(current.val + " current");
		char[] chars = current.val.toCharArray();
		// edit
		for (int i = 0; i < chars.length; ++i) {
			for (char c = 'a'; c <= 'z'; ++c) {
				char tmp = chars[i];
				chars[i] = c;
				String nbr = new String(chars);
				if (unvisited.contains(nbr)) {
					System.out.println("yes");
					queue.add(new Node(nbr, current, current.dist + 1));
					visited.add(nbr);
				}
				chars[i] = tmp;
			}
		}
		// delete

		String str = current.val;
		System.out.println(str + " str");
		for (int i = 0; i < chars.length; i++) {
			StringBuilder sb = new StringBuilder();
			String left = str.substring(0, i);
			String right = str.substring(i + 1, str.length());
			sb.append(left);
			sb.append(right);
			String delWord = sb.toString();
			System.out.println(delWord + " del");
			if (unvisited.contains(delWord)) {
				System.out.println("no");
				queue.add(new Node(delWord, current, current.dist + 1));
				visited.add(delWord);
			}
		}
		// add
		for (int i = 0; i < str.length() + 1; ++i) {
			for (char c = 'a'; c <= 'z'; ++c) {
				// char tmp = chars[i];
				// chars[i] = c;
				StringBuilder sb = new StringBuilder();
				String left = str.substring(0, i);
				String right = str.substring(i, str.length());
				if (i == 0) {
					sb.append(c);
					sb.append(left);
					sb.append(right);
				} else if (i < str.length()) {

					sb.append(left);
					sb.append(c);
					sb.append(right);
				} else {
					sb.append(left);
					sb.append(right);
					sb.append(c);
				}
				String addWord = sb.toString();
				if (unvisited.contains(addWord)) {
					System.out.println("no");
					queue.add(new Node(addWord, current, current.dist + 1));
					visited.add(addWord);
				}
			}
		}
		// anagrams
		List<Character> charList = new ArrayList<Character>();
		for (int i = 0; i < str.length(); i++) {
			charList.add(chars[i]);
		}
		List check = new ArrayList();
		Iterator<String> it = unvisited.iterator();
		while (it.hasNext()) {

			String currentString = it.next();
			if (currentString.length() == charList.size()) {
				List<Character> tempList = new ArrayList<Character>();
				for (int i = 0; i < charList.size(); i++) {
					tempList.add(charList.get(i));
				}
				for (int i = 0; i < currentString.length(); i++) {
					// System.out.println(tempList);
					// System.out.println(currentString.charAt(i));
					tempList.remove(Character.valueOf(currentString.charAt(i)));
					System.out.println(tempList);
					if (tempList.isEmpty() && currentString.length() == i + 1) {
						System.out.println("anagram");

						queue.add(new Node(currentString, current,
								current.dist + 1));
						visited.add(currentString);
					}
				}

			}
		}
	}

	private static void addPath(List<List<String>> result, Node current) {
		List<String> path = new ArrayList<>(current.dist);
		while (current != null) {
			path.add(current.val);
			current = current.parent;
		}
		result.add(path);
	}

}

class Node {
	String val;
	Node parent;
	int dist;

	Node(String val, Node parent, int dist) {
		this.val = val;
		this.parent = parent;
		this.dist = dist;
	}
}