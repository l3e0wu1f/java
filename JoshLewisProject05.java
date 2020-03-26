
/**
 * Write a mortgage calculator program to calculate fixed rate mortgage
 * payment. Your program should print out an amortization table on screen.
 * Input: Principle, Term (years), and Quoted Interest Rate.
 * Output: Month, Payment, Total Interest, and Balance.
 * @author (Josh Lewis)
 * @version (10/3/2018)
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class JoshLewisProject05
{
    public static void main(String args[]) {
      
      // Declare repeat conditional  
      String answer;
      
      do {
          
        // Create scanner variables for user input
        Scanner input = new Scanner(System.in);
        
        // Formatting
        DecimalFormat df = new DecimalFormat("0.00");
        
        // Ask user for input of values needed to make calculation
        System.out.println("Please enter the following values to calculate your mortgage.");
        
        // Principle
        System.out.print("Principle amount in dollars: ");
        double principle = input.nextDouble();
        
        // Term
        System.out.print("Term length in years: ");
        int numYears = input.nextInt();
        
        // Quoted Rate
        System.out.print("Quoted Interest Rate (decimal): ");
        double quotedRate = input.nextDouble();
        
        // Variables for calculation
        double N = numYears * 12.0;
        double r = quotedRate / 12;
        
        // Supplementary calculations
        double monthlyCost = ((principle * r) * Math.pow((r + 1), N)) / 
            (Math.pow((r + 1), N) - 1);
            
        // While Loop to print table
        int i = 1; // Month number
        System.out.println("Month" + "\tPayment" + 
                "\tTotal Interest" +  "\tBalance");
        while(i <= N) {
            double balance = (principle * Math.pow((r + 1), i)) - 
                (((Math.pow((r + 1), i) - 1) * monthlyCost) / r);
            double totalInterest = monthlyCost * i - (principle - balance);
            System.out.println(i + ".\t$" + df.format(monthlyCost) + "\t$" 
                + df.format(totalInterest) + "\t$" + df.format(balance));
            i++;
        }
        
        /* For Loop to print table
         * 
         * System.out.println("Month" + "\tPayment" + 
         *  "\tTotal Interest" +  "\tBalance");
         *  for(int i = 1; i <= N; i++) {
         *      double balance = (principle * Math.pow((r + 1), i)) - 
         *          (((Math.pow((r + 1), i) - 1) * monthlyCost) / r);    
         *      double totalInterest = monthlyCost * i - (principle - balance);
         *  System.out.println(i + ".\t$" + df.format(monthlyCost) + "\t$" 
         *      + df.format(totalInterest) + "\t$" + df.format(balance));
        }
         */
        
        // Ask to repeat calculation
        System.out.print("Would you like to calculate another mortgage? (Y/N): ");
        answer = input.next();
        if (answer.charAt(0) == 'n' || answer.charAt(0) == 'N') {
            System.out.println("Goodbye!");
            break;
        }
      } while(answer.charAt(0) == 'Y' || answer.charAt(0) == 'y');
        
        
    }
}
