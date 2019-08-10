public class Weights
{

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        // input reading
        // 10 20 15 7.5 2.5 8
        // max weight 30
        // max weight < sum of two weights
        // print
        // int j=0;
        final double weights[] = { 5, 20, 10, 7.5, 2.5, 9 };
        final double sum[] = new double[weights.length * weights.length];
        int k = 0;
        final int a = 0;
        final int b = 0;
        final double temp = 0;
        double idealmax = 0;
        final int z = 0;

        final double maxweight = 30;
        double weight1 = 0;
        double weight2 = 0;
        // System.out.println(weights.length);

        for (int i = 0; i < weights.length; i++) {
            for (int j = i + 1; j < weights.length; j++) {
                sum[k] = weights[i] + weights[j];

                if ((sum[k] >= idealmax) & (sum[k] < maxweight))

                {
                    idealmax = sum[k];
                    weight1 = weights[i];
                    weight2 = weights[j];
                }

                k++;

            }
        }
        System.out.println("max weight is" + idealmax + "   with weights" + weight1 + " 2nd weight is " + weight2);

    }

}
