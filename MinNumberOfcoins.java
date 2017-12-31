
import java.util.ArrayList;
import java.util.Collections;



public class MinNumberOfcoins {
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
