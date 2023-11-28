/*
4(i).Write an application that prompts a user for a full name and street address and 
constructs an ID from the user’s initials and numeric part of the address. 
For example, the user William Henry Harrison who lives at 34 Elm would have an ID of WHH34,
whereas user Addison Mitchell who lives at 1778 Monroe would have an ID of AM1778.
*/

package javasemesterlab;
import java.util.*;

/**
 *
 * @author VISHWA
 */

public class ID_Constructor 
{
    public static void main(String[] args) 
    {
        Scanner obj=new Scanner(System.in);
        String name,address;
        StringBuilder ID=new StringBuilder();
        
        System.out.print("\nEnter your name: ");
        name=obj.nextLine();
        System.out.print("Enter your address: ");
        address=obj.nextLine();
        
        String n[]=name.split(" ");
        for(String s:n)
        {
            char c=s.charAt(0);
            ID=ID.append(Character.toUpperCase(c));
        }
        
        String addnum=address.replaceAll("\\D","");
        ID.append(addnum);
        
        System.out.println("ID: "+ID);
    }    
}
