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
        boolean running = true;

        while (running) {
            System.out.println("Welcome to " + dealership.getName() + " Dealership!");
            System.out.println("1. List all vehicles");
            System.out.println("2. Search vehicles by make/model");
            System.out.println("3. Find vehicle by year range");
            System.out.println("4. Update vehicle details");
            System.out.println("5. Reserve a vehicle for a customer");
            System.out.println("6. Check and update vehicle service status");
            System.out.println("8. Add a new vehicle");
            System.out.println("99. Exit");
            System.out.print("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume next line

            switch (choice) {
                case 1:
                    listingVehicles();
                    break;
                case 2:
                    searchByMakeAndModel();
                    break;
                case 8:
                    addNewVehicle();
                    break;
                case 4:
                    updateVehicleDetails();
                    break;
                case 5:
                    reserveVehicle();
                    break;
                case 6:
                    checkAndUpdateServiceStatus();
                    break;
                case 99:
                    System.out.println("Exiting the program");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input, try again");
            }
        }
    }

    private void listingVehicles() {

        System.out.println("Listing all vehicles:");

        dealership.displayInventory();
    }

    private void searchByMakeAndModel() {
        System.out.print("Enter the make of the vehicle to search: ");
        String make = scanner.nextLine();

        System.out.print("Enter the model of the vehicle to search: ");
        String model = scanner.nextLine();

        List<Vehicle> results = dealership.searchByMakeAndModel(make, model);

        if (results.isEmpty()) {
            System.out.println("No vehicles found for make: " + make + " and model: " + model);
        } else {
            System.out.println("Vehicles found:");
            for (Vehicle vehicle : results) {
                System.out.println(vehicle);
            }
        }
    }

    private void addNewVehicle() {
        System.out.print("Enter VIN: ");
        String vin = scanner.nextLine();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();  // consume next line

        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        System.out.print("Enter type: ");
        String type = scanner.nextLine();

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        System.out.print("Enter odometer reading: ");
        int odometer = scanner.nextInt();
        scanner.nextLine();  // consume next line

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();  // consume next line

        Vehicle newVehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(newVehicle);

        System.out.println("New vehicle added!");
    }

    private void findVehiclesByYearRange() {
        System.out.print("Enter the minimum year: ");
        int minYear = scanner.nextInt();
        System.out.print("Enter the maximum year: ");
        int maxYear = scanner.nextInt();
        scanner.nextLine(); // Satır sonunu temizlemek için

        List<Vehicle> results = dealership.findVehiclesByYearRange(minYear, maxYear);

        if (results.isEmpty()) {
            System.out.println("No vehicles found in the year range " + minYear + " - " + maxYear);
        } else {
            System.out.println("Vehicles found in the year range " + minYear + " - " + maxYear + ":");
            for (Vehicle vehicle : results) {
                System.out.println(vehicle);
            }
        }
    }

    private void updateVehicleDetails() {

    }

    private void reserveVehicle() {

    }

    private void checkAndUpdateServiceStatus() {

    }
}
