import java.util.ArrayList;
import java.util.Date;

abstract class ParkingLot {
    ArrayList<TicketData> carInfo;
    //extended LotGroups
    int lotCapA = 0;
    int lotCapB = 0;
    int lotCapC = 0;
    int totalLotCap = lotCapA+lotCapB+lotCapC;
    int carsInLotA = 0;
    int carsInLotB = 0;
    int carsInLotC = 0;
    int totalCarsParked = carsInLotA+carsInLotB+carsInLotC;
    //extended TicketData
    char lot;
    int carID;
    Date dateIn = null;
    Date dateOut = null;
    //extended Pricing
    double discount;
    double price;
    double rate = 0.08333;
    //Universal parameters
    int printTime = 4;
    int waitTime = 2;

    ParkingLot() {}
    public int getTotalLotCap() { return totalLotCap;}
    public int getCarsParked() {return totalCarsParked;}
    public ArrayList<TicketData> getCarInfo() {return (ArrayList<TicketData>) carInfo; }
}

