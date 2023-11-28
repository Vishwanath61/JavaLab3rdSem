/*
1(i).Write a Java program to read 5 subject marks of a student and calculate the total and grade. The grade system is as follows.
Letter Grade
Grade Points
Marks Range
O (Outstanding)
10
91 – 100
A+ (Excellent)
9
81 – 90
A (Very Good)
8
71 – 80
B+ (Good)
7
61 – 70
B (Average)
6
50 – 60
RA
0
< 50
*/

package javasemesterlab;
import java.util.*;

/**
 *
 * @author VISHWA
 */

public class GradeCalculator
{
    String name;
    static int mark[]=new int[5];
    GradeCalculator(String name,int mark[])
    {
        this.name=name;
        this.mark=mark;
    }
    public static String[] gradec()
    {
        int sum=0;
        double avg;
        String grade[]=new String[5];
        for(int i:mark)
        {
            sum+=i;
        }
        avg=sum/5;
        
        for(int i=0;i<5;i++)
        {
            int m=mark[i];
            System.out.println(m);
            if(m>90&&m<=100)
            {
                grade[i]="O";                
            }
            else if(m>80&&m<=90)
            {
                grade[i]="A+";
            }
            else if(m>70&&m<=80)
            {
                grade[i]="A";
            }
            else if(m>60&&m<=70)
            {
                grade[i]="B+";
            }
            else if(m>50&&m<=60)
            {
                grade[i]="B";
            }
            else if(m<50)
            {
                grade[i]="RA";
            }
        }
        return grade;
    }
    public static void main(String[] args) 
    {
        Scanner obj=new Scanner(System.in);
        String name;
        int mark[]=new int[5];
        String grade[]=new String[5];
        System.out.print("\nEnter your name: ");
        name=obj.next();
        for(int i=0;i<5;i++)
        {
            System.out.print("Enter mark "+(i+1)+"- ");
            mark[i]=obj.nextInt();            
        }
        GradeCalculator g= new GradeCalculator(name,mark);
        grade=gradec();
        System.out.println("\n\t---Printing Details---");
        System.out.println("\n\tName: "+name);
        for(int i=0;i<5;i++)
        {
            System.out.print("Mark "+(i+1)+": "+mark[i]);
            System.out.println("\tGrade "+(i+1)+": "+grade[i]);
        }
    }    
}
