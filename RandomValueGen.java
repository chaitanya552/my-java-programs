import java.util.Random;
public class RandomValueGen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<5;i++)
		{
		int[] array ={1,2,3,4,5};
		    int rnd = new Random().nextInt(array.length);
		  System.out.println(array[rnd]);
		}
	}
	}

