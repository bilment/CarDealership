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
            System.out.println("4. Find vehicle by color");
            System.out.println("5. Find vehicle by mileage range");
            System.out.println("6. Find vehicle by type (car, truck, SUV, van)");
            System.out.println("7. Add a new vehicle");
            System.out.println("8. Remove a vehicle");
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
                case 3:
                    findVehiclesByYearRange();
                    break;
                case 4:
                    findVehiclesByColor();
                    break;
                case 5:
                    findVehiclesByMileageRange();
                case 6:
                    findVehiclesByType();
                    break;
                case 7:
                    addNewVehicle();
                    break;
                case 8:
                    removeVehicle();
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

        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveVehicleToFile(newVehicle);


        System.out.println("New vehicle added!");
    }

    private void findVehiclesByYearRange() {
        System.out.print("Enter the minimum year: ");
        int minYear = scanner.nextInt();
        System.out.print("Enter the maximum year: ");
        int maxYear = scanner.nextInt();
        scanner.nextLine();

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

    private void findVehiclesByColor() {
        System.out.print("Enter the color of the vehicle to search: ");
        String color = scanner.nextLine();

        List<Vehicle> results = dealership.findVehiclesByColor(color);

        if (results.isEmpty()) {
            System.out.println("No vehicles found with color: " + color);
        } else {
            System.out.println("Vehicles found with color: " + color);
            for (Vehicle vehicle : results) {
                System.out.println(vehicle);
            }
        }
    }

    private void findVehiclesByMileageRange() {
        System.out.print("Enter the minimum mileage: ");
        int minMileage = scanner.nextInt();
        System.out.print("Enter the maximum mileage: ");
        int maxMileage = scanner.nextInt();
        scanner.nextLine();

        List<Vehicle> results = dealership.findVehiclesByMileageRange(minMileage, maxMileage);

        if (results.isEmpty()) {
            System.out.println("No vehicles found in the mileage range " + minMileage + " - " + maxMileage + " km");
        } else {
            System.out.println("Vehicles found in the mileage range " + minMileage + " - " + maxMileage + " km:");
            for (Vehicle vehicle : results) {
                System.out.println(vehicle);
            }
        }
    }

    private void findVehiclesByType() {
        System.out.print("Enter the type of vehicle to search (e.g., car, truck, SUV, van): ");
        String type = scanner.nextLine();

        List<Vehicle> results = dealership.findVehiclesByType(type);

        if (results.isEmpty()) {
            System.out.println("No vehicles found of type: " + type);
        } else {
            System.out.println("Vehicles found of type: " + type);
            for (Vehicle vehicle : results) {
                System.out.println(vehicle);
            }
        }
    }

    private void removeVehicle() {
        System.out.print("Enter the VIN of the vehicle to remove: ");
        String vin = scanner.nextLine();

        boolean success = dealership.removeVehicleByVin(vin);

        if (success) {
            System.out.println("Vehicle with VIN " + vin + " has been removed from the inventory.");
        } else {
            System.out.println("Vehicle with VIN " + vin + " was not found in the inventory.");
        }
    }
}
