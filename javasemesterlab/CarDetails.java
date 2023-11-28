/*
7.Define an abstract class “car” with members reg_no, model, reg_date. 
Define two subclasses of this class – “transportVehicles ” (validity_no, start_date, period) and “privateVehicle ” (owner_name, owner_address).
Define appropriate constructors. Create n objects which could be of either transportVehicles or privateVehicle class by asking the user’s choice. 
Display details of all “privateVehicle” objects and all “transportVehicles” objects
*/

package javasemesterlab;
import java.util.*;

/**
 *
 * @author VISHWA
 */

abstract class car
{
    String reg_no,model,reg_date;
    
    car(String reg_no,String model,String reg_date)
    {
        this.reg_no=reg_no;
        this.model=model;
        this.reg_date=reg_date;
    }
    
    abstract void display();
}

class transportVehicles extends car
{
    String validity_no, start_date, period;

    public transportVehicles(String reg_no, String model, String reg_date,String validity_no,String start_date,String period) 
    {
        super(reg_no, model, reg_date);
        this.validity_no=validity_no;
        this.start_date=start_date;
        this.period=period;
    }

    @Override
    void display() 
    {
        System.out.println("Transport Vehicle Details:");
        System.out.println("Registration Number: " + reg_no);
        System.out.println("Model: " + model);
        System.out.println("Registration Date: " + reg_date);
        System.out.println("Validity Number: " + validity_no);
        System.out.println("Start Date: " + start_date);
        System.out.println("Validity Period: " + period + " years");
    }    
}

class privateVehicle extends car
{
    String owner_name, owner_address;

    public privateVehicle(String reg_no, String model, String reg_date,String owner_name,String owner_address)
    {
        super(reg_no, model, reg_date);
        this.owner_name=owner_name;
        this.owner_address=owner_address;
    }

    @Override
    void display() 
    {
        System.out.println("Private Vehicle Details:");
        System.out.println("Registration Number: " + reg_no);
        System.out.println("Model: " + model);
        System.out.println("Registration Date: " + reg_date);
        System.out.println("Owner Name: " + owner_name);
        System.out.println("Owner Address: " + owner_address);        
    }    
}


public class CarDetails
{
    public static void main(String[] args) 
    {
        Scanner obj=new Scanner(System.in);
        
        System.out.print("\nEnter no. of vehicles: ");
        int n=obj.nextInt();
        
        car c[]=new car[n];
        
        for(int i=0;i<n;i++)
        {
            System.out.println("Choose vehicle type for vehicle " + (i + 1) + ":");
            System.out.println("1. Transport Vehicle");
            System.out.println("2. Private Vehicle");
            System.out.print("Enter your choice: ");
            int choice = obj.nextInt();
            obj.nextLine(); 

            if (choice == 1) 
            {
                System.out.println("Enter details for Transport Vehicle:");
                System.out.print("Reg. No: ");
                String regNo = obj.nextLine();
                System.out.print("Model: ");
                String model = obj.nextLine();
                System.out.print("Reg. Date: ");
                String regDate = obj.nextLine();
                System.out.print("Validity No: ");
                String validityNo = obj.nextLine();
                System.out.print("Start Date: ");
                String startDate = obj.nextLine();
                System.out.print("Period: ");
                String period = obj.next();
                obj.nextLine(); 

                c[i] = new transportVehicles(regNo, model, regDate, validityNo, startDate, period);
                //transportVehicle.displayDetails();
            } 
            else if (choice == 2) 
            {
                System.out.println("Enter details for Private Vehicle:");
                System.out.print("Reg. No: ");
                String regNo = obj.nextLine();
                System.out.print("Model: ");
                String model = obj.nextLine();
                System.out.print("Reg. Date: ");
                String regDate = obj.nextLine();
                System.out.print("Owner Name: ");
                String ownerName = obj.nextLine();
                System.out.print("Owner Address: ");
                String ownerAddress = obj.nextLine();
                c[i]= new privateVehicle(regNo, model, regDate, ownerName, ownerAddress);
                //privateVehicle.displayDetails();
            }
            
            System.out.println("\nDetails of Transport Vehicles:");
            for (car ca : c) {
            if (ca instanceof transportVehicles) {
                ca.display();
                System.out.println();
            }
        }

        System.out.println("\nDetails of Private Vehicles:");
        for (car ca : c) {
            if (ca instanceof privateVehicle) {
                ca.display();
                System.out.println();
            }
        }
        }
    }    
}
