package com.pluralsight;

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

    private void displayVehicles(){
        return;
    }

    public void processGetByPriceRequest(){}

    public void processGetByMakeModelRequest(){}

    public void processGetByYearRequest(){}

    public void processGetByColorRequest(){}

    public void processGetByMileageRequest(){}

    public void processGetByVehicleTypeRequest(){}

    public void processGetAllVehicleRequest(){
        for (Vehicle v : dealership1.getAllVehicles()) {
            System.out.println(v);
        }
    }

    public void processAddVehicleRequest(){}

    public void processRemoveVehicleRequest(){}



}
