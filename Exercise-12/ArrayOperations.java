/*
1.Write a program to perform the following operations on an array using generic classes
 Add an element in the beginning/middle/end
 Delete an element from a given position
 */
package javaex12;
import java.util.Arrays;

/**
 *
 * @author VISHWA
 */

class GenericArrayOperations<T> 
{
    private T[] array;
    private int size;

    public GenericArrayOperations(int capacity) 
    {
        array = (T[]) new Object[capacity];
        size = 0;
    }

    public void addElementAtBeginning(T element) 
    {
        ensureCapacity();
        System.arraycopy(array, 0, array, 1, size);
        array[0] = element;
        size++;
    }

    public void addElementAtMiddle(int position, T element)
    {
        if (position < 0 || position > size) 
        {
            throw new IllegalArgumentException("Invalid position");
        }

        ensureCapacity();
        System.arraycopy(array, position, array, position + 1, size - position);
        array[position] = element;
        size++;
    }

    public void addElementAtEnd(T element) 
    {
        ensureCapacity();
        array[size++] = element;
    }

    public void deleteElement(int position) 
    {
        if (position < 0 || position >= size) 
        {
            throw new IllegalArgumentException("Invalid position");
        }

        System.arraycopy(array, position + 1, array, position, size - position - 1);
        size--;
    }

    private void ensureCapacity() 
    {
        if (size == array.length) 
        {
            array = Arrays.copyOf(array, size * 2);
        }
    }

    public void displayArray() 
    {
        System.out.println(Arrays.toString(array));
    }
}

public class ArrayOperations {
    public static void main(String[] args) {
        GenericArrayOperations<Integer> arrayOps = new GenericArrayOperations<>(5);

        // Adding elements
        arrayOps.addElementAtEnd(1);
        arrayOps.addElementAtEnd(2);
        arrayOps.addElementAtEnd(3);
        arrayOps.displayArray();

        arrayOps.addElementAtBeginning(0);
        arrayOps.displayArray();

        arrayOps.addElementAtMiddle(2, 10);
        arrayOps.displayArray();

        // Deleting element
        arrayOps.deleteElement(2);
        arrayOps.displayArray();
    }
}