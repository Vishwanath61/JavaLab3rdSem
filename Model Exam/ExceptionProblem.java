/*
4.Write a java program for exception handling:
    a.To create a user defined exception whenever user input the word “hello”.
    b.To add two integers and raise exception when any other character except number (0 – 9) is given as input.
*/

package javamodellab;
import java.util.*;

/**
 *
 * @author VISHWA
 */

public class ExceptionProblem
{
    public static void main(String[] args)
    {
        String text="";
        int sum;
        String a,b;
        Scanner obj=new Scanner(System.in);
        
        try
        {
            System.out.print("\nEnter number1: ");
            a=obj.next();
            System.out.print("Enter number2: ");
            b=obj.next();
            
            if((a.length()==1)&&(b.length()==1))
            {
                int x=Integer.parseInt(a);
                int y=Integer.parseInt(b);
                sum=x+y;
                System.out.println("The Sum is: "+sum);
            }
            else
            {
                throw new Num09("Number (0 – 9) is given as input.");
            }
        }
        catch(Num09 e)
        {
            System.out.println(e);            
        }
        
        do
        {            
            System.out.print("\nEnter the text: ");
            text=obj.next();
            try
            {
                if(text.equals("hello"))
                {
                    throw new HelloException("Hello Exception");
                }
                System.out.println("The Entered text: "+text);
            }
            catch(HelloException e)
            {
                System.out.println(e);
            }
        }while(!text.equals("-1"));
        
    }    
}

class HelloException extends Exception
{
    HelloException(String msg)
    {
        super(msg);
    }
}

class Num09 extends Exception
{
    Num09(String msg)
    {
        super(msg);
    }
}