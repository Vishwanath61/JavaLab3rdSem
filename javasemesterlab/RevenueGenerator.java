/*
3(ii).Write a Java program to calculate the revenue from a sale based on the unit price and quantity of a product input by the user.
The discount rate is 10% for the quantity purchased between 100 and 120 units, 
and 15% for the quantity purchased greater than 120 units. If the quantity purchased is less than 100 units,
the discount rate is 0%.
*/

package javasemesterlab;
import java.util.*;

/**
 *
 * @author VISHWA
 */

public class RevenueGenerator
{
    public static void main(String[] args) 
    {
        Scanner obj=new Scanner(System.in);
        double unitp,quant;
        System.out.print("\nEnter unit price: $");
        unitp=obj.nextDouble();
        System.out.print("Enter quantity: ");
        quant=obj.nextDouble();
        double rev=revenue(unitp,quant);
        System.out.println("\nRevenue: $"+rev);
    }    
    public static double revenue(double unit,double quant)
    {
        double dis=0.0;
        if(quant<100)
            dis=0.0;
        else if(quant>=100&&quant<=120)
            dis=0.10;
        else if(quant>120)
            dis=0.15;
        
        double disrate=unit-(unit*dis);
        double rev=disrate*quant;
        return rev;
    }
}
