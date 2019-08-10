package testPackage;

public class Class2
{

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        final Class1 c1 = new Class1();
        final int[] sample = new int[10];
        sample[0] = 100;
        c1.setArray(sample);
        // impotance of defensive copy is hown here
        c1.getArray()[0] = 10000;// the get modifies the array
        System.out.println(c1.getArray()[0]);

    }
}
