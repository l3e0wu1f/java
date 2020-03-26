
/**
 * Write your own String class based on the gven UML diagram.
 *
 * @author Josh Lewis
 * @version 11/14/2018
 */

import java.lang.*;

public class JoshLewisProj10
{
    public static class MyString {
        
        char[] data;
        
        // Assign character array variable to data
        public MyString(char[] chars) {
            this.data = chars;
        }
        
        // Find character at index
        public char charAt(int i) {
                return data[i];
            }
        
        // Find length of character array
        public int length() {
            int i = 0;
            for(char c: data) {
                i++;
            }
            return i;
        }
        
        // Return slice of string at given beggining and end points
        public MyString substring(int begin,int end) {
            int len = end - begin;
            char arr[] = new char[len];
            for (int i = 0; i < len; i++) {
                arr[i] = data[begin];
                begin++;
            }
            return new MyString(arr);
        }   
        
        public MyString toLowerCase() {
            int len = length();
            char arr[] = new char[len];
            for (int j = 0; j < len; j++) {
                arr[j] = (char)(data[j] + 32);
            }
            return new MyString(arr);
        }
        
        public boolean equals(MyString other) {
            int len = length();
            if(len != other.length()) {
                return false;
            }
            else {
                for(int i = 0; i < len; i++) {
                    if(data[i] != other.data[i])
                        return false;
                }
            }
            
            return true;
        }
        
        public static MyString valueOf(int i) {
            int num = i;
            int len = 0;
            while (num > 0) {
                num = num / 10;
                len++;
            }
            char[] arr = new char[len];
            for (int j = len - 1; j >= 0; j--) {
                arr[j] = (char)((num % 10) + '0');
                num = num / 10;
            }

            return new MyString(arr);
        }
        
        public char[] toChars() {
            return data;
        }   
    }
    
    public static void main(String[] args) {
        MyString s1 = new MyString(new char[] {'A', 'B', 'C', 'D'});
        
        System.out.println("Length of string: " + s1.length());
        System.out.println("Character at index 1: " + s1.charAt(1));

        MyString s2 = s1.substring(0, 3);
        System.out.println("Compare substring (abc) to new string (ab), result: " + s2.toLowerCase().equals(new MyString(new char[] {'a', 'b'})));

        char[] chars = MyString.valueOf(21).toChars();
        System.out.println(chars);
        for(int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
    }
}
