/*
8.Develop a course registration form with Name, Address, phone number,Gender(Male or Female),
department(user have to select from CSE, ECE,EEE, Mech, Civil) and 
course (user have to select from (C,C++,JAVA,PYTHON).
When the user submits the form, a dialog box should appear with a message “Username , 
you have successfully enrolled inCourse Name”
*/

package javamodellab;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author VISHWA
 */

public class CourseRegistrationForm extends JFrame implements ActionListener
{
    JLabel name,addr,ph,gen,dep,course;
    JTextField name1,addr1,ph1;
    JComboBox depc,genc,coursec;
    JButton submit;
    
    String deps[]={"CSE","ECE","EEE","CIVIL","IT"};
    String gend[]={"MALE","FEMALE"};
    String course1[]={"C","C++","JAVA","PYTHON"};
    
    CourseRegistrationForm()
    {
        setTitle("course registration form");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        //NAME
        name=new JLabel("Name: ");
        name.setBounds(20,20,80,20);
        add(name);        
        name1=new JTextField();
        name1.setBounds(120,20,200,20);
        add(name1);
        
        //ADDRESS
        addr=new JLabel("Address: ");
        addr.setBounds(20,60,80,20);
        add(addr);        
        addr1=new JTextField();
        addr1.setBounds(120,60,200,20);
        add(addr1);
        
        //PHONE NUMBER
        ph=new JLabel("Phone number: ");
        ph.setBounds(20,100,80,20);
        add(ph);        
        ph1=new JTextField();
        ph1.setBounds(120,100,200,20);
        add(ph1);
        
        //GENDER
        gen=new JLabel("Gender: ");
        gen.setBounds(20,140,80,20);
        add(gen);        
        genc=new JComboBox<>(gend);
        genc.setBounds(120,140,200,20);
        add(genc);
        
        //DEPARTMENT
        dep=new JLabel("Department");
        dep.setBounds(20,180,80,20);
        add(dep);
        depc=new JComboBox<>(deps);
        depc.setBounds(120,180,200,20);
        add(depc);
        
        //COURSE
        course=new JLabel("Course");
        course.setBounds(20,220,80,20);
        add(course);
        coursec=new JComboBox<>(course1);
        coursec.setBounds(120,220,200,20);
        add(coursec);
        
        //SUBMIT
        submit=new JButton("SUBMIT");
        submit.setBounds(60,260,100,30);
        add(submit);
        submit.addActionListener(this);
        
        setVisible(true);        
    }
    

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String Name=name1.getText();
        String cor=(String)coursec.getSelectedItem();
        JOptionPane.showMessageDialog(this,Name+" you have Successfully registered for the course "+cor);
    }
    
    public static void main(String[] args) 
    {
        new CourseRegistrationForm();       
    }    
}
