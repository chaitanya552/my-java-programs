package JavaConcepts;

import java.util.HashMap;
import java.util.Map;

public class testEqualsMethod
{

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        final Student s1 = new Student("h123");
        final Student s2 = new Student("h123");
        System.out.println(s1.equals(s2));

        final Map<Student, ReportCard> map = new HashMap<>();
        map.put(s1, new ReportCard());
        map.put(s2, new ReportCard());
        System.out.println(map.size());

    }

}
