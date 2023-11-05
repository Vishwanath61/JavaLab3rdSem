/*
3.Write a java program using Character Stream and byte Stream for binary files
 */
package javaex9;
import java.io.*;
/**
 *
 * @author VISHWA
 */


public class CharacterByteStreamExample {
    public static void main(String[] args) {
        String text = "Hello, this is a binary file example!";
        String filename = "binaryfile.dat";

        try (FileOutputStream fos = new FileOutputStream(filename);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            byte[] bytes = text.getBytes();
            bos.write(bytes);
            System.out.println("Binary file created using Byte Stream.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(filename);
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                String content = new String(buffer, 0, bytesRead);
                System.out.println("Read from binary file using Byte Stream: " + content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(filename);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(text);
            System.out.println("Binary file created using Character Stream.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader(filename);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Read from binary file using Character Stream: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
