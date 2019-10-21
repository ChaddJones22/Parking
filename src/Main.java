import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ParkingLot pl = new ParkingLot(3);
        int j=0;

        for(int i=0;i<1;i++){
        System.out.println("Enter Plate ID.");
        String plateID = scan.next();
        CarsInLot car = new CarsInLot(plateID);
        pl.EnteringLot(car);}


        while (j != pl.getCarsParked()){
            System.out.println("Enter ticket (Car ID): ");
            int carID = scan.nextInt();
            pl.ExitingLot(carID);}
    }
}

