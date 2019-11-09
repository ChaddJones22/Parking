import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Gate extends LotGroups {

    public Gate(int lotACap, int lotBCap, int lotCCap) throws FileNotFoundException, IOException {
        this.carInfo = new ArrayList<TicketData>();
        this.lotCapA = lotACap;
        this.lotCapB = lotBCap;
        this.lotCapC = lotCCap;
        this.totalLotCap = lotACap + lotBCap + lotCCap;
    }
    //

    //Car entering Parking lot.
    public void EnteringLot() throws InterruptedException, IOException {
        //if (this.totalCarsParked == this.totalLotCap) {
        if(getTotalCarsParked() == getTotalLotCap()){
            System.out.println("Parking Lot is full. Come back later.");
            if (getTotalLotCap() == 0) {
                System.out.println("Lot Capacity is 0.");
                System.exit(-1);
            }
        }
        else {
            parkingInquiry();
            this.lot = selectingLotGroup();
            TicketData ticket = new TicketData();
            ticket.setCarID();  //set ticket number as carID
            ticket.setDateIn(); //set date
            ticket.setLot(lot); //set date from LotGroups class
            carInfo.add(ticket);  //save all previous data on 1 array entry
            System.out.println("Car allowed to park.");
            System.out.println("Printing Ticket....");

            //Saves to out file for ticketID to be used for exiting.
            int input2File = ticket.getCarID();
            FileWriter fileOut = new FileWriter(file, true);
            fileOut.write( 'L'+ " " + input2File + " " + 'Y' + "\n");
            fileOut.close();

            TimeUnit.SECONDS.sleep(printTime);  //sim printing
            System.out.println("Ticket ID #" + ticket.getCarID() + " is entering parking Lot " + ticket.getLot() + ".");
            System.out.println("Date: " + ticket.getDateIn() + ".");
            TimeUnit.SECONDS.sleep(waitTime);  //sim waiting
        }
        //System.out.println("ArrayList: "+ carInfo.get(carParked-1).carID + carInfo.get(carParked-1).dateIn);  testing
    }



    //Car leaving Parking lot.
    public void ExitingLot(int cID) throws InterruptedException {
        int loopCounter = 0;
        for(int index = 0; index < (carInfo.size()); index++){
            //System.out.println("CarID:"+carInfo.get(index).carID+"  CID:"+cID); //testing
            if(carInfo.get(index).carID == cID){
                carInfo.get(index).setDateOut();    //setting Date out for calculating ticket price
                double lotRate = getRate(carInfo.get(index).lot);  // getting price rate form LotGroups class
                //System.out.println("Lot: " + carInfo.get(index).lot + " Rate: " + lotRate );  //testing
                String amount = payment(carInfo.get(index).dateIn.getTime(),carInfo.get(index).dateOut.getTime(),lotRate);  //getting total price at TicketData

               //System.out.println("DateIn:"+carInfo.get(index).dateIn.getTime()+"  DateOut:"+carInfo.get(index).dateOut.getTime()); //testing
                System.out.println("Applying Discount from Lot " + carInfo.get(index).lot + ".");
                System.out.println("Car #" + cID + " total price is: " + amount + ".");
                System.out.println("Waiting for payment.");
                TimeUnit.SECONDS.sleep(waitTime);  //sim paying ticket booth
                System.out.println("Printing receipt");
                TimeUnit.SECONDS.sleep(printTime);  //sim printing ticket
                System.out.println("Date Leaving: " + carInfo.get(index).getDateOut() + ".");
                lotChecker(carInfo.get(index).lot);
                carInfo.remove(carInfo.get(index));
                loopCounter--; //break;
            }
            loopCounter++;  //check if ticket is in the system
        }
        if(loopCounter == carInfo.size()){System.out.println("Ticket not found. Contact Customer Service. 777-9311");}
        //System.out.println("Array:"+ carInfo.contains(cID)+" Size:"+carInfo.size());  testing
    }

}
