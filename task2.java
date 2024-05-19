import java.util.Scanner;

public class task2 {

    private static int TotalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    private static double calculateAverage(int total, int TotalSubjects) {
        return (double) total / TotalSubjects;
    }

    private static String Grade(double avg) {
        if (avg >= 90) {
            return "A+";
        } else if (avg >= 80) {
            return "A";
        } else if (avg >= 70) {
            return "B+";
        } else if (avg >= 60) {
            return "B";
        } else if (avg >= 50) {
            return "C+";
        } else if (avg >= 40) {
            return "C";
        } else {
            return "F";
        }
    }

    private static void displayResults(int total, double avg, String grade) {
        System.out.println("Total Marks: " + total);
        System.out.println("Average Percentage: " + avg);
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Total number of subjects: ");
        int TotalSubjects = scanner.nextInt();
        int[] marks = new int[TotalSubjects];

        for (int i = 0; i < TotalSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();
        }

        int totalMarks = TotalMarks(marks);
        double Percent = calculateAverage(totalMarks, TotalSubjects);
        String grade = Grade(Percent);

        displayResults(totalMarks, Percent, grade);

        scanner.close();
    }
}
