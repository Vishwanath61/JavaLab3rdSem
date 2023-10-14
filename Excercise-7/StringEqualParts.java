/*
2.Write a Java program to divide a string in n equal parts.
Sample output
The given string is: abcdefghijklmnopqrstuvwxy
The string divided into 5 parts and they are: abcde fghij klmno pqrst uvwxy
*/

package javaex7;
import java.util.*;
import java.lang.Math;

/**
 *
 * @author VISHWA
 */

public class StringEqualParts 
{
    public static void main(String[] args) 
    {
        Scanner obj=new Scanner(System.in);
        String s;
        
        System.out.print("\nEnter a String to divide it into n equal parts: ");
        s=obj.next();
        String newString=""; 
        int n=s.length();
        boolean ans=isperfectsqare(n);
        
        if(ans)
        {
            double root=Math.sqrt(n);
            int parts=n/(int)root;
            for(int i=0;i<n;i+=parts)
            {
                newString+=s.substring(i, i+parts);
                newString+=" ";                
            }
            System.out.println("\nThe given string is: "+s);
            System.out.println("The string divided into "+parts+" parts and they are: "+newString);
        }
        else
        System.out.println("\nThe given string cannot be divided into n equal parts.");
    }
    
    public static boolean isperfectsqare(int n)
    {
        double sq=Math.sqrt(n);
        return sq*sq==n;
    }
}
