/*
13.A program accepts two integers as command line arguments. It displays all prime numbers between these two. 
Validate the input for the following criteria: Both should be positive integers. 
The second should be larger than the first. Create user defined exceptions for both.
*/
package javasemesterlab;

/**
 *
 * @author VISHWA
 */

class NegNum extends Exception
{
    NegNum(String msg)
    {
        super(msg);
    }
}

class numcmp extends Exception
{
    numcmp(String msg)
    {
        super(msg);
    }
}

public class PrimeException 
{
    public static void main(String[] args) 
    {
        int a=1;//Integer.parseInt(args[0]);
        int b=25;//Integer.parseInt(args[1]);
        int i,j;
        //System.out.println(a);
        try
        {
            if(a<0||b<0)
                throw new NegNum("");
            
            if(a>b)
                throw new numcmp("First number is greater");
            
            for(i=a;i<=b;i++)
            {
                for(j=2;j<i;j++)
                {
                    if(i%j==0)
                        break;
                }
                if(j==i)
                    System.out.println(j);
            }
            
        }
        catch(NegNum e)
        {
            System.out.println(e);
        }
        catch(numcmp e)
        {
            System.out.println(e);
        }
    }    
}
