/*
2.Write a Java program that reads a file name from the user, displays information about
whether the file exists, whether the file is readable, or writable, the type of file and the
length of the file in bytes
*/
package javaex9;
import java.io.*;
import java.util.*;

/**
 *
 * @author VISHWA
 */


import java.io.File;

public class FileInfoChecker {
    public static void main(String[] args) {
        java.util.Scanner Scanner = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String fileName = Scanner.nextLine();

        File file = new File(fileName);

        if (file.exists()) {
            System.out.println("File exists: Yes");

            if (file.canRead()) {
                System.out.println("File is readable: Yes");
            } else {
                System.out.println("File is readable: No");
            }

            if (file.canWrite()) {
                System.out.println("File is writable: Yes");
            } else {
                System.out.println("File is writable: No");
            }

            if (file.isFile()) {
                System.out.println("Type of file: Regular file");
            } else if (file.isDirectory()) {
                System.out.println("Type of file: Directory");
            } else {
                System.out.println("Type of file: Other");
            }
            System.out.println("Length of file (bytes): " + file.length());
        } else {
            System.out.println("File exists: No");
        }
    }
}