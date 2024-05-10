import java.util.Scanner;
import java.util.Random;

public class task1 {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 10;
    private static int score = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int correct_number = random_number(random);
            int attemptsLeft = MAX_ATTEMPTS;

            System.out.println("Guess the number between 1 to 100");

            while (attemptsLeft > 0) {
                int userGuess = get_guess_number(scanner);
                if (userGuess == correct_number) {
                    System.out.println("Winner!! Winner!! Winner!!");
                    score++;
                    break;
                } else if (userGuess < correct_number)
                    System.out.println("Too low!");
                else 
                    System.out.println("Too high!");
                attemptsLeft--;
                
                if (attemptsLeft == 0)
                    System.out.println("0 attemplts left.\nThe correct number was: " + correct_number);
                
            }
            System.out.println("====================================================\n");
            System.out.println("Your current score: " + score);
            System.out.println("Play again? (yes/no)");
            String playChoice = scanner.next();
            playAgain = playChoice.equalsIgnoreCase("yes");
        }

        System.out.println("Final score is: " + score);
        scanner.close();
    }

    private static int random_number(Random random) {
        return random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
    }

    private static int get_guess_number(Scanner scanner) {
        System.out.print("Enter your guess: ");
        return scanner.nextInt();
    }
}
