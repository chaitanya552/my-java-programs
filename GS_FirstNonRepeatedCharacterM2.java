
//Method 2 using single loop
 // using indexof and last index of 

import java.util.Scanner;
public class GS_FirstNonRepeatedCharacterM2 {
public static void main(String args[]){
char [] a ={'h','h','l','l','o'};
//Scanner sc=new Scanner(System.in);
String s=new String(a);//sc.next();
char c;
int i;
int length=s.length();
for(i=0;i<length;i++)
{
    c=s.charAt(i);
    if(s.indexOf(c)==s.lastIndexOf(c))
    {
        System.out.println("first non repeating char in a string   "+c);
        break;
    }
    else if(i==length-1)
    {
        System.out.println("no single char");
    }
}
}
}
