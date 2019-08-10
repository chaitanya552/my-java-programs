import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * a,2
 * b,5
 * c,8
 * d,1
 * e,8
 * f,10
 * g,11
 */
public class Top5Exceptions_glbf
{

    public static void main(final String[] args) throws FileNotFoundException
    {
        // TODO Auto-generated method stub
        final String input = "C:/Users/gkneerukonda/Documents/exceptions.csv";
        final BufferedReader br = new BufferedReader(new FileReader(new File(input)));
        final List<String> exceptions = new ArrayList<String>();
        try {
            String line;
            while ((line = br.readLine()) != null) {
                exceptions.add(line);
            }

        }
        catch (final IOException e) {
            e.printStackTrace();
        }
        System.out.println("input: " + exceptions);

        Top5(exceptions);

    }

    public static void Top5(final List<String> exceptions)
    {
        final Map<String, Integer> map = new TreeMap<String, Integer>();
        for (int i = 0; i < exceptions.size(); i++) {
            final int count = 0;
            final String key = exceptions.get(i);
            if (!map.containsKey(key)) {
                map.put(key, 1);
            }
            else {
                int val = map.get(key);
                val = val + 1;
                map.put(key, val);
            }
        }

        final Map<Integer, String> treemap = new TreeMap<Integer, String>(new DescOrder());
        for (final Map.Entry<String, Integer> entry : map.entrySet()) {

            treemap.put(entry.getValue(), entry.getKey());

        }
        int i = 0;

        System.out.println("output: " + "" + treemap.toString());
        // System.out.println(treemap.size());

        for (final Map.Entry<Integer, String> entry : treemap.entrySet()) {

            System.out.println(entry.getValue() + " " + entry.getKey());
            if (i == 4) {
                break;
            }
            i++;
        }

    }
}

class DescOrder implements Comparator<Integer>
{

    @Override
    public int compare(final Integer a1, final Integer a2)
    {
        return a2 - a1;
    }
}