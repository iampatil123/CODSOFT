import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main extends JFrame {
    private StudentManagementSystem sms;
    private JTable studentTable;
    private DefaultTableModel tableModel;

    public main() {
        sms = new StudentManagementSystem();
        setTitle("Student Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Table setup
        tableModel = new DefaultTableModel(new Object[] { "Name", "Roll Number", "Grade" }, 0);
        studentTable = new JTable(tableModel);
        container.add(new JScrollPane(studentTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));

        JButton addButton = new JButton("Add Student");
        JButton editButton = new JButton("Edit Student");
        JButton removeButton = new JButton("Remove Student");
        JButton searchButton = new JButton("Search Student");

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(searchButton);

        container.add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editStudent();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeStudent();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchStudent();
            }
        });
    }

    private void addStudent() {
        JTextField nameField = new JTextField();
        JTextField rollNumberField = new JTextField();
        JTextField gradeField = new JTextField();

        Object[] message = {
                "Name:", nameField,
                "Roll Number:", rollNumberField,
                "Grade:", gradeField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Add Student", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String rollNumber = rollNumberField.getText();
            String grade = gradeField.getText();
            sms.addStudent(new Student(name, rollNumber, grade));
            displayStudents();
        }
    }

private void editStudent() {
        String rollNumber = JOptionPane.showInputDialog(this, "Enter Roll Number to Edit:");
        if (rollNumber != null) {
            Student student = sms.searchStudent(rollNumber);
            if (student != null) {
                JTextField nameField = new JTextField(student.getName());
                JTextField gradeField = new JTextField(student.getGrade());
            Object[] message = {
                    "Name:", nameField,
                    "Grade:", gradeField
            };

            int option = JOptionPane.showConfirmDialog(this, message, "Edit Student", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String newName = nameField.getText();
                String newGrade = gradeField.getText();
                sms.editStudent(rollNumber, newName, newGrade);
                displayStudents();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Student not found!");
        }
    }
}

    private void removeStudent() {
        String rollNumber = JOptionPane.showInputDialog(this, "Enter Roll Number to Remove:");
        if (rollNumber != null) {
            if (sms.removeStudent(rollNumber)) {
                JOptionPane.showMessageDialog(this, "Student removed successfully!");
                displayStudents();
            } else {
                JOptionPane.showMessageDialog(this, "Student not found!");
            }
        }
    }

    private void searchStudent() {
        String rollNumber = JOptionPane.showInputDialog(this, "Enter Roll Number to Search:");
        if (rollNumber != null) {
            Student student = sms.searchStudent(rollNumber);
            if (student != null) {
                JOptionPane.showMessageDialog(this, student.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Student not found!");
            }
        }
    }

    private void displayStudents() {
        tableModel.setRowCount(0);
        for (Student student : sms.getAllStudents()) {
            tableModel.addRow(new Object[] { student.getName(), student.getRollNumber(), student.getGrade() });
        }
    }

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            new main().setVisible(true);
        }
    });
}}