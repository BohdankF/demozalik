import java.util.Scanner;

public class QuizApplication{
    public static void main(String[] args) {
        String[] questions = {
                "1. Столиця Франції",
                "2. Найбільша планета в сонячній системі?",
                "3. Хто намалював Мона Лізу?",
                "4. Яке хімічне позначення золота?",
                "5. Найвища гора світу?"
        };

        String[][] options = {
                {"A. Лондон", "B. Париж", "C. Рим", "D. Мадрид"},
                {"A. Юпітер", "B. Сатурн", "C. Земля", "D. Марс"},
                {"A. Леонардо да Вінчі", "B. Пабло Пікассо", "C. Вінсент ван Гог", "D. Мікіланджелло"},
                {"A. Au", "B. Ag", "C. Cu", "D. Hg"},
                {"A. Гора Еверест", "B. K2", "C. Гора Кіліманджаро", "D. Гора Фуджі"}
        };

        String[] answers = {"B", "A", "A", "A", "A"};

        Scanner scanner = new Scanner(System.in);

        int totalQuestions = questions.length;
        int correctAnswers = 0;
        int currentQuestion = 0;

        System.out.println("Welcome to the Quiz Application!");
        System.out.println("You will be asked " + totalQuestions + " questions. Enter 'q' at any time to quit.\n");

        while (currentQuestion < totalQuestions) {
            System.out.println(questions[currentQuestion]);

            for (int i = 0; i < 4; i++) {
                System.out.println(options[currentQuestion][i]);
            }

            System.out.print("Enter your answer: ");
            String userInput = scanner.nextLine().toUpperCase();

            if (userInput.equals("Q")) {
                break;
            }

            if (userInput.equals(answers[currentQuestion])) {
                System.out.println("Correct!\n");
                correctAnswers++;
            } else if (userInput.matches("[A-D]")) {
                System.out.println("Incorrect!\n");
            } else {
                System.out.println("Invalid input! Please enter A, B, C, D, or Q.\n");
                continue;
            }

            currentQuestion++;
        }

        if (currentQuestion == totalQuestions) {
            double percentage = (double) correctAnswers / totalQuestions * 100;
            System.out.println("Quiz completed!");
            System.out.println("Your score: " + correctAnswers + "/" + totalQuestions);
            System.out.println("Percentage: " + percentage + "%");
        }

        // Administrator view of correct answers
        System.out.println("\nAdministrator View - Correct Answers:");
        for (int i = 0; i < totalQuestions; i++) {
            System.out.println(questions[i] + " " + answers[i]);
        }
    }
}