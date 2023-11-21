/*
9.Write java programs that include generic method to satisfy the following property.
    a.To counts the number of odd integers in an integer list
    b.To exchange the positions of two different elements in an array.
    c.To find the maximal element in the range [begin, end] of a list.
*/

package javamodellab;

/**
 *
 * @author VISHWA
 */

public class GenericProblem 
{
    public static void main(String[] args) 
    {
        genericapp g=new genericapp();
        Integer intarr[]={7,4,61,69,75};
        
        g.Printarr(intarr);
        
        System.out.println("\n\nODD Count-"+g.OddCount(intarr));
        
        System.out.println("\nThe Maximal element in the list-"+g.Maximal(intarr));
        
        System.out.println("\nThe list after swapping index 1,2");
        g.Exchange(intarr,1,2);
        g.Printarr(intarr);
    }    
}

class genericapp
{
    <T extends Number> int OddCount(T arr[])
    {
        int count=0;
        for(T i:arr)
        {
            if((i.intValue()%2)!=0)
            {
                count++;
            }
        }
        return count;
    }
    
    <T> void Exchange(T arr[],int x,int y)
    {
        int len=arr.length;
        if((x!=y)&&(x<len)&&(y<len))
        {
            T temp=arr[x];
            arr[x]=arr[y];
            arr[y]=temp;
        }
    }
    
    <T extends Comparable> T Maximal(T arr[])
    {
        T max=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(max.compareTo(arr[i])<0)
            {
                max=arr[i];
            }
        }
        return max;
    }
    
    <T> void Printarr(T arr[])
    {
        int len=arr.length;
        System.out.print("{");
        for(int i=0;i<len-1;i++)
        {
            System.out.print(arr[i]+",");
        }
        System.out.println(arr[len-1]+"}");
    }
}