package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DealershipFileManager {

    public Dealership loadDealership(String name, String address, String phone) {

        Dealership dealership = new Dealership(name, address, phone);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("dealership.csv"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] parts = line.split("\\|");

                String vin = parts[0].trim();
                int year = Integer.parseInt(parts[1].trim());
                String make = parts[2].trim();
                String model = parts[3].trim();
                String type = parts[4].trim();
                String color = parts[5].trim();
                int odometer = Integer.parseInt(parts[6].trim());
                double price = Double.parseDouble(parts[7].trim());

                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                dealership.addVehicle(vehicle);
            }
        } catch (Exception e) {
            System.out.println("An error has occurred!");
            e.printStackTrace();
        }

        return dealership;
    }

    public void saveVehicleToFile(Vehicle vehicle) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dealership.csv", true))) {
            writer.write(vehicle.getVin() + "|" +
                    vehicle.getYear() + " | " +
                    vehicle.getMake() + " | " +
                    vehicle.getModel() + " | " +
                    vehicle.getType() + " | " +
                    vehicle.getColor() + " | " +
                    vehicle.getOdometer() + " | " +
                    vehicle.getPrice());
            writer.newLine();
        } catch (Exception e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
}