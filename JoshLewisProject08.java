
/**
 * Nine coins are placed in a 3x3 matrix w/ some face up and some face down.
 * Write a program that prompts the user to enter a number between 0 and 511
 * and displays the corresponding matrix with the characters H and T. 
 *
 * Josh Lewis
 * 10/29/2018
 */

import java.util.Scanner;
    
public class JoshLewisProject08
{   
    public static void main(String args[])
    {
        // Create matrix array
        int[][] matrix = new int[3][3];
        
        // Create Scanner for input
        Scanner input = new Scanner(System.in);
        
        // Ask user for input
        System.out.print("Please enter a number between 0 and 511: ");
        int num = input.nextInt();
        
        String bin = decToBin(num);
        int binIndex = 0;
        
        // Assign 0's or 1's to represent coin states
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                int coinState = (bin.charAt(binIndex++) == '0') ? 0 : 1;
                matrix[i][j] = coinState;
            }
        }
        
        // Assign H's or T's to corresponding bits
        for(int k = 0; k < matrix.length; k++) {
            for(int l = 0; l < matrix[k].length; l++) {
                char ht = (matrix[k][l] == 0) ? 'H' : 'T';
                System.out.print(ht + " ");
            }
            
            System.out.println("");
        }
    }
    
    public static String decToBin(int num)
    {
        StringBuilder str = new StringBuilder();
        
        while(num != 0) {
            str.append(num & 1);
            num = num >> 1;
        }
        
        while(str.length() < 9) {
            str.insert(0, '0');
        }
        
        return str.toString();
    }
}
