package testPackage;

import java.util.Arrays;

public class Class1
{
    private int[] array = new int[10];

    Class1()
    {
        array[0] = 1;
    }

    public int[] getArray()
    {
        // return array; this is bad
        return Arrays.copyOf(array, array.length);
    }

    public void setArray(final int[] array)
    {
        this.array = array;
    }

}
