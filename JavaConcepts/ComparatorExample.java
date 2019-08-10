package JavaConcepts;

// Java program to demonstrate working of Comparator
// interface
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// A class to represent a student.
class Student
{
    int rollno;
    String name, address;

    // Constructor
    public Student(final int rollno, final String name, final String address)
    {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    // Used to print student details in main()
    @Override
    public String toString()
    {
        return rollno + " " + name + " " + address;
    }
}

class Sortbyroll implements Comparator<Student>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(final Student a, final Student b)
    {
        return a.rollno - b.rollno;
    }
}

class Sortbyname implements Comparator<Student>
{
    // Used for sorting in ascending order of
    // roll name
    public int compare(final Student a, final Student b)
    {
        return a.name.compareTo(b.name);
    }
}

// Driver class
public class ComparatorExample
{
    public static void main(final String[] args)
    {
        final ArrayList<Student> ar = new ArrayList<Student>();
        final Student s1 = new Student(111, "bb", "africa");
        ar.add(new Student(111, "bbbb", "london"));
        ar.add(new Student(131, "aaaa", "nyc"));
        ar.add(new Student(121, "cccc", "jaipur"));

        System.out.println("Unsorted");
        for (int i = 0; i < ar.size(); i++) {
            System.out.println(ar.get(i));
        }

        Collections.sort(ar, new Sortbyroll());

        System.out.println("\nSorted by rollno");
        for (int i = 0; i < ar.size(); i++) {
            System.out.println(ar.get(i));
        }

        Collections.sort(ar, new Sortbyname());

        System.out.println("\nSorted by name");
        for (int i = 0; i < ar.size(); i++) {
            System.out.println(ar.get(i));
        }
    }
}