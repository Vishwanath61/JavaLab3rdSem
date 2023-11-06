/******************************************************************************

Welcome to GDB Online.
  GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
  C#, OCaml, VB, Perl, Swift, Prolog, Javascript, Pascal, COBOL, HTML, CSS, JS
  Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Faculty implements Serializable {
    private int code;
    private String name;
    private String dept;
    private String position;

    public Faculty(int code, String name, String dept, String position) {
        this.code = code;
        this.name = name;
        this.dept = dept;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Code: " + code + ", Name: " + name + ", Department: " + dept + ", Position: " + position;
    }
}

public class FacultyManagement {
    public static void main(String[] args) {
        List<Faculty> facultyList = new ArrayList<>();
        int n = 3;
        facultyList.add(new Faculty(101, "John Doe", "Computer Science", "Professor"));
        facultyList.add(new Faculty(102, "Jane Smith", "Mathematics", "Associate Professor"));
        facultyList.add(new Faculty(103, "Bob Johnson", "Physics", "Assistant Professor"));
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("faculty_data.ser"))) {
            oos.writeObject(facultyList);
            System.out.println("Faculty information stored to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int searchCode = 102;
        searchFacultyByCode(searchCode);
    }

    public static void searchFacultyByCode(int code) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("faculty_data.ser"))) {
            List<Faculty> facultyList = (List<Faculty>) ois.readObject();

            for (Faculty faculty : facultyList) {
                if (faculty != null && faculty.getCode() == code) {
                    System.out.println("Faculty information found:");
                    System.out.println(faculty);
                    return;
                }
            }

            System.out.println("Faculty with code " + code + " not found.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
