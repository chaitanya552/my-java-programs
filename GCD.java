public class GCD
{

    public static void main(final String[] args)
    {

        int num1 = 55, num2 = 129;

        while (num1 != num2) {
            if (num1 > num2) {
                num1 = num1 - num2;
            }
            else {
                num2 = num2 - num1;
                System.out.println(num2);
            }
        }

        System.out.printf("GCD of given numbers is: %d", num2);
    }

}