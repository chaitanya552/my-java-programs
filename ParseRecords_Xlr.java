import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*

 N O V   2 3 R D
 MTG: $1,613,729* from Avidia Bank
 ADD: 169 Mountain Rd., Princeton
 BORROWER: Diane L. Boudreau

 MTG: $1,492,500 from Salem Five Cents
 Savings Bank
 ADD: Carlson Way and 148 Main St., Rutland
 BORROWER: Gengel C&S Builders Inc., man-
 aged by Leonard F. Gengel

 N O V   2 4 T H
 MTG: $4,000* from Avidia Bank
 ADD: 169 Mountain Rd., Princeton
 BORROWER: Diane L. Boudreau
 BANK: Wells Fargo

 ADD|BANK|BORROWER|MTG|DATE
 169 Mountain Rd., Princeton||Diane L. Boudreau|$1,613,729* from Avidia Bank|N O V   2 3 R D
 Carlson Way and 148 Main St., Rutland||Gengel C&S Builders Inc., man- aged by Leonard F. Gengel|$1,492,500 from Salem Five Cents Savings Bank|N O V   2 3 R D
 169 Mountain Rd., Princeton|Wells Fargo|Diane L. Boudreau|$4,000* from Avidia Bank|N O V   2 4 R D
 */
public class ParseRecords_Xlr {

	public static void main(String[] args) {

		String stdin = "input.txt";
		File file = new File(stdin);
		String line;
		String[] headers;
		String date = "";
		// to map the headers to its corresponding values
		// treee map bcz we want keys in asc order
		Map<String, String> map = new TreeMap<>();
		// set bcz we have to get union of keys from all records
		Set<String> keys = new TreeSet<>();
		// to use the lines again
		List<String> listLines = new LinkedList<String>();
		// to keep track of previous keys and string is immutable so I used sb
		StringBuilder prevKey = new StringBuilder();
		StringBuilder prevValue = new StringBuilder();
		// to capture the first empty line
		int i = 1;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			// we get union of all keys in set
			while ((line = br.readLine()) != null) {
				listLines.add(line);
				// to detect if its a date
				if ((line.indexOf(" ") == 1) && (line.contains("   "))) {
					continue;
				}
				if (line.indexOf(": ") >= 0) {
					// collecting all the keys
					keys.add(line.split(": ")[0]);
				}
			}
			// main header i.e all keys are printed ( no pipe at the last key
			// ..so we use count)
			int count = 1;
			for (String key : keys) {
				System.out.print(key);
				if (count != keys.size()) {
					System.out.print("|");
				}
				count++;
			}
			System.out.println();
			// now again we read each line
			for (String lineNew : listLines) {
				// to detect if its a date ...cap space cap space cap space and
				// 3 spaces
				if ((lineNew.indexOf(" ") == 1) && (lineNew.contains("   "))) {
					date = lineNew;
					// date is stored and we go to next line
					continue;
				}
				// if line has ": " it is a header
				// split by ": " so we have key in 0 and val in 1
				if (lineNew.indexOf(": ") >= 0) {
					headers = lineNew.split(": ");
					prevKey = new StringBuilder(headers[0]);
					prevValue = new StringBuilder(headers[1]);
					map.put(headers[0], headers[1]);

				} else if (!lineNew.trim().isEmpty()) {
					// it means there is a continusion of previous header in new
					// line so we haave to append
					prevValue.append(" ");
					prevValue.append(lineNew);
					map.put(prevKey.toString(), prevValue.toString());
				}

				if (lineNew.trim().isEmpty()) {
					if (i == 1) {
						// first line is empty given in input so we skip it
						i++;
						continue;
					}
					// iterate through all keys and get values from map
					for (String key : keys) {
						if (map.get(key) != null) {
							System.out.print(map.get(key));
						} else {
							System.out.print("");
						}
						System.out.print("|");
					}
					// reset map after each record
					map.clear();

					System.out.print(date);
					if (i != 1) {
						System.out.println();
					}
					i++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// / for last iteration there is no empty line detection so we print it
		for (String key : keys) {
			if (map.get(key) != null) {
				System.out.print(map.get(key));
			} else {
				System.out.print("");
			}

			System.out.print("|");
		}
		System.out.print(date);
	}

}
