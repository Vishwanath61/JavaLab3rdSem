/*
11.Remove duplicate character
*/
package stringhandling;
import java.util.*;

/**
 *
 * @author VISHWA
 */

public class RemoveDuplicate 
{
    public static void main(String[] args) 
    {
        Scanner obj=new Scanner(System.in);
        String news="";
        System.out.print("\nEnter the String: ");
        String s=obj.next();
        char v='$';
        char arr[]=s.toCharArray();
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(arr[i]==arr[j])
                {
                    char temp=arr[j];
                    arr[j]=v;
                }
            }
        }
        for(char c:arr)
        {
            if(c!=v)
            {
                news+=c;
            }
        }
        System.out.println("\nThe String after removing duplicate characters in \""+s+"\" is: "+news);
    }      
}
