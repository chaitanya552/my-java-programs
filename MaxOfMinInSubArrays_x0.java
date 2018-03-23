//find sub arrays of length k
//find mins of all sub arrays
//now find max of all these mins found in sub arrays


import java.util.ArrayList;
import java.util.List;

public class MaxOfMinInSubArrays_x0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=3;
		int[] arr={2,5,4,6,8};
		System.out.println(segment(x, arr));
	}

	static int segment(int x, int[] arr) {
		
		int n=arr.length;
		int j;
		int min;
		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<=n-x;i++)
		{
			min=arr[i];
			for(j=1;j<x;j++)
			{
				if(arr[i+j]<min)
				{
					min=arr[i+j];
				}
			}
			//System.out.println(min+"min");
			if (min>max)
			{
				max=min;
			}
		}
		return max;
	}
}

/*
 * List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(5);
		list.add(2);
		list.add(3);
		list.sort(null);
		System.out.println(list.get(list.size()-1));
		*/
