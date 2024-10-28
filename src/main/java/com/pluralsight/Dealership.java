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

    public List<Vehicle> searchByMake(String make) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make)) {
                results.add(vehicle);
            }
            
        }
        return results;
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
