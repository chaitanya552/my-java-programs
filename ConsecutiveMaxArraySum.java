public class ConsecutiveMaxArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// // int[] array = { 20, -19, 7, 9, 4 };
		// int[] array = { -20, -5, -2, -9 };
		int[] array = { 20, -19, 6, 9, 4 };
		int l = array.length;
		// System.out.println(getMinValue(array));
		
		int min = array[0];
		int max = array[0];
		for (int ii = 0; ii < array.length; ii++) {
			if (array[ii] < min) {
				min = array[ii];
			} else if (array[ii] > max) {
				max = array[ii];
			}
		}

		int sum = 0;
		// int max=0;
		for (int i = 0; i < l; i++) {
			sum = array[i];

			if (sum >= max) {
				max = sum;
			}
			for (int j = i + 1; j < l; j++) {
				sum = sum + array[j];

				if (sum > max) {
					max = sum;

				}
			}
		}
		System.out.println(max);
	}

}
