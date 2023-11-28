/*
6.Write a java class called ‘student’ with name, and rollno. Write a class ‘Result’ to get Marks of 3
subjects and another class “Sports’ to get the points obtained in sports. Calculate the total Marks
and displays the result (pass or fail) with points obtained in sports for three students using
inheritance and constructor.
*/

package javasemesterlab;

/**
 *
 * @author VISHWA
 */

class Student
{
    String name;
    int rollno;
    Student(String name,int roll)
    {
        this.name=name;
        rollno=roll;
    }
}

class Result extends Student
{
    int mark1,mark2,mark3;
    
    Result(String name,int roll,int m1,int m2,int m3)
    {
        super(name,roll);
        mark1=m1;
        mark2=m2;
        mark3=m3;
    }
    
    int TotalCalculate()
    {
        return mark1+mark2+mark3;
    }
    
    void ResultStatus()
    {
        System.out.println("\nName:"+name);
        System.out.println("Roll no:"+rollno);
        System.out.println("Total:"+TotalCalculate());
        if(TotalCalculate()>100)
        {
            System.out.println("\nResult: PASS");
        }
        else
        {
            System.out.println("\nResult: FAIL");
        }
    }
}


class Sports extends Result
{
    int sppoint;
    
    Sports(String name,int roll,int m1,int m2,int m3,int sportpoint)
    {
        super(name,roll,m1,m2,m3); 
        sppoint=sportpoint;
    }
    
    void SportsStatus()
    {
        ResultStatus();
        System.out.println("\nSports Point: "+sppoint);
    }
}

public class StudentSport_6 
{
    public static void main(String[] args) 
    {
        Sports s=new Sports("Vishwa",61,56,66,77,10);
        s.SportsStatus();
    }    
}