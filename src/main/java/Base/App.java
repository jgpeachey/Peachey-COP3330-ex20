/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 John Peachey
 */

package Base;

/*
Create a tax calculator that handles multiple states and multiple counties
within each state. The program prompts the user for the order amount and the
state where the order will be shipped.

*Wisconsin residents must be changed 5% sales tax with an additional
county-level charge. For Wisconsin residents, prompt for the county of
residence.
*For Eau Claire county residents, add an additional 0.005 tax.
*For Dunn county residents, add an additional 0.004 tax.
*Illinois residents must be charged 8% sales tax with no additional
county-level charge.
*All other states are not charged tax.
*The program then displays the tax and the total for Wisconsin and Illinois
residents but just the total for everyone else.

Example Output:
What is the order amount? 10
What state do you live in? Wisconsin
What county do you live in? Dane
The tax is $0.50.
The total is $10.50.

Constraints:
*Ensure that all money is rounded up to the nearest cent.
*Use a single output statement at the end of the program to display the
program results.

Challenges:
*Add support for your state and county.
*Allow the user to enter a state abbreviation and county name in upper,
lower, or mixed case.
*Allow the user to also enter the state’s full name in upper, lower, or
mixed case.
*Implement the program using data structures to avoid nested if statements.
 */

import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        boolean taxed = true;
        double tax = 0;
        double total = 0;

        System.out.println("What is the order amount? ");
        double amount = in.nextDouble();
        System.out.println("What state do you live in? ");
        String state = in.next();
        System.out.println("What county do you live in? ");
        String county = in.next();

        if (state.equalsIgnoreCase("Wisconsin")){
            if (county.equalsIgnoreCase("Eau Claire")){
                tax = Math.round(0.055*amount*100.0)/100.0;
                total = amount+tax;
            }
            else if (county.equalsIgnoreCase("Dunn")){
                tax = Math.round(0.054*amount*100.0)/100.0;
                total = amount+tax;
            }
            else{
                tax = Math.round(0.05*amount*100.0)/100.0;
                total = amount+tax;
            }
        }
        else if (state.equalsIgnoreCase("Illinois")){
            tax = Math.round(0.08*amount*100.0)/100.0;
            total = amount+tax;
        }
        else{
            taxed = false;
            total = amount;
        }

        String output = taxed ? "The tax is $"+tax+".\nThe total is $"+total+"." : "The total is $"+total+".";
        System.out.println(output);
    }
}
