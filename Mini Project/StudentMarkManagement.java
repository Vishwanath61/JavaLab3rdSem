/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaminiproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMarkManagement extends JFrame {

    public StudentMarkManagement() {
        super("Student Mark Management");

        JButton studentButton = new JButton("Student");
        JButton teacherButton = new JButton("Teacher");

        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showStudentMarksDialog();
            }
        });

        teacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTeacherDialog();
            }
        });

        setLayout(new GridLayout(2, 1));
        add(studentButton);
        add(teacherButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null); 
    }

    private void showStudentMarksDialog() {
        String rollNo = JOptionPane.showInputDialog(this, "Enter Roll Number:");

        if (rollNo != null && !rollNo.isEmpty()) {
            String url = "jdbc:mysql://localhost:3306/student_db";
            String username = "your_username";
            String password = "your_password";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String sql = "SELECT * FROM student_marks WHERE rollno = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, Integer.parseInt(rollNo));

                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            int subject1 = resultSet.getInt("subject1");
                            int subject2 = resultSet.getInt("subject2");
                            int subject3 = resultSet.getInt("subject3");
                            int subject4 = resultSet.getInt("subject4");
                            int subject5 = resultSet.getInt("subject5");

                            String message = "Roll No: " + rollNo + "\n"
                                    + "Subject 1: " + subject1 + "\n"
                                    + "Subject 2: " + subject2 + "\n"
                                    + "Subject 3: " + subject3 + "\n"
                                    + "Subject 4: " + subject4 + "\n"
                                    + "Subject 5: " + subject5 + "\n";

                            JOptionPane.showMessageDialog(this, message);
                        } else {
                            JOptionPane.showMessageDialog(this, "Student not found.");
                        }
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error connecting to the database.");
            }
        }
    }

    private void showTeacherDialog() {
        TeacherInputForm teacherInputForm = new TeacherInputForm();
        teacherInputForm.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentMarkManagement().setVisible(true);
            }
        });
    }

    private static class TeacherInputForm extends JFrame {
        private JTextField rollNoField, subject1Field, subject2Field, subject3Field, subject4Field, subject5Field;

        public TeacherInputForm() {
            super("Teacher Input Form");

            // UI components
            JPanel panel = new JPanel(new GridLayout(7, 2));

            JLabel rollNoLabel = new JLabel("Roll Number:");
            rollNoField = new JTextField();
            JLabel subject1Label = new JLabel("Subject 1 Marks:");
            subject1Field = new JTextField();
            JLabel subject2Label = new JLabel("Subject 2 Marks:");
            subject2Field = new JTextField();
            JLabel subject3Label = new JLabel("Subject 3 Marks:");
            subject3Field = new JTextField();
            JLabel subject4Label = new JLabel("Subject 4 Marks:");
            subject4Field = new JTextField();
            JLabel subject5Label = new JLabel("Subject 5 Marks:");
            subject5Field = new JTextField();
            JButton saveButton = new JButton("Save");

            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    saveStudentMarks();
                }
            });

            panel.add(rollNoLabel);
            panel.add(rollNoField);
            panel.add(subject1Label);
            panel.add(subject1Field);
            panel.add(subject2Label);
            panel.add(subject2Field);
            panel.add(subject3Label);
            panel.add(subject3Field);
            panel.add(subject4Label);
            panel.add(subject4Field);
            panel.add(subject5Label);
            panel.add(subject5Field);
            panel.add(saveButton);

            setLayout(new BorderLayout());
            add(panel, BorderLayout.NORTH);

            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(400, 300);
            setLocationRelativeTo(null); 
        }

        private void saveStudentMarks() {
            String rollNo = rollNoField.getText();
            int subject1 = Integer.parseInt(subject1Field.getText());
            int subject2 = Integer.parseInt(subject2Field.getText());
            int subject3 = Integer.parseInt(subject3Field.getText());
            int subject4 = Integer.parseInt(subject4Field.getText());
            int subject5 = Integer.parseInt(subject5Field.getText());

            String url = "jdbc:mysql://localhost:3306/student_db";
            String username = "your_username";
            String password = "your_password";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String sql = "INSERT INTO student_marks (rollno, subject1, subject2, subject3, subject4, subject5) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, Integer.parseInt(rollNo));
                    statement.setInt(2, subject1);
                    statement.setInt(3, subject2);
                    statement.setInt(4, subject3);
                    statement.setInt(5, subject4);
                    statement.setInt(6, subject5);

                    int rowsInserted = statement.executeUpdate();

                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(this, "Student marks saved successfully.");
                        clearFields();
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to save student marks.");
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error connecting to the database.");
            }
        }

        private void clearFields() {
            rollNoField.setText("");
            subject1Field.setText("");
            subject2Field.setText("");
            subject3Field.setText("");
            subject4Field.setText("");
            subject5Field.setText("");
        }
    }
}
