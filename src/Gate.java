import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Gate extends TicketData {
    public Gate(int lotCapacity){
        this.carInfo = new ArrayList<TicketData>();
        this.lotCapacity = lotCapacity;
        this.carParked = 0;
    }
    //Car entering lot.
    public void EnteringLot() throws InterruptedException {
        if (this.carParked == this.lotCapacity) {
            System.out.println("Parking Lot is full. Come back later.");
        }
        else {
            TicketData ticket = new TicketData();
            ticket.setCarID();
            ticket.setDateIn();
            //ticket.hashCode();
            carInfo.add(ticket);
            System.out.println("Car allowed to park.");
            System.out.println("Printing Ticket....");
            TimeUnit.SECONDS.sleep(printTime);
            System.out.println("Car #" + ticket.getCarID() + " is entering parking lot.");
            System.out.println("Date: " + ticket.getDateIn() + ".");
            carParked++;
            TimeUnit.SECONDS.sleep(waitTime);
        }
        //System.out.println("ArrayList: "+ carInfo.get(carParked-1).carID + carInfo.get(carParked-1).dateIn);  testing
    }

    //Car leaving Parking lot.
    public void ExitingLot(int cID) throws InterruptedException {
        int loopCounter = 0;
        for(int index = 0; index < (carInfo.size()); index++){
            //System.out.println("CarID:"+carInfo.get(index).carID+"  CID:"+cID); testing
            if(carInfo.get(index).carID == cID){
                carInfo.get(index).setDateOut();
                String amount = payment(carInfo.get(index).dateIn.getTime(),carInfo.get(index).dateOut.getTime());  //getting total price.
               //System.out.println("DateIn:"+carInfo.get(index).dateIn.getTime()+"  DateOut:"+carInfo.get(index).dateOut.getTime()); testing
                System.out.println("Car #" + cID + " total price is: " + amount + ".");
                System.out.println("Waiting for payment.");
                TimeUnit.SECONDS.sleep(waitTime);
                System.out.println("Printing receipt");
                TimeUnit.SECONDS.sleep(printTime);
                System.out.println("Date Leaving: " + carInfo.get(index).getDateOut() + ".");
                carInfo.remove(carInfo.get(index));
                carParked--; loopCounter--; break;
            }
            loopCounter++;
        }
        if(loopCounter == carInfo.size()){System.out.println("Ticket not found. Contact Customer Service. 777-9311");}
        //System.out.println("Array:"+ carInfo.contains(cID)+" Size:"+carInfo.size());  testing
    }
}
