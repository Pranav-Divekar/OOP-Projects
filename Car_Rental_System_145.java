import java.io.*;
import java.util.*;

// Vehicle class as the base class for Car and Truck
class Vehicle implements Serializable {
    private int vehicleId;
    private String model;
    private String make;
    private int year;
    private double rentalCostPerDay;
    private boolean isAvailable;

    public Vehicle(int vehicleId, String model, String make, int year, double rentalCostPerDay) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.make = make;
        this.year = year;
        this.rentalCostPerDay = rentalCostPerDay;
        this.isAvailable = true;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public double getRentalCostPerDay() {
        return rentalCostPerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return make + " " + model + " (" + year + ")";
    }
}

// Car class inheriting from Vehicle
class Car extends Vehicle {
    public Car(int vehicleId, String model, String make, int year, double rentalCostPerDay) {
        super(vehicleId, model, make, year, rentalCostPerDay);
    }

    @Override
    public String toString() {
        return super.toString() + " - Car";
    }
}

// Truck class inheriting from Vehicle
class Truck extends Vehicle {
    public Truck(int vehicleId, String model, String make, int year, double rentalCostPerDay) {
        super(vehicleId, model, make, year, rentalCostPerDay);
    }

    @Override
    public String toString() {
        return super.toString() + " - Truck";
    }
}

// Customer class
class Customer implements Serializable {
    private int customerId;
    private String name;
    private String email;
    private String phone;

    public Customer(int customerId, String name, String email, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name;
    }
}

// RentalSystem class managing rental operations
class RentalSystem implements Serializable {
    private List<Vehicle> vehicles;
    private List<Customer> customers;
    private Map<Integer, Map<String, Object>> rentedVehicles;

    public RentalSystem() {
        vehicles = new ArrayList<>();
        customers = new ArrayList<>();
        rentedVehicles = new HashMap<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public String rentVehicle(int customerId, int vehicleId, int days) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId() == vehicleId && vehicle.isAvailable()) {
                double totalCost = days * vehicle.getRentalCostPerDay();
                vehicle.setAvailable(false);
                Map<String, Object> rentalInfo = new HashMap<>();
                rentalInfo.put("vehicle", vehicle);
                rentalInfo.put("days", days);
                rentalInfo.put("totalCost", totalCost);
                rentedVehicles.put(customerId, rentalInfo);
                return vehicle.toString() + " rented successfully for " + days + " days. Total Cost: " + totalCost;
            }
        }
        return "Vehicle not available or ID incorrect.";
    }

    public String returnVehicle(int customerId) {
        if (rentedVehicles.containsKey(customerId)) {
            Vehicle rentedVehicle = (Vehicle) rentedVehicles.get(customerId).get("vehicle");
            rentedVehicle.setAvailable(true);
            rentedVehicles.remove(customerId);
            return rentedVehicle.toString() + " returned successfully.";
        }
        return "Customer ID not found in rented vehicles.";
    }

    public void saveData(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(vehicles);
            oos.writeObject(customers);
            oos.writeObject(rentedVehicles);
        }
    }

    public void loadData(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            vehicles = (List<Vehicle>) ois.readObject();
            customers = (List<Customer>) ois.readObject();
            rentedVehicles = (Map<Integer, Map<String, Object>>) ois.readObject();
        }
    }

    public void displayAvailableVehicles() {
        System.out.println("Available Vehicles:");
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                System.out.println(vehicle);
            }
        }
    }
}

// Main class to test the car rental system
public class Car_Rental_System_145 {
    public static void main(String[] args) {
        RentalSystem system = new RentalSystem();

        Car car1 = new Car(1, "Camry", "Toyota", 2022, 50);
        Truck truck1 = new Truck(2, "F-150", "Ford", 2023, 60);
        system.addVehicle(car1);
        system.addVehicle(truck1);

        Customer customer1 = new Customer(1, "John Doe", "john@example.com", "123-456-7890");
        system.addCustomer(customer1);

        try {
            system.displayAvailableVehicles();
            System.out.println(system.rentVehicle(1, 1, 5));  // Renting car1 for 5 days
            System.out.println(system.returnVehicle(1));      // Returning car1

            system.saveData("rental_data.ser");  // Saving data to a file

            // After restarting the program or loading data from a saved file
            RentalSystem system2 = new RentalSystem();
            system2.loadData("rental_data.ser");

            System.out.println(system2.rentVehicle(1, 2, 3));  // Renting truck1 for 3 days
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
