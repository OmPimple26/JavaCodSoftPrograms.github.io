import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int MAX_ATTEMPTS = 5;
        int roundsWon = 0;
        int totalScore=0;
        boolean playAgain=true;

        while(playAgain){
            int numberToGuess = random.nextInt(100)+1;
            int attempts=0;
            boolean hasGuessedCorrectly=false;

            System.out.println("Guess the number between 1 to 100. You have maximum "+MAX_ATTEMPTS+" attempts.");

            while(attempts<MAX_ATTEMPTS && !hasGuessedCorrectly){
                System.out.println("Enter your guess: ");
                int userGuess=sc.nextInt();
                attempts++;

                if(userGuess==numberToGuess){
                    System.out.println("Congratulations! You have guessed the number corerctly.");
                    hasGuessedCorrectly=true;
                    roundsWon++;
                    totalScore+=(MAX_ATTEMPTS-attempts+1);
                }else if(userGuess<numberToGuess){
                    System.out.println("Your guess is low");
                }else{
                    System.out.println("Your guess is high");
                }
            }

            if(!hasGuessedCorrectly){
                System.out.println("You have guessed wrong number.The number was "+numberToGuess);
            }

            System.out.println("Do you want to play again (Yes/No) : ");
            String response=sc.nextLine();
            playAgain=response.equalsIgnoreCase("yes");
        }

        System.out.println("Game over.Your total score was "+totalScore);
        System.out.println("You won total "+roundsWon+" rounds.");
        sc.close();
    }
}
