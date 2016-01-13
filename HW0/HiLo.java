import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class HiLo {
  static public void main(String [ ] args){
    
    Random rnd = new Random();
    int target = rnd.nextInt(1000) + 1;
    
    System.out.println("Let's play a game!");
    System.out.println("I'm thinking of a number between 1 and 1000");
    System.out.println("Try to guess what it is!");
    
    System.out.print("Enter a guess: "); 
    int userGuess;
    int count = 1;
    Scanner input = new Scanner(System.in); // I'm reading what the user typed
    
    while ( input.hasNextLine() ) {         // keep looping for each guess, use 'break' to exit
        
        String line = input.nextLine();     // Read the next line of input from the user

        Scanner s2 = new Scanner(line);     // s2 will let me break 'line' apart

        if  ( s2.hasNextInt() ) {           // check to see if s2 would next see an integer number
            // Good! do something with this
            userGuess = s2.nextInt();       // read in that number
            if (userGuess == target){
              System.out.println("You guessed my number! It took you " + count + " tries.");
              break;
            }
            else if (userGuess > target){
              System.out.println("Too high!"); // number given is higher than expected
            }
            else {
              System.out.println("Too low!");  // number given is lower than the expected
            }
        } else {
            System.out.println("That's not a number, try again.");         // Too bad, print a message and then...
            continue;                       // jump back to the top of the while loop
        }
        
        count = count+1;
        System.out.print("Enter a guess: "); //the program will keep asking for a new number while the user doesn't properly guess the number
        

    }
  }  
}
