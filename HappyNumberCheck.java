import java.util.HashSet;
import java.util.Set;


public class HappyNumberCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int num=94;
 //System.out.println(squareDigits(num));

 System.out.println(num +" is :"+checkHappy(num));
	}
	public static String checkHappy(int num)
	{
		int temp=num;
		if (temp==1)
		{
			return "happy number";
		}
		Set<Integer> set= new HashSet<Integer>();
		int loop=temp;
		
		while(loop!=1)
		{
			loop=squareDigits(loop);
			if(!set.add(loop))
			{
				return "not happy";
			}
		}
		return "happy ";
	}
	public static int squareDigits(int num)
	{
		int sq=0;
		while(num!=0)
		{
		int digit = num%10;
		sq+= digit*digit;
		num=num/10;
		}
		//System.out.println(sq+"square");
		return sq;
	}
}
