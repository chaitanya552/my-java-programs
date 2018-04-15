public class ReturnMultipleValues_Java2 {
	int mul;
	double div;

	ReturnMultipleValues_Java2(int m, double d) {
		this.mul = m;
		this.div = d;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReturnMultipleValues_Java2 ans = doMultDiv(40, 30);
		System.out.println("multiplication is:" + ans.mul);
		System.out.println("division is:" + ans.div);
		ReturnMultipleValues_Java2 ans2 = doSome(40, 30);
		System.out.println("multiplication is:" + ans2.mul);
		System.out.println("division is:" + ans2.div);
	}

	static ReturnMultipleValues_Java2 doMultDiv(int a, int b) {
		int multiply = a * b;
		double division = (double) a / b;
		// return new multDiv(a * b, (double) a / b);
		// return new multDiv(multiply,division);
		ReturnMultipleValues_Java2 res = new ReturnMultipleValues_Java2(
				multiply, division);
		return res;
	}

	static ReturnMultipleValues_Java2 doSome(int a, int b) {
		int multiplyBy10 = a * b * 10;
		double divisionBy10 = (double) a / b / (10.0);
		// return new multDiv(a * b, (double) a / b);
		// return new multDiv(multiply,division);

		ReturnMultipleValues_Java2 res2 = new ReturnMultipleValues_Java2(
				multiplyBy10, divisionBy10);
		return res2;
	}

}
