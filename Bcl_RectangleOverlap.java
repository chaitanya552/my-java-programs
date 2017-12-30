//
//java Given two axis-aligned rectangles A and B, 
//determine if the two overlap. 
//The rectangles considered overlapping if they have at least one common point.
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Bcl_RectangleOverlap {
	/**
	 * Iterate through each line of input.
	 */
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in,
				StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		// Scanner scan = new Scanner(in);

		String line;
		int i = 0;
		String data[] = null;
		String splitby=",";

		while (((line = in.readLine()) != null)) {
			data= (line.split(splitby));
			//data[i] = Integer.parseInt(line);
			break;
		}
		/*
		 * while ((line = in.readLine()) != null) { // System.out.println(line);
		 * // System.out.println(i); data[i] = Integer.parseInt(line); //
		 * System.out.println(data[i]+"data"); i++; if (i == 8) { break; } //
		 * System.out.println(i); }
		 */
		/*
		 * for (int j = 0; j < 8; j++) { System.out.println(data[j]);
		 */
		// }
		 int[] ints = new int[data.length];
	        for (int j = 0; j < ints.length; j++) {
	            ints[j] = Integer.parseInt(data[j]);
	            System.out.println(ints[j]);
	        }
		int x1 = ints[0];
		int y1 = ints[1];
		int x2 = ints[2];
		int y2 = ints[3];
		int x3 = ints[4];
		int y3 = ints[5];
		int x4 = ints[6];
		int y4 = ints[7];

		// System.out.println(data[0]);
		if ((x2 < x3) || (x4 < x1) || (y3 < y2) || (y1 < y4)) {
			System.out.println("not overlapping");
		} else {
			System.out.println("overlapping");
		}
	}
}
