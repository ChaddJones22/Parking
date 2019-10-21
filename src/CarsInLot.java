import java.util.Date;

public class CarsInLot {
    private int carID;
    private Date dateIn;
    private Date dateOut;
    private int car;

    public CarsInLot(int car) {
        this.car = car; }

    public void setCarID(Date currentDate){this.carID = (int) currentDate.getTime();}
    public void setDateIn(Date enteringLot){this.dateIn = enteringLot;}
    public void setDateOut(Date leavingLot){this.dateOut = leavingLot;}
    public Date getDateIn() {return dateIn;}
    public Date getDateOut() {return dateOut;}
    public int getCarID(){return carID;}

}
