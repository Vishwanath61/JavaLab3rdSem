/*
1(ii).Write a program that allows a user to enter three words, 
and display the appropriate three-letter acronym in all uppercase letters.
If the user enters more than three words, ignore the extra words.
*/

package javasemesterlab;
import java.util.*;

/**
 *
 * @author VISHWA
 */

public class Acronym
{
    public static void main(String[] args) 
    {
        Scanner obj=new Scanner(System.in);
        String words,wordarr[];
        String acro="";
        
        System.out.print("\nEnter the words: ");
        words=obj.nextLine();
        wordarr=words.split(" ");
        if(wordarr.length>=3)
        {
            for(int i=0;i<3;i++)
            {
                String temp=wordarr[i];
                char c=temp.charAt(0);
                acro+=Character.toUpperCase(c);
                if(i<2)
                {
                    acro+=".";
                }
            }
            System.out.println("\nThe Acronym of "+words+" is: "+acro);
        }
        else
        {
            System.out.println("\nCheck the no. of words");
        }
    }    
}
