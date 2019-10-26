import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Gate extends LotGroups {
    public Gate(int lotACap, int lotBCap, int lotCCap){
        this.carInfo = new ArrayList<TicketData>();
        this.lotCapA = lotACap;
        this.lotCapB = lotBCap;
        this.lotCapC = lotCCap;
        this.totalLotCap = lotACap + lotBCap + lotCCap;
    }
    //Car entering lot.
    public void EnteringLot() throws InterruptedException {
        if (this.totalCarsParked == this.totalLotCap) {
            System.out.println("Parking Lot is full. Come back later.");
        }
        else {
            parkingInquiry();
            this.lot = selectingLotGroup();
            TicketData ticket = new TicketData();
            ticket.setCarID();
            ticket.setDateIn();
            ticket.setLot(lot);
            //ticket.hashCode();
            carInfo.add(ticket);
            System.out.println("Car allowed to park.");
            System.out.println("Printing Ticket....");
            TimeUnit.SECONDS.sleep(printTime);
            System.out.println("Car #" + ticket.getCarID() + " is entering parking Lot " + ticket.getLot() + ".");
            System.out.println("Date: " + ticket.getDateIn() + ".");
            //totalCarsParked++;
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
                carInfo.get(index).setDateOut();    //setting Date out
                double lotRate = getRate(carInfo.get(index).lot);  //LotGroups
                String amount = payment(carInfo.get(index).dateIn.getTime(),carInfo.get(index).dateOut.getTime(),lotRate);  //getting total price at TicketData

               //System.out.println("DateIn:"+carInfo.get(index).dateIn.getTime()+"  DateOut:"+carInfo.get(index).dateOut.getTime()); testing
                System.out.println("Applying Discount from Lot " + carInfo.get(index).lot + ".");
                System.out.println("Car #" + cID + " total price is: " + amount + ".");
                System.out.println("Waiting for payment.");
                TimeUnit.SECONDS.sleep(waitTime);
                System.out.println("Printing receipt");
                TimeUnit.SECONDS.sleep(printTime);
                System.out.println("Date Leaving: " + carInfo.get(index).getDateOut() + ".");
                carInfo.remove(carInfo.get(index));
                totalCarsParked--; loopCounter--; break;
            }
            loopCounter++;  //check if ticket is in the system
        }
        if(loopCounter == carInfo.size()){System.out.println("Ticket not found. Contact Customer Service. 777-9311");}
        //System.out.println("Array:"+ carInfo.contains(cID)+" Size:"+carInfo.size());  testing
    }
}
