/*
2.Create a Java program that uses two threads to print odd and even numbers alternately. The
program should start with an initial value (e.g., 1) and continue printing numbers in
sequential order. One thread should print odd numbers, and the other should print even
numbers. Implement synchronization to ensure that the numbers are printed in the correct
order.
*/

package javaex8;
import java.util.*;

/**
 *
 * @author VISHWA
 */
public class AlternateNumberThread 
{
    public static void main(String[] args) 
    {
        Scanner obj=new Scanner(System.in);
        int b,a;
        System.out.print("Enter the first num: ");
        b=obj.nextInt();
        System.out.print("Enter the last num: ");
        a=obj.nextInt();
        numberprint n=new numberprint();
        odd t1=new odd(b,a,n);
        even t2=new even(b,a,n);
        System.out.println("\nPrinting the Alternate numbers:\n");
        t1.start();
        t2.start();
    }
    
}
class numberprint
{
    boolean v=false;
    public synchronized void print1(int a) throws InterruptedException
    {
        while(v)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                System.out.println("e");
            }
        }
        try
        {
            Thread.sleep(1000);
            System.out.println(a);
        }
        catch(InterruptedException e)
        {
            
        }
        v=true;
        notify();
    }
     public synchronized void print2(int a)
    {
        while(!v)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                System.out.println("e");
            }
        }
        try
        {
            Thread.sleep(1000);
            System.out.println(a);
        }
        catch(InterruptedException e)
        {
            
        }
        v=false;
        notify();
    }
}

class odd extends Thread
{
    int b,a;
    numberprint n;
    odd(int b,int a,numberprint n)
    {
        this.n=n;
        this.b=b;
        this.a=a;
    }
    public void run()
    {
        for(int i=b;i<=a;i++)
        {
            if(i%2==1)
            {
                try {
                    //System.out.println("Odd Numbers");
                    n.print1(i);
                } 
                catch (InterruptedException ex)
                {
                    
                }
            }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        }
    }
}

class even extends Thread
{
    int b,a;
    numberprint n;
    even(int b,int a,numberprint n)
    {
        this.n=n;
        this.b=b;
        this.a=a;
    }
    public void run()
    {
        for(int i=b;i<=a;i++)
        {
            if(i%2==0)
            {               
                n.print2(i);
            }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        }
    }
}