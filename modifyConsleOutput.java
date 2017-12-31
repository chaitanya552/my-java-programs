
public class modifyConsleOutput {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
System.out.println(add(10,20));
System.out.print("hello");
Thread.sleep(1000); // Just to give the user a chance to see "hello".
System.out.print("\b\b\b\b\b");
System.out.print("world");
	}
public static int add(int a, int b)
{
	int sum=a+b;
	return sum;
}
}
