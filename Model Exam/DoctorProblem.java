/*
5.Create a class Doctor with attributes id, name, age and department. 
Initialize values through parameterized constructor. 
If age of Doctor is not in between 25 and 65 then generate user-defined exception “AgeNotWithinRangeException”. 
If name contains numbers or special symbols raise exception “NameNotValidException”.
Define the two exception classes.
*/

package javamodellab;

/**
 *
 * @author VISHWA
 */

public class DoctorProblem
{
    public static void main(String[] args)
    {
        Doctor d=new Doctor(12,"Vishwa",19,"CSE");
        
        //NameNotValidException
        try
        {
            String name=d.name;
            if(!name.matches("^[a-zA-Z]+$"))
            {
                throw new NameNotValidException("Name Not Valid Exception");           
            }
        }
        catch(NameNotValidException e)
        {
            System.out.println(e);
        }
        
        //AgeNotWithinRangeException
        try
        {
            int age=d.age;
            if(age<25&&age>65)
            {
                throw new AgeNotWithinRangeException("Age Not Within Range Exception");

            }
        }
        catch(AgeNotWithinRangeException e)
        {
            System.out.println(e);            
        }        
    }
}

class Doctor 
{
    int id,age;
    String name,dep;
    
    Doctor(int id,String name,int age,String dep)
    {
        this.id=id;
        this.name=name;
        this.age=age;
        this.dep=dep;        
    }           
}

class NameNotValidException extends Exception
{
    NameNotValidException(String msg)
    {
        super(msg);
    }
}

class AgeNotWithinRangeException extends Exception
{
    AgeNotWithinRangeException(String msg)
    {
        super(msg);
    }
}