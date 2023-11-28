/*
3(i).Write a program that inserts parentheses, a space, and a dash into a string of 10 user-entered numbers to format it as a phone number.
For example, 5153458912 becomes (515) 345-8912. If the user does not enter exactly 10 digits, display an error message.
Continue to accept user input until the user enters 999. Save the file as PhoneNumberFormat.java.
*/

package javasemesterlab;
import java.util.*;

/**
 *
 * @author VISHWA
 */

public class PhonenumberFormat 
{
    public static void main(String[] args) 
    {
        Scanner obj=new Scanner(System.in);
        String input;
        while(true)
        {
            System.out.print("\nEnter the ph no: ");
            input=obj.next();
            
            if(input.equals("999"))
            {
                break;
            }
            
            if(checkinput(input))
            {
                String ans=Formatted(input);
                System.out.println("\n"+ans);
            }
            else
            {
                System.out.println("\nEnter a proper number..");
            }
        }
        
    }
    public static boolean checkinput(String input)
    {
        return input.matches(("\\d{10}"));
    }
    public static String Formatted(String input)
    {
        String fir=input.substring(0,3);
        String mid=input.substring(3,6);
        String end=input.substring(6,10);
        
        String format="("+fir+") "+mid+"-"+end;
        return format;
    }
}
