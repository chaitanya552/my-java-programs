/*
 * Input
You will receive a string array of at most 300,000 strings, where each string corresponds to one
event. These events are already sorted in terms of time, and take one of two forms:
1. Job start events
Take the form <CONTRACTOR_NAME>;START
The CONTRACTOR_NAME is a unique identifier for the contractor, and is guaranteed not
to contain a semicolon.
2. Job completion events
Take the form <CONTRACTOR_NAME>;<INVOICE_ID>(,<INVOICE_ID>)*
The CONTRACTOR_NAME is the same unique identifier for the contractor as before.
INVOICE_ID 's are integer values, guaranteed to fit within the value of a signed 64-
bit long.
test case 1:
David;START
David;24
Evil;START
Evil;18

18<24 hence its a shortened_job
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TimeSheetErrorDetection_Pntr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = { "Nick;START", "Jeremy;START", "Nick;10",
				"Leah;START", "Leah;7", "Jeremy;START", "Jeremy;START",
				"Jeremy;8,11,12" };
		// System.out.println(input[0]);
		String[] result = findViolations(input);
		for (String elements : result) {
			System.out.println(elements);
		}
	}

	
	static String[] findViolations(String[] datafeed) {

		List<String> res = new LinkedList<>();

		int min = Integer.MIN_VALUE;

		// Map for < contractor - <Line number, previous invoice number> >
		// mapping
		Map<String, Pair> hm = new HashMap<>();

		int lines = 1;

		for (String data : datafeed) {
			// System.out.println("current min is : " + min);
			String[] input = data.split(";");

			if (input[1].equals("START")) {

				hm.put(input[0], new Pair(lines, min));
				// System.out.println(input[0] + " value :" + min);
			} else {
				// NOT START its having invoices
				String[] invoices = input[1].split(",");
				if (invoices.length == 1) {
					// its single invoice, so check for shortened job
					// get the previous start's value pair
					Pair entry = hm.get(input[0]);
					// entry.y has the key's previous start value
					if (Integer.parseInt(invoices[0]) < entry.y) {
						// current invoice is less than start's invoice its a
						// shortened job
						// System.out.println("fraud case");
						String fraud_Shortened = "" + entry.x + ";" + input[0]
								+ ";" + "SHORTENED_JOB";
						res.add(fraud_Shortened);
					} else {
						// ****update the min value ********
						// *****No need to update the hash map
						// min = Integer.parseInt(invoices[0]);
						// min only needs to be updated when the min obtained is
						// greater than previous min
						int temp_min = Integer.parseInt(invoices[0]);
						if (temp_min > min && temp_min < Integer.MAX_VALUE) {
							min = temp_min;
						}
					}
				} else {
					// *********** more invoices *************


					Pair entry = hm.get(input[0]);

					Arrays.sort(invoices);
					// sort gives elements in descending order
					int len = invoices.length;
					// 0th is smallest and len-1 is largest
					// if all are shortened so it has to be considered as
					// individual shortened jobs
					// System.out.println("max invoice is " + invoices[len -
					// 1]);
					if (Integer.parseInt(invoices[0]) < entry.y) {
						// System.out.println("all shortened case");
						for (int h = 0; h < invoices.length; h++) {
							int line_temp = entry.x - h;
							String fraud_Shortened = "" + line_temp + ";"
									+ input[0] + ";" + "SHORTENED_JOB";
							res.add(fraud_Shortened);

						}
						// to check atleast one of it is shortened
					} else if (Integer.parseInt(invoices[len - 1]) < entry.y) {
						String fraud_Suspicious = "" + lines + ";" + input[0]
								+ ";" + "SUSPICIOUS_BATCH";
						res.add(fraud_Suspicious);

					} else {

						// if (!fraud) {

						int temp1_min = Integer.parseInt(invoices[len - 1]);
						if (temp1_min > min && temp1_min < Integer.MAX_VALUE) {
							min = temp1_min;
						}
					}

				}
			}

			lines++;

		}
		// System.out.println(res);
		String[] ans = new String[res.size()];
		for (int i = 0; i < res.size(); i++) {
			ans[i] = res.get(i);
			// System.out.println(ans[i]);
		}
		// String[] ans = (res.toArray(new String[res.size()]));
		return ans;
	}

	static class Pair {
		// x : line number
		int x;
		// y : previous invoice number record
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}