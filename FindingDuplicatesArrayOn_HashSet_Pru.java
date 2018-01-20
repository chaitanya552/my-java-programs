/*
 * We use this property of HashSet to find duplicates in an array. 
 * What we do is we try to add each element of an array into HashSet using add() method. 
 * This method adds only unique elements into HashSet. 
 * If you try to add duplicate element, it will return false.
 * to find duplicates in array in O(n) -> less time complexity
 * Tree set actually sorts the elements
 * Hash set is unordered
 * Hash set add method returns true if that element is not present in list
 * hash set wont allow duplicates
 */
import java.util.HashSet;
import java.util.TreeSet;

public class FindingDuplicatesArrayOn_HashSet_Pru {
	public static void main(String args[]) {

		String[] strArray = { "abc", "def", "mno", "xyz", "pqr", "xyz", "def" };
		int[] intArray={6,1,2,2,3,4,4,5};

		HashSet<String> set = new HashSet<String>();
		HashSet<Integer> intset = new HashSet<Integer>();
		TreeSet<String> myTreeSet = new TreeSet<String>();
		for (String arrayElement : strArray) {
			if (!set.add(arrayElement)) {
				System.out.println("Duplicate Sring Element is : " + arrayElement);
			}
			//set.add(arrayElement);
		}
		for (int arrayElement : intArray) {
			if (!intset.add(arrayElement)) {
				System.out.println("Duplicate integer Element is : " + arrayElement);
			}
			//set.add(arrayElement);
		}
		System.out.println();
		System.out.println("Final contents in array");
		System.out.println();
		System.out.println(set);
		System.out.println(intset);
		myTreeSet.addAll(set);
		System.out.println(myTreeSet);
	}


}
