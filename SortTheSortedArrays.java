import java.util.Arrays;

public class SortTheSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = new int[5][];
System.out.println(A.length);
		A[0] = new int[] { 1, 5, 8, 9 };
		A[1] = new int[] { 2, 3, 7, 10 };
		A[2] = new int[] { 4, 6, 11, 15 };
		A[3] = new int[] { 9, 14, 16, 19 };
		A[4] = new int[] { 2, 4, 6, 9 };
		
	
		int[] B = Sorting(A[0], A[1]);
		for (int j=2; j<A.length;j++)
		{
			B = Sorting(B, A[j]);
		}
		//B = Sorting(B, A[i]);
		System.out.println(Arrays.toString(B));
	}

	public static int[] Sorting(int a[], int b[]) {
		int len = a.length + b.length;
		int[] newarray = new int[len];
		int j = 0;
		int k = 0;
		int i = 0;
		// Max (a.len , b.len)

		while (i < a.length && j < b.length) {

			if (a[i] < b[j]) {
				newarray[k] = a[i];
				k++;
				i++;
			} else {
				newarray[k] = b[j];
				j++;
				k++;
			}

		}

		while (i >= a.length && k < len) {
			

			newarray[k] = b[j];
			//System.out.println(newarray[k]);
			j++;
			k++;
		}
		while (j >= b.length && k < len) {
			newarray[k] = a[i];
			i++;
			k++;
		}
		return newarray;
	}
}