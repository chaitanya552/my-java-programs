/*
 * Write a program to check whether a given number is an ugly number.
To check if a number is ugly, divide the number by greatest divisible powers of 2, 3 and 5, if the number becomes 1 then it is an ugly number otherwise not.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

To check if a number is ugly, divide the number by greatest divisible powers of 2, 3 and 5, if the number becomes 1 then it is an ugly number otherwise not.
Note:

1 is typically treated as an ugly number.
 * 
 * 
 * (1) basic cases: <= 0 and == 1
(2) other cases: since the number can contain the factors of 2, 3, 5, I just remove those factors. So now, I have a number without any factors of 2, 3, 5.
(3) after the removing, the number (new number) can contain a) the factor that is prime and meanwhile it is >= 7, or b) the factor that is not the prime and the factor is not comprised of 2, 3 or 5. In both cases, it is false (not ugly number).
 */
public class UglyNumber_LeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(isUgly(6));
	}
	public static boolean isUgly(int num) {
	    if (num <= 0) {return false;}
	    if (num == 1) {return true;}
	    if (num % 2 == 0) {
	        return isUgly(num/2);
	    }
	    if (num % 3 == 0) {
	        return isUgly(num/3);
	    }
	    if (num % 5 == 0) {
	        return isUgly(num/5);
	    }
	    return false;
	}
}
/*
 * m2
 * This function divides a by greatest divisible 
 * power of b
int maxDivide(int a, int b)
{
while (a%b == 0)
 a = a/b; 
return a;
}    

// Function to check if a number is ugly or not 
int isUgly(int no)
{
no = maxDivide(no, 2);
no = maxDivide(no, 3);
no = maxDivide(no, 5);
 
return (no == 1)? 1 : 0;
} 

*/