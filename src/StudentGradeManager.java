import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

    public class StudentGradeManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Input student data
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();

            System.out.print("Enter grade for " + name + ": ");
            double grade = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            students.add(new Student(name, grade));
        }

        // Initialize variables for stats
        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        String topStudent = "";
        String lowStudent = "";

        // Process grades
        for (Student s : students) {
            total += s.grade;

            if (s.grade > highest) {
                highest = s.grade;
                topStudent = s.name;
            }

            if (s.grade < lowest) {
                lowest = s.grade;
                lowStudent = s.name;
            }
        }

        double average = total / students.size();

        // Summary Report
        System.out.println("\n----- Summary Report -----");
        System.out.printf("Average Score: %.2f\n", average);
        System.out.printf("Highest Score: %.2f (by %s)\n", highest, topStudent);
        System.out.printf("Lowest Score: %.2f (by %s)\n", lowest, lowStudent);

        System.out.println("\nAll Students:");
        for (Student s : students) {
            System.out.println("Name: " + s.name + ", Grade: " + s.grade);
        }

        scanner.close();
    }
}