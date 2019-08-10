import java.util.LinkedList;
import java.util.Queue;

/*
 * just using depth
 * https://www.geeksforgeeks.org/shortest-distance-two-cells-matrix-grid/
 * Examples:
 * Input : {'0', '*', '0', 's'},
 * {'*', '0', '*', '*'},
 * {'0', '*', '*', '*'},
 * {'d', '*', '*', '*'}
 * Output : 6
 * Input : {'0', '*', '0', 's'},
 * {'*', '0', '*', '*'},
 * {'0', '*', '*', '*'},
 * {'d', '0', '0', '0'}
 * Output : -1
 * Recommended: Please try your approach on {IDE} first, before moving on to the solution.
 * The idea is to BFS (breadth first search) on matrix cells. Note that we can always use BFS to find shortest path if graph is unweighted.
 * Store each cell as a node with their row, column values and distance from source cell.
 * Start BFS with source cell.
 * Make a visited array with all having “false” values except ‘0’cells which are assigned “true” values as they can not be traversed.
 * Keep updating distance from source value in each move.
 * Return distance when destination is met, else return -1 (no path exists in between source and destination).
 */
public class ShortestDistanceTwoCellsMatrixGridBFS_usingDepth_Amz
{

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub

        final char[][] grid = { { '0', '*', '0', 's' }, { '*', '0', '*', '*' }, { '0', '*', '*', '*' }, { 'd', '*', '*', '*' } };

        System.out.println(minDistance(grid));

    }

    private static int minDistance(final char[][] grid)
    {

        final int row = grid.length;
        final int col = grid[0].length;
        final boolean[][] visited = new boolean[row][col];
        int sourceRow = 0;
        int sourceColumn = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (grid[i][j] == '0') {
                    visited[i][j] = true;
                }
                else {
                    visited[i][j] = false;
                }
                // Finding source
                if (grid[i][j] == 's') {

                    sourceRow = i;
                    sourceColumn = j;
                }
            }
        }
        final Queue<QItem> q = new LinkedList<>();
        q.add(new QItem(sourceRow, sourceColumn));
        int depth = 0;
        while (!q.isEmpty()) {

            for (int i = 0; i < q.size(); i++) {
                final QItem temp = q.remove();
                if (grid[temp.row][temp.col] == 'd') {
                    System.out.println(depth + 1);
                    return depth + 1;
                }

                // left
                if ((temp.col > 0) && (visited[temp.row][temp.col - 1] == false)) {
                    final QItem element = new QItem(temp.row, temp.col - 1);
                    visited[temp.row][temp.col - 1] = true;
                    q.add(element);
                }
                // right
                if ((temp.col < (col - 1)) && (visited[temp.row][temp.col + 1] == false)) {
                    final QItem element = new QItem(temp.row, temp.col + 1);
                    visited[temp.row][temp.col + 1] = true;
                    q.add(element);
                }
                // up
                if ((temp.row > 0) && (visited[temp.row - 1][temp.col] == false)) {
                    final QItem element = new QItem(temp.row - 1, temp.col);
                    visited[temp.row - 1][temp.col] = true;
                    q.add(element);
                }
                // down
                if ((temp.row < (row - 1)) && (visited[temp.row + 1][temp.col] == false)) {
                    final QItem element = new QItem(temp.row + 1, temp.col);
                    visited[temp.row + 1][temp.col] = true;
                    q.add(element);
                }
            }
            depth++;
        }

        return -1;

    }

}

class QItem
{
    int row;
    int col;

    public QItem(final int x, final int y)
    {
        row = x;
        col = y;
    }

}
