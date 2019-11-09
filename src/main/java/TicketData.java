import java.io.IOException;
import java.util.Date;

public class TicketData extends ParkingLot {
    public TicketData() throws IOException {
        this.carID = carID;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.lot = lot;
    }//constructor
    public void setCarID(){ this.carID = ((int) new Date().getTime());}
    public void setDateIn(){this.dateIn = new Date();}
    public void setDateOut(){this.dateOut = new Date();}
    public char setLot(char c){this.lot = c; return lot;}
    public Date getDateIn() {return dateIn;}
    public Date getDateOut() {return dateOut;}
    public int getCarID(){return carID;}
    public char getLot(){return lot;}

    //calculating time
    public String payment(long in, long out, double rate){

        double totaling = ((out - in) / (60 * 1000) % 60) *rate; //$5 an hour or 0.08333 per min.
        this.profit = profit + totaling;
        String pay = form.format(totaling);
        return pay;
    }
}
