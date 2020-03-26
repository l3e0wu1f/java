
/**
 * Write the following two overloaded methods:
 * 1. public static int countLetters(String s) which count the number of 
 * English letters in given String s.
 * 2. public static int countLetters(String s, char c) which count the number
 * of English letter c (not case sensitive) in given String s. If c is not an 
 * English letter, returns -1.
 *
 * @author Josh Lewis
 * @version 10/10/2018
 */

import java.util.Scanner;

public class JoshLewis_Project06
{   
    public static void main(String args[]){        
        
        // Create scanner variables for user input
        Scanner input = new Scanner(System.in);
        
        // Declare repeat conditional
        char answer;
        
        do {
        // Ask user for input to test overloaded methods
        System.out.print("Enter a string: ");
        String s = input.next();
        System.out.print("Enter a character: ");
        char c = input.next().charAt(0);
        
        // Print results of overloaded methods
        System.out.println("The result of calling function int " +
        "countLetters(String s) is: " + countLetters(s));
        System.out.println("The result of calling function int " +
        "countLetters(String s, char c) is: " + countLetters(s,c));
        
        // Ask user if they'd like to repeat process
        System.out.print("Do you want to do another test? Y/N: ");
        answer = input.next().charAt(0);        
        } while(answer == 'Y' || answer == 'y');
        
        System.out.println("Goodbye!");
    }
    
    public static int countLetters(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if('A' <= s.charAt(i) && s.charAt(i) <= 'z')
                count++;
        }
        return count;
    }
    
    public static int countLetters(String s, char c){
        int charCount = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c)
                charCount++;
        }
        
        if('A' <= c && c <= 'z')
            return charCount;
        else
            return -1;           
    }
}
