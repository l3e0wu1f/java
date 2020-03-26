
/**
 * Write a program that asks the user to input change between 1 and 99 cents. 
 * The program then will display it in amount of quarters, dimes, nickels and 
 * pennies.
 *
 * @author Josh Lewis
 * @version 08/27/2018
 */

import java.util.Scanner;

public class JoshLewisProject02
{
    public static void main(String args[]) {
        /* 
         * Get user-generated number
         * Scanner input = new Scanner(System.in);
         * System.out.print("Enter a change between 1 and 99 cents: ");
         * int change = input.nextInt(); 
         */
        
        // Randomly generate number between 1 and 99
        int change = (int)(Math.random() * 100);
        
        // Output amount of change
        System.out.println("You have change " + change + " cents.");
        System.out.println("That is: ");
        
        // Quarters
        int quarters = change / 25;
        int remainder = change % 25;
        System.out.println(quarters + " quarters");
        
        // Dimes
        int dimes = remainder / 10;
        remainder %= 10;
        System.out.println(dimes + " dimes");
        
        // Nickels
        int nickels = remainder / 5;
        remainder %= 5;
        System.out.println(nickels + " nickels");
        
        // Pennies
        int pennies = remainder / 1;
        System.out.println(pennies + " pennies");
    }
}
