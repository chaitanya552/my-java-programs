/**.*
...
.*.
input is above



output
*2*
232
1*1
*/
/*******************************************************************************

 *  
 *  Creates an MxN minesweeper game where each cell is a bomb with
 *  probability p. Prints out the m-by-n game and the neighboring bomb
 *  counts.
 *
 *  Sample execution:
 *
 *      
 *      * . . . . . . . . * 
 *      . . . . . . * . . . 
 *      . . . . . . . . * * 
 *      . . . * * * . . * . 
 *      . . . * . . . . . . 
 *
 *      * 1 0 0 0 1 1 1 1 * 
 *      1 1 0 0 0 1 * 2 3 3 
 *      0 0 1 2 3 3 2 3 * * 
 *      0 0 2 * * * 1 2 * 3 
 *      0 0 2 * 4 2 1 1 1 1 
 *
 *
 **************************************************************************
 */
//code should iterate through matrix and check for
// *'s should remain where as dots should be replaced with number of mines surrounding it ( in 8 directios)

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Bcl_MineSweeperMine {
	
	public static void main(String[] args) throws IOException {
	
		String line;
		//int i = 0;
		String data[] = null;
		String splitby = ",";	
		String count;
		int m=5;
		int n=5;
		String[][] matrix= {{"*",".","*",".","*"},{".",".",".","*","."},{".","*",".",".","."},{".","*",".",".","."},{".","*",".",".","."}};
		System.out.println("given mines");
		for (int i=0;i<m;i++)
		{
			for (int j=0;j<n;j++){
				//System.out.println(i+"j"+j);
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i=0;i<m;i++)
		{
			for (int j=0;j<n;j++){
				if( matrix[i][j]=="*")
				{
					continue;
				}
				else {
				
					count =checkforstars(matrix,i,j,m,n);
					matrix[i][j]= count;
				}
			}
			
		}
		System.out.println("output");
		for (int i=0;i<m;i++)
		{
			for (int j=0;j<n;j++){
				
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	public static String checkforstars(String matrix[][],int i,int j, int m ,int n)
	{
		//System.out.println("i value is "+i + "j value is "+j);
		//System.out.println(matrix[0][2]+"matrix value");
		int count=0;
		//left
		if ((j-1)>=0)
		{
	    if (matrix[i][j-1]=="*") 
		{
			count++;
		}
		}
		//right
		if ((j+1)<n)
		{
	    if (matrix[i][j+1]=="*") 
		{
			count++;
		}
		}
		//up
		if ((i-1)>=0)
		{
	    if (matrix[i-1][j]=="*") 
		{
			count++;
		}
		}
		//bottom
		if ((i+1)<m)
		{
	    if (matrix[i+1][j]=="*") 
		{
			count++;
		}
		}
		//top left
		if ((i-1)>=0 & (j-1)>=0)
		{
	    if (matrix[i-1][j-1]=="*") 
		{
			count++;
		}
		}
		//borrom right
		if ((i+1)<m & (j+1)<n)
		{
	    if (matrix[i+1][j+1]=="*") 
		{
			count++;
		}
		}
		//top right
		if ((i-1)>=0 & (j+1)<n)
		{
	    if (matrix[i-1][j+1]=="*") 
		{
			count++;
		}
		}
		//bottom left
		if ((i+1)<m & (j-1)>=0)
		{
	    if (matrix[i+1][j-1]=="*") 
		{
			count++;
		}
		}
		String countstr= Integer.toString(count);
		return countstr;
		
	}
}
