package nl.project;

public class PointSystem {

    //TODO
    //Make methods to convert KM per vehicle to points, getters and setters (to database as well).


    // Method to convert KMs to in App points
    public int convertToPoints(String transport){

        if(transport.contains("GasolineCar")){
            return transport.getTotalKM() * 0.25;
        }
        else if(transport.contains("DieselCar")){
            return transport.getTotalKM() * 0.30;
        }
        else if(transport.contains("ElectricCar")){
            return transport.getTotalKM() * 0.8;
        }
        else if(transport.contains("PublicTransport")){
            return transport.getTotalKM() * 0.50;
        }
        else if(transport.contains("HybridCar")){
            return transport.getTotalKM() * 0.45;
        }
        else if(transport.contains("Bicycle")){
            return transport.getTotalKM() * 1.05;
        }
        else if(transport.contains("Bicycle")){
            return transport.getTotalKM() * 1.5;
        }
        else{
            System.out.println("Cannot get vehicle category");
            return 0;
        }
    }

}
