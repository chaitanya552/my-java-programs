import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class initializations {

}

/* scanner
 * Scanner dd = new Scanner(System.in);
		System.out.println("Hi! My name is Jarvis....I'm happy to help you ");
		System.out.println();
		System.out.println("Enter the start time 'hhmm'");
		int idFile = dd.nextInt();
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * char[] myCharArray = myString.toCharArray();
 * char[] a = new char[s1.length()];
 * 
 * 
 * 
 * StringBuilder sb = new StringBuilder();
 * adds 9 character string at beginning
 *  sb.append("Greetings");
 * StringBuilder sb = new StringBuilder("geeks");
 * 
        
        sb.reverse();  // reverse it
         String ans =sb.toString() // string builder to string 
        
 * 
 * StringBuffer s3 = new StringBuffer("Geeks")
 * s3.append("forgeeks");
 * StringBuffer is similar to StringBuilder except one difference that StringBuffer is thread safe, 
 * i.e., multiple threads can use it 
 * 
 * strings
 * delimiter concept 
 * String sentence= " hello i am new here";
 * String[] words = sentence.split(" ");
 * words arrays contains all teh words
 * 
 *iterating through these words
 *for( String word : words)
 *{
 *} 
 * 
 * 
 * str = str.replace("i", "!"); 
 * 
 * str= aapple;
 * str.substring(1) - omits first character
 * 
 * if (string.matches("(.*)㉺")) -booleabn value
 * 
 * 
 * 
 * list
 * 
 * List<String> dateTime = new ArrayList<>();
			List<Integer> count = new ArrayList<>();


 * LinkedList<String> linkedList = new LinkedList<String>();
 * 
 *   List l2 = new ArrayList();
        l2.add(1);
        l2.add(2);
        l2.add(3);
 * System.out.println(l1.get(3));
 * 
 *sublist 
 *  List<String> l = new ArrayList<String>(5);
 
        l.add("GeeksforGeeks");
        l.add("Practice");
        l.add("GeeksQuiz");
        l.add("IDE");
        l.add("Courses");
 
        List<String> range = new ArrayList<String>();
 
        // return List between 2nd(including)
        // and 4th element(excluding)
        range = l.subList(2, 4);
 * 
 * 
 * date and time subtractions 
 * SimpleDateFormat format1 = new SimpleDateFormat("HH:mm");
 * s1 = (idFile / 100) + ":" + (idFile % 100);
		String s2;
		s2 = (endFile / 100) + ":" + (endFile % 100);
		Date ds1 = null;
		Date ds2 = null;
		try {
			ds1 = format1.parse(s1);
			ds2 = format1.parse(s2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
 * 
 * SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");
 * 
 * Date ds3 = null;
		Date ds4 = null;
		String datebegins = Integer.toString(datebegin);
		String dateends = Integer.toString(dateend);
		try {
			ds3 = format2.parse(datebegins);
			ds4 = format2.parse(dateends);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long diff2 = Math.round((ds4.getTime() - ds3.getTime())
				/ (double) 86400000);
		int days;
		days = (int) diff2;
 * 
 * 
 * file reading 
 * String line = "";
 * String[] data = null;
 * List<String> dateTimeL = new ArrayList<>();
			List<Integer> countL = new ArrayList<>();
			List<String> symbolL = new ArrayList<>();
			
			
 * csvFinal = "C:/Users/cn94682/Desktop/input2/" + datebegin
							+ "/HumanCount_PairCount_0" + idFile + ".csv";
                 File inp = new File(file path string or csvfinal);
				try (BufferedReader br = new BufferedReader(new FileReader(inp))) {
					// initializing the lists for taking the columns
					while ((line = br.readLine()) != null) {
						// use comma as separator
						data = line.split(cvsSplitBy);
						// trims the data so that there are no extra spaces
						// adding the data to lists
						dateTimeL.add(data[0].trim());
						symbolL.add(data[1].trim());
						countL.add(Integer.parseInt(data[2].trim()));
 * }
 * list to array conversion
 * String[] datearray = new String[dateTime.size()];
			datearray = dateTimeL.toArray(datearray);

			String[] symbolarray = new String[symbol.size()];
			symbolarray = symbolL.toArray(symbolarray);

			int[] countArray = new int[count.size()];
			for (int i = 0; i < countArray.length; i++) {
				countArray[i] = countL.get(i);
			}
 * 
 * 
 * writing files to a csv
 * FileWriter Visual = new FileWriter("visual" + datebegin + "_to_"
				+ dateend + ".csv");
		Visual.append(VIS_HEADER);
		Visual.append("\n");
		visual.append(Integer.toString(n + 1));
	
		visual.append(COMMA_DELIMITER);
		
		Visual.flush();
	Visual.close(); 
		
		
		
		
		
 */
