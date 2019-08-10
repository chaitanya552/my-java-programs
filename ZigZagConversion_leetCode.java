/*
 * The problem statement itself is unclear for many. Especially for 2-row case. "ABCD", 2 --> "ACBD". The confusion most likely is from the character placement.
 * I would like to extend it a little bit to make ZigZag easy understood.
 * The example can be written as follow:
 * P......A.....H.......N
 * ..A..P...L..S..I...I....G
 * ....Y......I....R
 * see the zig zag
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
 * Therefore, <ABCD, 2> can be arranged as:
 * A....C
 * ...B....D
 * ABCDEFGHIJKLM in zigzag
 * A......E.....I.......M
 * ..B..D...F..H..J...L....N
 * ....C......G....K
 */
/*
 * Logic is as follows
 * take String Buffers for each row
 * fill
 */
// Logic is as follows

// take String Buffers for each row
// fill an element and increment the index of string buffer sb[0] has first element
// sb[1] has second element and so....on
// now when we reach te last row we fill the element
// and then we have to go up(i.e decrement the index
/*
 * 1
 * 2
 * 3
 * 4
 * 3
 * 2
 * 1
 * 2
 * 3
 * 4
 */

public class ZigZagConversion_leetCode
{

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub

        /*
         * i.e from first row we increment index and when we reach last row we
         * decrement index
         */

        System.out.println(ZigZagConvert("PAYPALISHIRING", 3));
    }

    public static String ZigZagConvert(final String s, final int rows)
    {
        final int len = s.length();
        if (len <= 1) {
            return s;
        }
        final StringBuffer[] sb = new StringBuffer[rows];
        for (int i = 0; i < rows; i++) {
            sb[i] = new StringBuffer("");

        }
        int currentRow = 0;
        int increment = 1;
        for (int i = 0; i < s.length(); i++) {
            sb[currentRow].append(s.charAt(i));
            // System.out.println(currentRow);
            currentRow = currentRow + increment;

            if (currentRow == (rows - 1)) {
                increment = -1;
            }
            if (currentRow == 0) {
                increment = 1;
            }

        }
        // now concatenate StringBuffer and convert to string
        String answer = "";
        for (int i = 0; i < rows; i++) {
            answer = answer + sb[i];

        }
        return answer;
    }

}
