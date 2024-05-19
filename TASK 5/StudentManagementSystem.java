import java.util.ArrayList;

public class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student searchStudent(String rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber().equalsIgnoreCase(rollNumber)) {
                return student;
            }
        }
        return null;
    }

    public boolean removeStudent(String rollNumber) {
        Student student = searchStudent(rollNumber);
        if (student != null) {
            students.remove(student);
            return true;
        }
        return false;
    }

    public boolean editStudent(String rollNumber, String newName, String newGrade) {
        Student student = searchStudent(rollNumber);
        if (student != null) {
            student.setName(newName);
            student.setGrade(newGrade);
            return true;
        }
        return false;
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }
}
