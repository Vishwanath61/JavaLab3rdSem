/*
13.count no of times each character present
*/
package stringhandling;
import java.util.*;

/**
 *
 * @author VISHWA
 */

public class CharacterCount 
{
    public static void main(String[] args) 
    {
        Scanner obj=new Scanner(System.in);
        System.out.print("\nEnter the String: ");
        String s=obj.next();
        
        String cpy=s;
        
        System.out.println("\nCounting the occurence of each character in \""+s+"\": ");
        do
        {
            int count=0;
            char arr[]=cpy.toCharArray();
            int n=cpy.length();
            for(int i=0;i<n;i++)
            {
                if(arr[0]==arr[i])
                {
                    count++;
                }                
            }
            if(count>=1)
            {
                System.out.println(""+arr[0]+": "+count);
            }
            cpy=cpy.replace(""+arr[0],"");
            
        }while(cpy.length()!=0);        
    }   
}
