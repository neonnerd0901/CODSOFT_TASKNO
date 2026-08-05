import java.util.Scanner;
import java.util.concurrent.*;

public class QuizApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] questions = {
                "Which keyword is used to create an object?",
                "Which loop executes at least once?",
                "Which data type stores decimal values?",
                "Which method is the entry point of a Java program?",
                "Which package contains Scanner class?"
        };

        String[][] options = {
                {"A. class", "B. new", "C. this", "D. static"},
                {"A. for", "B. while", "C. do-while", "D. switch"},
                {"A. int", "B. boolean", "C. double", "D. char"},
                {"A. start()", "B. run()", "C. main()", "D. execute()"},
                {"A. java.io", "B. java.util", "C. java.lang", "D. java.awt"}
        };

        char[] answers = {'B', 'C', 'C', 'C', 'B'};

        int score = 0;

        System.out.println("========================================");
        System.out.println("         JAVA QUIZ APPLICATION");
        System.out.println("========================================");

        for (int i = 0; i < questions.length; i++) {

            System.out.println("\nQuestion " + (i + 1));
            System.out.println(questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.println("You have 10 seconds to answer.");
            System.out.print("Enter your answer (A/B/C/D): ");

            ExecutorService executor = Executors.newSingleThreadExecutor();

            Future<String> future = executor.submit(() -> sc.next());

            try {

                String input = future.get(10, TimeUnit.SECONDS);
                char userAnswer = Character.toUpperCase(input.charAt(0));

                if (userAnswer == answers[i]) {
                    System.out.println("✅ Correct!");
                    score++;
                } else {
                    System.out.println("❌ Wrong!");
                    System.out.println("Correct Answer: " + answers[i]);
                }

            } catch (TimeoutException e) {

                System.out.println("\n⏰ Time's Up!");
                System.out.println("Correct Answer: " + answers[i]);
                future.cancel(true);

            } catch (Exception e) {

                System.out.println("Invalid Input!");

            } finally {

                executor.shutdownNow();

            }

            System.out.println("----------------------------------------");
        }

        double percentage = (double) score / questions.length * 100;

        System.out.println("\n========================================");
        System.out.println("           QUIZ COMPLETED");
        System.out.println("========================================");
        System.out.println("Correct Answers : " + score);
        System.out.println("Wrong Answers   : " + (questions.length - score));
        System.out.println("Final Score     : " + score + "/" + questions.length);
        System.out.printf("Percentage      : %.2f%%\n", percentage);
        System.out.println("========================================");

        sc.close();
    }
}