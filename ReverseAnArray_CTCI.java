//swap first and last elements
//runs only n/2 length 
//but time complexity is O(n)

public class ReverseAnArray_CTCI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 2, 3, 4, 5};
		for (int i = 0; i < a.length / 2; i++) {
			int last = a.length - 1 - i;
			int temp = a[i];
			a[i] = a[last];
			a[last] = temp;
		}
		for(int i=0;i<a.length; i++)
		{
		System.out.print(a[i]+" ");
		}
	}

}
