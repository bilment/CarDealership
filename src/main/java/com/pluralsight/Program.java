package com.pluralsight;

public class Program {
    public static void main(String[] args) {
        DealershipFileManager fileManager = new DealershipFileManager();
        Dealership dealership = fileManager.loadDealership("Car World", "123 Main St", "555-123-4567");

        UserInterface userInterface = new UserInterface(dealership);
        userInterface.showMenu();
    }
}