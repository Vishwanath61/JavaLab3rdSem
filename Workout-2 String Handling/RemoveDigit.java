/*
12.Remove digit
*/
package stringhandling;
import java.util.*;

/**
 *
 * @author VISHWA
 */

public class RemoveDigit 
{
    public static void main(String[] args) 
    {
        Scanner obj=new Scanner(System.in);
        String newstring="",digit="";
        System.out.print("\nEnter the String: ");
        String s=obj.next();
        char arr[]=s.toCharArray();
        for(char c:arr)
        {
            int ascii=(int)c;
            if(ascii>=48&&ascii<=57)
            {
                digit+=c;
            }
            else
            {
                newstring+=c;
            }
        }
        System.out.println("\nThe String after removing digits: "+newstring);
    }      
}
