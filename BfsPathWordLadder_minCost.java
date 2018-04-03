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
import java.util.Set;

public class BfsPathWordLadder_minCost {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Sample test cases ******Modify String[] dictionary = { "hot", "hip",
		 * "hop", "pop", "dot", "kit", "kip","mip" };
		 * 
		 * *****Delete & Modify String[] dictionary =
		 * {"appse","appls","mppse","ppse"
		 * ,"apply","appy","app","appl","aple","apl"};
		 * 
		 * *****Anagram, add, delete, modify check String[] dictionary = {
		 * "cat", "cats", "catsy", "cacsy", "cacsh", "caceh", " cache", "cae",
		 * "came", "cahme", "cahcme", "cachem" }
		 * 
		 * String[] dictionary = {"health","heath","heats","hents","hends"};
		 * Set<String> wordList = new
		 * HashSet<String>(Arrays.asList(dictionary));
		 * System.out.println(findLadders("hands", "health", wordList));
		 */

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
		System.out.println(findLadders( "health", "hands",wordList));
		System.out.println(findLadders( "team", "mate",wordList));
		System.out.println(findLadders( "ophthalmology", "glasses",wordList));
		System.out.println(findLadders( "again", "age",wordList));
	}

	public static int findLadders( String beginWord,String endWord,
			Set<String> wordList) {
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

			addNeighbours(queue, visited, unvisited, current);
		}
		// ******paths print for verifying System.out.println(result);*********
		if (minCost == Integer.MAX_VALUE) {
			minCost = -1;
		}
		System.out.println(result);
		return minCost;
	}

	private static void addNeighbours(Queue<Node> queue, Set<String> visited,
			Set<String> unvisited, Node current) {
		int add = 1;
		int del = 1;
		int mod = 1;
		int anagr = 1;
		
		char[] chars = current.val.toCharArray();
		// modify/change
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
		// delete

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
		// add
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
					
					tempList.remove(Character.valueOf(currentString.charAt(i)));
					
					if (tempList.isEmpty() && currentString.length() == i + 1) {
						queue.add(new Node(currentString, current, current.dist
								+ anagr));
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