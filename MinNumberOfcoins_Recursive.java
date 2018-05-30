
import java.util.ArrayList;
import java.util.Collections;



public class MinNumberOfcoins_Recursive {
    public static void main(String[] args) {
        // int n = 5;
        ArrayList<Integer> s = new ArrayList<>();
        s.add(1);
        s.add(5);
        s.add(10);
        s.add(20);
        s.add(50);
        s.add(100);
        
        System.out.println(CoinChange(7, s));
        System.out.println(CoinChange(17, s));
        System.out.println(CoinChange(23, s));
        
    }
    
    public static int CoinChange(int n, ArrayList<Integer> s) {
        ArrayList<Integer> result = new ArrayList<>();
        if (s.contains(n)) {
            return 1;
        }
        for (int i = 0; i < s.size(); i++) {
            if(s.get(i) <= n){
                result.add( (CoinChange(n - s.get(i), s)));
            }
        }
        return Collections.min(result) + 1;
    }
}
//lot of recomputations so we use dp

/*// m is size of coins array 
// (number of different coins)
static int minCoins(int coins[], int m, int V)
{
    // table[i] will be storing 
    // the minimum number of coins
    // required for i value. So 
    // table[V] will have result
    int table[] = new int[V + 1];

    // Base case (If given value V is 0)
    table[0] = 0;

    // Initialize all table values as Infinite
    for (int i = 1; i <= V; i++)
    table[i] = Integer.MAX_VALUE;

    // Compute minimum coins required for all
    // values from 1 to V
    for (int i = 1; i <= V; i++)
    {
        // Go through all coins smaller than i
        for (int j = 0; j < m; j++)
        if (coins[j] <= i)
        {
            int sub_res = table[i - coins[j]];
            if (sub_res != Integer.MAX_VALUE 
                   && sub_res + 1 < table[i])
                   table[i] = sub_res + 1;
                    
             
        }
         
    }
    return table[V];
     
}

// Driver program 
public static void main (String[] args) 
{
    int coins[] = {9, 6, 5, 1};
    int m = coins.length;
    int V = 11;
    System.out.println ( "Minimum coins required is "
                        + minCoins(coins, m, V));
}
}

//This article is contributed by vt_m.*/