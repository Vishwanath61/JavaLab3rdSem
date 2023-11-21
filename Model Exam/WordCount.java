/*
6.Write a Java program ‘WordCount’ that counts the words in one or more files.
Start a new thread for each file. For example, if you call 
“java  WordCount  report.txt  address.txt  Homework.java “
then the program might print 
address.txt: 1052
Homework.java: 445 
report.txt: 2099
 */

package javamodellab;
import java.io.*;

/**
 *
 * @author VISHWA
 */

public class WordCount extends Thread
{
    String name;
    
    WordCount(String fname)
    {
        this.name=fname;
    }
    
    public void run()
    {
        int count=wordcount(name);        
        System.out.println(name+":"+count);
    }
    
    public static void main(String[] args)
    {
        String names[]={"sample.txt","sample1.txt"};
        for(String i:names)
        {
            WordCount wc=new WordCount(i);
            Thread t=new Thread(wc);
            t.start();
        }        
    } 
    
    public  int wordcount(String fname)
    {
        name=fname;
        int count=0;
        try
        {            
            FileReader fr=new FileReader(fname);
            BufferedReader br=new BufferedReader(fr);            
            String words[],line;
            while((line=br.readLine())!=null)
            {
                words=line.split("\\s+");
                count+=words.length;
            }            
        }
        catch(Exception e)
        {
            System.out.println("File error");
        }
        return count;        
    }
}
