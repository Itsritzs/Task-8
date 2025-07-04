import java.util.*;

class Question {
    String question;
    String[] options;
    int correctAnswerIndex;

    public Question(String question, String[] options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public void displayQuestion() {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public boolean isCorrect(int userAnswerIndex) {
        return userAnswerIndex == correctAnswerIndex;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
            "What is the capital of France?",
            new String[]{"Berlin", "Madrid", "Paris", "Rome"},
            2));
        questions.add(new Question(
            "Which language runs in a web browser?",
            new String[]{"Java", "C", "Python", "JavaScript"},
            3));
        questions.add(new Question(
            "Which planet is known as the Red Planet?",
            new String[]{"Earth", "Mars", "Jupiter", "Saturn"},
            1));

        int score = 0;

        System.out.println("=== Welcome to the Java Console Quiz ===");
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("\nQuestion " + (i + 1));
            Question q = questions.get(i);
            q.displayQuestion();

            int userAnswer = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Your answer (1-4): ");
                    userAnswer = Integer.parseInt(scanner.nextLine()) - 1;
                    if (userAnswer >= 0 && userAnswer < q.options.length) {
                        validInput = true;
                    } else {
                        System.out.println("Please enter a number between 1 and 4.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            if (q.isCorrect(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer: " + q.options[q.correctAnswerIndex]);
            }
        }

        System.out.println("\n=== Quiz Finished ===");
        System.out.println("Your score: " + score + " out of " + questions.size());
    }
}
