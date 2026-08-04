import java.util.Scanner;

public class QuizApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Quetions
        String[] questions = {
                "Which keyword is used to create an object?",
                "Which loop executes at least once?",
                "Which data type stores decimal values?",
                "Which method is the entry point of a Java program?",
                "Which package contains Scanner class?"
        };

        // Options
        String[][] options = {
                {"A. class", "B. new", "C. this", "D. static"},
                {"A. for", "B. while", "C. do-while", "D. switch"},
                {"A. int", "B. boolean", "C. double", "D. char"},
                {"A. start()", "B. run()", "C. main()", "D. execute()"},
                {"A. java.io", "B. java.util", "C. java.lang", "D. java.awt"}
        };

        // Correct Answers
        char[] answers = {'B', 'C', 'C', 'C', 'B'};

        int score = 0;

        System.out.println("========================================");
        System.out.println("        JAVA QUIZ APPLICATION");
        System.out.println("========================================");

        // Display Questions
        for (int i = 0; i < questions.length; i++) {

            System.out.println("\nQuestion " + (i + 1));
            System.out.println(questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Enter your answer (A/B/C/D): ");
            char userAnswer = Character.toUpperCase(sc.next().charAt(0));

            if (userAnswer == answers[i]) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong!");
                System.out.println("Correct Answer: " + answers[i]);
            }
        }

        // Final Result
        System.out.println("\n--------------------------------------");
        System.out.println("           QUIZ COMPLETED");
        System.out.println("----------------------------------------");
        System.out.println("Correct Answers : " + score);
        System.out.println("Wrong Answers   : " + (questions.length - score));
        System.out.println("Final Score     : " + score + "/" + questions.length);

        double percentage = (double) score / questions.length * 100;
        System.out.printf("Percentage      : %.2f%%\n", percentage);

        System.out.println("========================================");

        sc.close();
    }
}