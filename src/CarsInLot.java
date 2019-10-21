import java.util.Date;
import java.text.NumberFormat;

public class CarsInLot {
    private long timeParked;
    private int carID;
    private Date dateIn;
    private Date dateOut;
    private String car;

    public CarsInLot(String plateID) {this.car = plateID;} //constructor

    public void setCarID(Date currentDate){ this.carID = ((int) currentDate.getTime()*-1);}
    public void setDateIn(Date enteringLot){this.dateIn = enteringLot;}
    public void setDateOut(Date leavingLot){this.dateOut = leavingLot;}
    public Date getDateIn() {return dateIn;}
    public Date getDateOut() {return dateOut;}
    public int getCarID(){return carID;}
    public long timeParked(){return (dateOut.getTime() - dateIn.getTime());}    //calculating time

}
