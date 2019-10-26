import java.util.ArrayList;
import java.util.Date;

abstract class ParkingLot {
    ArrayList<TicketData> carInfo;  //Car Item
    int lotCapacity; //Parking lot Item
    int carParked = 0;  //Cars Item
    int carID;
    Date dateIn = null;
    Date dateOut = null;
    long timeParked; //ticketBooth item
    int printTime = 4;
    int waitTime = 2;
    ParkingLot() {}
    public int getLotCapacity() { return lotCapacity;}
    public int getCarsParked() {return carParked;}
    public ArrayList<TicketData> getCarInfo() {return (ArrayList<TicketData>) carInfo; }
        /*boolean check = carInfo.contains(cID);
        if(check==false){System.out.println("Car ID not found. Contact Customer Service.");}
        else {
            int i = carInfo.indexOf(cID);
            Date leavingLot = new Date();   //setting out date.
            carInfo.get(i).setDateOut(leavingLot);
            String amount = priceTotal(carInfo.get(i).timeParked());  //getting total price.
            this.carParked--;   //removing car from lot.
            System.out.println("Car #" + cID + " total price is: "+ amount +  ".");
            System.out.println("Date leaving: "+ carInfo.get(i).getDateOut() +".");
            carInfo.remove(carInfo.get(i));
        }*/

}

