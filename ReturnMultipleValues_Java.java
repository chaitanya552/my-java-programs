public class ReturnMultipleValues_Java {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		multDiv ans = doMultDiv(40, 30);
		System.out.println("multiplication is:"+ans.mul);
		System.out.println("division is:"+ans.div);
	}

	static multDiv doMultDiv(int a, int b) {
		int multiply=a*b;
		double division= (double)a/b;
		//return new multDiv(a * b, (double) a / b);
		//return new multDiv(multiply,division);
		multDiv res= new multDiv(multiply,division);
		return res;
	}

}

// this class stores integer and double
class multDiv {
	int mul;
	double div;

	multDiv(int m, double d) {
		this.mul = m;
		this.div = d;
	}

}