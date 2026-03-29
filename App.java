/*
 * Name: Dustin Pulu
 * Date: March 29, 2026
 * Assignment: SDC230 Week 4 PA - Account Balance Calculations
 * This program uses a user-defined exception to prevent
 * the account balance from becoming negative while processing credits
 * and debits entered by the user
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    // User-defined exception inside the same file
    static class NegativeBalanceException extends Exception {
        public NegativeBalanceException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Dustin Pulu - Week 4 PA Account Balance Calculations");
        System.out.println();

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the starting balance: ");
        double balance = input.nextDouble();

        double amount = 0.0;

        do {
            try {
                System.out.print("Please enter a credit or debit amount (0 to quit): ");
                amount = input.nextDouble();

                if (amount == 0) {
                    break;
                }

                if (balance + amount < 0) {
                    throw new NegativeBalanceException("Amount entered will cause account to be negative.");
                }

                balance += amount;
                System.out.printf("The updated balance is: %.2f%n%n", balance);

            } catch (InputMismatchException e) {
                System.out.println(e);
                System.out.println("Please enter a numeric value.");
                input.nextLine();
                System.out.println();

            } catch (NegativeBalanceException e) {
                System.out.println(e);
                System.out.println();
            }

        } while (amount != 0);

        System.out.printf("The updated balance is: %.2f%n", balance);

        input.close();
    }
}