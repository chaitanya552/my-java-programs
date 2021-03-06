import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class initializationsOfJava
{
    public static void main(final String[] args)
    {
        initializing_String_int_char();
        stringBuffer_Builder_substring();
        FileReadandMap();
        scanning();
        StringIntCharObjects();
        split();
        collections();

    }

    // int String char
    public static void initializing_String_int_char()
    {
        System.out.println();
        System.out.println("initializing_String_int_char()");
        final String str = "it is a string";
        final char a = 'a';
        System.out.println("ascii value of a is: " + (int) a);

        final char ch = 'a' + 2;
        System.out.println("character a added a value of 2: " + ch);
        // character subtraction
        final char temp = 'c';
        // c-a i.e 99-97 =2
        System.out.println("subtracting character a: " + (temp - 'a'));

        final int num = 23;
        final String s1 = String.valueOf(num);
        // or
        final String s2 = Integer.toString(num);
        System.out.println("num converted to string: " + s1);

        final String str2 = "2312";
        final int strToNum = Integer.parseInt(str2);
        System.out.println("String is cnverted to num: " + strToNum);

        String s5 = "geek";
        s5 = s5.replace("e", "o");
        System.out.println("using replace e is repaced with o: " + s5);

        final String s6 = "aapple";
        s6.substring(1);
        // - omits first character
        System.out.println("omits first character :" + s6.substring(1));
        // if (string.matches("(.*)㉺")) -booleabn value

        final String s7 = "chaianya";
        final char[] s7_char = s7.toCharArray();
        System.out.println("string |chaitanya| is converted to char array and first element is: " + s7_char[0]);
        System.out.println();
        final int[] nums = { 1, 2, 3 };
        // converting integer array to a string
        System.out.println("prints an nums integer array" + Arrays.toString(nums));

        System.out.println();
        System.out.println("extending the nums array");
        final int[] extended = new int[nums.length + 1];
        extended[0] = 9;

        System.arraycopy(nums, 0, extended, 1, nums.length);
        System.out.println("extended array" + Arrays.toString(extended));
        // arraycopy(Object src, int srcPos, Object dest, int destPos, int
        // length)
        // here length is nmber of elements copied
    }

    // strungBuffer_Builder_substring()
    public static void stringBuffer_Builder_substring()
    {
        System.out.println();
        System.out.println("stringBuffer_Builder_substring()");
        final StringBuilder sb = new StringBuilder();
        // adds 9 character string at beginning
        sb.append("chaitanya");
        sb.append("kumar");

        sb.reverse();
        // reverse it
        final String s3 = sb.toString();

        System.out.println("string builder is reverse and to string is used :" + s3);

        final StringBuffer s4 = new StringBuffer("Geeks");
        s4.append("forgeeks");
        /*
         * StringBuffer is similar to StringBuilder except one difference that
         * StringBuffer is thread safe, i.e., multiple threads can use it n that
         * is sychronized one after other
         */
        // substrings
        // substring of (a,b) means a is included and b is excluded and it
        // starts from index 0
        System.out.println("substring of(2,5) in chaitanya: " + "Chaitanya".substring(2, 5));

    }

    // file reading and putting into maps
    public static void FileReadandMap()
    {
        System.out.println();
        System.out.println("FileReadandMap()");
        // import java.util.HashMap;
        final Map<String, String> map = new HashMap<String, String>();

        final File file = new File("PhenomeDict.txt");
        try {

            final FileReader fileReader = new FileReader(file);
            final BufferedReader br = new BufferedReader(fileReader);
            final StringBuffer buf = new StringBuffer();
            // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            // BufferedReader br = new BufferedReader(new FileReader(file)))
            // Scanner scan=new Scanner(System.in);
            String line;
            while ((line = br.readLine()) != null) {
                // splits text by spaces
                // APPLE AE1 P AH0 L
                // key is pheome AE1 P AH0 L
                // value is APPLEBEE
                final String lineSplit[] = line.split("  ");
                map.put(lineSplit[1], lineSplit[0]);

            }
            System.out.println("checking the value by giving key'AE1 P AH0 L':  " + map.get("AE1 P AH0 L"));
        }
        catch (final Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // scanner
    public static void scanning()
    {
        System.out.println();
        System.out.println("scanning()");
        final Scanner dd = new Scanner(System.in);
        System.out.println("Enter the start time 'hhmm'");
        // int idFile = dd.nextInt();
    }

    // arrays

    // lists

    // Integer String char objects
    public static void StringIntCharObjects()
    {
        System.out.println();
        System.out.println("StringIntCharObjects()");
        // List<String> myString = new List<String>();
        // char[] myCharArray = myString.toCharArray();
        // char[] a = new char[s1.length()];
    }

    // list to array conversions

    // splitby
    public static void split()
    {
        System.out.println();
        System.out.println("split()");

        final String input = "98+99/77-22";
        // String input = "2*8*4";
        // String input = "2*8*4";

        // this splits by numbers, accumates all the numbers and then prints
        // only symbols .ie other than numbers
        final String operators[] = input.split("[0-9]+");
        // prints only the numbers and it splits by + - /*
        final String operands[] = input.split("[+-/*]");
        final int arr[] = { 1, 1, 1, 2, 2, 3, 4 };
        System.out.println(Arrays.toString(arr) + "array got converted to string but not perfect");
        final String str = Arrays.toString(arr).replaceAll("\\[|\\]|,|\\s", "");
        System.out.println(str + "  usiing regex we replaced [ , ] and extra spaces with empty");
        System.out.println("operator is :" + operators[1]);
        System.out.println("first operand is: " + operands[0]);
        // The characters are ^ - [ and two &s in a row(&&). In order to use one of these characters, we need to put \\ in front of the character:

        final String expr = "2*x^3 - 4/5*y + z^2";
        final String delims = "[+\\-*/\\^ ]+"; // so the delimiters are: + - * / ^ space
        final String[] tokens = expr.split(delims);
        // final String[] words2 = instring.replaceAll("[^a-zA-Z]", "").toLowerCase().split("\\s+");
        final String delims2 = "[ .,?!]+";
        final String[] tokens2 = str.split(delims);

        final String paragraph = "gutfyiutf ufyfuyf yfuyffu foyfyuf";
        /*
         * for (final char c: paragraph.toCharArray()) {
         * if (Character.isLetter(c)) {
         * word.append(Character.toLowerCase(c));
         * } else if (word.length() > 0) {
         * final String finalword = word.toString();
         * }
         * }
         */
    }

    public static void collections()
    {
        final Set<String> set = new LinkedHashSet<String>();
        final List<String> list = new LinkedList<String>();
        final Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

        // iterations
        for (final Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " is repeated " + entry.getValue());
        }
        final ArrayList<ArrayList<String>> listOLists = new ArrayList<ArrayList<String>>();
        // or
        final List<List<String>> listOListsNew = new ArrayList<>();
        final ArrayList<String> singleList = new ArrayList<String>();
        // or
        final List<String> singleListNew = new ArrayList<>();
        singleList.add("hello");
        singleList.add("world");
        listOLists.add(singleList);

        // m1
        final java.util.Iterator<String> it = set.iterator();

        // Display element by element using Iterator
        // Java rule : One public class in one file.
        // cannot have two public classes in one program
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        // m2
        for (final String temp : set) {
            System.out.println(temp);
        }
    }
    // File writer
}
//

/*
 * *
 * list
 * List<String> dateTime = new ArrayList<>(); List<Integer> count = new
 * ArrayList<>();
 * LinkedList<String> linkedList = new LinkedList<String>();
 * List l2 = new ArrayList(); l2.add(1); l2.add(2); l2.add(3);
 * System.out.println(l1.get(3));
 * sublist List<String> l = new ArrayList<String>(5);
 * l.add("GeeksforGeeks"); l.add("Practice"); l.add("GeeksQuiz"); l.add("IDE");
 * l.add("Courses");
 * List<String> range = new ArrayList<String>();
 * // return List between 2nd(including) // and 4th element(excluding) range =
 * l.subList(2, 4);
 * date and time subtractions SimpleDateFormat format1 = new
 * SimpleDateFormat("HH:mm"); s1 = (idFile / 100) + ":" + (idFile % 100); String
 * s2; s2 = (endFile / 100) + ":" + (endFile % 100); Date ds1 = null; Date ds2 =
 * null; try { ds1 = format1.parse(s1); ds2 = format1.parse(s2); } catch
 * (ParseException e) { e.printStackTrace(); }
 * SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");
 * Date ds3 = null; Date ds4 = null; String datebegins =
 * Integer.toString(datebegin); String dateends = Integer.toString(dateend); try
 * { ds3 = format2.parse(datebegins); ds4 = format2.parse(dateends); } catch
 * (ParseException e) { e.printStackTrace(); } long diff2 =
 * Math.round((ds4.getTime() - ds3.getTime()) / (double) 86400000); int days;
 * days = (int) diff2;
 * file reading String line = ""; String[] data = null; List<String> dateTimeL =
 * new ArrayList<>(); List<Integer> countL = new ArrayList<>(); List<String>
 * symbolL = new ArrayList<>();
 * csvFinal = "C:/Users/cn94682/Desktop/input2/" + datebegin +
 * "/HumanCount_PairCount_0" + idFile + ".csv"; File inp = new File(file path
 * string or csvfinal); try (BufferedReader br = new BufferedReader(new
 * FileReader(inp))) { // initializing the lists for taking the columns while
 * ((line = br.readLine()) != null) { // use comma as separator data =
 * line.split(cvsSplitBy); // trims the data so that there are no extra spaces
 * // adding the data to lists dateTimeL.add(data[0].trim());
 * symbolL.add(data[1].trim()); countL.add(Integer.parseInt(data[2].trim())); }
 * list to array conversion String[] datearray = new String[dateTime.size()];
 * datearray = dateTimeL.toArray(datearray);
 * String[] symbolarray = new String[symbol.size()]; symbolarray =
 * symbolL.toArray(symbolarray);
 * int[] countArray = new int[count.size()]; for (int i = 0; i <
 * countArray.length; i++) { countArray[i] = countL.get(i); }
 * writing files to a csv FileWriter Visual = new FileWriter("visual" +
 * datebegin + "_to_" + dateend + ".csv"); Visual.append(VIS_HEADER);
 * Visual.append("\n"); visual.append(Integer.toString(n + 1));
 * visual.append(COMMA_DELIMITER);
 * Visual.flush(); Visual.close();
 * //list to int conversion static int[] oddNumbers(int l, int r) {
 * List<Integer> count = new ArrayList<>(); for(int i=l; i<=r;i++) {
 * if (i%2==1) { count.add(i); } } int[] countArray = new int[count.size()]; for
 * (int i = 0; i < countArray.length; i++) { countArray[i] = count.get(i); }
 * return countArray; } }
 */
