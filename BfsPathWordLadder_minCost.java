import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/*
 * Algorithm: 
 * BFS will be optimal. Consider every word as a node in a tree. The begin word is the root. 
 * Every word could possibly have pow(26, len(word)) derivatives. In other word, every tree node has up to 26^len(word) children.
 * Keep building the tree by deriving new words until the current level of leaves contains the end word.
 *  
 * Date 03/04/2018
 * @author Chaitanya Kumar Neerukonda
 *
 * Reference:
 * Dictionary words are from this link ( added few more words manually which are given in the question) 
 * https://www.ef.edu/english-resources/english-vocabulary/top-3000-words/
 *
 */
public class BfsPathWordLadder_minCost {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] costs = new int[4];
		System.out.println("Enter costs");
		for (int i = 0; i < 4; i++) {
			costs[i] = scan.nextInt();
		}
		scan.nextLine();
		System.out.println("enter begin word");
		String beginWord = scan.nextLine().toLowerCase();
		System.out.println("enter end word");
		String endWord = scan.nextLine().toLowerCase();
		scan.close();

		String csvFinal = "C:/Users/gkneerukonda/Desktop/Dictionary.csv";
		File file = new File(csvFinal);
		String line = "";
		Set<String> wordList = new HashSet<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			while ((line = br.readLine()) != null) {

				if (line.length() >= 3) {
					// interim word length is should be at least of length 3
					wordList.add(line.trim());
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(findPath(beginWord, endWord, wordList, costs));

		// Test Cases
		// System.out.println(findPath("health", "hands",wordList, costs));
		// System.out.println(findPath("team", "mate",wordList, costs));
		// System.out.println(findPath("ophthalmology","glasses", wordList,
		// costs));
		// System.out.println(findPath("again","age", wordList, costs));
		// System.out.println(findPath("age","again", wordList, costs));

	}

	public static int findPath(String beginWord, String endWord,
			Set<String> wordList, int[] costs) {
		wordList.add(endWord);
		Queue<Node> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>(), unvisited = new HashSet<>();
		unvisited.addAll(wordList);
		int level = 0, minDist = Integer.MAX_VALUE;
		List<List<String>> result = new ArrayList<>();

		queue.add(new Node(beginWord, null, 0));
		visited.add(beginWord);
		int minCost = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			Node current = queue.remove();
			if (current.val.equals(endWord) && current.dist <= minDist) {
				minDist = current.dist;
				if (minDist < minCost) {
					minCost = minDist;
				}
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

			addNodes(queue, visited, unvisited, current, costs);
		}
		// ******paths print for verifying System.out.println(result);*********
		if (minCost == Integer.MAX_VALUE) {
			minCost = -1;
		}
		System.out.println(result);
		return minCost;
	}

	private static void addNodes(Queue<Node> queue, Set<String> visited,
			Set<String> unvisited, Node current, int[] costs) {
		int add = costs[0];
		int del = costs[1];
		int mod = costs[2];
		int anagram = costs[3];

		char[] chars = current.val.toCharArray();
		// modify/change logic
		for (int i = 0; i < chars.length; ++i) {
			for (char c = 'a'; c <= 'z'; ++c) {
				char tmp = chars[i];
				chars[i] = c;
				String nbr = new String(chars);
				if (unvisited.contains(nbr)) {

					queue.add(new Node(nbr, current, current.dist + mod));
					visited.add(nbr);
				}
				chars[i] = tmp;
			}
		}
		// delete logic

		String str = current.val;

		for (int i = 0; i < chars.length; i++) {
			StringBuilder sb = new StringBuilder();
			String left = str.substring(0, i);
			String right = str.substring(i + 1, str.length());
			sb.append(left);
			sb.append(right);
			String delWord = sb.toString();

			if (unvisited.contains(delWord)) {
				;
				queue.add(new Node(delWord, current, current.dist + del));
				visited.add(delWord);
			}
		}
		// add logic
		for (int i = 0; i < str.length() + 1; ++i) {
			for (char c = 'a'; c <= 'z'; ++c) {

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

					queue.add(new Node(addWord, current, current.dist + add));
					visited.add(addWord);
				}
			}
		}
		// anagrams logic
		List<Character> charList = new ArrayList<Character>();
		for (int i = 0; i < str.length(); i++) {
			charList.add(chars[i]);
		}
		Iterator<String> it = unvisited.iterator();
		while (it.hasNext()) {

			String currentString = it.next();
			if (currentString.length() == charList.size()) {
				List<Character> tempList = new ArrayList<Character>();
				for (int i = 0; i < charList.size(); i++) {
					tempList.add(charList.get(i));
				}
				for (int i = 0; i < currentString.length(); i++) {

					tempList.remove(Character.valueOf(currentString.charAt(i)));

					if (tempList.isEmpty() && currentString.length() == i + 1) {
						queue.add(new Node(currentString, current, current.dist
								+ anagram));
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
		Collections.reverse(path);
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