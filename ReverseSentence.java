//input :hello world
//output:olleh dlrow
//inp:cat dog pig
//out ideal:tac god gip
//my op: gip god tac

public class ReverseSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sentence = "hello world";
		String[] words = sentence.split(" ");

		String reverseString = "";

		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			String reverseWord = "";

			for (int j = word.length() - 1; j >= 0; j--) {
				reverseWord = reverseWord + word.charAt(j);
			}

			reverseString = reverseString + reverseWord + " ";
		}

		

		System.out.println(reverseString);
	}

}

/*
 * String sentence = "hello world"; String[] words = sentence.split(" "); String
 * answer=""; for ( String word : words) {
 * 
 * System.out.print(new StringBuilder(word).reverse() + " ");
 * 
 * } //return System.out.print(new StringBuilder(word).reverse() + " ");
 */