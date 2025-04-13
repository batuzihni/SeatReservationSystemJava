package com.mycompany.cosc005w_mock_planeapp;

import java.util.Scanner;

public class App {

    // Global variables
    private static int[][] planeSeats = null;
    private static int[] pricePerRow = null;

    // Global Payment Variable
    private static Payment[] payments = new Payment[75]; // Store multiple numbers
    private static int paymentCount = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to Flying Java!");
        initialiseRows();
        runMenu();
    }

    public static void initialiseRows() {
        planeSeats = new int[4][];
        planeSeats[0] = new int[16];
        planeSeats[1] = new int[22];
        planeSeats[2] = new int[22];
        planeSeats[3] = new int[16];
        pricePerRow = new int[4];
        pricePerRow[0] = 50;
        pricePerRow[1] = 80;
        pricePerRow[2] = 80;
        pricePerRow[3] = 50;
    }

    public static void runMenu() {
        int option;
        boolean cont = true;

        while (cont) {
            option = getOption();
            switch (option) {
                case 0:
                    cont = false;
                    break;
                case 1:
                    buyTicket();
                    break;
                case 2:
                    showSeatingArea();
                    break;
                case 3:
                    showAllPayments();
                    break;
                default:
                    System.out.println("Option not available. Please select a valid option: ");
            }
        }
    }

    private static int getOption() {
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        int option = -1;
        do {
            System.out.println();
            System.out.println("+---------------------------------------------+");
            System.out.println("|                MAIN MENU                    |");
            System.out.println("+---------------------------------------------+");
            System.out.println("|  1) Buy a plane ticket                      |");
            System.out.println("|  2) Show seating area and available seats   |");
            System.out.println("|  3) Show all payments                       |");
            System.out.println("|  0) Quit                                    |");
            System.out.println("+---------------------------------------------+");
            System.out.print("Please select an option: ");
            try {
                option = input.nextInt();
                valid = true;
            } catch (Exception e) {
                System.out.println("This option not valid.");
                input.nextLine(); // clear invalid input
            }
        } while (!valid);
        return option;
    }

    private static void buyTicket() {
        Scanner input = new Scanner(System.in);

        System.out.println("Each seat in row 1 costs $50.");
        System.out.println("Each seat in row 2 costs $80.");
        System.out.println("Each seat in row 3 costs $80.");
        System.out.println("Each seat in row 4 costs $50.");

        System.out.print("Enter row number: ");
        int row = input.nextInt() - 1;
        while (row < 0 || row >= 4) {
            System.out.println("ERROR! There are only 4 rows available. Please try again...");
            System.out.print("Enter row number: ");
            row = input.nextInt() - 1;
        }

        System.out.print("Enter seat number: ");
        int seat = input.nextInt() - 1;
        if (row == 0 || row == 3) {
            while (seat < 0 || seat >= 16) {
                System.out.println("ERROR! There are only 16 seats in this row. Please try again...");
                System.out.print("Enter seat number: ");
                seat = input.nextInt() - 1;
            }
        } else {
            while (seat < 0 || seat >= 22) {
                System.out.println("ERROR! There are only 22 seats in this row. Please try again...");
                System.out.print("Enter seat number: ");
                seat = input.nextInt() - 1;
            }
        }

        input.nextLine(); // consume newline
        System.out.print("Enter your email: ");
        String userEmail = input.nextLine();

        int paymentAmount;
        if (row == 0 || row == 3) {
            paymentAmount = 50;
        } else {
            paymentAmount = 80;
        }

        // Check if the seat is available
        if (planeSeats[row][seat] == 0) {
            planeSeats[row][seat] = 1;
            Payment newPayment = new Payment(userEmail, paymentAmount);
            payments[paymentCount] = newPayment;
            paymentCount++;

            System.out.println("Purchase successful.");
            showSeatingArea();
            newPayment.printPayment(); // ✅ payment details
        } else {
            System.out.println("This seat is already taken.");
        }
    }

    private static void showSeatingArea() {
        int rows = planeSeats.length;
        char aisle = '|';

        System.out.println("=".repeat(76));
        System.out.println("                              PLANE SEATING MAP ");
        System.out.println("=".repeat(76));

        for (int row = 0; row < rows; row++) {
            System.out.print("Row " + (row + 1) + "(£" + pricePerRow[row] + ")  ");
            int seatsPerRow = planeSeats[row].length;
            for (int seat = 0; seat < seatsPerRow; seat++) {
                if (seat == 9) {
                    System.out.print(" " + aisle + " ");
                }
                if (planeSeats[row][seat] == 0) {
                    System.out.print("[O]");
                } else {
                    System.out.print("[X]");
                }
            }
            System.out.println();
        }
        System.out.println("=".repeat(76));
        System.out.println("LEGEND: [O] = Seat available, [X] = Seat not available, | = Aisle");
        System.out.println("=".repeat(76));
        System.out.println();
    }

    private static void showAllPayments() {
        if (paymentCount == 0) {
            System.out.println("No payments made yet.");
        } else {
            System.out.println("List of all payments:");
            for (int i = 0; i < paymentCount; i++) {
                payments[i].printPayment();
            }
        }
    }
}
