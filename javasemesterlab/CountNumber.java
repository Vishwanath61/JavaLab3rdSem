/*
4(ii).Count the numbers from 1 to n that have 5 as a digit.
*/

package javasemesterlab;
import java.util.*;

/**
 *
 * @author VISHWA
 */

public class CountNumber 
{
    public static void main(String[] args) 
    {
        Scanner obj=new Scanner(System.in);
        int n,i=1,count=0;
        
        System.out.print("\nEnter the value of range: ");
        n=obj.nextInt();
        
        while(i<=n)
        {
            if(i%10==5)
                count++;
            
            i++;
        }
        
        System.out.println("\nCount: "+count);
    }    
}
