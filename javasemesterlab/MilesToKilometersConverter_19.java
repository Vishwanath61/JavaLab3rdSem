/*
19.Create a new Java GUI application to convert miles to kilometers 
when pressing the “Convert!” button. Note that you need to implement the ActionListener interface
and override the actionPerformed() method. Note that 1 mile is equal to 1.609 kilometers
*/

package javasemesterlab;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author VISHWA
 */

public class MilesToKilometersConverter_19 extends JFrame implements ActionListener
{
    JLabel miles,result,res;
    JTextField mile;
    JButton convert;
    
    MilesToKilometersConverter_19()
    {
        setTitle("MilesToKilometersConverter");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        //MILES
        miles=new JLabel("Enter Miles:");
        add(miles);
        mile=new JTextField(6);
        add(mile);
        convert=new JButton("Convert");
        add(convert);        
        result=new JLabel("Result:");
        add(result);
        res=new JLabel();
        add(res);
        
        convert.addActionListener(this);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new MilesToKilometersConverter_19();
    }    

    @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            double mil=Double.parseDouble(mile.getText());
            double km=mil*1.609;
            res.setText(""+km);
        }
        catch(NumberFormatException e1)
        {
            JOptionPane.showMessageDialog(this,"Enter a valid input!!!");
        }
    }
}
