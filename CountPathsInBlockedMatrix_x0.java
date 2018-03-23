/*
1 1 1
1 1 1 
1 1 1

no of paths with no blocking
go right or go down so we use dynamic and construct the answer
1 1 1 (left values)
1
1
{up values)
///////
1 1 1
1 2(sum up up value and left value) and so on 
1
*/
public class CountPathsInBlockedMatrix_x0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = { { 1, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 } };
		
		System.out.println(numberOfPaths(a));
	}

	static int numberOfPaths(int[][] a) {
		int result[][] = a;

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				if (result[i][j] != 0) {
					result[i][j] = 0;
					if (i == 0) {
						result[i][j] += result[i][j - 1];
					}
					if (j == 0) {
						result[i][j] += result[i - 1][j];
					}
					if (i > 0 && j > 0) {
						result[i][j] = result[i - 1][j] + result[i][j - 1];
					}

				}

			}
		}

		return result[a.length - 1][a[0].length - 1];
	}
}

