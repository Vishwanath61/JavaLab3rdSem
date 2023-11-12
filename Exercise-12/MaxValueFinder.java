/*
2.Write a java program to find the maximum value from the given type of elements using a
generic function.
 */
package javaex12;

/**
 *
 * @author VISHWA
 */

public class MaxValueFinder 
{
    public static void main(String[] args)
    {
        findMax f=new findMax();
        Integer[] intArray = {1, 5, 3, 7, 2, 8, 4};
        Double[] doubleArray = {2.5, 8.1, 4.7, 9.3, 5.6};
        String[] stringArray = {"apple", "banana", "orange", "grape"};
        
        f.print(intArray);
        System.out.println("Maximum value in Integer array: " + f.maximum(intArray));
        
        f.print(doubleArray);
        System.out.println("Maximum value in Double array: " + f.maximum(doubleArray));
        
        f.print(stringArray);
        System.out.println("Maximum value in String array: " + f.maximum(stringArray));
    }    
}

class findMax
{
    <T extends Comparable> T maximum(T array[])
    {
        T max=array[0];
        for(int i=1;i<array.length;i++)
        {
            T val=array[i];
            if(max.compareTo(val)<0)
            {
                max=val;
            } 
        }
        return max;
    }
    
    <T> void print(T array[])
    {
        System.out.print("\n{");
        for (int i=0;i<array.length-1;i++) 
        {
            System.out.print(""+array[i]+",");
            
        }
        System.out.print(array[array.length-1]+"}\n");
    }    
}