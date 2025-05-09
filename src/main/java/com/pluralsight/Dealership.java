package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;
public class Dealership {
    private String name;
    private String addresss;
    private String phone;


    public Dealership(String name, String addresss, String phone) {
        this.name = name;
        this.addresss = addresss;
        this.phone = phone;
        ArrayList<String> arrayList = new ArrayList<>();

    }
    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max){
        return null;
    }

    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model){
        return null;
    }

    public ArrayList<Vehicle> getVehicleByYear(double min, double max){
        return null;
    }

    public ArrayList<Vehicle> getVehicleByColor(String color){

        return null;
    }

    public ArrayList<Vehicle> getVehicleByMileage(double min, double max){

        return null;
    }

    public ArrayList<Vehicle> getVehicleByType(String vehicleType){

        return null;
    }

    public ArrayList<Vehicle> getAllVehicles(){

        return null;
    }

    public void addVehicle(Vehicle vehicle){

    }

    public void removeVehicle(Vehicle vehicle){

    }



}
