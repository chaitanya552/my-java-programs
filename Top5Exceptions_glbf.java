import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.TreeMap.*;

/*
 * a,2
 * b,5
 * c,8
 * d,1
 * e,8
 * f,10
 * g,11
 */
public class Top5Exceptions_glbook {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String input = "C:/Users/gkneerukonda/Documents/exceptions.csv";
		BufferedReader br = new BufferedReader(new FileReader(new File(input)));
		List<String> exceptions = new ArrayList<String>();
		try {
			String line;
			while ((line = br.readLine()) != null) {
				exceptions.add(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("input: " +exceptions);

		Top5(exceptions);

	}

	public static void Top5(List<String> exceptions) {
		Map<String, Integer> map = new TreeMap<String, Integer>();
		for (int i = 0; i < exceptions.size(); i++) {
			int count = 0;
			String key = exceptions.get(i);
			if (!map.containsKey(key)) {
				map.put(key, 1);
			} else {
				int val = map.get(key);
				val = val + 1;
				map.put(key, val);
			}
		}

		Map<Integer, String> treemap = new TreeMap<Integer, String>(
				new DescOrder());
		for (Map.Entry<String, Integer> entry : map.entrySet()) {

			treemap.put(entry.getValue(), entry.getKey());

		}
		int i = 0;

		System.out.println("output: "
				+ ""+treemap.toString());
		//System.out.println(treemap.size());

		for (Map.Entry<Integer, String> entry : treemap.entrySet()) {

			System.out.println(entry.getValue() + " " + entry.getKey());
			if (i == 4) {
				break;
			}
			i++;
		}

	}
}

class DescOrder implements Comparator<Integer> {

	@Override
	public int compare(Integer a1, Integer a2) {
		return a2 - a1;
	}
}