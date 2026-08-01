import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int subjects;
        int totalMarks = 0;
        double averagePercentage;
        String grade;

        System.out.println("----------------------------------------");
        System.out.println("      STUDENT GRADE CALCULATOR");
        System.out.println("----------------------------------------");

        System.out.print("Enter the number of subjects: ");
        subjects = sc.nextInt();

        for (int i = 1; i <= subjects; i++) {

            int marks;

            while (true) {
                System.out.print("Enter marks for Subject " + i + " (0-100): ");
                marks = sc.nextInt();

                if (marks >= 0 && marks <= 100) {
                    break;
                } else {
                    System.out.println("Invalid marks! Please enter marks between 0 and 100.");
                }
            }

            totalMarks += marks;
        }

        averagePercentage = (double) totalMarks / subjects;

        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }


        System.out.println("\n= RESULT ");
        System.out.println("Total Marks       : " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade             : " + grade);
        System.out.println("============================");

        sc.close();
    }
}