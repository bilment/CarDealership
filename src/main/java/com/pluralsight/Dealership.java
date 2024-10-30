package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void displayInventory() {
        for (Vehicle vehicle : inventory) {
            System.out.println(vehicle);
            
        }
    }

    public List<Vehicle> searchByMakeAndModel(String make, String model) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                results.add(vehicle);
            }
        }
        return results;
    }

    public List<Vehicle> findVehiclesByYearRange(int minYear, int maxYear) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear) {
                results.add(vehicle);
            }
        }
        return results;
    }

    public List<Vehicle> findVehiclesByColor(String color) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                results.add(vehicle);
            }
        }
        return results;
    }

    public List<Vehicle> findVehiclesByMileageRange(int minMileage, int maxMileage) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= minMileage && vehicle.getOdometer() <= maxMileage) {
                results.add(vehicle);
            }
        }
        return results;
    }

    public List<Vehicle> findVehiclesByType(String type) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getType().equalsIgnoreCase(type)) {
                results.add(vehicle);
            }
        }
        return results;
    }

    public boolean removeVehicleByVin(String vin) {
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVin().equalsIgnoreCase(vin)) {
                inventory.remove(vehicle);
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
