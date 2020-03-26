/**
 * CSCI251 Project One
 * 
 * @author Josh Lewis
 * @version Jan 31, 2019
 */
import java.util.*;

public class MySort
{
    public static void insertSort(int [] arr) {
        int i = 0;
        int j = 0;
        int temp = 0;  // Temporary variable for swap
   
        for (i = 1; i < arr.length; ++i) {
            j = i;
            // Insert numbers[i] into sorted part
            // stopping once numbers[i] in correct position
            while (j > 0 && arr[j] < arr[j - 1]) {
         
                // Swap numbers[j] and numbers[j - 1]
                temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                --j;
            }
        }
    }
    
    public static void selectSort(int [] arr) {
       int i = 0;
       int j = 0;
       int indexSmallest = 0;
       int temp = 0;  // Temporary variable for swap
   
       for (i = 0; i < arr.length - 1; ++i) {
      
           // Find index of smallest remaining element
           indexSmallest = i;
           for (j = i + 1; j < arr.length; ++j) {
         
               if ( arr[j] < arr[indexSmallest] ) {
                   indexSmallest = j;
                }
            }
      
            // Swap numbers[i] and numbers[indexSmallest]
            temp = arr[i];
            arr[i] = arr[indexSmallest];
            arr[indexSmallest] = temp;
        }
    }
    
    public static void quickSort(int [] arr) {
        int j = 0;
        int begin = arr[0];
        int end = arr[arr.length - 1];
   
        // Base case: If there are 1 or zero elements to sort,
        // partition is already sorted
        if (arr[0] >= arr[arr.length - 1]) {
            return;
        }
   
        // Partition the data within the array. Value j returned
        // from partitioning is location of last element in low partition.
        j = pivot(arr, begin, end);
   
        // Recursively sort low partition (i to j) and
        // high partition (j + 1 to k)
        quickSortRecursive(arr, begin, end);
        quickSortRecursive(arr, begin + 1, end);
    }
    
    public static void mergeSort(int [] arr) {
        int j = 0;
        int i = arr[0];
        int k = arr[arr.length - 1];
        
        if (i < k) {
            j = (i + k) / 2;  // Find the midpoint in the partition
      
            // Recursively sort left and right partitions
            mergeSortRecursive(arr, i, j);
            mergeSortRecursive(arr, j + 1, k);
      
            // Merge left and right partition in sorted order
            merge(arr, i, j, k);
        }
    }
    
    //merge method
    //merge two sorted portions of given array arr, namely, from start to middle 
    //and from middle + 1 to end into one sorted portion, namely, from start to end 
    private static void merge(int [] arr, int start, int middle, int end) {
        int mergedSize = end - start + 1;            // Size of merged partition
        int mergePos = 0;                            // Position to insert merged number
        int leftPos = 0;                             // Position of elements in left partition
        int rightPos = 0;                            // Position of elements in right partition
        int [] mergedNumbers = new int[mergedSize];  // Dynamically allocates temporary array for merged numbers
        leftPos = start;                             // Initialize left partition position
        rightPos = middle + 1;                       // Initialize right partition position
   
        // Add smallest element from left or right partition to merged numbers
        while (leftPos <= middle && rightPos <= end) {
            if (arr[leftPos] <= arr[rightPos]) {
                mergedNumbers[mergePos] = arr[leftPos];
                ++leftPos;
            }
            else {
                mergedNumbers[mergePos] = arr[rightPos];
                ++rightPos;
            }
            ++mergePos;
        }
   
        // If left partition is not empty, add remaining elements to merged numbers
        while (leftPos <= middle) {
            mergedNumbers[mergePos] = arr[leftPos];
            ++leftPos;
            ++mergePos;
        }
   
        // If right partition is not empty, add remaining elements to merged numbers
        while (rightPos <= end) {
            mergedNumbers[mergePos] = arr[rightPos];
            ++rightPos;
            ++mergePos;
        }
   
        // Copy merge number back to numbers
        for (mergePos = 0; mergePos < mergedSize; ++mergePos) {
            arr[start + mergePos] = mergedNumbers[mergePos];
        }
    }
    
    //merge sort recursive version
    //sort the portion of giving array arr, from begin to end 
    private static void mergeSortRecursive(int [] arr, int begin, int end) {
        if (begin < end) {
            int middle = begin + (end - begin) / 2;
            mergeSortRecursive(arr, begin, middle);
            mergeSortRecursive(arr, middle + 1, end);
            merge(arr, begin, middle, end);
        }
    }
    
    //find pivot point for quick sort
    private static int pivot(int [] arr, int begin, int end) {
        int l = 0;
        int h = 0;
        int midpoint = 0;
        int pivot = 0;
        int temp = 0;
        Boolean done = false;
   
        // Pick middle element as pivot
        midpoint = begin + (end - begin) / 2;
        pivot = arr[midpoint];
   
        l = begin;
        h = end;

        while (!done) {
      
            // Increment l while numbers[l] < pivot
            while (arr[l] < pivot) {
                ++l;
             }
      
            // Decrement h while pivot < numbers[h]
            while (pivot < arr[h]) {
                --h;
            }
      
            // If there are zero or one elements remaining,
            // all numbers are partitioned. Return h
            if (l >= h) {
                done = true;
            }
            else {
                // Swap numbers[l] and numbers[h],
                // update l and h
                temp = arr[l];
                arr[l] = arr[h];
                arr[h] = temp;
                ++l;
                --h;
            }
        }
   
        return h;
    }
   
    //quick sort recursive version
    //sort the portion of given array arr, from begin to end
    private static void quickSortRecursive(int [] arr, int begin, int end) {
        if(begin >= end) {
            return;
        }
           
        int split = pivot(arr, begin, end);
        quickSortRecursive(arr, begin, end - 1);
        quickSortRecursive(arr, begin + 1, end);
    }
}