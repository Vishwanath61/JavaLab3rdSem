/*
3.Write a method addStars that accepts an array list of strings as a parameter and places a *
before each element. –
Example: if an array list named list initially stores: [the, quick, brown, fox] –
Then the call of addStars(list); makes it store: [*, the, *, quick, *, brown, *, fox]
Write a method removeStars that accepts an array list of strings, assuming that every
other element is a *, and removes the stars (undoing what was done by addStars above).
 */

package javaex13;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VISHWA
 */

public class StarManipulation 
{  
    public static void addStars(List<String> list) 
    {
        for (int i = 0; i < list.size(); i += 2) 
        {
            list.add(i, "*");
        }
    }

    public static void removeStars(List<String> list) 
    {
        for (int i = 0; i < list.size(); i++) 
        {
            if ("*".equals(list.get(i))) 
            {
                list.remove(i);
                i--; 
            }
        }
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("the");
        words.add("quick");
        words.add("brown");
        words.add("fox");

        System.out.println("Original List: " + words);

        addStars(words);
        System.out.println("List after adding stars: " + words);

        removeStars(words);
        System.out.println("List after removing stars: " + words);
    }    
}
