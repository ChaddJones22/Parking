import java.text.NumberFormat;
import java.util.Date;

public class TicketData extends ParkingLot {
    public TicketData() {
        this.carID = carID;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }//constructor
    public void setCarID(){ this.carID = ((int) new Date().getTime());}
    public void setDateIn(){this.dateIn = new Date();}
    public void setDateOut(){this.dateOut = new Date();}
    public Date getDateIn() {return dateIn;}
    public Date getDateOut() {return dateOut;}
    public int getCarID(){return carID;}
    public String payment(long in, long out){   //calculating time
        NumberFormat form = NumberFormat.getCurrencyInstance();
        double totaling = ((out - in) / (60 * 1000) % 60) *0.08; //$5 an hour.
        String pay = form.format(totaling);
        return pay;
    }

    /*@Override
    public boolean equals(Object obj){
        if (this==obj)
            return true;
        if(obj == null || obj.getClass()!=this.getClass())
            return false;
        CarData CD = (CarData) obj;
        return (CD.carID == this.carID && CD.dateIn == this.dateIn);
    }
    @Override
    public int hashCode() { return this.carID; }*/
}