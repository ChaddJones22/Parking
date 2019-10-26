import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        Gate pl = new Gate(2);
        int j=0;

        for(int i=0;i<3;i++){
        System.out.println("Car attempting to enter lot.");
        //String plateID = scan.next();
        //TicketMachine car = new TicketMachine(plateID);
        pl.EnteringLot();}

        for(int i=0;i<3;i++){
           System.out.println("Enter ticket (Car ID): ");
            int carID = scan.nextInt();
            pl.ExitingLot(carID);}
    }
}

