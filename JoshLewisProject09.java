
/**
 * 1. The main method must create four Temperature objects by using all four constructors.
 * 2. The main method must test all set and get methods by setting the attributes according to user’s input then 
 *    displaying the temperature by printing out the result of get methods.
 * 3. The main function must test equals, isLessThan, and isGreaterThan methods by compare two Temperature objects 
 *    and print out the result.
 *
 * @author: Josh Lewis
 * @version: 11/10/2018
 */

import java.util.Scanner;

public class JoshLewisProject09
{
    public static class Temperature {
       private double degree;
       private char scale;
       
       //Constructors
       public Temperature() {
             degree = 0;
             scale = 'C';
       }

       public Temperature(double degree) {
             this.degree = degree;
             scale = 'C';
       }

       public Temperature(char scale) {
             degree = 0;
             this.scale = scale;       
       }

       public Temperature(double degree, char scale) {
             this.degree = degree;
             this.scale = scale;
       }

       // Method to return the value of degree in celsius
       public double getDegreeInCelsius() {
             if(scale == 'C' || scale == 'c')
                    return degree;
             else
                    return(((degree - 32) * 5) / 9);
       }

       // Method to return the value of degree in fahrenheit
       public double getDegreeInFahrenheit() {
             if(scale == 'F' || scale == 'f')
                    return degree;
             else
                    return(1.8 * degree + 32);
       }

       // Overloaded setDegree methods
       public void setDegree(double degree) {
             this.degree = degree;
       }

       public void setDegree(char scale) {
             this.scale = scale;
       }

       public void setDegree(double degree, char scale) {
             this.degree = degree;
             this.scale = scale;
       }

       // Returns if temperatures are equal
       public boolean equals(Temperature obj) {
             if(getDegreeInCelsius() == obj.getDegreeInCelsius())
                    return true;
                    
             return false;
       }

       // Returns true if this temperature is less than obj
       public boolean isLessThan(Temperature obj) {
             if(getDegreeInCelsius() < obj.getDegreeInCelsius())
                    return true;

             return false;
       }

       // Returns true if this temperature is greater than obj
       public boolean isGreaterThan(Temperature obj) {
             if(getDegreeInCelsius() > obj.getDegreeInCelsius())
                    return true;

             return false;
       }
    };

    public static void main(String[] args) {
       double degree;
       String scale;

       Scanner input = new Scanner(System.in);

       Temperature temp1 = new Temperature();

       System.out.print("Enter degree for first Temperature object: ");
       degree = input.nextDouble();
       input.nextLine();

       System.out.print("Enter scale(C or F) for first Temperature object: ");
       scale = input.nextLine();

          while(scale.toUpperCase().charAt(0)!= 'C' && scale.toUpperCase().charAt(0) != 'F') {
             System.out.print("Valid values for scale are C and F. Enter scale(C or F) for first Temperature object: ");
             scale = input.nextLine();
          }

       temp1.setDegree(degree, scale.toUpperCase().charAt(0));

       System.out.print("Enter degree for second Temperature object: ");
       degree = input.nextDouble();
       input.nextLine();

       System.out.print("Enter scale(C or F) for second Temperature object: ");
       scale = input.nextLine();

          while(scale.toUpperCase().charAt(0)!= 'C' && scale.toUpperCase().charAt(0) != 'F') {
             System.out.print("Valid values for scale are C and F. Enter scale(C or F) for second Temperature object:");
             scale = input.nextLine();
          }

       Temperature temp2 = new Temperature(degree);
       temp2.setDegree(scale.toUpperCase().charAt(0));

       System.out.print("Enter degree for third Temperature object: ");
       degree = input.nextDouble();
       input.nextLine();

       System.out.print("Enter scale(C or F) for third Temperature object: ");
       scale = input.nextLine();

          while(scale.toUpperCase().charAt(0)!= 'C' && scale.toUpperCase().charAt(0) != 'F') {
             System.out.print("Valid values for scale are C and F. Enter scale(C or F) for third Temperature object: ");
             scale = input.nextLine();
          }

       Temperature temp3 = new Temperature(scale.toUpperCase().charAt(0));
       temp3.setDegree(degree);

       System.out.print("Enter degree for fourth Temperature object: ");
       degree = input.nextDouble();
       input.nextLine();

       System.out.print("Enter scale(C or F) for fourth Temperature object: ");
       scale = input.nextLine();

          while(scale.toUpperCase().charAt(0)!= 'C' && scale.toUpperCase().charAt(0) != 'F') {
             System.out.print("Valid values for scale are C and F. Enter scale(C or F) for fourth Temperature object: ");
             scale = input.nextLine();
          }

       Temperature temp4 = new Temperature(degree,scale.toUpperCase().charAt(0));

       System.out.println("Temperatures: ");
       System.out.println("Celsius: " + temp1.getDegreeInCelsius() + " Fahrenheit: " + temp1.getDegreeInFahrenheit());
       System.out.println("Celsius: " + temp2.getDegreeInCelsius() + " Fahrenheit: " + temp2.getDegreeInFahrenheit());
       System.out.println("Celsius: " + temp3.getDegreeInCelsius() + " Fahrenheit: " + temp3.getDegreeInFahrenheit());
       System.out.println("Celsius: " + temp4.getDegreeInCelsius() + " Fahrenheit: " + temp4.getDegreeInFahrenheit());

          if(temp1.equals(temp2))
             System.out.println("Temperature 1 and Temperature 2 are equal.");
          else
             System.out.println("Temperature 1 and Temperature 2 are not equal.");

          if(temp1.isLessThan(temp2))
             System.out.println("Temperature 1 is less than Temperature 2.");
          else
             System.out.println("Temperature 1 is not less than Temperature 2.");

          if(temp1.isGreaterThan(temp2))
             System.out.println("Temperature 1 is greater than Temperature 2.");
          else
             System.out.println("Temperature 1 is not greater than Temperature 2.");

          if(temp1.equals(temp3))
             System.out.println("Temperature 1 and Temperature 3 are equal.");
          else
             System.out.println("Temperature 1 and Temperature 3 are not equal.");

          if(temp1.isLessThan(temp3))
             System.out.println("Temperature 1 is less than Temperature 3.");
          else
             System.out.println("Temperature 1 is not less than Temperature 3.");

          if(temp1.isGreaterThan(temp3))
             System.out.println("Temperature 1 is greater than Temperature 3.");
          else
             System.out.println("Temperature 1 is not greater than Temperature 3.");

          if(temp1.equals(temp4))
             System.out.println("Temperature 1 and Temperature 4 are equal.");
          else
             System.out.println("Temperature 1 and Temperature 4 are not equal.");

          if(temp1.isLessThan(temp4))
             System.out.println("Temperature 1 is less than Temperature 4.");
          else
             System.out.println("Temperature 1 is not less than Temperature 4.");

          if(temp1.isGreaterThan(temp4))
             System.out.println("Temperature 1 is greater than Temperature 4.");
          else
             System.out.println("Temperature 1 is not greater than Temperature 4.");

          if(temp2.equals(temp3))
             System.out.println("Temperature 2 and Temperature 3 are equal.");
          else
             System.out.println("Temperature 2 and Temperature 3 are not equal.");

          if(temp2.isLessThan(temp3))
             System.out.println("Temperature 2 is less than Temperature 3.");
          else
             System.out.println("Temperature 2 is not less than Temperature 3.");

          if(temp2.isGreaterThan(temp3))
             System.out.println("Temperature 2 is greater than Temperature 3.");
          else
             System.out.println("Temperature 2 is not greater than Temperature 3.");

          if(temp2.equals(temp4))
             System.out.println("Temperature 2 and Temperature 4 are equal.");
          else
             System.out.println("Temperature 2 and Temperature 4 are not equal.");

          if(temp2.isLessThan(temp4))
             System.out.println("Temperature 2 is less than Temperature 4.");
          else
             System.out.println("Temperature 2 is not less than Temperature 4.");

          if(temp2.isGreaterThan(temp4))
             System.out.println("Temperature 2 is greater than Temperature 4.");
          else
             System.out.println("Temperature 2 is not greater than Temperature 4.");

          if(temp3.equals(temp4))
             System.out.println("Temperature 3 and Temperature 4 are equal.");
          else
             System.out.println("Temperature 3 and Temperature 4 are not equal.");

          if(temp3.isLessThan(temp4))
             System.out.println("Temperature 3 is less than Temperature 4.");
          else
             System.out.println("Temperature 3 is not less than Temperature 4.");     

          if(temp3.isGreaterThan(temp4))
             System.out.println("Temperature 3 is greater than Temperature 4.");
          else
             System.out.println("Temperature 3 is not greater than Temperature 4.");

       input.close();

    }
}
