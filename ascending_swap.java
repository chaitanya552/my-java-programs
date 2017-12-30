public class ascending_swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double weights[] = { 5, 20, 10, 7.5, 2.5, 8 };
		//int k = 1;
		double temp = 0;
		
		for (int k=0;k<weights.length-1;k++)
		{
		for (int i = 0; i < weights.length - 1; i++) {

			if (weights[i] > weights[i + 1]) {
				temp = weights[i];
				weights[i] = weights[i + 1];
				weights[i + 1] = temp;
				// System.out.println("true" + j);
			}
			// System.out.println(weights[i] + "and " + weights[j]);
		}
		}
		/*
			 * 
			 */

		// System.out.println("i value is "+i);
		for (int j = 0; j < weights.length; j++) {
			System.out.println("Ascending Order is " + weights[j] + ",");
		}
	}

}
