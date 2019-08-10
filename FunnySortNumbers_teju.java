import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * given a list of numbers, for example:
 * 1, 7, 2, 3, 19
 * if you sort them (ascending order) they will look like:
 * 1, 2, 3, 5, 7, 19
 * however we want to sort them in a "funny" way, where the sort order is like:
 * largest number, second largest, smallest number, second smallest, Third largest, fourth largest, third smallest, fourth smallest…
 * For the above example the funny sort will look like:
 * 19, 7, 1, 2, 5, 3
 * Implement a method that gets a list of numbers, and returns a funny sorted list. The Java signature would look like:
 * List<Integer> funnySort(List<Integer> unsorted) {...}
 */
public class FunnySortNumbers_teju
{

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        final List<Integer> unsorted = new ArrayList<>();
        unsorted.add(1);
        unsorted.add(7);
        unsorted.add(5);
        unsorted.add(2);
        unsorted.add(3);
        unsorted.add(19);

        System.out.println(funnySort(unsorted));
    }

    private static List<Integer> funnySort(final List<Integer> unsorted)
    {
        final List<Integer> result = new ArrayList<>();
        Collections.sort(unsorted);
        System.out.println(unsorted);
        while (unsorted.size() > 0) {
            if (unsorted.size() > 0) {
                result.add(unsorted.get(unsorted.size() - 1));
                unsorted.remove((unsorted.size() - 1));
            }
            if (unsorted.size() > 0) {
                result.add(unsorted.get(unsorted.size() - 1));
                unsorted.remove((unsorted.size() - 1));
            }
            if (unsorted.size() > 0) {

                result.add(unsorted.get(0));
                unsorted.remove(0);
            }
            if (unsorted.size() > 0) {
                result.add(unsorted.get(0));
                unsorted.remove(0);
            }
        }

        return result;
    }

}
