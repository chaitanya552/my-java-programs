import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Java rule : One public class in one file.
/* 
 * implement an interface (void add,recent items method)
 *  
 * 1. add elemnts to a list and duplicate shouldnt be added
 * 2. when duplicate comes add that n that same previous elemnet should be considered while retrieved
 * and retrieve last 4 elements
 */
/*
 * 
 * example interface
 interface printable{  
 void print();  
 }  
 class A6 implements printable{  
 public void print(){System.out.println("Hello");}  

 public static void main(String args[]){  
 A6 obj = new A6();  
 obj.print();  
 }  
 }  
 */
interface RecentItems {
	void add(String d);

	List<String> getMostRecent();
}

class AddElements2ConditionsOption1_Ap implements RecentItems {
	Set<String> set = new LinkedHashSet<String>();

	// set is not a better way because its diffict to retrirve last 4 
	// 
	// initially added to set and then converted tolist to use sub list
	public void add(String d) {

		set.add(d);
	}

	public List<String> getMostRecent() {
		List orderedList = new LinkedList(set);

		// a b c d e f g h we must print h g f e so reversing and printing first
		// 4
		Collections.reverse(orderedList);
		return orderedList.subList(0, 4);
		// inclusive start,exclusive end

	}
}

class AddElements2ConditionsOption2_Ap implements RecentItems {
	List<String> list = new LinkedList<String>();

	// set is not a better way because its diffict to retrirve last 4 whereas
	// list as remove Last method

	public void add(String d) {
		if (!list.contains(d)) {
			list.add(d);
		} else {
			list.remove(d);
			list.add(d);
		}
	}

	public List<String> getMostRecent() {
		// LinkedList is already ordered in this case

		// a b c d a f b h we must print h b f a so reversing and printing first
		// 4
		Collections.reverse(list);
		return list.subList(0, 4);
		// inclusive start,exclusive end

	}
}

public class AddElementsRetrieveLast4_Ap {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddElements2ConditionsOption1_Ap r = new AddElements2ConditionsOption1_Ap();
		r.add("a");
		r.add("b");
		r.add("c");
		r.add("b");
		r.add("e");
		r.add("b");
		r.add("g");
		System.out.println("option1:" + r.getMostRecent());
		// option 2: duplicat must override
		AddElements2ConditionsOption2_Ap s = new AddElements2ConditionsOption2_Ap();
		s.add("a");
		s.add("b");
		s.add("c");
		s.add("b");
		s.add("e");
		s.add("b");
		s.add("g");
		System.out.println("option2: " + s.getMostRecent());
	}

}
