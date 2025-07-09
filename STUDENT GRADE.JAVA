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

public class Main {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Student Grade Tracker ===");
        while (true) {
            System.out.print("Enter student name (or type 'done' to finish): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("done")) break;

            System.out.print("Enter grade for " + name + ": ");
            double grade = Double.parseDouble(scanner.nextLine());

            students.add(new Student(name, grade));
        }

        if (students.isEmpty()) {
            System.out.println("No student data entered.");
            return;
        }

        displaySummary();
        scanner.close();
    }

    private static void displaySummary() {
        System.out.println("\n--- Summary Report ---");

        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        String topStudent = "", bottomStudent = "";

        for (Student s : students) {
            System.out.println(s.name + " - Grade: " + s.grade);
            total += s.grade;

            if (s.grade > highest) {
                highest = s.grade;
                topStudent = s.name;
            }

            if (s.grade < lowest) {
                lowest = s.grade;
                bottomStudent = s.name;
            }
        }

        double average = total / students.size();

        System.out.printf("\nAverage Grade: %.2f\n", average);
        System.out.println("Highest Grade: " + highest + " (by " + topStudent + ")");
        System.out.println("Lowest Grade: " + lowest + " (by " + bottomStudent + ")");
    }
}
