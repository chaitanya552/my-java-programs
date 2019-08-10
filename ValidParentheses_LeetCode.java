import java.util.Stack;

public class ValidParentheses_LeetCode
{
    public static boolean balancedParenthensies(final String s)
    {
        final Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if ((c == '[') || (c == '(') || (c == '{')) {
                stack.push(c);
            }
            else if (c == ']') {
                if (stack.isEmpty() || (stack.pop() != '[')) {
                    return false;
                }
            }
            else if (c == ')') {
                if (stack.isEmpty() || (stack.pop() != '(')) {
                    return false;
                }
            }
            else if (c == '}') {
                if (stack.isEmpty() || (stack.pop() != '{')) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        System.out.println(balancedParenthensies("{(a,b)}"));
        System.out.println(balancedParenthensies("{(a},b)"));
        System.out.println(balancedParenthensies("{)(a,b}"));
    }
}
