
/**
 * CSCI 231 Project 07 – An Array Festive
 * Apply linear search algorithm, apply selection sort algorithm, and apply
 * array iteration skill in following eight methods.
 *
 * @author: Josh Lewis
 * @version: 10/22/2018
 */

import java.util.Scanner;

public class JoshLewisProject07
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        
        String answer;
        
        do {
            int[] array = new int[10];
            initializeArray(array);
            System.out.println("Printed array: ");
            printArray(array);
            System.out.println("Largest element in array: " + 
                largest(array) + "\nSmallest element in array: " + smallest(array));
            System.out.println("The range of the array is: " + range(array));
            System.out.println("The average of its elements is: " + average(array));
            System.out.print("Please enter a search key: ");
            int key = input.nextInt();
        
            if(linearSearch(array, key) == -1) 
                System.out.println("The index of the key could not be" +
                " found.");
            else
                System.out.println("The index of the key is: " + 
                linearSearch(array, key));
            
            selectSort(array);
            System.out.println("Numerically sorted: ");
            printArray(array);
            
            System.out.print("Would you like to go again? (Y/N): ");
            answer = input.next();
            
        } while(answer.charAt(0) != 'n' && answer.charAt(0) != 'N');
        
        System.out.println("Goodbye!");
    }
    
    // Return index of the first occurence of key in arr
    // If key is not found, return -1
    public static int linearSearch(int arr[], int key)
    {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == key)
                return i;
        }
        
        return -1;
    }

    // Sort the array from least to largest by using selection sort algorithm
    public static void selectSort(int arr[])
    {
        for(int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min])
                    min = j;
            }
                
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    
    // Print out all array elements, 5 per line
    public static void printArray(int arr[])
    {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if((i + 1) % 5 == 0)
                System.out.print("\n");
        }
    }

    // Assign each element in the array with a random number 
    // between 1 & 100 inclusive
    public static void initializeArray(int arr[])
    {
        for(int i = 0; i < arr.length - 1; i++) {
            arr[i] = (int)(Math.random() * 100 + 1);
        }
    }

    // Find the range of all array elements, defined as the difference 
    // between the largest and the smallest elements
    public static int range(int arr[]) {
        int min = arr[0];
        int max = arr[0];
        
        for(int i = 0; i < arr.length - 1; i++) {
            
            for(int j = 0; j < arr.length; j++) {           
                // Assign smaller element, if any
                    if(arr[j] < min)
                        min = arr[j];
            }
            
            for(int k = 0; k < arr.length; k++) {           
                // Assign larger element, if any
                    if(arr[k] > max)
                        max = arr[k];
            }
        }
        
        // Get range
        int range = max - min;               
        return range;
    }

    // Find the largest element in array
    public static int largest(int arr[])
    {
        int max = arr[0];
        
        for(int i = 0; i < arr.length; i++) {           
            // Assign larger element, if any
                if(arr[i] > max)
                    max = arr[i];
        }

        return max;        
    }

    // Find the smallest element in array
    public static int smallest(int arr[])
    {
        int min = arr[0];
        
        for(int i = 0; i < arr.length; i++) {           
            // Assign smaller element, if any
                if(arr[i] < min)
                    min = arr[i];
        }
        
        return min;
    }

    // Find the average value of all elements in array
    public static double average(int arr[])
    {
        double avg = 0.0;
        double total = 0.0;
        
        for(int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        
        // Calculate average
        avg = total / arr.length;
        return avg;
    }
}
