
/**
 * Write a game program. The computer will ask the user to input a score. 
 * The program will first check if the score is valid (between 0 and 100, 
 * inclusive). If the score is not valid, print out the error message and 
 * exit the program. Otherwise, display the corresponding letter grade.
 *
 * @author Josh Lewis
 * @version 08/29/2018
 */
import java.util.Scanner;

public class JoshLewisProject03
{
  public static void main(String args[]) {
    
    // Create Scanner
    Scanner input = new Scanner(System.in);
    
    // Ask user for input
    System.out.print("Enter your score (0 - 100): ");
    int score = input.nextInt();
    
    /*
    // Grading Rubric (If/Else Statements)
    if(score < 60)
        System.out.println("Your grade is: F");
    else if(score < 70)
        System.out.println("Your grade is: D");
    else if(score < 80)    
        System.out.println("Your grade is: C");
    else if(score < 90)    
        System.out.println("Your grade is: B");
    else    
        System.out.println("Your grade is: A");
    }
    */
   
    // Grading Rubric (Switch Statement)
    switch(score / 10) {
        case 6: System.out.println("Your grade is: D");
            break;
        case 7: System.out.println("Your grade is: C");
            break;
        case 8: System.out.println("Your grade is: B");
            break;
        case 9: 
        case 10: System.out.println("Your grade is: A");
            break;
        default: System.out.println("Your grade is: F");
            break;
    }
  }
}
