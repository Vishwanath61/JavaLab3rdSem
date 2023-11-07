/*
2.Write a java application to change happy smiley with yellow color to sad smiley with red
color on MouseClickEvent .
 */

package pkg22cseb61_javaex10;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author 22CSEB61
 */

public class Smiley extends JFrame implements MouseListener
{
    public static void main(String[] args) 
    {
        new Smiley();     
        //Frame f=new Frame();
       
    }
    int click=0;
    Smiley()
    {        
        setSize(1000,1000);        
        setTitle("Smiley");
        setVisible(true);
        setBounds(1,1,500,500);
        addMouseListener(this);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                dispose();
            }
        });
    } 
    
    public void paint(Graphics g)
    {
       g.setColor(Color.YELLOW);
       g.fillOval(100,100,300,300);
       g.setColor(Color.black);
       g.fillOval(150,200,50,50);
       g.setColor(Color.black);
       g.fillOval(300,200,50,50);
       g.setColor(Color.WHITE);
       g.fillArc(220,280,65,65,0,-180);
       
    }

    public void mouseClicked(MouseEvent e)
    {
        Graphics g=getGraphics();
        click++;
        if(click%2==0)
        {
            g.setColor(Color.YELLOW);
            g.fillOval(100,100,300,300);
            g.setColor(Color.black);
            g.fillOval(150,200,50,50);
            g.setColor(Color.black);
            g.fillOval(300,200,50,50);
            g.setColor(Color.WHITE);
            g.fillArc(220,280,65,65,0,-180);
        }
        else
        {
            g.setColor(Color.RED);
            g.fillOval(100,100,300,300);
            g.setColor(Color.black);
            g.fillOval(150,200,50,50);
            g.setColor(Color.black);
            g.fillOval(300,200,50,50);
            g.setColor(Color.WHITE);
            g.fillArc(220,280,65,65,0,180);
        }  
    }
    
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
}