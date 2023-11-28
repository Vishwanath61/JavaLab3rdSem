/*
10.Write a java program that reads a string from inputs containing first name,
last name and computes an e-mail address with first 3 letters of the first name, 
first 4 letters of last name, ‘.’ separator and domain. Display the outputs by invoking objects.
*/

package javasemesterlab;
import java.util.*;

/**
 *
 * @author VISHWA
 */

public class EmailGenerator 
{
    public static void main(String[] args) 
    {
        Scanner obj=new Scanner(System.in);
        String fname,lname;
        String mail;
        
        System.out.print("\nEnter your first name: ");
        fname=obj.next();
        System.out.print("Enter your last name: ");
        lname=obj.next();
        mail=mail(fname,lname);
        
        System.out.println("Email: "+mail);
    }   
    public static String mail(String fname,String lname)
    {
        String part1,part2;
        String res="";
        
        if(fname.length()>=3)
            part1=fname.substring(0,3);
        else
            part1=fname.substring(0,fname.length()-1);
        
        if(lname.length()>=4)
            part2=lname.substring(0,4);
        else
            part2=lname.substring(0,fname.length()-1);
        
        res+=part1+"."+part2+"@gmail.com";
        return res;
    }
}
