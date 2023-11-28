/*
2(ii).Write a Java program that determines the number of days in a month
*/

package javasemesterlab;
import java.util.*;

/**
 *
 * @author VISHWA
 */

public class MonthDays 
{
    public static void main(String[] args)
    {
        Scanner obj=new Scanner(System.in);
        int month,year,days;
        System.out.print("\nEnter the year: ");
        year=obj.nextInt();
        System.out.print("Enter the month (1-12): ");
        month=obj.nextInt();
        days=days(year,month);
        System.out.println("Days of "+month+" of "+year+" is: "+days);
    }
    public static int days(int year,int month)
    {
        int days=0;
        switch(month)
        {
            case 1,3,5,7,8,10,12:
                days=31;
                break;
            case 4,6,9,11:
                days=30;
                break;
            case 2:
                if((year%4==0&&year%100!=0)||(year%400==0))
                    days=29;
                else
                    days=28;
                break;
        }        
        return days;
    }    
}
