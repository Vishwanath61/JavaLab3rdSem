/*
10(ii).Create a java abstract class to implement stack concept. Check for the overflow and empty conditions.
*/

package javasemesterlab;
import java.util.*;

/**
 *
 * @author VISHWA
 */

abstract class stackab
{    
    abstract void push(int value);
    abstract int pop();
    abstract void isempty();
    abstract void isfull();
    abstract void display();
}

class stack extends stackab
{    
    int top;
    int arr[];
    int max=10;
    
    stack()
    {
        top=-1;
        arr=new int[max];
    }

    @Override
    void push(int value) 
    {
        arr[++top]=value;
    }

    @Override
    int pop() 
    {
        return arr[--top];
    }

    @Override
    void isempty() 
    {
        if(top==-1)
            System.out.println("Stack is empty");
        else
            System.out.println("Stack is not empty");
    }

    @Override
    void isfull() 
    {
        if(top==max-1)
            System.out.println("Stack is full");
        else
            System.out.println("Stack is not full");
    }

    @Override
    void display() 
    {
        int val=top;
        while(val!=-1)
        {
            System.out.print(arr[val]+" ");
            val--;
        }
        System.out.println();
    }
    
}

public class StackOp 
{
    public static void main(String[] args) 
    {
        stack s=new stack();
        
        s.push(3);
        s.push(7);
        s.push(9);
        s.push(4);
        s.display();
        
        int c=s.pop();
        s.display();
        
        s.isempty();
        s.isfull();
    }    
}
