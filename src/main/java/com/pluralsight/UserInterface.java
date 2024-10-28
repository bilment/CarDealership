package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner;

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
        this.scanner = new Scanner(System.in);

    }

    public void showMenu() {
        boolean running =true;

        while (running) {
            System.out.println("Welcome to " + dealership.getName() + " Dealership!");
            System.out.println("1. List all vehicles");
            System.out.println("2. Search vehicles by make");
            System.out.println("3. Exit");
            System.out.print("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume next line

            switch (choice) {
                case 1:
                    listAllVehicles();
                    break;
                case 2:
                    searchByMake();
                    break;
                case 3:
                    System.out.println("Exiting the program");
                    break;
                default:
                    System.out.println("Invalid input, try again");
            }
        }
    }

    private void listAllVehicles() {

        System.out.println("Listing all vehicles:");

        dealership.displayInventory();
    }

    private void searchByMake() {

        System.out.print("Enter the make of the vehicle to search: ");

        String make = scanner.nextLine();
        List<Vehicle> results = dealership.searchByMake(make);

        if (results.isEmpty()) {
            System.out.println("There is no result for make: " + make);
        } else {
            System.out.println("Vehicle found:");
            for (Vehicle vehicle : results) {
                System.out.println(vehicle);
            }
        }
    }
}
