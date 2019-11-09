import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class LotGroups extends TicketData{

    public LotGroups() throws IOException {
        this.discount = discount;
        this.rate = rate;
        this.price = 0.08335;
    }

    public char selectingLotGroup() throws InterruptedException, FileNotFoundException {
        int selectingLot = 0;
        //checks and balancing for selecting which lot to park in
        while(true) {
            System.out.println("Select a lot:");
            System.out.println("Enter 1 for Lot A.\nEnter 2 for Lot B.\nEnter 3 for Lot C.");
            //selectingLot = sc.nextInt(); //console inputs

           selectingLot = fileScan.nextInt();

            TimeUnit.SECONDS.sleep(waitTime);
            if(selectingLot == 1 && lotCapA > carsInLotA) break;
            if (selectingLot == 2 && lotCapB > carsInLotB) break;
            if (selectingLot == 3 && lotCapC > carsInLotC) break;
            System.out.println("Error!");
            TimeUnit.SECONDS.sleep(waitTime);

        }
            switch (selectingLot) {  //counting cars that park in each lot.
                case 1:
                    this.lot = 'A';
                    this.carsInLotA++;
                    break;
                case 2:
                    this.lot = 'B';
                    this.carsInLotB++;
                    break;
                case 3:
                    this.lot = 'C';
                    this.carsInLotC++;
                    break;
                default:
                    this.lot = 'G';
                    break; //general admission lot.
            }
        System.out.println("You have selected Lot "+ this.lot);
        totalCarsParked++;  //keeping count of total cars parked.
        return this.lot;
    }

    //shows all available parking spaces in each lot
    public void parkingInquiry() throws InterruptedException, FileNotFoundException {
        char answer;
        System.out.println("Do you want the lot inquiry? 1 for yes.");
        TimeUnit.SECONDS.sleep(waitTime);
        answer = fileScan.next().charAt(0);
        //answer = sc.next().charAt(0); //console inputs

        if (answer == '1'){
        System.out.println("Lot Inquiry:");
        System.out.println("Lot A has " + (lotCapA - carsInLotA) + " open spaces at " + form.format(getRate('A')*60) + "/hour." +
                "\nLot B has " + (lotCapB - carsInLotB) + " open spaces at " + form.format(getRate('B')*60) + "/hour." +
                "\nLot C has " + (lotCapC - carsInLotC) + " open spaces at " + form.format(getRate('C')*60) + "/hour.");
            TimeUnit.SECONDS.sleep(waitTime);
        }
    }

    //gets discount and calculates price rate for each lot
    public double getRate(char lotNumber){
        switch (lotNumber){
            case 'A': this.discount = 0.1; break;//10% off
            case 'B': this.discount = 0.15; break;//15% off
            case 'C': this.discount = 0.18; break;  //18% off
            default: this.discount = 0;  //no discount
            System.out.println("Discount was not applied to ticket.");
            break;
        }
        return (this.rate = this.price-(price*discount));
    }

    public void lotChecker(char lotNum){
        switch (lotNum){
            case 'A': carsInLotA--; break;
            case 'B': carsInLotB--; break;
            case 'C': carsInLotC--; break;
        }

    }
}
