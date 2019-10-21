import java.text.NumberFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class ParkingLot {
    private List<CarsInLot> carInfo;
    private int carParked = 0;  //default setting
    private int lotCapacity = 0;    //default setting

    public ParkingLot(int lotCapacity){
        this.carInfo = new ArrayList<CarsInLot>();
        this.lotCapacity = lotCapacity;
        this.carParked = 0;
    }
    public int getLotCapacity(){return lotCapacity;}
    public int getCarsParked(){return carParked;}
    public ArrayList<CarsInLot> getCarInfo(){return (ArrayList<CarsInLot>) carInfo;}

    //Car entering lot.
    public void EnteringLot(CarsInLot cID){
        if(this.carParked==this.lotCapacity){
            System.out.println("Parking Lot is full. Come back later.");}
        else {
            Date enteringLot = new Date();
            cID.setCarID(enteringLot);  //getting and setting Car ID.
            cID.setDateIn(enteringLot); //setting in Date
            System.out.println("Car #"+ cID.getCarID() + " allowed to park.");
            System.out.println("Date: "+ cID.getDateIn() +".");
            this.carParked++; carInfo.add(cID);}
    }

    //Car leaving Parking lot.
    public void ExitingLot(int cID) {
        for (int i=0; i< carInfo.size(); i++){
            if(cID == carInfo.get(i).getCarID());{
                Date leavingLot = new Date();
                carInfo.get(i).setDateOut(leavingLot);
                String amount = priceTotal(carInfo.get(i).timeParked());  //getting total price.
                this.carParked--;   //removing car from lot.
                System.out.println("Car #" + cID + " total price is: "+ amount +  ".");
                System.out.println("Date leaving: "+ carInfo.get(i).getDateOut() +".");
                carInfo.remove(carInfo.get(i));}
        }
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


    public String priceTotal(long totalTime){
        NumberFormat form = NumberFormat.getCurrencyInstance();
        double totaling = (totalTime / (60 * 1000) % 60) *0.08; //$5 an hour.
        String totalPay = form.format(totaling);
        return totalPay;
    }
}

