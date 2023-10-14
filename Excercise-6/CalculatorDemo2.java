/*
1.Create a CalculatorDemo program that asked the user to solve an arithmetic problem and provided
the system calculator for assistance. Now modify that program to include the following
improvements: Both numbers in the arithmetic problem should be random integers between 1 and
5,000. The program should ask the user to solve five problems. The program should handle any
noninteger data entry by displaying an appropriate message and continuing with the next problem.
Save the file as CalculatorDemo2.java
 */
package javaex6;
import java.util.*;
/**
 *
 * @author VISHWA
 */
class numlimit extends Exception
{
    numlimit(String msg)
    {
        super(msg);
    }
}

public class CalculatorDemo2 
{
    public static void main(String[] args) 
    {
        Scanner obj=new Scanner(System.in);
        int a,b;
        String s1,s2;
        int choice;
        for(int i=0;i<5;i++)
        {
            try
            {
                System.out.print("\nEnter the value of A: ");
                s1=obj.next();
                System.out.print("Enter the value of B: ");
                s2=obj.next();
                a=Integer.parseInt(s1);
                b=Integer.parseInt(s2);
                if(a<1||a>5000||b<1||b>5000)
                {
                    throw new numlimit("The input exceeds the limit.");
                }
                System.out.println("\n1.Addition(+) \n2.Subraction \n3.Mulitiplication(*) \n4.Divison(/) \n5.Modulus(%)");
                System.out.print("\nEnter Your Choice: ");
                choice=obj.nextInt();
                switch(choice)
                {
                    case 1:
                    {
                        int sum=a+b;
                        System.out.println("The Sum of "+a+" and "+b+" is: "+sum);
                        break;
                    }
                    case 2:
                    {
                        int diff=a-b;
                        System.out.println("The Difference of "+a+" and "+b+" is: "+diff);
                        break;
                    }
                    case 3:
                    {
                        int mul=a*b;
                        System.out.println("The Product of "+a+" and "+b+" is: "+mul);
                        break;                    
                    }
                    case 4:
                    {
                        int div=a/b;
                        System.out.println("The Division of "+a+" and "+b+" is: "+div);
                        break;
                    }
                    case 5:
                    {
                        int mod=a%b;
                        System.out.println("The Modulus of "+a+" and "+b+" is: "+mod);
                        break;
                    }
                    default:
                    {
                        System.out.println("\nPlease enter a valid choice.");
                    }
                }
            }
            catch(NumberFormatException | numlimit e)
            {
                System.out.println(e);
            }            
        }        
    }    
}
