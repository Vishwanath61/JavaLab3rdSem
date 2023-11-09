/*
1.Create an application that models a simple sales terminal. You should be able to sell three
kinds of items. Have one button for each item, and attach a picture of the item to the
button. Each button should have three labels associated with it. These labels will display
the price of the item, the number of that item sold in the current transaction, and a
subtotal for that item. Each time a button is pressed, increase the count of that item in the
current sale by one and update the subtotal. A separate tenth label should show the total
cost of the current sale. An “EndSale” menu item ends the current sale and resets the
totals to zero
*/

package javaex10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author VISHWA
 */

public class SalesTerminalApp extends JFrame 
{
    JButton itemButton1, itemButton2, itemButton3;
    JLabel quantityLabel1, quantityLabel2, quantityLabel3;
    JLabel priceLabel1, priceLabel2, priceLabel3;
    JLabel subtotalLabel1, subtotalLabel2, subtotalLabel3;
    JLabel totalCostLabel;

    int quantity1, quantity2, quantity3;
    double totalCost;

    public SalesTerminalApp() 
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        itemButton1 = new JButton("Item 1");
        itemButton2 = new JButton("Item 2");
        itemButton3 = new JButton("Item 3");

        quantityLabel1 = new JLabel("Quantity: 0");
        quantityLabel2 = new JLabel("Quantity: 0");
        quantityLabel3 = new JLabel("Quantity: 0");
        
        priceLabel1 = new JLabel("Price: $10.00");
        priceLabel2 = new JLabel("Price: $15.00");
        priceLabel3 = new JLabel("Price: $20.00");

        subtotalLabel1 = new JLabel("Subtotal: $0.00");
        subtotalLabel2 = new JLabel("Subtotal: $0.00");
        subtotalLabel3 = new JLabel("Subtotal: $0.00");

        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 0;
        add(itemButton1, c);
        c.gridx = 1;
        add(quantityLabel1, c);
        c.gridx = 2;
        add(priceLabel1, c);
        c.gridx = 3;
        add(subtotalLabel1, c);

        c.gridx = 0;
        c.gridy = 1;
        add(itemButton2, c);
        c.gridx = 1;
        add(quantityLabel2, c);
        c.gridx = 2;
        add(priceLabel2, c);
        c.gridx = 3;
        add(subtotalLabel2, c);

        c.gridx = 0;
        c.gridy = 2;
        add(itemButton3, c);
        c.gridx = 1;
        add(quantityLabel3, c);
        c.gridx = 2;
        add(priceLabel3, c);
        c.gridx = 3;
        add(subtotalLabel3, c);

        itemButton1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                quantity1++;
                updateTotals();
            }
        });

        itemButton2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                quantity2++;
                updateTotals();
            }
        });

        itemButton3.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                quantity3++;
                updateTotals();
            }
        });

        totalCostLabel = new JLabel("Total Cost: $0.00");
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 4;
        add(totalCostLabel, c);

        setTitle("Sales Terminal");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateTotals() 
    {       
        double price1 = 10.00;  
        double price2 = 15.00;  
        double price3 = 20.00;  

        double subtotal1 = quantity1 * price1;
        double subtotal2 = quantity2 * price2;
        double subtotal3 = quantity3 * price3;

        quantityLabel1.setText("Quantity: " + quantity1);
        quantityLabel2.setText("Quantity: " + quantity2);
        quantityLabel3.setText("Quantity: " + quantity3);

        subtotalLabel1.setText("Subtotal: $" + String.format("%.2f", subtotal1));
        subtotalLabel2.setText("Subtotal: $" + String.format("%.2f", subtotal2));
        subtotalLabel3.setText("Subtotal: $" + String.format("%.2f", subtotal3));

        totalCost = subtotal1 + subtotal2 + subtotal3;

        totalCostLabel.setText("Total Cost: $" + String.format("%.2f", totalCost));
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() {
                new SalesTerminalApp();
            }
        });
    }
}
