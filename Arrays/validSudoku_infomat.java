package Arrays;

/*
 * Input:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 * modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 */
import java.util.HashSet;
import java.util.Set;

public class validSudoku_infomat
{
    // Test

    public static void main(final String[] args)
    {
        final String[][] sudoku = { { "8", "3", ".", ".", "7", ".", ".", ".", "." }, { "6", ".", ".", "1", "9", "5", ".", ".", "." },
            { ".", "9", "8", ".", ".", ".", ".", "6", "." }, { "8", ".", ".", ".", "6", ".", ".", ".", "3" }, { "4", ".", ".", "8", ".", "3", ".", ".", "1" },
            { "7", ".", ".", ".", "2", ".", ".", ".", "6" }, { ".", "6", ".", ".", ".", ".", "2", "8", "." }, { ".", ".", ".", "4", "1", "9", ".", ".", "5" },
            { ".", ".", ".", ".", "8", ".", ".", "7", "9" } };
        System.out.println(isValid(sudoku));

    }

    static boolean isValid(final String[][] sudoku)
    {
        final Set<String> rowSet = new HashSet<>();
        final Set<String> columnSet = new HashSet<>();
        final Set<String> blocksSet = new HashSet<>();
        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                // checking all rows
                if (!rowSet.add(sudoku[i][j])) {
                    return false;
                }
                // checking all columns
                if (!columnSet.add(sudoku[j][i])) {
                    return false;
                }
                // method 2
                // blocks can also be verified
                // for column to move horizontally it is j%3 ->0 , 1 , 2, to move to next block horizontally it is j%3 +3*(i%3)
                // for rows to move vertically it is j/3 ->0 , 1 , 2, to move to next block vertically it is j/3 +3*(i/3)
                // blockSet.add[j/3+ (3*i/3)][j%3 +(3*i%3)]

            }
            rowSet.clear();
            columnSet.clear();// set = new Hashset<>()
        }

        /*
         * iterating block by block
         * j is 0, later j becomes 3
         * 00 01 02 03 04 05
         * 10 11 12 13 14 15
         * 20 21 22
         */
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                // checking individual blocks
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (!blocksSet.add(sudoku[i + k][j + l])) {
                            return false;
                        }
                    }
                }
                blocksSet.clear();
            }
        }

        return true;

    }

}
