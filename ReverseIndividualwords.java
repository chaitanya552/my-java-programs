public class ReverseIndividualwords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sentence = "hello world";
		String[] words = sentence.split(" ");
		String answer = "";
		for (String word : words) {
			StringBuilder bldr = new StringBuilder(word);
			// bldr.append(word);
			String a = bldr.reverse().toString();
			answer = answer + a + " ";
		} // return System.out.print(new StringBuilder(word).reverse() + " ");
		System.out.println(answer);
	}

}
