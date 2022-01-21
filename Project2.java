/**
 * Course: TCSS142 - Introduction to Object-Oriented Programming
 * File Name: Project2.java
 * Assignment: 2
 * Due Date: 2021/11/09
 * Instructor: Mr. Schuessler
 * 
 */

 import java.util.Scanner;

 /**
  * Based on a user input value for the number of employeees to process,
  * this program will also prompt the user for each employee's hours
  * worked, hourly pay rate, and name.
  *
  * @author Charmaine Dacones
  * @version 2021/11/03
  */
public class Project2 {
    /**
     * This method creates a Scanner object and passes the object to two
     * methods.
     * 
     * @param theArgs
     */
    public static void main(String[] theArgs) {
        Scanner console = new Scanner(System.in);
        int totalEmployees = getEmployeeCnt(console);
        processEmployeePay(console, totalEmployees);
    }


    /**
     * This method prompts the user to enter the number of employees
     * then returns the value.
     * 
     * @param theConsole
     * @return returns an integer to main() as the number of
     * employees
     */
    public static int getEmployeeCnt(Scanner theConsole) {
        System.out.print("How many employees are there? ");
        return theConsole.nextInt();
    }


    /**
     * This method prompts the user for different inputs, processes
     * the information then displays the results.
     * 
     * @param theCon
     * @param theEmployees
     */
    public static void processEmployeePay(Scanner theCon, int theEmployees) {
        double topHours = 0.0;
        String topName = "";

        // Based on the number of employees the user enters, each employee
        // is prompted for specific information.
        for (int employee = 1; employee <= theEmployees; employee++) {
            System.out.print("Enter Hours Worked, Pay Rate, and Employee ");
            System.out.print("name separated by a space: ");
            double workHours = theCon.nextDouble();
            double payRate = theCon.nextDouble();
            String employeeName = theCon.next() + " " + theCon.next();
            if (workHours > topHours) {
                topHours = workHours;
                topName = employeeName;
            }
            double gross = getGrossPay(workHours, payRate);
            displayEmployeePay(employeeName, workHours, payRate, gross);
        }
        displayTopEmployee(topHours, topName);
    }


    /**
     * This method receives the employee's total work hours and pay
     * rate, then returns the gross pay.
     * 
     * @param theWorkHours
     * @param thePayRate
     * @return returns a double to main() as the grossPay
     */
    public static double getGrossPay(double theWorkHours, double thePayRate) {
        double grossPay = 0.0;
        if (theWorkHours > 48) {
            grossPay = ((theWorkHours - 48.0) * 2 * thePayRate);

            // theWorkHours is reassigned the value of 48 to test true
            // for the next if statement
            theWorkHours = 48;
        }
        if (theWorkHours > 40 && theWorkHours <= 48) {
            grossPay += ((theWorkHours - 40) * 1.5 * thePayRate);

            // theWorkHours is reassigned the value of 40 to test true
            // for the next if statement
            theWorkHours = 40;
        }
        if (theWorkHours <= 40) {
            grossPay += (theWorkHours * thePayRate);
        }
        return grossPay;
    }


    /**
     * This method displays the employee's information.
     * 
     * @param theName
     * @param theHours
     * @param thePay
     */
    public static void displayEmployeePay(String theName, double theHours,
                                          double thePay, double theGross) {
        System.out.printf("%27s", "Employee Name: ");
        System.out.println(theName);
        System.out.printf("%27s", "Hours Worked: ");
        System.out.printf("%13.2f\n", theHours);
        System.out.printf("%27s", "Pay Rate: ");
        System.out.printf("%13.2f\n", thePay);
        System.out.printf("%27s", "Gross Pay: ");
        System.out.printf("%13.2f\n", theGross);
        System.out.println();
    }


    /**
     * This method displays one of four messages based on the top
     * employee's work hours.
     * 
     * @param theTopHours
     * @param theTopEmployee
     */
    public static void displayTopEmployee(double theTopHours, String
                                          theTopEmployee) {
        if (theTopHours > 56) {
            System.out.printf("WOW!!! What a Dynamo! " + theTopEmployee);
            System.out.printf(" Worked %.2f Hours this WEEK!", theTopHours);
        } else if (theTopHours > 48 && theTopHours <= 56) {
            System.out.print(theTopEmployee + " is Such a WorkHorse! ");
            System.out.printf("Looks Like You Worked %.2f", theTopHours);
            System.out.println(" Hours this WEEK!");
        } else if (theTopHours > 40 && theTopHours <= 48) {
            System.out.print("Well, Good For YOU" + theTopEmployee);
            System.out.print(", Who Worked %.2f " + theTopHours + " Hours ");
            System.out.println(" this WEEK!");
        } else if (theTopHours < 40) {
            System.out.print("Most hours but no one worked over 40: ");
            System.out.print(theTopEmployee + " Worked " + theTopHours);
            System.out.printf("%.2f", theTopHours);
            System.out.println(" Hours this WEEK!");
        }
    }
}
 