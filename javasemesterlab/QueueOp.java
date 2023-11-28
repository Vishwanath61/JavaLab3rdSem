/*
5.Define an interface “QueueOperations” which declares methods for a static queue. 
Define a class “MyQueue” which contains an array and front and rear as data members and implements the above interface.
Initialize the queue using a constructor. Write the code to perform operations on a queue object.
*/

package javasemesterlab;

/**
 *
 * @author VISHWA
 */

interface QueueOperations
{
    void enqueue(int value);
    int dequeue();
    void display();
}

class MyQueue implements QueueOperations
{
    int arr[];
    int front,rear;

    MyQueue()
    {
        arr=new int[10];
        front=-1;
        rear=-1;
    }
    
    @Override
    public void enqueue(int value) 
    {
        if(front==-1)
            front++;
        
        arr[++rear]=value;        
    }

    @Override
    public int dequeue()
    {
        if(front==-1)
            return -1;
        else
            return arr[front++];        
    }

    @Override
    public void display() 
    {
        for(int i=front;i<=rear;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
}

public class QueueOp
{
    public static void main(String[] args) 
    {
        MyQueue q=new MyQueue();
        
        q.enqueue(12);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(1);
        
        q.display();
        
        int rem=q.dequeue();
        
        q.display();
    }    
}
