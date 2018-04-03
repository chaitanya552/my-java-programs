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
 * Considering the begin word as the root of a tree, and every other word formed by( adding,deleting,changing a character, anagram) of this root are added as node to the tree
 * So, every node could possibly form dictionary words by the 4 operations(add, del,modify, anagram)  
 * 
 * Consider every word as a node in a tree. The begin word is the root.
 * Keep on building the tree by deriving new words until the current level of leaves contains the end word. 
 * 
 * Then we find the min paths from starting word to ending word. this is done using BFS. At each node we trace back to upstream using a list of possible upstream nodes
 * Every word could possibly have pow(26, len(word)) derivatives. In other word, every tree node has up to 26^len(word) children.
 * 
 *  
 * Date 03/04/2018
 * @author Chaitanya Kumar Neerukonda
 *
 * Reference:
 * Dictionary words are from this link ( added few more words manually which are given in the question) 
 * https://www.ef.edu/english-resources/english-vocabulary/top-3000-words/
 *
 */
public class transformWordBfsMinCost {

	public static void main(String[] args) {

		// reading input from the user
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

		// dictionary/ words list is read from the csv file
		// and stored into a hashset named wordList
		// csvFinal = "C:/Users/ckneerukonda/Desktop/Dictionary.csv"; to read
		// file from local folder
		// file is stored in java resource library
		String csvFinal = "Dictionary.csv";
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
		// Breadth First Search uses queue
		Queue<Node> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>(), unvisited = new HashSet<>();
		// initially every word in the dictionary is unvisited
		unvisited.addAll(wordList);
		int level = 0, minDist = Integer.MAX_VALUE;
		// result will have all the optimal paths from begin to end word
		List<List<String>> result = new ArrayList<>();
		// root node( begin word ) has no parent i.e null
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
				// add this path to result and continue
				tracePath(result, current);
				continue;
			}
			// optimized the code
			if (current.dist > minDist) {
				break;
			}

			if (current.dist > level) {
				unvisited.removeAll(visited);
				level = current.dist;
			}

			addNodes(queue, visited, unvisited, current, costs);
		}
		// if minCost hasn't been changed in the program i.e begin word can't
		// transformed, we initialize it to -1
		if (minCost == Integer.MAX_VALUE) {
			minCost = -1;
		}
		//paths can be printed for verification and debugging
		System.out.println(result);
		return minCost;
	}

	private static void addNodes(Queue<Node> queue, Set<String> visited,
			Set<String> unvisited, Node current, int[] costs) {
		// costs for various operations are set
		int add = costs[0];
		int del = costs[1];
		int change = costs[2];
		int anagram = costs[3];

		char[] chars = current.val.toCharArray();
		// modify/change logic
		// each letter in the current word/node is changed from a to z and we
		// are seeing if the newly formed word is in the dictionary of unvisited
		for (int i = 0; i < chars.length; ++i) {
			for (char c = 'a'; c <= 'z'; ++c) {
				char tmp = chars[i];
				chars[i] = c;
				String nbr = new String(chars);
				if (unvisited.contains(nbr)) {

					queue.add(new Node(nbr, current, current.dist + change));
					visited.add(nbr);
				}
				chars[i] = tmp;
			}
		}
		// delete logic
		// each letter in the current word/node is being deleted and we are
		// seeing if the newly formed word is in the dictionary of unvisited
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
		// a to z letter are added to the current word/node at all possible
		// places and we are seeing if the newly formed word is in the
		// dictionary of unvisited
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
		// current word/node leters are added to a list and are compared with
		// all the unvisited words in the dictioanry( list comparison)
		// if both the lists have same letters and same size then they are
		// anagrams
		List<Character> charList = new ArrayList<Character>();
		for (int i = 0; i < str.length(); i++) {
			charList.add(chars[i]);
		}
		Iterator<String> it = unvisited.iterator();
		while (it.hasNext()) {

			String currentString = it.next();
			if (currentString.length() == charList.size()) {
				// a temperory list is created for the current node/word
				List<Character> tempList = new ArrayList<Character>();
				for (int i = 0; i < charList.size(); i++) {
					tempList.add(charList.get(i));
				}
				// temporary list is compared with all the unvisited words in
				// the dictioanry
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

	private static void tracePath(List<List<String>> result, Node current) {
		List<String> path = new ArrayList<>(current.dist);
		// back tracking the path with the help of parent nodes till it finds
		// root node
		while (current != null) {

			path.add(current.val);
			current = current.parent;
		}
		// list has to be reversed since we back tracked
		Collections.reverse(path);
		result.add(path);
	}

}

// Node class
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