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
		// TODO Auto-generated method stub
		String stdin = "input.txt";
		File file = new File(stdin);
		String line;
		String[] headers;

		String date = "";
		Map<String, String> map = new TreeMap<>();
		Set<String> keys = new TreeSet<>();
		List<String> listLines = new LinkedList<String>();
		StringBuilder prevKey = new StringBuilder();
		StringBuilder prevValue = new StringBuilder();
		int i = 1;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			while ((line = br.readLine()) != null) {
				listLines.add(line);
				if ((line.indexOf(" ") == 1) && (line.contains("   "))) {
					continue;
				}
				if (line.indexOf(":") >= 0) {
					// collecting all the keys
					keys.add(line.split(": ")[0]);
				}
			}

			for (String lineNew : listLines) {

				if (lineNew.indexOf(" ") == 1) {
					date = lineNew;
					// System.out.println("date is: " + date);
					continue;
				}
				if (lineNew.indexOf(":") >= 0) {
					headers = lineNew.split(": ");
					prevKey = new StringBuilder(headers[0]);
					prevValue = new StringBuilder(headers[1]);
					map.put(headers[0].trim(), headers[1].trim());
				} else if (!lineNew.trim().isEmpty()) {
					prevValue.append(" ");
		 			prevValue.append(lineNew);
					map.put(prevKey.toString(), prevValue.toString());
				}

				if (lineNew.trim().isEmpty()) {
					if (i == 1) {

						for (String key : keys) {
							System.out.print(key);
							System.out.print("|");
						}
						System.out.println();
					}

					for (Map.Entry<String, String> entry : map.entrySet()) {
						System.out.print(entry.getValue());
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
		// System.out.println("ADD|BANK|BORROWER|MTG|DATE");
		// String[] heads ={"ADD","MTG"
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.print(entry.getValue());
			System.out.print("|");

		}
		System.out.print(date);
	}

}
