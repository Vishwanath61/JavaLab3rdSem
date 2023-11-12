/*
4.Create a fruit class with name,price,quantity as attributes. Store 20 fruits information in
arraylist. Use Comparator interface to sort the fruits details according to price.
*/

package javaex13;
import java.util.*;

/**
 *
 * @author VISHWA
 */

class Fruit 
{
    private String name;
    private double price;
    private int quantity;

    public Fruit(String name, double price, int quantity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() 
    {
        return name;
    }

    public double getPrice() 
    {
        return price;
    }

    public int getQuantity() 
    {
        return quantity;
    }

    @Override
    public String toString() 
    {
        return "Fruit{name='" + name + "', price=" + price + ", quantity=" + quantity + '}';
    }
}

class FruitComparator implements Comparator<Fruit> 
{
    @Override
    public int compare(Fruit fruit1, Fruit fruit2) 
    {
        return Double.compare(fruit1.getPrice(), fruit2.getPrice());
    }
}

public class FruitSorting 
{
    public static void main(String[] args) 
    {
        List<Fruit> fruits = new ArrayList<>();

        // Adding 20 fruits to the list
        fruits.add(new Fruit("Apple", 2.5, 10));
        fruits.add(new Fruit("Banana", 1.8, 15));
        fruits.add(new Fruit("Orange", 3.2, 8));
        // Add more fruits as needed

        System.out.println("Original list of fruits:");
        displayFruits(fruits);

        // Sorting fruits based on price using Comparator
        Collections.sort(fruits, new FruitComparator());

        System.out.println("\nSorted list of fruits based on price:");
        displayFruits(fruits);
    }

    private static void displayFruits(List<Fruit> fruits) 
    {
        for (Fruit fruit : fruits) 
        {
            System.out.println(fruit);
        }
    }
}
