import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

abstract class ParkingLot {
    ArrayList<TicketData> carInfo;
    //extended LotGroups
    int lotCapA;
    int lotCapB;
    int lotCapC;
    int totalLotCap = 0;
    int carsInLotA = 0;
    int carsInLotB = 0;
    int carsInLotC = 0;
    int currentlyParked = 0;
    int totalCarsParked = 0;
    //extended TicketData
    char lot;
    int carID;
    Date dateIn = null;
    Date dateOut = null;
    //extended Pricing
    double discount;
    double price;
    double rate = 0.08335;
    double profit;
    String totalProfit;
    //Universal parameters
    File file = new File("C:\\Users\\Twent\\Documents\\Test Case\\testcase3.txt");
    Scanner fileScan = new Scanner(file);

    int printTime = 3;  //sim print time in seconds
    int waitTime = 2;   //sim wait time in seconds
    NumberFormat form = NumberFormat.getCurrencyInstance();
    Scanner sc = new Scanner(System.in);

    ParkingLot() throws IOException {}
    int getTotalLotCap() { return totalLotCap = (lotCapA+lotCapB+lotCapC);} //get total capacity of the lots.
    int getTotalCarsParked() {return totalCarsParked;}  //get total cars that parked in the lot.
    int getTotalCarsParkedCurrently() {return currentlyParked = (carsInLotA+carsInLotB+carsInLotC);}  //get cars currently parked in lot
    String getProfit() {totalProfit = form.format(profit);
    return totalProfit;}     //get total profit
    ArrayList<TicketData> getCarInfo() {return (ArrayList<TicketData>) carInfo; }

}

