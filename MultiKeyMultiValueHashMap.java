
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class MultiKeyMultiValueHashMap
{

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        // multi value
        System.out.println("multi value");
        final Map<String, Cricketer> mapMultiVal = new HashMap<String, Cricketer>();
        mapMultiVal.put("sachin", new Cricketer("Sachin", 14000));
        mapMultiVal.put("dravid", new Cricketer("Dravid", 12000));
        mapMultiVal.put("ponting", new Cricketer("Ponting", 11500));
        mapMultiVal.put("bradman", new Cricketer("Bradman", 9996));
        final Cricketer p1 = mapMultiVal.get("sachin");
        System.out.println(p1.toString());
        System.out.println();
        for (final Map.Entry<String, Cricketer> entr : mapMultiVal.entrySet()) {

            System.out.println(entr.getValue());
        }

        ////// multi key
        System.out.println();
        System.out.println("multi key to string");
        final Map<String, Integer> mapMultiKeyString = new TreeMap<String, Integer>();
        mapMultiKeyString.put(new Cricket("Sachin", "Tendulkar").toString(), 10000);
        mapMultiKeyString.put(new Cricket("Saurav", "Ganguly").toString(), 9000);
        final Cricket c1 = new Cricket("Rahul", "Dravid");
        mapMultiKeyString.put(c1.toString(), 8000);
        final Cricket c2 = new Cricket("Saurav", "Ganguly");
        final int val1 = mapMultiKeyString.get(new Cricket("Saurav", "Ganguly").toString());
        System.out.println(val1);
        final int val2 = mapMultiKeyString.get(c2.toString());
        System.out.println(val2);
        for (final Map.Entry<String, Integer> entry1 : mapMultiKeyString.entrySet()) {

            System.out.println(entry1.getKey() + entry1.getValue());
        }

        System.out.println();

        System.out.println("multi key iteration");
        final Map<Cricket, Integer> mapMultiKey = new HashMap<Cricket, Integer>();
        mapMultiKey.put(new Cricket("chait", "Tendulkar"), 10000);
        mapMultiKey.put(new Cricket("kiran", "Ganguly"), 9000);

        for (final Map.Entry<Cricket, Integer> entry2 : mapMultiKey.entrySet()) {

            System.out.println(entry2.getKey().toString());
        }
        System.out.println();
        System.out.println("***********multi key tree map stored acc to first name");
        final Map<Cricket, Integer> mapMultiKeyTree = new TreeMap<Cricket, Integer>(new SortByFname());
        mapMultiKeyTree.put(new Cricket("chait", "Tendulkar"), 10000);
        mapMultiKeyTree.put(new Cricket("kiran", "Ganguly"), 9000);
        mapMultiKeyTree.put(new Cricket("ashok", "koppula"), 9000);

        for (final Map.Entry<Cricket, Integer> entry3 : mapMultiKeyTree.entrySet()) {
            // System.out.println("yessss");
            System.out.println(entry3.getKey().toString());
        }

        System.out.println("tree map sort by key in descending order");

        // sort by key
        final TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();
        tmap.put(5, "chaitu");
        tmap.put(1, "chanti");
        tmap.put(3, "apple");
        tmap.put(4, "bannana");
        for (final Map.Entry<Integer, String> entry : tmap.descendingMap().entrySet()) {
            System.out.println(entry.getKey());
        }

        // set desc
        final TreeSet<Integer> tset = new TreeSet<Integer>();
        tset.add(1);
        tset.add(3);
        tset.add(2);
        tset.add(4);
        System.out.println();
        System.out.println("headset method prints less than 3 exclusive");
        System.out.println(tset.headSet(3));
        System.out.println("tail set prints greater than 2 inclusive");
        System.out.println(tset.tailSet(2));
        final TreeSet<Integer> dset = (TreeSet<Integer>) tset.descendingSet();
        // System.out.println(dset);

    }

}

class Cricketer
{
    String playerName;
    int runs;

    Cricketer(final String playerName, final int runs)
    {
        this.playerName = playerName;
        this.runs = runs;
    }

    public String toString()
    {
        return playerName + "* " + runs;

    }
}

class Cricket
{
    String firstName;
    String lastName;

    public Cricket(final String firstName, final String lastName)
    {

        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString()
    {
        return "Cricket [firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}

class SortByFname implements Comparator<Cricket>
{

    @Override
    public int compare(final Cricket o1, final Cricket o2)
    {
        return o1.firstName.compareTo(o2.firstName);
    }

}