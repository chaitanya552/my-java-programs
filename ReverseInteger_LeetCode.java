
public class ReverseInteger_LeetCode {
	public static int reverse(int x) {
	    int sign = (x < 0)? -1 : 1;
	    x = Math.abs(x);
	    long res=0;
	    while(x > 0){
	        res = res*10 + x%10;
	        x = x/10;
	    }
	    if(sign == 1 &&  res > Integer.MAX_VALUE)
	        return 0;
	    if(sign == -1 && -1*res < Integer.MIN_VALUE)
	        return 0;
	    return (int)res*sign;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(120));
		System.out.println(Integer.MAX_VALUE);
	}

}
