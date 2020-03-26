
/**
 * Write a program that can convert a binary to decimal (only for integer case).
 * Easy way: Directly use Java built-in method to do this. In this case, only 
 * couple lines of code. Hint: Study Integer class in Java. 
 * Hard way: Write your own code to convert a binary to decimal from scratch. 
 * The input is a binary string. The program output is its corresponding decimal
 * value.
 *
 * @author Josh Lewis
 * @version 09/14/2018
 */
import java.util.Scanner;

public class JoshLewisProject04 {
   public static void main(String args[]) {
      // Create Scanner
      Scanner input = new Scanner(System.in);
      
      // Easy Conversion
      System.out.print("Now demonstrating parseInt method of Integer class.\nPlease enter a binary number: ");
      String binaryString = input.nextLine();
      System.out.println("Result: " + Integer.parseInt(binaryString, 2));
      
      // From Scratch Conversion
      System.out.print("Now demonstrating binary to decimal algorithm.\nPlease enter a binary number: ");
      int binaryInt = input.nextInt();
      int decimalConversion = 0, place = 0;
      
      while(binaryInt != 0) {
         decimalConversion += ((binaryInt % 10) * Math.pow(2,place));
         binaryInt /= 10;
         place++;
      }
   
   System.out.println("Result: " + decimalConversion);
      
   }
}