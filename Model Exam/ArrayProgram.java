/*
10.Write a Java program to perform the following task.
Take an integer array of size 20, initialize values randomly between 10 and 90,
simultaneously sum all values and calculate average. 
Now separate values below average and above average in ArrayLists.
Finally print both lists in 2 separate rows.
*/

package javamodellab;
import java.util.*;

/**
 *
 * @author VISHWA
 */

public class ArrayProgram 
{
    public static void main(String[] args) 
    {
        int sum=0;
        double average;
        ArrayList<Integer> abvave=new ArrayList<>();
        ArrayList<Integer> belave=new ArrayList<>();
        int intarr[]=new int[20];
        Random rand=new Random();
        ArrayProgram ap=new ArrayProgram();
        
        for(int i=0;i<intarr.length;i++)
        {
            intarr[i]=rand.nextInt(81)+10;
        }
        System.out.println("The Original Array");
        ap.PrintArray(intarr);
        
        for(int i:intarr)
        {
            sum+=i;
        }
        System.out.println("\nThe Sum of the array "+sum);
        
        average=sum/intarr.length;
        System.out.println("\nThe Average of the array "+average);

        
        for(int i:intarr)
        {
            if(i>average)
            {
                abvave.add(i);
            }
            else if(i<average)
            {
                belave.add(i);
            }
        }
        
        System.out.println("\nThe values below average: ");
        ap.PrintList(belave);
        
        System.out.println("\nThe values above average: ");
        ap.PrintList(abvave);
    }    
    
    void PrintArray(int arr[])
    {
        int len=arr.length;
        System.out.print("{");
        for(int i=0;i<len-1;i++)
        {
            System.out.print(arr[i]+",");
        }
        System.out.println(arr[len-1]+"}");
    }
    
    void PrintList(ArrayList<Integer> arr) 
    {
        for (int i:arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }   
}
