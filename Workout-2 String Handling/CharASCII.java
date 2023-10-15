/*
14.Print ASCII code of each character of string
*/
package stringhandling;
import java.util.*;

/**
 *
 * @author VISHWA
 */

public class CharASCII 
{
    public static void main(String[] args) 
    {
        Scanner obj=new Scanner(System.in);
        System.out.print("\nEnter the String: ");
        String s=obj.next();
        System.out.println("\nASCII code of each character in the string \""+s+"\" is: ");
        char arr[]=s.toCharArray();
        for(char c:arr)
        {
            int ascii=(int)c;
            System.out.println(c+"- "+ascii);
        }
    }    
}
