package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.io.IOException;


public class DealershipFileManager {

    public Dealership getDealership() {
        Dealership dealership = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("dealership.csv"));
            String line;

            if ((line = br.readLine()) != null) {
                String[] dealerInfo = line.split(",");
                String name = dealerInfo[0];
                String address = dealerInfo[1];
                String phone = dealerInfo[2];

                dealership = new Dealership(name, address, phone);
            }

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; // skip empty lines
                }
                String[] parts = line.split("\\|");
                if (parts.length != 5) {
                    System.out.println("Skipping bad line: " + line);
                    continue; // skip invalid lines
                }
                int vin = Integer.parseInt(parts[0]);
                String make = parts[1];
                int year = Integer.parseInt(parts[2]);
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);


                Vehicle vehicle = new Vehicle(vin, make, year, model, vehicleType, color, odometer, price);
                dealership.addVehicle(vehicle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dealership;
    }


        public void saveDealership (Dealership dealership){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("dealership.csv"))) {
                writer.write(dealership.getName() + "," + dealership.getAddresss() + "," + dealership.getPhone());
                writer.newLine();

                for(Vehicle vehicle : dealership.getAllVehicles()){
                    String line = vehicle.getVin() + "|" +
                            vehicle.getMake() + "|" +
                            vehicle.getYear() + "|" +
                            vehicle.getModel() + "|" +
                            vehicle.getVehicleType() + "|" +
                            vehicle.getColor() + "|" +
                            vehicle.getOdometer() + "|" +
                            vehicle.getPrice();

                    writer. write(line);
                    writer.newLine();

                }
            }
            catch (Exception e){
                System.out.println("Error saving dealership: " + e.getMessage());

            }
        }

}
