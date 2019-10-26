import java.text.NumberFormat;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class LotGroups extends TicketData{
    Scanner sc = new Scanner(System.in);
    NumberFormat form = NumberFormat.getCurrencyInstance();

    public LotGroups() {
        this.discount = discount;
        this.rate = rate;
        this.price = 0.08333;
    }

    public char selectingLotGroup() throws InterruptedException {
        int selectingLot = 0;
        while(true) {
            System.out.println("Select at lot:");
            System.out.println("Enter 1 for Lot A.\nEnter 2 for Lot B.\nEnter 3 for Lot C.");
            selectingLot = sc.nextInt();
            if(selectingLot == 1 && lotCapA > carsInLotA) break;
            if (selectingLot == 2 && lotCapB > carsInLotB) break;
            if (selectingLot == 3 && lotCapC > carsInLotC) break;
            System.out.println("Error!");
            TimeUnit.SECONDS.sleep(waitTime);

        }
            switch (selectingLot) {
                case 1:
                    this.lot = 'A';
                    carsInLotA++;
                    break;
                case 2:
                    this.lot = 'B';
                    carsInLotB++;
                    break;
                case 3:
                    this.lot = 'C';
                    carsInLotC++;
                    break;
                default:
                    this.lot = 'G';
                    break; //general admission lot.
            }
        System.out.println("You have selected Lot "+ this.lot);
        return this.lot;
    }

    public void parkingInquiry() throws InterruptedException {
        char answer;
        System.out.println("Do you want the lot inquiry? 1 for yes.");
        answer = sc.next().charAt(0);
        if (answer == '1'){
        System.out.println("Lot Inquiry:");
        System.out.println("Lot A has " + (lotCapA - carsInLotA) + " open spaces at " + form.format(lotARate()*60) + "/hour." +
                "\nLot B has " + (lotCapB - carsInLotB) + " open spaces at " + form.format(lotBRate()*60) + "/hour." +
                "\nLot C has " + (lotCapC - carsInLotC) + " open spaces at " + form.format(lotCRate()*60) + "/hour.");
            TimeUnit.SECONDS.sleep(waitTime);
        }
    }
    public double lotARate(){
        this.discount = 0.1; //10% off
        return (this.rate = this.price-(price*discount));
    }
    public double lotBRate(){
        this.discount = 0.15;  //15% off
        return (this.rate = this.price-(price*discount));
    }
    public double lotCRate(){
        this.discount = 0.18;  //18% off
        return (this.rate = this.price-(price*discount));
    }
    public double getRate(char lotNumber){
        if(lotNumber == 'A'){return lotARate();}
        if(lotNumber =='B'){return lotBRate();}
        if(lotNumber == 'C'){return lotCRate();}
        System.out.println("Discount was not applied to ticket.");
        return this.rate = 0.08333;
    }
}
