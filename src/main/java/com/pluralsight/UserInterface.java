package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;
public class UserInterface {

private DealershipFileManager dealership;
private Dealership dealership1;

    public void display(){
        init();
            Scanner scanner = new Scanner(System.in);
            boolean running = true;
       while(running){


           System.out.println("Enter your choice: ");
           String input = scanner.nextLine();

           switch (input){
               case "1":
                   processGetByPriceRequest();
                   break;

               case "2":
                   processGetByMakeModelRequest();
                   break;
               case "3":
                   processGetByYearRequest();
                   break;
               case "4":
                   processGetByColorRequest();
                   break;
               case "5":
                   processGetByMileageRequest();
                   break;
               case "6":
                   processGetByVehicleTypeRequest();
                   break;
               case "7":
                   processGetAllVehicleRequest();
                   break;
               case "8":
                   processAddVehicleRequest();
                   break;
               case "9":
                   processRemoveVehicleRequest();
                   break;
               case "0":
                   System.out.println("Goodbye!");
                   running = false;
                   break;
               default:
                   System.out.println("Invalid choice. Please try again");
           }

    }

    }

    public void displayMenu(){
        System.out.println("\n ******* Dealership Menu *******");
        System.out.println("1. View All Vehicles");
        System.out.println("2. Search By Price");
        System.out.println("3. Search by Make/Model");
        System.out.println("4. Search by Year");
        System.out.println("5. Search by Color");
        System.out.println("6. Search by Mileage");
        System.out.println("7. Search by Vehicle Type");
        System.out.println("8. Add a Vehicle");
        System.out.println("9. Remove a Vehicle");
        System.out.println("0. Quit");
    }


    private void init(){
        dealership1 = dealership.getDealership();
        dealership = new DealershipFileManager();
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles){
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

    }

    public void processGetByPriceRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the lowest price you want to search for: ");
        double price1 = scanner.nextDouble();
        System.out.println("Enter the highest price you want to search for: ");
        double price2 = scanner.nextDouble();
        ArrayList<Vehicle> results = dealership.getDealership().getVehiclesByPrice(price1, price2);

        displayVehicles(results);
    }

    public void processGetByMakeModelRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter make you want to search for: ");
       String make = scanner.nextLine();
        System.out.println("Enter the model you want to search for: ");
        String model = scanner.nextLine();
        ArrayList<Vehicle> results = dealership.getDealership().getVehicleByMakeModel(make, model);

        displayVehicles(results);
    }

    public void processGetByYearRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter earliest model year to include: ");
        int minYear = scanner.nextInt();
        System.out.println("Enter the latest model year to include: ");
        int maxYear = scanner.nextInt();
        ArrayList<Vehicle> results = dealership.getDealership().getVehicleByYear(minYear, maxYear);

        displayVehicles(results);
    }

    public void processGetByColorRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter color your want to search for: ");
        String color = scanner.nextLine();
        ArrayList<Vehicle> results = dealership.getDealership().getVehicleByColor(color);

        displayVehicles(results);
    }

    public void processGetByMileageRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter car minimum mileage your want to search for: ");
        double minMileage = scanner.nextDouble();
        System.out.println("Enter car maximum mileage your want to search for: ");
        double maxMileage = scanner.nextDouble();
        ArrayList<Vehicle> results = dealership.getDealership().getVehicleByMileage(minMileage, maxMileage);

        displayVehicles(results);
    }

    public void processGetByVehicleTypeRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter car type your want to search for: ");
        String type = scanner.nextLine();
        ArrayList<Vehicle> results = dealership.getDealership().getVehicleByType(type);

        displayVehicles(results);
    }

    public void processGetAllVehicleRequest(){
        for (Vehicle v : dealership1.getAllVehicles()) {
            System.out.println(v);
        }
    }

    public void processAddVehicleRequest(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter VIN number: ");
        int vin = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Make: ");
        String make = scanner.nextLine();

        System.out.print("Enter Model: ");
        String model = scanner.nextLine();

        System.out.print("Enter Year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Vehicle Type: ");
        String type = scanner.nextLine();

        System.out.print("Enter Color: ");
        String color = scanner.nextLine();

        System.out.print("Enter Odometer Reading: ");
        int odometer = scanner.nextInt();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        Vehicle newVehicle = new Vehicle(vin,make,year,model,type, color,odometer,price);
        dealership1.addVehicle(newVehicle);


    }

    public void processRemoveVehicleRequest(){
        Vehicle toRemove = null;

        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehicle> results = dealership1.getAllVehicles();

        System.out.print("Enter VIN number: ");
        int vin = Integer.parseInt(scanner.nextLine());
        for (Vehicle vehicle : results) {
            if(vin == vehicle.getVin()){
                toRemove = vehicle;
                break;
            }
        }
        if(toRemove != null){
            dealership1.removeVehicle(toRemove);
            dealership.saveDealership(dealership1);
            System.out.println("Vehicle removed successfully");
        } else{
            System.out.println("Vehicel with a vin " + vin + " not found");
        }


        
    }



}
