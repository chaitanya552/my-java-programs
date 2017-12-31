
public class GroupOfDelimiters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "This is a sentence.  This is a question, right?  Yes!  It is.";
		String delims = "[ .,?!]+";
		String[] tokens = str.split(delims);
		
		for (int i = 0; i < tokens.length; i++)
		    System.out.println(tokens[i]);
	}

}
