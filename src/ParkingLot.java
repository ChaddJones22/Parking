import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class ParkingLot {
    private List<CarsInLot> carInfo = null;
    private int carParked = 0;
    private int lotCapacity = 0;

    public ParkingLot(int lotCapacity){
        this.carInfo = new ArrayList<CarsInLot>();
        this.lotCapacity = lotCapacity;
        this.carParked = 0;
    }
    public int getLotCapacity(){return lotCapacity;}
    public int getCarsParked(){return carParked;}
    public ArrayList<CarsInLot> getCarInfo(){return (ArrayList<CarsInLot>) carInfo;}


    public void EnteringLot(CarsInLot cID){
        if(this.carParked==this.lotCapacity){
            System.out.println("Parking Lot is full. Come back later.");}
        else {
            Date enteringLot = new Date();
            cID.setCarID(enteringLot);
            cID.setDateIn(enteringLot);
            System.out.println("Car #"+ cID.getCarID() + " allowed to park.");
            System.out.println("Date: "+ cID.getDateIn() +".");
            this.carParked++;}
    }
    public void ExitingLot(int cID) {
        boolean check = carInfo.contains(cID);
        if(!check){System.out.println("Car ID not found. Contact Customer Service.");}
        else {
            int i = carInfo.indexOf(cID);
            Date leavingLot = new Date();
            carInfo.get(i).setDateOut(leavingLot);
            carInfo.remove(carInfo.get(i));
            this.carParked--;
            System.out.println("Car #" + cID + " is leaving the lot.");
        }
    }

}

