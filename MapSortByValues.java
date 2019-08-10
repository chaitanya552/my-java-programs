import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapSortByValues
{
    public static void main(final String[] args)
    {
        final HashMap<String, Double> map = new HashMap<String, Double>();
        final ValueComparator bvc = new ValueComparator(map);
        final TreeMap<String, Double> sorted_map = new TreeMap<String, Double>(new ValueComparator(map));

        map.put("B", 67.4);
        map.put("A", 20.0);
        map.put("C", 67.4);
        map.put("D", 67.3);

        System.out.println("unsorted map: " + map);
        sorted_map.putAll(map);
        System.out.println("results: " + sorted_map);
    }
}

class ValueComparator implements Comparator<String>
{
    Map<String, Double> base;

    public ValueComparator(final Map<String, Double> base)
    {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with
    // equals.
    public int compare(final String a, final String b)
    {
        if (base.get(a) >= base.get(b)) {
            return -1;
        }
        else {
            return 1;
        } // returning 0 would merge keys
    }
}
