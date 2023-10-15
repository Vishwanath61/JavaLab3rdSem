/*
15.Print Upper case characters in Java
*/
package stringhandling;
import java.util.*;

/**
 *
 * @author VISHWA
 */
public class Uppercase 
{
    public static void main(String[] args) 
    {
        Scanner obj=new Scanner(System.in);
        String upstr="";
        System.out.print("\nEnter the String: ");
        String s=obj.next();
        char arr[]=s.toCharArray();                                         //A-65-->Z-90
        for(char c:arr)
        {
            int v=(int)c;
            if(v>=65&&v<=90)
            {
                upstr+=c;
            }
        }
        System.out.println("The Upper case character in the string \""+s+"\"is: "+upstr);
    }    
}
