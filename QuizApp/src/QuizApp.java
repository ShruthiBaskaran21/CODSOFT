import java.util.*;
import java.util.Timer;

public class QuizApp {
    
    static class Question {
        String questionText;
        String[] options;
        int correctAnswer;

        public Question(String questionText, String[] options, int correctAnswer) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }

    static List<Question> questions = new ArrayList<>();
    static int score = 0;
    static Timer timer;
    static int currentQuestionIndex = 0;

    public static void main(String[] args) {
        // Add quiz questions
        questions.add(new Question("What is the capital of France?", new String[]{"1. Paris", "2. London", "3. Rome", "4. Berlin"}, 1));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"1. Earth", "2. Mars", "3. Venus", "4. Jupiter"}, 2));
        questions.add(new Question("What is 2 + 2?", new String[]{"1. 3", "2. 4", "3. 5", "4. 6"}, 2));
        questions.add(new Question("Who wrote 'Hamlet'?", new String[]{"1. Shakespeare", "2. Dickens", "3. Chaucer", "4. Austen"}, 1));
        questions.add(new Question("What is the largest ocean?", new String[]{"1. Atlantic", "2. Indian", "3. Arctic", "4. Pacific"}, 4));

        // Start the quiz
        startQuiz();
    }

    public static void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        // Loop through each question
        for (currentQuestionIndex = 0; currentQuestionIndex < questions.size(); currentQuestionIndex++) {
            Question question = questions.get(currentQuestionIndex);

            // Display the question and options
            System.out.println("Question " + (currentQuestionIndex + 1) + ": " + question.questionText);
            for (String option : question.options) {
                System.out.println(option);
            }

            // Start the timer for each question
            startTimer();

            // Get user answer within the given time
            System.out.print("Select your answer (1-4): ");
            int userAnswer = scanner.nextInt();

            // Stop the timer
            timer.cancel();

            // Check if the answer is correct
            if (userAnswer == question.correctAnswer) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was option " + question.correctAnswer + ".\n");
            }
        }

        // Display the final score
        displayResult();
    }

    public static void startTimer() {
        // Set a timer for 10 seconds (this is just an example, adjust as needed)
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up! Moving to the next question.\n");
                score--; // Deduct points for time expiration
                timer.cancel();
            }
        }, 10000);  // 10 seconds timer
    }

    public static void displayResult() {
        System.out.println("\nQuiz Finished!");
        System.out.println("Your final score is: " + score + "/" + questions.size());
        System.out.println("Summary:");
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Q" + (i + 1) + ": " + (question.correctAnswer == 1 ? "Correct" : "Incorrect"));
        }
    }
}
