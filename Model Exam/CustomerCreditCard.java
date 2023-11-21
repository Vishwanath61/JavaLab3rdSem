/*
3.Create an interface “CreditCardInterface” with methods to viewCreditAmount, viewPin, changePin and payBalance.
Create a class Customer (name, card number, pin, creditAmount – initialized to 0). 
Implement methods of the interface “CreditCardInterface” in Customer class.
Create an array of customer objects and perform the following actions. 
    •Pay Balance
    •Change Pin
*/

package javamodellab;

/**
 *
 * @author VISHWA
 */

interface CreditCardInterface
{
    void viewCreditAmount();
    void viewPin();
    void changePin(int newpin);
    void payBalance(double amount);
}

class Customer implements CreditCardInterface
{
    String name,cardnumber;
    int pin;
    double creditAmount=0;
    Customer(String name,String cardnumber,int pin,double creditAmount)
    {
        this.name=name;
        this.cardnumber=cardnumber;
        this.pin=pin;
        this.creditAmount=creditAmount;        
    }

    @Override
    public void viewCreditAmount() 
    {
        System.out.println("\nCredit Amount: "+creditAmount);
    }

    @Override
    public void viewPin() 
    {
        System.out.println("PIN: "+pin);
    }

    @Override
    public void changePin(int newpin) 
    {
        pin=newpin;
        System.out.println("PIN updated");
    }

    @Override
    public void payBalance(double amount) 
    {
        if((amount>1)&&(creditAmount>=amount))
        {
            creditAmount-=amount;
        }
    }
}

public class CustomerCreditCard
{
    public static void main(String[] args)
    {
        Customer c[]=new Customer[5];
        String cname[]={"Vishwa","Vishnu","RDJ","Sparrow","Loki"};
        String ccardnumber[]={"1231","2321","4356","8756","6594"};
        int cpin[]={123,231,456,367,908};
        double ccreditAmount[]={20000,4000,5600,567099,25};
        
        for(int i=0;i<5;i++)
        {            
            c[i]=new Customer(cname[i],ccardnumber[i],cpin[i],ccreditAmount[i]);
            c[i].viewCreditAmount();
            c[i].viewPin();
            c[i].changePin(4321);
            c[i].viewPin();
            c[i].payBalance(50.0);
            c[i].viewCreditAmount();
            System.out.println("------");
            
            
        }
                
    }    
}
